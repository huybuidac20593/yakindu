/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.typesystem.edit.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipselabs.mscript.typesystem.TypeSystem;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.TypeSystemPackage;

import org.eclipselabs.mscript.typesystem.edit.TypeSystemEditPlugin;

/**
 * This is the item provider adapter for a {@link org.eclipselabs.mscript.typesystem.TypeSystem} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TypeSystemItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeSystemItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(TypeSystemPackage.Literals.TYPE_SYSTEM__TOP_LEVEL_ELEMENTS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns TypeSystem.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/TypeSystem"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_TypeSystem_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(TypeSystem.class)) {
			case TypeSystemPackage.TYPE_SYSTEM__TOP_LEVEL_ELEMENTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(TypeSystemPackage.Literals.TYPE_SYSTEM__TOP_LEVEL_ELEMENTS,
				 TypeSystemFactory.eINSTANCE.createArrayType()));

		newChildDescriptors.add
			(createChildParameter
				(TypeSystemPackage.Literals.TYPE_SYSTEM__TOP_LEVEL_ELEMENTS,
				 TypeSystemFactory.eINSTANCE.createRealType()));

		newChildDescriptors.add
			(createChildParameter
				(TypeSystemPackage.Literals.TYPE_SYSTEM__TOP_LEVEL_ELEMENTS,
				 TypeSystemFactory.eINSTANCE.createIntegerType()));

		newChildDescriptors.add
			(createChildParameter
				(TypeSystemPackage.Literals.TYPE_SYSTEM__TOP_LEVEL_ELEMENTS,
				 TypeSystemFactory.eINSTANCE.createBooleanType()));

		newChildDescriptors.add
			(createChildParameter
				(TypeSystemPackage.Literals.TYPE_SYSTEM__TOP_LEVEL_ELEMENTS,
				 TypeSystemFactory.eINSTANCE.createStringType()));

		newChildDescriptors.add
			(createChildParameter
				(TypeSystemPackage.Literals.TYPE_SYSTEM__TOP_LEVEL_ELEMENTS,
				 TypeSystemFactory.eINSTANCE.createEnumeration()));

		newChildDescriptors.add
			(createChildParameter
				(TypeSystemPackage.Literals.TYPE_SYSTEM__TOP_LEVEL_ELEMENTS,
				 TypeSystemFactory.eINSTANCE.createEnumerationLiteral()));

		newChildDescriptors.add
			(createChildParameter
				(TypeSystemPackage.Literals.TYPE_SYSTEM__TOP_LEVEL_ELEMENTS,
				 TypeSystemFactory.eINSTANCE.createInvalidDataType()));

		newChildDescriptors.add
			(createChildParameter
				(TypeSystemPackage.Literals.TYPE_SYSTEM__TOP_LEVEL_ELEMENTS,
				 TypeSystemFactory.eINSTANCE.createPackage()));

		newChildDescriptors.add
			(createChildParameter
				(TypeSystemPackage.Literals.TYPE_SYSTEM__TOP_LEVEL_ELEMENTS,
				 TypeSystemFactory.eINSTANCE.createTensorType()));

		newChildDescriptors.add
			(createChildParameter
				(TypeSystemPackage.Literals.TYPE_SYSTEM__TOP_LEVEL_ELEMENTS,
				 TypeSystemFactory.eINSTANCE.createRecord()));

		newChildDescriptors.add
			(createChildParameter
				(TypeSystemPackage.Literals.TYPE_SYSTEM__TOP_LEVEL_ELEMENTS,
				 TypeSystemFactory.eINSTANCE.createUnitType()));

		newChildDescriptors.add
			(createChildParameter
				(TypeSystemPackage.Literals.TYPE_SYSTEM__TOP_LEVEL_ELEMENTS,
				 TypeSystemFactory.eINSTANCE.createAnyDataType()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return TypeSystemEditPlugin.INSTANCE;
	}

}
