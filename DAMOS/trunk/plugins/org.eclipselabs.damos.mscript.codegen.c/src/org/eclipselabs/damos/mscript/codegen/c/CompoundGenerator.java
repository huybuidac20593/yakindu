/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.mscript.codegen.c;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.ArrayDimension;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.ForStatement;
import org.eclipselabs.damos.mscript.IfStatement;
import org.eclipselabs.damos.mscript.LocalVariableDeclaration;
import org.eclipselabs.damos.mscript.Statement;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.internal.VariableAccessGenerator;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.damos.mscript.il.Assignment;
import org.eclipselabs.damos.mscript.il.Compound;
import org.eclipselabs.damos.mscript.il.util.ILSwitch;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.util.MscriptSwitch;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class CompoundGenerator implements ICompoundGenerator {
	
	private final IExpressionGenerator expressionGenerator = new ExpressionGenerator();
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.codegen.c.ICompoundGenerator#generate(org.eclipselabs.mscript.codegen.c.IMscriptGeneratorContext, org.eclipselabs.mscript.language.il.Compound, org.eclipselabs.mscript.codegen.c.IVariableAccessStrategy)
	 */
	public void generate(IMscriptGeneratorContext context, Compound compound) {
		new CompoundGeneratorSwitch(context).doSwitch(compound);
	}
	
	private class CompoundGeneratorSwitch extends ILSwitch<Boolean> {

		private IMscriptGeneratorContext context;

		private PrintAppendable out;
		
		private AstCompoundGeneratorSwitch astCompoundGeneratorSwitch = new AstCompoundGeneratorSwitch();

		/**
		 * 
		 */
		public CompoundGeneratorSwitch(IMscriptGeneratorContext context) {
			this.context = context;
			out = new PrintAppendable(context.getAppendable());
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.imperativemodel.util.ILSwitch#caseCompound(org.eclipselabs.mscript.language.imperativemodel.Compound)
		 */
		@Override
		public Boolean caseCompound(Compound compound) {
			boolean block = compound instanceof Statement;
			if (block) {
				out.print("{\n");
			}
			for (LocalVariableDeclaration localVariableDeclaration : compound.getLocalVariableDeclarations()) {
				out.print(MscriptGeneratorUtil.getCVariableDeclaration(context.getComputationModel(), getDataType(localVariableDeclaration), localVariableDeclaration.getName(), false));
				out.print(";\n");
			}
			for (Statement statement : compound.getStatements()) {
				doSwitch(statement);
			}
			if (block) {
				out.print("}\n");
			}
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.imperativemodel.util.ILSwitch#caseAssignment(org.eclipselabs.mscript.language.imperativemodel.Assignment)
		 */
		@Override
		public Boolean caseAssignment(Assignment assignment) {
			VariableDeclaration target = assignment.getTarget();
			writeAssignment(getDataType(target), new VariableAccessGenerator(context, assignment).generate(), assignment.getAssignedExpression());
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.imperativemodel.util.ILSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		public Boolean defaultCase(EObject object) {
			if (object instanceof Expression) {
				expressionGenerator.generate(context, (Expression) object);
				return true;
			}
			return astCompoundGeneratorSwitch.doSwitch(object);
		}
		
		private void writeAssignment(DataType targetDataType, String target, Expression assignedExpression) {
			ArrayType arrayType = null;
			if (targetDataType instanceof ArrayType) {
				arrayType = (ArrayType) targetDataType;
			}
			if (arrayType != null) {
				out.print("memcpy(");
			}
			out.print(target);
			if (arrayType != null) {
				out.print(", ");
			} else {
				out.print(" = ");
			}
			cast(targetDataType, assignedExpression);
			if (arrayType != null) {
				out.printf(", sizeof (%s)", MscriptGeneratorUtil.getCDataType(context.getComputationModel(), arrayType.getElementType()));
				for (ArrayDimension arrayDimension : arrayType.getDimensions()) {
					out.printf(" * %d", arrayDimension.getSize());
				}
				out.print(")");
			}
			out.print(";\n");
		}
		
		private void cast(DataType targetDataType, Expression expression) {
			MscriptGeneratorUtil.cast(context, expression, targetDataType);
		}
		
		/**
		 * @param eObject
		 * @return
		 */
		private DataType getDataType(EObject eObject) {
			IValue value = context.getStaticEvaluationContext().getValue(eObject);
			return value != null ? value.getDataType() : null;
		}

		private class AstCompoundGeneratorSwitch extends MscriptSwitch<Boolean> {
			
			@Override
			public Boolean caseLocalVariableDeclaration(LocalVariableDeclaration localVariableDeclaration) {
				if (localVariableDeclaration.getInitializer() != null) {
					writeAssignment(getDataType(localVariableDeclaration), localVariableDeclaration.getName(), localVariableDeclaration.getInitializer());
				}
				return true;
			}
			
			@Override
			public Boolean caseForStatement(ForStatement forStatement) {
				VariableDeclaration iterationVariableDeclaration = forStatement.getDeclaredIterationVariable();
				DataType collectionDataType = getDataType(forStatement.getCollectionExpression());
				if (!(collectionDataType instanceof ArrayType)) {
					throw new RuntimeException("Collection type must be array type");
				}
				ArrayType collectionArrayType = (ArrayType) collectionDataType;
				if (collectionArrayType.getDimensionality() != 1) {
					throw new RuntimeException("Array dimensionality must be 1");
				}
				
				String itVarName = iterationVariableDeclaration.getName();
				String itVarDecl = MscriptGeneratorUtil.getCVariableDeclaration(context.getComputationModel(), getDataType(iterationVariableDeclaration), itVarName, false);
				int size = TypeUtil.getArraySize(collectionArrayType);
				
				out.println("{");
				out.printf("%s %s_i;\n", MscriptGeneratorUtil.getIndexCDataType(context.getComputationModel(), size), itVarName);
				out.printf("for (%s_i = 0; %s_i < %d; ++%s_i) {\n", itVarName, itVarName, size, itVarName);
				out.printf("%s = (", itVarDecl);
				CompoundGeneratorSwitch.this.doSwitch(forStatement.getCollectionExpression());
				out.printf(")[%s_i];\n", itVarName);
				CompoundGeneratorSwitch.this.doSwitch(forStatement.getBody());
				out.println("}");
				out.println("}");
				
				return true;
			}

			@Override
			public Boolean caseIfStatement(IfStatement ifStatement) {
				out.print("if (");
				CompoundGeneratorSwitch.this.doSwitch(ifStatement.getCondition());
				out.print(")\n");
				CompoundGeneratorSwitch.this.doSwitch(ifStatement.getThenStatement());
				out.print("else\n");
				CompoundGeneratorSwitch.this.doSwitch(ifStatement.getElseStatement());
				return true;
			}
			
		}
	
	}
	
}
