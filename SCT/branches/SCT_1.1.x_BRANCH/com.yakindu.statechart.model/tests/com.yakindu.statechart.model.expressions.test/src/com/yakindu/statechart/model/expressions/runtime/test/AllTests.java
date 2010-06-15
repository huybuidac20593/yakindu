/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.statechart.model.expressions.runtime.test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
@RunWith(value=Suite.class)
@SuiteClasses(value={
		ExpressionsTest.class, 
		FunctionsTest.class,
		CoreFunctionsTest.class
		}) 
*/
public class AllTests extends TestSuite{
	
	public static Test suite() {
		TestSuite suite = new AllTests();
		suite.addTestSuite(ExpressionsTest.class);
		suite.addTestSuite(FunctionsTest.class);
		suite.addTestSuite(CoreFunctionsTest.class);
			
		return suite;
	}

	

}
