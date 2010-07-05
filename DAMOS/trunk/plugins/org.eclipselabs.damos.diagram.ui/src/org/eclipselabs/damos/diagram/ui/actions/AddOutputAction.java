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

package org.eclipselabs.damos.diagram.ui.actions;

import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipselabs.damos.diagram.ui.requests.RequestConstants;

/**
 * @author Andreas Unger
 *
 */
public class AddOutputAction extends DiagramAction {

	/**
	 * @param workbenchPage
	 */
	public AddOutputAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler#init()
	 */
	public void init() {
		super.init();
		setText("Add Output");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#createTargetRequest()
	 */
	protected Request createTargetRequest() {
		return new Request(RequestConstants.REQ_ADD_OUTPUT);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#isSelectionListener()
	 */
	protected boolean isSelectionListener() {
		return true;
	}

}
