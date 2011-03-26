package org.eclipselabs.damos.diagram.ui.internal.editpolicies;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.view.ISemanticHints;

/**
 * @author Andreas Unger
 *
 */
public abstract class CompoundCanonicalEditPolicy extends CanonicalEditPolicy {

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy#shouldDeleteView(org.eclipse.gmf.runtime.notation.View)
	 */
	@Override
	protected boolean shouldDeleteView(View view) {
		return !ISemanticHints.COMPOUND_COMPARTMENT.equals(view.getType());
	}
	
}