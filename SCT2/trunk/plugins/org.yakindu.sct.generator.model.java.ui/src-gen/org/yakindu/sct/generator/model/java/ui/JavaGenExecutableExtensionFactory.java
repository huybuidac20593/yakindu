/*
 * generated by Xtext
 */
package org.yakindu.sct.generator.model.java.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class JavaGenExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return org.yakindu.sct.generator.model.java.ui.internal.JavaGenActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return org.yakindu.sct.generator.model.java.ui.internal.JavaGenActivator.getInstance().getInjector("org.yakindu.sct.generator.model.java.JavaGen");
	}
	
}
