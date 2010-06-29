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

package org.esmp.dsm.library.sources.ui.editparts;

import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.esmp.dsm.diagram.ui.editparts.RectangularBlockEditPart;
import org.esmp.dsm.diagram.ui.figures.StandardBlockLayout;
import org.esmp.dsm.library.sources.ui.figures.SineWaveContentFigure;

/**
 * @author Andreas Unger
 *
 */
public class SineWaveEditPart extends RectangularBlockEditPart {

	/**
	 * @param view
	 */
	public SineWaveEditPart(View view) {
		super(view);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart#createMainFigure()
	 */
	protected NodeFigure createMainFigure() {
		NodeFigure figure = super.createMainFigure();
		StandardBlockLayout layout = (StandardBlockLayout) figure.getLayoutManager();
		layout.setHorizontalContentAlignment(SWT.FILL);
		layout.setVerticalContentAlignment(SWT.FILL);
		figure.add(new SineWaveContentFigure());
		return figure;
	}
	
}
