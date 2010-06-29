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

package org.esmp.dsm.diagram.ui.internal.services;

/**
 * @author Andreas Unger
 *
 */
public class EditPartMappingService extends AbstractNotationMappingService {

	private static EditPartMappingService instance;
	
	public static EditPartMappingService getInstance() {
		if (instance == null) {
			instance = new EditPartMappingService();
		}
		return instance;
	}
	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.ui.internal.services.AbstractNotationMappingService#getExtensionPointName()
	 */
	protected String getExtensionPointName() {
		return "editParts";
	}

	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.ui.internal.services.AbstractNotationMappingService#getNotationName()
	 */
	protected String getNotationName() {
		return "editPart";
	}
}
