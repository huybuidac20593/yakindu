
/*
* generated by Xtext
*/
package org.yakindu.sct.generator.genmodel.ui.refactoring;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategy;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.ui.jvmmodel.refactoring.AbstractJvmModelRenameStrategy;

import com.google.inject.Inject;

/**
 * Encapsulates the model changes of a rename refactoring.  
 */
@SuppressWarnings("all")
public class SGenRenameStrategy extends AbstractJvmModelRenameStrategy {

	public static class Provider extends DefaultRenameStrategy.Provider {

		@Inject
		private IJvmModelAssociations jvmModelAssociations;

		@Override
		public IRenameStrategy get(EObject targetElement, IRenameElementContext renameElementContext) {
			return new SGenRenameStrategy(targetElement, getLocationInFileProvider(), jvmModelAssociations);
		}
	}
	
	protected SGenRenameStrategy(EObject targetElement, ILocationInFileProvider locationInFileProvider,
			IJvmModelAssociations jvmModelAssociations) {
		super(targetElement, locationInFileProvider, jvmModelAssociations);
	}

	@Override
	protected void setInferredJvmElementName(String name, EObject renamedSourceElement) {
		/*
		 * TODO: rename inferred elements as you would in IJvmModelInferrer 
		 */
	}
}
