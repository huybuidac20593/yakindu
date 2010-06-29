/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.esmp.dsm.library.signal.ui.figures;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.swt.SWT;
import org.esmp.dsm.diagram.ui.figures.CanvasContext;
import org.esmp.dsm.diagram.ui.figures.FigureConstants;
import org.esmp.dsm.diagram.ui.figures.RectangularBlockFigure;

/**
 * @author Andreas Unger
 *
 */
public class SwitchFigure extends RectangularBlockFigure implements FigureConstants {

	public Dimension calculateMinimumCanvasSize(int wHint, int hHint) {
		if (minSize == null) {
			minSize = getPreferredCanvasSize().getCopy();
			if (minSize.width < minSize.height) {
				minSize.width = minSize.height;
			}
		}
		return minSize;
	}

	protected void paintCanvas(CanvasContext cc) {
		super.paintCanvas(cc);
		
		Dimension size = getCanvasSize();
		
		cc.setLineWidth(DEFAULT_LINE_WIDTH);

		cc.drawLine(0, size.height / 6, 300, size.height / 6);

		cc.drawLine(0, size.height / 2, 200, size.height / 2);
		cc.drawLine(200, size.height / 2 - 100, 200, size.height / 2 + 100);

		cc.drawLine(0, size.height - size.height / 6, 300, size.height - size.height / 6);

		cc.drawLine(size.width - 200, size.height / 2, size.width, size.height / 2);
		
		cc.drawLine(300, size.height / 6, size.width - 200, size.height / 2);
		
		cc.setLineStyle(SWT.LINE_DOT);
		cc.drawLine(300, size.height - size.height / 6, size.width - 200, size.height / 2);
	}

}
