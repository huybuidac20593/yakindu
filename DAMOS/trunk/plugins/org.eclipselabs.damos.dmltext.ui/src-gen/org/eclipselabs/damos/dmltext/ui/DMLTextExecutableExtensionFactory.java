/*
 * generated by Xtext
 */
package org.eclipselabs.damos.dmltext.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class DMLTextExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return org.eclipselabs.damos.dmltext.ui.internal.DMLTextActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return org.eclipselabs.damos.dmltext.ui.internal.DMLTextActivator.getInstance().getInjector("org.eclipselabs.damos.dmltext.DMLText");
	}
	
}
