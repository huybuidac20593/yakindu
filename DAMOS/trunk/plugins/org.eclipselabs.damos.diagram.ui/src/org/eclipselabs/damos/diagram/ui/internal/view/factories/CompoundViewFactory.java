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

package org.eclipselabs.damos.diagram.ui.internal.view.factories;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;
import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipselabs.damos.diagram.ui.view.ISemanticHints;

public class CompoundViewFactory extends AbstractShapeViewFactory {

	protected void decorateView(View containerView, View view, IAdaptable element, String semanticHint, int index, boolean persisted) {
		super.decorateView(containerView, view, element, semanticHint, index, persisted);
		ShapeStyle style = (ShapeStyle) view.getStyle(NotationPackage.eINSTANCE.getShapeStyle());
		style.setLineColor(0x555555);
		style.setFontColor(0);

        GradientData gradientData = new GradientData();
        gradientData.setGradientColor1(0xfcfcfc);
        gradientData.setGradientColor2(0xf0f0f0);
        gradientData.setGradientStyle(GradientStyle.VERTICAL);
        style.setGradient(gradientData);

        getViewService().createNode(element, view, ISemanticHints.COMPOUND_COMPARTMENT, ViewUtil.APPEND, getPreferencesHint());
	}
	
}
