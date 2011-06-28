/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.statechart.diagram.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.statechart.diagram.editor.figures.ChoiceFigure;
import org.yakindu.sct.statechart.diagram.editor.figures.utils.MapModeUtils;
import org.yakindu.sct.statechart.diagram.policies.RelationshipSemanticEditPolicy;

import de.itemis.gmf.runtime.commons.editparts.FixedSizeShapeNodeEditPart;

/**
 * 
 * @author andreas muelder
 * 
 */
public class ChoiceEditPart extends FixedSizeShapeNodeEditPart {

	public ChoiceEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new RelationshipSemanticEditPolicy());
	}

	@Override
	public Dimension getDefaultSize() {
		return MapModeUtils.getMappedDimensions(getMapMode(),
				MapModeUtils.DEFAULT_SMALL_NODE_DIMENSION);
	}

	@Override
	public IFigure getPrimaryShape() {
		return new ChoiceFigure();
	}

}
