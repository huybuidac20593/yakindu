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

package org.eclipselabs.mscript.computation.engine.value;

import org.eclipselabs.mscript.computation.engine.IComputationContext;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.TensorType;

/**
 * @author Andreas Unger
 *
 */
public class VectorValue extends AbstractExplicitDataTypeValue implements IArrayValue {

	private INumericValue[] elements;
	
	/**
	 * @param context
	 * @param dataType
	 */
	public VectorValue(IComputationContext context, TensorType dataType, INumericValue[] elements) {
		super(context, dataType);
		if (!dataType.isVector()) {
			throw new IllegalArgumentException("Tensor type must be vector");
		}
		if (elements.length != dataType.getSize()) {
			throw new IllegalArgumentException("Number of elements must be equal to vector size");
		}
		this.elements = elements;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.engine.value.AbstractExplicitDataTypeValue#getDataType()
	 */
	@Override
	public TensorType getDataType() {
		return (TensorType) super.getDataType();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.engine.value.AbstractValue#doConvert(org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doConvert(DataType dataType) {
		return null;
	}
	
	public INumericValue get(int index) {
		return elements[index];
	}

	public IValue get(int rowIndex, int columnIndex) {
		throw new UnsupportedOperationException();
	}
	
	public INumericValue get(int... indices) {
		if (indices.length != 1) {
			throw new IllegalArgumentException("Index array length must be 1");
		}
		return elements[indices[0]];
	}
	
	public void set(int index, IValue value) {
		if (!(value instanceof INumericValue)) {
			throw new IllegalArgumentException("Value must be numeric");
		}
		elements[index] = (INumericValue) value;
	}
	
	public void set(int rowIndex, int columnIndex, IValue value) {
		throw new UnsupportedOperationException();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.engine.value.IArrayValue#set(int[], org.eclipselabs.mscript.computation.engine.value.IValue)
	 */
	public void set(int[] indices, IValue value) {
		if (indices.length != 1) {
			throw new IllegalArgumentException("Index array length must be 1");
		}
		if (!(value instanceof INumericValue)) {
			throw new IllegalArgumentException("Value must be numeric");
		}
		elements[indices[0]] = (INumericValue) value;
	}
	
}
