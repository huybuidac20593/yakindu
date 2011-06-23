/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.codegen.c.generator;

import java.io.Writer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenModel;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.execution.core.IComponentSignature;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModel;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModel;
import org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelUtil;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractComponentGenerator implements IComponentGenerator {

	private IGeneratorContext context;
	private ComponentNode node;
	private IComponentSignature signature;
	
	private ComputationModel cachedComputationModel;

	/**
	 * @return the context
	 */
	public IGeneratorContext getContext() {
		return context;
	}
	
	/**
	 * @param context the context to set
	 */
	public void setContext(IGeneratorContext context) {
		this.context = context;
	}
	
	/**
	 * @return the node
	 */
	public ComponentNode getNode() {
		return node;
	}
	
	/**
	 * @param node the node to set
	 */
	public void setNode(ComponentNode node) {
		this.node = node;
	}
	
	protected Component getComponent() {
		return node.getComponent();
	}
	
	/**
	 * @return the signature
	 */
	public IComponentSignature getSignature() {
		return signature;
	}
	
	/**
	 * @param signature the signature to set
	 */
	public void setSignature(IComponentSignature signature) {
		this.signature = signature;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGenerator#initialize()
	 */
	public void initialize() throws CoreException {
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGenerator#contributesContextCode()
	 */
	public boolean contributesContextCode() {
		return false;
	}
	
	public void generateContextCode(Writer writer, String typeName, IProgressMonitor monitor) throws CoreException {
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGenerator#contributesInitializationCode()
	 */
	public boolean contributesInitializationCode() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGenerator#generateInitializationCode(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void generateInitializationCode(Writer writer, IVariableAccessor variableAccessor, IProgressMonitor monitor) throws CoreException {
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGenerator#contributesComputeOutputsCode()
	 */
	public boolean contributesComputeOutputsCode() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGenerator#generateComputeOutputsCode(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void generateComputeOutputsCode(Writer writer, IVariableAccessor variableAccessor, IProgressMonitor monitor) throws CoreException {
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGenerator#contributesUpdateCode()
	 */
	public boolean contributesUpdateCode() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGenerator#generateUpdateCode(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void generateUpdateCode(Writer writer, IVariableAccessor variableAccessor, IProgressMonitor monitor) throws CoreException {
	}
	
	protected final GenModel getGenModel() {
		return getContext().getGenModel();
	}
	
	protected final ExecutionModel getExecutionModel() {
		return getGenModel().getExecutionModel();
	}
	
	protected final ComputationModel getComputationModel() {
		if (cachedComputationModel == null) {
			cachedComputationModel = getExecutionModel().getComputationModel(getComponent().getOwningFragment());
			if (cachedComputationModel == null) {
				cachedComputationModel = ComputationModelUtil.constructDefaultComputationModel();
			}
		}
		return cachedComputationModel;
	}

}
