/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.extensions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExpressionLanguageProviderExtensions {

	private static final String EXPRESSIONS_EXTENSION = "org.yakindu.sct.ui.editor.expressions";

	private static final String ATTR_CLASS = "class";

	private static final String ATTR_RESOURCE_EXTENSION = "resourceExtension";

	private static final String ATTR_SEMANTIC_TARGET = "semanticTarget";

	public enum SemanticTarget {
		StatechartInterface, StateDeclaration, TransitionExpression
	}

	protected ExpressionLanguageProviderExtensions() {
		// Not intended to be instantiated
	}

	/**
	 * Returns all registered {@link IExpressionLanguageProvider}s
	 * 
	 */
	public static IExpressionLanguageProvider getRegisteredProvider(
			SemanticTarget target, String resourceExtension) {
		IConfigurationElement[] configurationElements = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						EXPRESSIONS_EXTENSION);
		for (IConfigurationElement configurationElement : configurationElements) {
			try {
				String semanticTarget = configurationElement
						.getAttribute(ATTR_SEMANTIC_TARGET);
				String registeredExtension = configurationElement
						.getAttribute(ATTR_RESOURCE_EXTENSION);
				if (SemanticTarget.valueOf(semanticTarget) == target
						&& resourceExtension.endsWith(registeredExtension)) {
					return (IExpressionLanguageProvider) configurationElement
							.createExecutableExtension(ATTR_CLASS);
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return new IExpressionLanguageProvider.NullLanguageProvider();
	}
}
