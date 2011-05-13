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

package org.eclipselabs.damos.library.base.ui.sinks.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipselabs.damos.diagram.ui.figures.FontColorAwareFigure;
import org.eclipselabs.damos.diagram.ui.figures.IFigureConstants;

/**
 * @author Andreas Unger
 *
 */
public class ScopeContentFigure extends FontColorAwareFigure implements IFigureConstants {

	/**
	 * 
	 */
	public ScopeContentFigure() {
		setPreferredSize(400, 400);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.figures.BlockFigure#paintCanvas(org.eclipselabs.damos.diagram.figures.ICanvasContext)
	 */
	protected void paintFigure(Graphics g) {
		Rectangle border = getBounds().getCopy();
		border.shrink(DEFAULT_LINE_WIDTH_HALF, DEFAULT_LINE_WIDTH_HALF);
		border.shrink(border.width * 9 / 10, 0);
		border.y += border.height / 10;
		border.height /= 2;
    	g.setForegroundColor(getFontColor());
		g.setLineWidth(DEFAULT_LINE_WIDTH);
		g.drawRectangle(border);
	}

}
