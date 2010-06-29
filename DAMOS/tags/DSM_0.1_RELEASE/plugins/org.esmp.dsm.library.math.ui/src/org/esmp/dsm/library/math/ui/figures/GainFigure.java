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

package org.esmp.dsm.library.math.ui.figures;

import org.eclipse.draw2d.geometry.Dimension;
import org.esmp.dsm.diagram.ui.figures.CanvasContext;
import org.esmp.dsm.diagram.ui.figures.FigureConstants;
import org.esmp.dsm.diagram.ui.figures.StandardBlockFigure;

/**
 * @author Andreas Unger
 *
 */
public class GainFigure extends StandardBlockFigure implements FigureConstants {
	
	private int[] points = new int[6];
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.Figure#getMinimumSize(int, int)
	 */
	public Dimension calculateMinimumCanvasSize(int wHint, int hHint) {
		if (minSize == null) {
			minSize = getPreferredCanvasSize().getCopy();
			if (minSize.width < minSize.height) {
				minSize.width = minSize.height;
			}
		}
		return minSize;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	protected void paintCanvas(CanvasContext cc) {
		Dimension size = getCanvasSize();
		
		points[0] = size.width - DEFAULT_LINE_WIDTH_HALF;
		points[1] = size.height / 2;
		points[2] = DEFAULT_LINE_WIDTH_HALF;
		points[3] = DEFAULT_LINE_WIDTH;
		points[4] = DEFAULT_LINE_WIDTH_HALF;
		points[5] = size.height - DEFAULT_LINE_WIDTH;
		
		cc.setLineWidth(DEFAULT_LINE_WIDTH);
		cc.drawPolygon(points);
	}
	
}
