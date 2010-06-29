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

package org.esmp.dsm.library.logic.ui.figures.shapes;

import org.eclipse.draw2d.geometry.Dimension;
import org.esmp.dsm.diagram.ui.figures.BlockFigure;
import org.esmp.dsm.diagram.ui.figures.CanvasContext;

/**
 * @author Andreas Unger
 *
 */
public class DistinctiveInverterShape extends LogicGateShape {

	/**
	 * @param blockFigure
	 */
	public DistinctiveInverterShape(BlockFigure blockFigure) {
		super(blockFigure);
	}

	private static final int CIRCLE_RADIUS = 80;

	private int[] points = new int[6];
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	public void paintCanvas(CanvasContext cc) {
		Dimension size = blockFigure.getCanvasSize();
		
		points[0] = size.width - 2 * CIRCLE_RADIUS - DEFAULT_LINE_WIDTH;
		points[1] = size.height / 2;
		points[2] = DEFAULT_LINE_WIDTH_HALF;
		points[3] = DEFAULT_LINE_WIDTH;
		points[4] = DEFAULT_LINE_WIDTH_HALF;
		points[5] = size.height - DEFAULT_LINE_WIDTH;
		
		cc.setLineWidth(DEFAULT_LINE_WIDTH);
		cc.drawPolygon(points);
		cc.drawOval(points[0] + DEFAULT_LINE_WIDTH_HALF, points[1] - CIRCLE_RADIUS, 2 * CIRCLE_RADIUS, 2 * CIRCLE_RADIUS);
	}

}
