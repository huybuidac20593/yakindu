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

package org.eclipselabs.damos.mscript.il.transform;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.mscript.AdditiveExpression;
import org.eclipselabs.damos.mscript.ArrayConstructionIterationClause;
import org.eclipselabs.damos.mscript.ArrayConstructionOperator;
import org.eclipselabs.damos.mscript.BooleanLiteral;
import org.eclipselabs.damos.mscript.Compound;
import org.eclipselabs.damos.mscript.EqualityExpression;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.FunctionCall;
import org.eclipselabs.damos.mscript.IfExpression;
import org.eclipselabs.damos.mscript.IfStatement;
import org.eclipselabs.damos.mscript.ImpliesExpression;
import org.eclipselabs.damos.mscript.IntegerLiteral;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.IterationCall;
import org.eclipselabs.damos.mscript.LetExpression;
import org.eclipselabs.damos.mscript.LetExpressionAssignment;
import org.eclipselabs.damos.mscript.Literal;
import org.eclipselabs.damos.mscript.LocalVariableDeclaration;
import org.eclipselabs.damos.mscript.LogicalAndExpression;
import org.eclipselabs.damos.mscript.LogicalOrExpression;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.MultiplicativeExpression;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.ParenthesizedExpression;
import org.eclipselabs.damos.mscript.RealLiteral;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.RelationalExpression;
import org.eclipselabs.damos.mscript.StringLiteral;
import org.eclipselabs.damos.mscript.TypeTestExpression;
import org.eclipselabs.damos.mscript.UnaryExpression;
import org.eclipselabs.damos.mscript.UnitConstructionOperator;
import org.eclipselabs.damos.mscript.VariableAccess;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.il.Assignment;
import org.eclipselabs.damos.mscript.il.ILFactory;
import org.eclipselabs.damos.mscript.il.InvalidExpression;
import org.eclipselabs.damos.mscript.il.VariableReference;
import org.eclipselabs.damos.mscript.internal.MscriptPlugin;
import org.eclipselabs.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.util.MscriptSwitch;
import org.eclipselabs.damos.mscript.util.SyntaxStatus;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionTransformer extends MscriptSwitch<Expression> implements IExpressionTransformer {

	private ITransformerContext context;

	private IterationCallTransformerLookupTable iterationCallTransformerLookupTable = new IterationCallTransformerLookupTable();
	
	private MultiStatus status;

	/**
	 * 
	 */
	public ExpressionTransformer(ITransformerContext context) {
		this.context = context;
		status = new MultiStatus(MscriptPlugin.PLUGIN_ID, 0, "Expression transformation", null);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.util.Switch#doSwitch(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public Expression doSwitch(EObject eObject) {
		Expression newExpression = super.doSwitch(eObject);
		IValue value = context.getStaticEvaluationContext().getValue(eObject);
		if (value != null) {
			if (!(eObject instanceof Literal)) {
				newExpression = condenseExpression(value, newExpression);
			}
			context.getStaticEvaluationContext().setValue(newExpression, value);
		}
		return newExpression;
	}

	/**
	 * @param value
	 * @param expression
	 * @return
	 */
	protected Expression condenseExpression(IValue value, Expression expression) {
		if (value instanceof ISimpleNumericValue) {
			ISimpleNumericValue numericValue = (ISimpleNumericValue) value;
			NumericType dataType = numericValue.getDataType();
			if (dataType instanceof RealType) {
				RealLiteral realLiteral = MscriptFactory.eINSTANCE.createRealLiteral();
				realLiteral.setValue(numericValue.doubleValue());
				realLiteral.setUnit(EcoreUtil.copy(dataType.getUnit()));
				expression = realLiteral;
			} else if (dataType instanceof IntegerType) {
				IntegerLiteral integerLiteral = MscriptFactory.eINSTANCE.createIntegerLiteral();
				integerLiteral.setValue(numericValue.longValue());
				integerLiteral.setUnit(EcoreUtil.copy(dataType.getUnit()));
				expression = integerLiteral;
			}
		}
		return expression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.transform.IExpressionTransformer#transform(org.eclipselabs.mscript.language.ast.Expression, java.util.List)
	 */
	public IStatus transform(Expression expression, List<? extends IExpressionTarget> targets) {
		Expression result = doSwitch(expression);
		IExpressionTarget target = targets.get(0);

		Assignment assignment = ILFactory.eINSTANCE.createAssignment();
		assignment.setAssignedExpression(result);
		assignment.setTarget(target.getVariableDeclaration());
		assignment.setStepIndex(target.getStepIndex());
		context.getCompound().getStatements().add(assignment);
		
		return status.isOK() ? Status.OK_STATUS : status;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLetExpression(org.eclipselabs.mscript.language.ast.LetExpression)
	 */
	@Override
	public Expression caseLetExpression(LetExpression letExpression) {
		LocalVariableDeclaration localVariableDeclaration = MscriptFactory.eINSTANCE.createLocalVariableDeclaration();
		IValue expressionValue = context.getStaticEvaluationContext().getValue(letExpression);
		context.getStaticEvaluationContext().setValue(localVariableDeclaration, expressionValue);
		context.getCompound().getStatements().add(localVariableDeclaration);

		Compound compoundStatement = MscriptFactory.eINSTANCE.createCompound();
		context.enterScope();
		context.setCompound(compoundStatement);
		context.addVariableDeclaration(localVariableDeclaration);

		for (LetExpressionAssignment assignment : letExpression.getAssignments()) {
			LocalVariableDeclaration localVariable = MscriptFactory.eINSTANCE.createLocalVariableDeclaration();
			VariableDeclaration variable = assignment.getVariables().get(0);
			IValue partValue = context.getStaticEvaluationContext().getValue(variable);
			context.getStaticEvaluationContext().setValue(localVariable, partValue);
			localVariable.setName(variable.getName());
			Expression assignedExpression = doSwitch(assignment.getAssignedExpression());
			localVariable.setInitializer(assignedExpression);
			compoundStatement.getStatements().add(localVariable);
			context.addVariableDeclaration(localVariable);
		}

		transform(
				letExpression.getTarget(),
				Collections.singletonList(new ExpressionTarget(localVariableDeclaration, 0)));
		
		context.leaveScope();
		
		context.getCompound().getStatements().add(compoundStatement);
		
		VariableReference variableReference = ILFactory.eINSTANCE.createVariableReference();
		variableReference.setTarget(localVariableDeclaration);
		variableReference.setStepIndex(0);
		return variableReference;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIfExpression(org.eclipselabs.mscript.language.ast.IfExpression)
	 */
	@Override
	public Expression caseIfExpression(IfExpression ifExpression) {
		IValue ifConditionValue = context.getStaticEvaluationContext().getValue(ifExpression.getCondition());
		if (ifConditionValue instanceof IBooleanValue) {
			boolean condition = ((IBooleanValue) ifConditionValue).booleanValue();
			Expression expression = condition ? ifExpression.getThenExpression() : ifExpression.getElseExpression();
			return doSwitch(expression);
		}
		
		LocalVariableDeclaration localVariableDeclaration = MscriptFactory.eINSTANCE.createLocalVariableDeclaration();
		IValue ifExpressionValue = context.getStaticEvaluationContext().getValue(ifExpression);
		context.getStaticEvaluationContext().setValue(localVariableDeclaration, ifExpressionValue);
		
		context.getCompound().getStatements().add(localVariableDeclaration);
		IfStatement ifStatement = MscriptFactory.eINSTANCE.createIfStatement();
		Expression conditionExpression = doSwitch(ifExpression.getCondition());
		ifStatement.setCondition(conditionExpression);
		
		Compound thenStatement = MscriptFactory.eINSTANCE.createCompound();
		context.enterScope();
		context.setCompound(thenStatement);
		context.addVariableDeclaration(localVariableDeclaration);
		transform(
				ifExpression.getThenExpression(),
				Collections.singletonList(new ExpressionTarget(localVariableDeclaration, 0)));
		context.leaveScope();
		ifStatement.setThenStatement(thenStatement);
		
		Compound elseStatement = MscriptFactory.eINSTANCE.createCompound();
		context.enterScope();
		context.setCompound(elseStatement);
		context.addVariableDeclaration(localVariableDeclaration);
		transform(
				ifExpression.getElseExpression(),
				Collections.singletonList(new ExpressionTarget(localVariableDeclaration, 0)));
		context.leaveScope();
		ifStatement.setElseStatement(elseStatement);
		
		context.getCompound().getStatements().add(ifStatement);
		
		VariableReference variableReference = ILFactory.eINSTANCE.createVariableReference();
		variableReference.setTarget(localVariableDeclaration);
		variableReference.setStepIndex(0);
		return variableReference;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseVariableAccess(org.eclipselabs.mscript.language.ast.VariableAccess)
	 */
	@Override
	public Expression caseVariableAccess(VariableAccess variableAccess) {
		VariableDeclaration variableDeclaration = context.getVariableDeclaration(variableAccess.getFeature().getName());
		if (variableDeclaration != null) {
			VariableReference variableReference = ILFactory.eINSTANCE.createVariableReference();
			variableReference.setTarget(variableDeclaration);
			variableReference.setStepIndex(context.getStaticEvaluationContext().getStepIndex(variableAccess));
			return variableReference;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseFunctionCall(org.eclipselabs.mscript.language.ast.FunctionCall)
	 */
	@Override
	public Expression caseFunctionCall(FunctionCall functionCall) {
		FunctionCall transformedFunctionCall = MscriptFactory.eINSTANCE.createFunctionCall();
		transformedFunctionCall.setFeature(functionCall.getFeature());
		for (Expression expression : functionCall.getArguments()) {
			Expression transformedExpression = doSwitch(expression);
			if (transformedExpression instanceof InvalidExpression) {
				return transformedExpression;
			}
			transformedFunctionCall.getArguments().add(transformedExpression);
		}
		return transformedFunctionCall;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIterationCall(org.eclipselabs.mscript.language.ast.IterationCall)
	 */
	@Override
	public Expression caseIterationCall(IterationCall iterationCall) {
		IIterationCallTransformer transformer = iterationCallTransformerLookupTable.getTransformer(iterationCall.getIdentifier());
		if (transformer == null) {
			status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, "Invalid iteration call", iterationCall));
			return createInvalidExpression();
		}
		
		IIterationCallTransformerResult result = transformer.transform(context, iterationCall, doSwitch(iterationCall.getTarget()));
		
		VariableReference variableReference = ILFactory.eINSTANCE.createVariableReference();
		variableReference.setTarget(result.getLocalVariableDeclaration());
		variableReference.setStepIndex(0);
		return variableReference;
	}
			
	private InvalidExpression createInvalidExpression() {
		InvalidExpression invalidExpression = ILFactory.eINSTANCE.createInvalidExpression();
		return invalidExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseImpliesExpression(org.eclipselabs.mscript.language.ast.ImpliesExpression)
	 */
	@Override
	public Expression caseImpliesExpression(ImpliesExpression impliesExpression) {
		ImpliesExpression transformedImpliesExpression = MscriptFactory.eINSTANCE.createImpliesExpression();
		
		Expression leftTransformedExpression = doSwitch(impliesExpression.getLeftOperand());
		Expression rightTransformedExpression = doSwitch(impliesExpression.getRightOperand());
		
		transformedImpliesExpression.setLeftOperand(leftTransformedExpression);
		transformedImpliesExpression.setRightOperand(rightTransformedExpression);

		return transformedImpliesExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalOrExpression(org.eclipselabs.mscript.language.ast.LogicalOrExpression)
	 */
	@Override
	public Expression caseLogicalOrExpression(LogicalOrExpression logicalOrExpression) {
		LogicalOrExpression transformedExpression = MscriptFactory.eINSTANCE.createLogicalOrExpression();
		transformedExpression.setLeftOperand(doSwitch(logicalOrExpression.getLeftOperand()));
		transformedExpression.setRightOperand(doSwitch(logicalOrExpression.getRightOperand()));
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseLogicalAndExpression(org.eclipselabs.mscript.language.ast.LogicalAndExpression)
	 */
	@Override
	public Expression caseLogicalAndExpression(LogicalAndExpression logicalAndExpression) {
		LogicalAndExpression transformedExpression = MscriptFactory.eINSTANCE.createLogicalAndExpression();
		transformedExpression.setLeftOperand(doSwitch(logicalAndExpression.getLeftOperand()));
		transformedExpression.setRightOperand(doSwitch(logicalAndExpression.getRightOperand()));
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseEqualityExpression(org.eclipselabs.mscript.language.ast.EqualityExpression)
	 */
	@Override
	public Expression caseEqualityExpression(EqualityExpression equalityExpression) {
		EqualityExpression transformedExpression = MscriptFactory.eINSTANCE.createEqualityExpression();
		transformedExpression.setOperator(equalityExpression.getOperator());
		
		Expression leftExpression = doSwitch(equalityExpression.getLeftOperand());
		transformedExpression.setLeftOperand(leftExpression);
		Expression rightExpression = doSwitch(equalityExpression.getRightOperand());		
		transformedExpression.setRightOperand(rightExpression);
		
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRelationalExpression(org.eclipselabs.mscript.language.ast.RelationalExpression)
	 */
	@Override
	public Expression caseRelationalExpression(RelationalExpression relationalExpression) {
		RelationalExpression transformedExpression = MscriptFactory.eINSTANCE.createRelationalExpression();
		transformedExpression.setOperator(relationalExpression.getOperator());
		
		Expression leftExpression = doSwitch(relationalExpression.getLeftOperand());
		transformedExpression.setLeftOperand(leftExpression);
		Expression rightExpression = doSwitch(relationalExpression.getRightOperand());
		transformedExpression.setRightOperand(rightExpression);
		
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseAdditiveExpression(org.eclipselabs.mscript.language.ast.AdditiveExpression)
	 */
	@Override
	public Expression caseAdditiveExpression(AdditiveExpression additiveExpression) {
		AdditiveExpression transformedExpression = MscriptFactory.eINSTANCE.createAdditiveExpression();
		transformedExpression.setOperator(additiveExpression.getOperator());
		transformedExpression.setLeftOperand(doSwitch(additiveExpression.getLeftOperand()));
		transformedExpression.setRightOperand(doSwitch(additiveExpression.getRightOperand()));
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseMultiplicativeExpression(org.eclipselabs.mscript.language.ast.MultiplicativeExpression)
	 */
	@Override
	public Expression caseMultiplicativeExpression(MultiplicativeExpression multiplicativeExpression) {
		MultiplicativeExpression transformedExpression = MscriptFactory.eINSTANCE.createMultiplicativeExpression();
		transformedExpression.setOperator(multiplicativeExpression.getOperator());
		transformedExpression.setLeftOperand(doSwitch(multiplicativeExpression.getLeftOperand()));
		transformedExpression.setRightOperand(doSwitch(multiplicativeExpression.getRightOperand()));
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseTypeTestExpression(org.eclipselabs.mscript.language.ast.TypeTestExpression)
	 */
	@Override
	public Expression caseTypeTestExpression(TypeTestExpression typeTestExpression) {
		TypeTestExpression transformedTypeTestExpression = MscriptFactory.eINSTANCE.createTypeTestExpression();
		Expression expression = doSwitch(typeTestExpression.getExpression());
		transformedTypeTestExpression.setExpression(expression);
		transformedTypeTestExpression.setTypeSpecifier(EcoreUtil.copy(typeTestExpression.getTypeSpecifier()));
		return transformedTypeTestExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnaryExpression(org.eclipselabs.mscript.language.ast.UnaryExpression)
	 */
	@Override
	public Expression caseUnaryExpression(UnaryExpression unaryExpression) {
		UnaryExpression transformedExpression = MscriptFactory.eINSTANCE.createUnaryExpression();
		transformedExpression.setOperator(unaryExpression.getOperator());
		Expression expression = doSwitch(unaryExpression.getOperand());
		transformedExpression.setOperand(expression);
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseArrayConstructionOperator(org.eclipselabs.mscript.language.ast.ArrayConstructionOperator)
	 */
	@Override
	public Expression caseArrayConstructionOperator(ArrayConstructionOperator arrayConstructionOperator) {
		ArrayConstructionOperator transformedExpression = MscriptFactory.eINSTANCE.createArrayConstructionOperator();
		for (Expression expression : arrayConstructionOperator.getExpressions()) {
			transformedExpression.getExpressions().add(doSwitch(expression));
		}
		for (ArrayConstructionIterationClause iterationClause : arrayConstructionOperator.getIterationClauses()) {
			Expression transformedCollectionExpression = doSwitch(iterationClause.getCollectionExpression());
			ArrayConstructionIterationClause transformedIterationClause = MscriptFactory.eINSTANCE.createArrayConstructionIterationClause();
			transformedIterationClause.setVariableName(iterationClause.getVariableName());
			transformedIterationClause.setCollectionExpression(transformedCollectionExpression);
			transformedExpression.getIterationClauses().add(transformedIterationClause);
		}
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseParenthesizedExpression(org.eclipselabs.mscript.language.ast.ParenthesizedExpression)
	 */
	@Override
	public Expression caseParenthesizedExpression(ParenthesizedExpression parenthesizedExpression) {
		ParenthesizedExpression transformedExpression = MscriptFactory.eINSTANCE.createParenthesizedExpression();
		Expression firstParenthesizedExpression = parenthesizedExpression.getExpressions().get(0);
		Expression transformedFirstParenthesizedExpression = doSwitch(firstParenthesizedExpression);
		transformedExpression.getExpressions().add(transformedFirstParenthesizedExpression);
		return transformedExpression;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRealLiteral(org.eclipselabs.mscript.language.ast.RealLiteral)
	 */
	@Override
	public Expression caseRealLiteral(RealLiteral realLiteral) {
		RealType realType = MscriptFactory.eINSTANCE.createRealType();
		realType.setUnit(EcoreUtil.copy(realLiteral.getUnit()));
		
		RealLiteral transformedRealLiteral = EcoreUtil.copy(realLiteral);
		return transformedRealLiteral;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerLiteral(org.eclipselabs.mscript.language.ast.IntegerLiteral)
	 */
	@Override
	public Expression caseIntegerLiteral(IntegerLiteral integerLiteral) {
		IntegerType integerType = MscriptFactory.eINSTANCE.createIntegerType();
		integerType.setUnit(EcoreUtil.copy(integerLiteral.getUnit()));

		IntegerLiteral transformedIntegerLiteral = EcoreUtil.copy(integerLiteral);
		return transformedIntegerLiteral;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseBooleanLiteral(org.eclipselabs.mscript.language.ast.BooleanLiteral)
	 */
	@Override
	public Expression caseBooleanLiteral(BooleanLiteral booleanLiteral) {
		BooleanLiteral transformedBooleanLiteral = EcoreUtil.copy(booleanLiteral);
		return transformedBooleanLiteral;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseStringLiteral(org.eclipselabs.mscript.language.ast.StringLiteral)
	 */
	@Override
	public Expression caseStringLiteral(StringLiteral stringLiteral) {
		StringLiteral transformedStringLiteral = EcoreUtil.copy(stringLiteral);
		return transformedStringLiteral;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseUnitConstructionOperator(org.eclipselabs.mscript.language.ast.UnitConstructionOperator)
	 */
	@Override
	public Expression caseUnitConstructionOperator(UnitConstructionOperator unitConstructionOperator) {
		UnitConstructionOperator transformedUnitConstructionOperator = EcoreUtil.copy(unitConstructionOperator);
		return transformedUnitConstructionOperator;
	}
	
}
