/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.NamedTypeSpecifier;
import org.eclipselabs.mscript.language.ast.SymbolReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Type Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.NamedTypeSpecifierImpl#getTypeReference <em>Type Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NamedTypeSpecifierImpl extends DataTypeSpecifierImpl implements NamedTypeSpecifier
{
  /**
   * The cached value of the '{@link #getTypeReference() <em>Type Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeReference()
   * @generated
   * @ordered
   */
  protected SymbolReference typeReference;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NamedTypeSpecifierImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return AstPackage.Literals.NAMED_TYPE_SPECIFIER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SymbolReference getTypeReference()
  {
    return typeReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTypeReference(SymbolReference newTypeReference, NotificationChain msgs)
  {
    SymbolReference oldTypeReference = typeReference;
    typeReference = newTypeReference;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.NAMED_TYPE_SPECIFIER__TYPE_REFERENCE, oldTypeReference, newTypeReference);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeReference(SymbolReference newTypeReference)
  {
    if (newTypeReference != typeReference)
    {
      NotificationChain msgs = null;
      if (typeReference != null)
        msgs = ((InternalEObject)typeReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.NAMED_TYPE_SPECIFIER__TYPE_REFERENCE, null, msgs);
      if (newTypeReference != null)
        msgs = ((InternalEObject)newTypeReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.NAMED_TYPE_SPECIFIER__TYPE_REFERENCE, null, msgs);
      msgs = basicSetTypeReference(newTypeReference, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.NAMED_TYPE_SPECIFIER__TYPE_REFERENCE, newTypeReference, newTypeReference));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case AstPackage.NAMED_TYPE_SPECIFIER__TYPE_REFERENCE:
        return basicSetTypeReference(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case AstPackage.NAMED_TYPE_SPECIFIER__TYPE_REFERENCE:
        return getTypeReference();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AstPackage.NAMED_TYPE_SPECIFIER__TYPE_REFERENCE:
        setTypeReference((SymbolReference)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case AstPackage.NAMED_TYPE_SPECIFIER__TYPE_REFERENCE:
        setTypeReference((SymbolReference)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case AstPackage.NAMED_TYPE_SPECIFIER__TYPE_REFERENCE:
        return typeReference != null;
    }
    return super.eIsSet(featureID);
  }

} //NamedTypeSpecifierImpl
