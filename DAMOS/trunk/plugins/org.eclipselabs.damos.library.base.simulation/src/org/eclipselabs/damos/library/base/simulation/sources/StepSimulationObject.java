/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.library.base.simulation.sources;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.execution.core.util.ExpressionUtil;
import org.eclipselabs.damos.library.base.util.sources.StepConstants;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.Values;
import org.eclipselabs.damos.simulation.core.ISimulationMonitor;
import org.eclipselabs.damos.simulation.simulator.AbstractBlockSimulationObject;

/**
 * @author Andreas Unger
 *
 */
public class StepSimulationObject extends AbstractBlockSimulationObject {

	private IValue initialValue;
	private IValue finalValue;
	private double stepTime;
	
	private IValue outputValue;

	@Override
	public void initialize(IProgressMonitor monitor) throws CoreException {
		initialValue = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), StepConstants.PARAMETER__INITIAL_VALUE);
		finalValue = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), StepConstants.PARAMETER__FINAL_VALUE);
		stepTime = ExpressionUtil.evaluateSimpleNumericArgument(getComponent(), StepConstants.PARAMETER__STEP_TIME).doubleValue();

		initialValue = Values.transform(getComputationContext(), initialValue);
		finalValue = Values.transform(getComputationContext(), finalValue);
	}
	
	@Override
	public IValue getOutputValue(int outputIndex, int portIndex) {
		return outputValue;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#computeOutputValues()
	 */
	@Override
	public void computeOutputValues(double t, ISimulationMonitor monitor) throws CoreException {
		outputValue = t < stepTime ? initialValue : finalValue;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#getZeroCrossingTime(double)
	 */
	@Override
	public double computeZeroCrossingTime(double t) {
		return stepTime;
	}
	
}
