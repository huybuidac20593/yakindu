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

package org.eclipselabs.damos.simulation.simulator.internal.simulationobjects;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dml.Latch;
import org.eclipselabs.damos.execution.core.util.ExpressionUtil;
import org.eclipselabs.damos.execution.executionflow.LatchNode;
import org.eclipselabs.damos.execution.executionflow.TaskNode;
import org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject;
import org.eclipselabs.damos.simulation.simulator.internal.SimulationEnginePlugin;
import org.eclipselabs.damos.simulation.simulator.internal.Task;
import org.eclipselabs.mscript.computation.core.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class LatchSimulationObject extends AbstractSimulationObject {

	private volatile IValue value;
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#initialize(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void initialize(IProgressMonitor monitor) throws CoreException {
		Latch latch = (Latch) getComponent();
		if (latch.getInitialValue() == null) {
			throw new CoreException(new Status(IStatus.ERROR, SimulationEnginePlugin.PLUGIN_ID, "No initial value set"));
		}
		value = ExpressionUtil.evaluateExpression(latch.getInitialValue().stringValue());
	}
	
	@Override
	public void setInputValue(int inputIndex, int portIndex, IValue value) {
		this.value = value;
		for (TaskNode taskNode : getNode().getTaskNodes()) {
			if (taskNode.getInputNodes().isEmpty()) {
				Task task = (Task) EcoreUtil.getAdapter(taskNode.eAdapters(), Task.class);
				if (task != null) {
					task.newLatchValueAvailable();
				}
			}
		}
	}
	
	@Override
	public IValue getOutputValue(int outputIndex, int portIndex) {
		return value;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#getNode()
	 */
	@Override
	protected LatchNode getNode() {
		return (LatchNode) super.getNode();
	}
	
}
