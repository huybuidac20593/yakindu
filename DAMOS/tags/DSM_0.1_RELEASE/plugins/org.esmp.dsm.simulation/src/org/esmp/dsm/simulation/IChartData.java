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

package org.esmp.dsm.simulation;


/**
 * @author Andreas Unger
 *
 */
public interface IChartData {

	String getChartTitle();
	String getXAxisTitle();
	String getYAxisTitle();

	double[][] getXValues();
	double[][] getYValues();
	
}
