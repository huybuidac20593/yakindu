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

package org.eclipselabs.damos.evaluation.internal.providers;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OpaqueBehaviorSpecification;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.evaluation.EvaluationPlugin;
import org.eclipselabs.damos.evaluation.componentsignature.ComponentSignature;
import org.eclipselabs.damos.evaluation.componentsignature.ComponentSignatureEvaluationResult;
import org.eclipselabs.damos.evaluation.componentsignature.IComponentSignatureEvaluationResult;
import org.eclipselabs.damos.evaluation.componentsignature.IComponentSignaturePolicy;
import org.eclipselabs.mscript.computation.core.ComputationContext;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.computation.core.value.ValueConstructor;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.Module;
import org.eclipselabs.mscript.language.ast.ParameterDeclaration;
import org.eclipselabs.mscript.language.functionmodel.util.FunctionDescriptorConstructor;
import org.eclipselabs.mscript.language.functionmodel.util.IFunctionDescriptorConstructorResult;
import org.eclipselabs.mscript.language.il.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.il.transform.FunctionDefinitionTransformer;
import org.eclipselabs.mscript.language.il.transform.IFunctionDefinitionTransformerResult;
import org.eclipselabs.mscript.language.il.transform.ITransformerContext;
import org.eclipselabs.mscript.language.il.transform.TransformerContext;
import org.eclipselabs.mscript.language.interpreter.IInterpreterContext;
import org.eclipselabs.mscript.language.interpreter.InterpreterContext;
import org.eclipselabs.mscript.language.interpreter.util.ExpressionInterpreterHelper;
import org.eclipselabs.mscript.language.parser.antlr.MscriptParser;
import org.eclipselabs.mscript.language.util.LanguageUtil;
import org.eclipselabs.mscript.typesystem.ArrayType;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.IntegerType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.UnitSymbol;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

class DeclarativeBlockSignaturePolicy implements IComponentSignaturePolicy {
	
	private static final String SAMPLE_TIME_TEMPLATE_PARAMETER_NAME = "T";

	public IComponentSignatureEvaluationResult evaluateSignature(Component component,
			Map<InputPort, DataType> incomingDataTypes) {
		Block block = (Block) component;

		MultiStatus status = new MultiStatus(EvaluationPlugin.PLUGIN_ID, 0, "", null);

		OpaqueBehaviorSpecification behavior = (OpaqueBehaviorSpecification) block.getType().getBehavior();

		if (StringUtils.isBlank(behavior.getBehavior())) {
			status.add(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "No block behavior specified"));
			return new ComponentSignatureEvaluationResult(status);
		}

		MscriptParser parser = EvaluationPlugin.getDefault().getMscriptParser();

		IParseResult parseResult = parser.parse(parser.getGrammarAccess().getModuleRule().getName(),
				new StringReader(behavior.getBehavior()));

