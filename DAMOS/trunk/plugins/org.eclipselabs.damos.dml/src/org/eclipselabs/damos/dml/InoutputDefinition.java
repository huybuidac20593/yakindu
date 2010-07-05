/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml;




/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inoutput Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.InoutputDefinition#getMinimumPortCount <em>Minimum Port Count</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.InoutputDefinition#getMaximumPortCount <em>Maximum Port Count</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.InoutputDefinition#isManyPorts <em>Many Ports</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.InoutputDefinition#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dml.DMLPackage#getInoutputDefinition()
 * @model abstract="true"
 * @generated
 */
public interface InoutputDefinition extends ParameterableElement {
	/**
	 * Returns the value of the '<em><b>Minimum Port Count</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum Port Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum Port Count</em>' attribute.
	 * @see #setMinimumPortCount(int)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getInoutputDefinition_MinimumPortCount()
	 * @model default="1" required="true" ordered="false"
	 * @generated
	 */
	int getMinimumPortCount();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.InoutputDefinition#getMinimumPortCount <em>Minimum Port Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum Port Count</em>' attribute.
	 * @see #getMinimumPortCount()
	 * @generated
	 */
	void setMinimumPortCount(int value);

	/**
	 * Returns the value of the '<em><b>Maximum Port Count</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Port Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Port Count</em>' attribute.
	 * @see #setMaximumPortCount(int)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getInoutputDefinition_MaximumPortCount()
	 * @model default="1" required="true" ordered="false"
	 * @generated
	 */
	int getMaximumPortCount();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.InoutputDefinition#getMaximumPortCount <em>Maximum Port Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Port Count</em>' attribute.
	 * @see #getMaximumPortCount()
	 * @generated
	 */
	void setMaximumPortCount(int value);

	/**
	 * Returns the value of the '<em><b>Many Ports</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Ports</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many Ports</em>' attribute.
	 * @see org.eclipselabs.damos.dml.DMLPackage#getInoutputDefinition_ManyPorts()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isManyPorts();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getInoutputDefinition_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.InoutputDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // InoutputDefinition
