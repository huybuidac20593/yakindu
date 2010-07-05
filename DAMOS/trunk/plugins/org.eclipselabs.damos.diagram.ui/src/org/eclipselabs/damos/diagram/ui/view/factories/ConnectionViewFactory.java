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

package org.eclipselabs.damos.diagram.ui.view.factories;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.notation.ConnectorStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.View;

public class ConnectionViewFactory extends org.eclipse.gmf.runtime.diagram.ui.view.factories.ConnectionViewFactory {
	
	protected void decorateView(View containerView, View view, IAdaptable element, String semanticHint, int index, boolean persisted) {
		super.decorateView(containerView, view, element, semanticHint, index, persisted);
        ConnectorStyle connectorStyle = (ConnectorStyle) view.getStyle(NotationPackage.eINSTANCE.getConnectorStyle());
        connectorStyle.setLineColor((FigureUtilities.colorToInteger(ColorConstants.black)).intValue());
        connectorStyle.setRouting(Routing.RECTILINEAR_LITERAL);
	}
	
}
