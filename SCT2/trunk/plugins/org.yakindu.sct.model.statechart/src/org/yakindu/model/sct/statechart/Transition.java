/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.model.sct.statechart;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.model.sct.statechart.Transition#getTarget <em>Target</em>}</li>
 *   <li>{@link org.yakindu.model.sct.statechart.Transition#getSource <em>Source</em>}</li>
 *   <li>{@link org.yakindu.model.sct.statechart.Transition#getRegion <em>Region</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.model.sct.statechart.StatechartPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends ExpressionElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2011 committers of YAKINDU and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\nContributors:\r\ncommitters of YAKINDU - initial API and implementation\r\n";

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.yakindu.model.sct.statechart.Vertex#getIncomingTransitions <em>Incoming Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Vertex)
	 * @see org.yakindu.model.sct.statechart.StatechartPackage#getTransition_Target()
	 * @see org.yakindu.model.sct.statechart.Vertex#getIncomingTransitions
	 * @model opposite="incomingTransitions" required="true" ordered="false"
	 * @generated
	 */
	Vertex getTarget();

	/**
	 * Sets the value of the '{@link org.yakindu.model.sct.statechart.Transition#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Vertex value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.yakindu.model.sct.statechart.Vertex#getOutgoingTransitions <em>Outgoing Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Vertex)
	 * @see org.yakindu.model.sct.statechart.StatechartPackage#getTransition_Source()
	 * @see org.yakindu.model.sct.statechart.Vertex#getOutgoingTransitions
	 * @model opposite="outgoingTransitions" required="true" ordered="false"
	 * @generated
	 */
	Vertex getSource();

	/**
	 * Sets the value of the '{@link org.yakindu.model.sct.statechart.Transition#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Vertex value);

	/**
	 * Returns the value of the '<em><b>Region</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.yakindu.model.sct.statechart.Region#getTransitions <em>Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Region</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Region</em>' container reference.
	 * @see #setRegion(Region)
	 * @see org.yakindu.model.sct.statechart.StatechartPackage#getTransition_Region()
	 * @see org.yakindu.model.sct.statechart.Region#getTransitions
	 * @model opposite="transitions" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Region getRegion();

	/**
	 * Sets the value of the '{@link org.yakindu.model.sct.statechart.Transition#getRegion <em>Region</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Region</em>' container reference.
	 * @see #getRegion()
	 * @generated
	 */
	void setRegion(Region value);

} // Transition
