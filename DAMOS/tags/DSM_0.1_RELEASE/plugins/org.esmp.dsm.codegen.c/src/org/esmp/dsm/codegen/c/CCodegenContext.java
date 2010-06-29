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

package org.esmp.dsm.codegen.c;

import java.util.Map;

/**
 * @author Andreas Unger
 *
 */
public interface CCodegenContext {

	String getHeaderFolder();
	String getSourceFolder();
	String getPrefix();
	long getSamplingFrequency();
	
	Map<Object, Object> getData();

}
