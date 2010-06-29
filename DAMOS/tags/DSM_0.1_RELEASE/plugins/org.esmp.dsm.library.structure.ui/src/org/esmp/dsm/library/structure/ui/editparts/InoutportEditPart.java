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

package org.esmp.dsm.library.structure.ui.editparts;

import org.eclipse.gmf.runtime.draw2d.ui.figures.LabelEx;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.esmp.dsm.diagram.ui.editparts.EditableContentBlockEditPart;
import org.esmp.dsm.library.structure.ui.figures.InoutportFigure;
import org.esmp.dsm.library.structure.util.InoutportConstants;
import org.esmp.dsm.semantic.blockdiagram.Parameter;
import org.esmp.dsm.semantic.blockdiagram.ParameterableElement;

/**
 * @author Andreas Unger
 *
 */
public class InoutportEditPart extends EditableContentBlockEditPart {

	/**
	 * @param view
	 */
	public InoutportEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.ui.editparts.StandardBlockEditPart#createMainFigure()
	 */
	protected NodeFigure createMainFigure() {
		NodeFigure figure = new InoutportFigure();
		figure.add(new LabelEx());
		return figure;
	}
	
	protected Parameter getParameter() {
		return ((ParameterableElement) resolveSemanticElement()).getParameter(InoutportConstants.PARAMETER__PORT_NUMBER);
	}
	
}
