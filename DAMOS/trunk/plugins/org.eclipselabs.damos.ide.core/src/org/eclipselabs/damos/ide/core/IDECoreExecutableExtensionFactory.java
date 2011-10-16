/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.ide.core;

import org.eclipselabs.damos.common.inject.AbstractGuiceAwareExecutableExtensionFactory;
import org.eclipselabs.damos.dmltext.DMLTextRuntimeModule;
import org.osgi.framework.Bundle;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.util.Modules;

/**
 * @author Andreas Unger
 *
 */
public class IDECoreExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.common.inject.AbstractGuiceAwareExecutableExtensionFactory#getBundle()
	 */
	@Override
	protected Bundle getBundle() {
		return IDECorePlugin.getDefault().getBundle();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.common.inject.AbstractGuiceAwareExecutableExtensionFactory#getInjector()
	 */
	@Override
	protected Injector getInjector() {
		return Guice.createInjector(Modules.override(new DMLTextRuntimeModule()).with(new IDEModule()));
	}

}
