/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.statechart.diagram.validation.constraints;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.sct.model.statechart.statechart.InitialState;
import org.yakindu.sct.model.statechart.statechart.Region;

public class ExactlyOneInitialState extends AbstractModelConstraint {
	@Override
	public IStatus validate(IValidationContext ctx) {
		Region region = (Region) ctx.getTarget();
		List<InitialState> initialStates = EcoreUtil2.getAllContentsOfType(region, InitialState.class);
		if (initialStates.size() != 1) {
			return ctx.createFailureStatus(region, initialStates.size());
		}
		return ctx.createSuccessStatus();

	}

}