		if (!parseResult.getParseErrors().isEmpty()) {
			status.add(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Parsing block behavior failed"));
			return new ComponentSignatureEvaluationResult(status);
		}

		Module module = (Module) parseResult.getRootASTElement();
		FunctionDefinition functionDefinition = LanguageUtil.getFunctionDefinition(module, block.getName());
		if (functionDefinition == null) {
			status.add(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Mscript function '" + block.getName() + "' not found"));
			return new ComponentSignatureEvaluationResult(status);
		}

		IFunctionDescriptorConstructorResult functionDescriptorConstructorResult = new FunctionDescriptorConstructor()
				.construct(functionDefinition);

		if (!functionDescriptorConstructorResult.getStatus().isOK()) {
			status.add(functionDescriptorConstructorResult.getStatus());
			return new ComponentSignatureEvaluationResult(status);
		}
		
		List<IValue> templateArguments = getTemplateArguments(status, block, functionDefinition);
		List<DataType> inputParameterDataTypes = getInputParameterDataTypes(status, block, incomingDataTypes, functionDefinition);

		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		if (inputParameterDataTypes == null) {
			return new ComponentSignatureEvaluationResult();
		}

		IFunctionDefinitionTransformerResult functionDefinitionTransformerResult = new FunctionDefinitionTransformer()
				.transform(functionDescriptorConstructorResult.getFunctionDescriptor(), null,
						templateArguments,
						inputParameterDataTypes);

		if (!functionDefinitionTransformerResult.getStatus().isOK()) {
			status.add(functionDefinitionTransformerResult.getStatus());
			return new ComponentSignatureEvaluationResult(status);
		}
		
		ComponentSignature componentSignature = new ComponentSignature();
		for (OutputVariableDeclaration outputVariableDeclaration : functionDefinitionTransformerResult.getILFunctionDefinition().getOutputVariableDeclarations()) {
			DataType dataType = outputVariableDeclaration.getType();
			
			BlockOutput output = (BlockOutput) block.getOutput(outputVariableDeclaration.getName());
			if (output == null) {
				status.add(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Output '" + outputVariableDeclaration.getName() + "' not found"));
				continue;
			}

			if (output.getDefinition().isManyPorts() || output.getDefinition().getMinimumPortCount() == 0) {
				if (!(dataType instanceof ArrayType)) {
					status.add(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Output '" + outputVariableDeclaration.getName() + "' must result to array type"));
					continue;
				}
				ArrayType arrayType = (ArrayType) dataType;
				
				for (OutputPort outputPort : output.getPorts()) {
					componentSignature.getOutputDataTypes().put(outputPort, EcoreUtil.copy(arrayType.getElementType()));
				}
			} else {
				if (output.getPorts().isEmpty()) {
					status.add(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Invalid output '" + outputVariableDeclaration.getName() + "'"));
					continue;
				}
				componentSignature.getOutputDataTypes().put(output.getPorts().get(0), dataType);
			}
		}

		if (!status.isOK()) {
			return new ComponentSignatureEvaluationResult(status);
		}
		
		return new ComponentSignatureEvaluationResult(componentSignature);
	}
	
	private List<IValue> getTemplateArguments(MultiStatus status, Block block, FunctionDefinition functionDefinition) {
		List<IValue> templateArguments = new ArrayList<IValue>();
		for (ParameterDeclaration parameterDeclaration : functionDefinition.getTemplateParameterDeclarations()) {
			String argument = block.getArgumentStringValue(parameterDeclaration.getName());
			if (argument == null) {
				if (SAMPLE_TIME_TEMPLATE_PARAMETER_NAME.equals(parameterDeclaration.getName())) {
					IntegerType integerType = TypeSystemFactory.eINSTANCE.createIntegerType();
					integerType.setUnit(TypeSystemUtil.createUnit(UnitSymbol.SECOND));
					IValue secondValue = new ValueConstructor().createIntegerValue(new ComputationContext(), integerType, 1);
					templateArguments.add(secondValue);
				} else {
					status.add(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Block parameter '" + parameterDeclaration.getName() + "' not found"));
				}
				continue;
			}

			MscriptParser parser = EvaluationPlugin.getDefault().getMscriptParser();

			IParseResult parseResult = parser.parse(parser.getGrammarAccess().getExpressionRule().getName(),
					new StringReader(argument));
			
			if (!parseResult.getParseErrors().isEmpty()) {
				status.add(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Parsing block parameter '" + parameterDeclaration.getName() + "' failed"));
				continue;
			}

			ITransformerContext transformerContext = new TransformerContext();
			IInterpreterContext interpreterContext = new InterpreterContext(new ComputationContext());

			ExpressionInterpreterHelper expressionInterpreterHelper = new ExpressionInterpreterHelper(transformerContext,
					interpreterContext, (Expression) parseResult.getRootASTElement());
			
			try {
				IValue value = expressionInterpreterHelper.evaluateSingle();
				templateArguments.add(value);
			} catch (CoreException e) {
				status.add(e.getStatus());
			}
		}
		return templateArguments;
	}

	private List<DataType> getInputParameterDataTypes(MultiStatus status, Block block, Map<InputPort, DataType> incomingDataTypes, FunctionDefinition functionDefinition) {
		List<DataType> dataTypes = new ArrayList<DataType>();
		for (ParameterDeclaration parameterDeclaration : functionDefinition.getInputParameterDeclarations()) {
			BlockInput input = (BlockInput) block.getInput(parameterDeclaration.getName());
			if (input == null) {
				status.add(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Input '" + parameterDeclaration.getName() + "' not found"));
				continue;
			}

			if (input.getDefinition().isManyPorts() || input.getDefinition().getMinimumPortCount() == 0) {
				DataType elementDataType = null;
				for (InputPort inputPort : input.getPorts()) {
					DataType dataType = incomingDataTypes.get(inputPort);
					if (dataType != null) {
						if (elementDataType == null) {
							elementDataType = dataType;
						} else {
							elementDataType = TypeSystemUtil.getLeftHandDataType(elementDataType, dataType);
							if (elementDataType == null) {
								status.add(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Input '" + parameterDeclaration.getName() + "' has incompatible input values"));
								continue;
							}
						}
					}
				}
				if (elementDataType == null) {
					return null;
				}
				dataTypes.add(TypeSystemUtil.createArrayType(elementDataType, input.getPorts().size()));
			} else {
				DataType dataType = null;
				if (input.getPorts().isEmpty()) {
					status.add(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Invalid input '" + parameterDeclaration.getName() + "'"));
					continue;
				}
				dataType = incomingDataTypes.get(input.getPorts().get(0));
				if (dataType == null) {
					return null;
				}
				dataTypes.add(dataType);
			}
		}
		return dataTypes;
	}

}