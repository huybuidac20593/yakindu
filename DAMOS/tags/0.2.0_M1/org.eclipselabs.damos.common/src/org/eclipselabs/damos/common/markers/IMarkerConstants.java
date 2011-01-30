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

package org.eclipselabs.damos.common.markers;

import org.eclipselabs.damos.common.CommonPlugin;

/**
 * @author Andreas Unger
 *
 * @noextend
 * @noimplement
 */
public interface IMarkerConstants {

	String PROBLEM_MARKER_ID = CommonPlugin.PLUGIN_ID + ".damosProblem";
	String ATTRIBUTE__ELEMENT_URI = CommonPlugin.PLUGIN_ID + ".elementURI";
	String ATTRIBUTE__FRAGMENT_URI = CommonPlugin.PLUGIN_ID + ".fragmentURI";
	
}
