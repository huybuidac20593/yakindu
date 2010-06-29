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

package org.esmp.dsm.diagram.ui.editpolicies;

/**
 * @author Andreas Unger
 *
 */
public interface EditPolicyRoles extends org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles {

	String TERMINAL_ROLE = "terminalRole";
	String TRANSFORM_ROLE = "transformRole";
	String ADJUST_INPUT_COUNT_ROLE = "adjustInputCountRole";
	String ADJUST_OUTPUT_COUNT_ROLE = "adjustOutputCountRole";
	String SNAP_TO_PORT_FEEDBACK_ROLE = "snapToPortFeedbackRole";
	
}
