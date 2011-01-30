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

package org.eclipselabs.damos.execution.engine;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.dml.Component;

/**
 * @author Andreas Unger
 *
 */
public class ComponentSignatureResolverResult {

	private Map<Component, IComponentSignature> signatures = new HashMap<Component, IComponentSignature>();
	private IStatus status = Status.OK_STATUS;
	
	/**
	 * 
	 */
	public ComponentSignatureResolverResult(Map<Component, IComponentSignature> signatures) {
		this.signatures = signatures;
	}

	/**
	 * 
	 */
	public ComponentSignatureResolverResult(Map<Component, IComponentSignature> signatures, IStatus status) {
		this.signatures = signatures;
		this.status = status;
	}

	public Map<Component, IComponentSignature> getSignatures() {
		return signatures;
	}
	
	/**
	 * @return the status
	 */
	public IStatus getStatus() {
		return status;
	}
	
}
