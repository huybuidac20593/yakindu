/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.notation.blockdiagramnotation.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.esmp.dsm.notation.blockdiagramnotation.BlockDiagramNotationFactory;
import org.esmp.dsm.notation.blockdiagramnotation.BlockDiagramNotationPackage;
import org.esmp.dsm.notation.blockdiagramnotation.BlockLayoutConstraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BlockDiagramNotationPackageImpl extends EPackageImpl implements BlockDiagramNotationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockLayoutConstraintEClass = null;
	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.esmp.dsm.notation.blockdiagramnotation.BlockDiagramNotationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BlockDiagramNotationPackageImpl() {
		super(eNS_URI, BlockDiagramNotationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link BlockDiagramNotationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BlockDiagramNotationPackage init() {
		if (isInited) return (BlockDiagramNotationPackage)EPackage.Registry.INSTANCE.getEPackage(BlockDiagramNotationPackage.eNS_URI);

		// Obtain or create and register package
		BlockDiagramNotationPackageImpl theBlockDiagramNotationPackage = (BlockDiagramNotationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BlockDiagramNotationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BlockDiagramNotationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		NotationPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theBlockDiagramNotationPackage.createPackageContents();

		// Initialize created meta-data
		theBlockDiagramNotationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBlockDiagramNotationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BlockDiagramNotationPackage.eNS_URI, theBlockDiagramNotationPackage);
		return theBlockDiagramNotationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlockLayoutConstraint() {
		return blockLayoutConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlockLayoutConstraint_Flipped() {
		return (EAttribute)blockLayoutConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlockLayoutConstraint_Rotation() {
		return (EAttribute)blockLayoutConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockDiagramNotationFactory getBlockDiagramNotationFactory() {
		return (BlockDiagramNotationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		blockLayoutConstraintEClass = createEClass(BLOCK_LAYOUT_CONSTRAINT);
		createEAttribute(blockLayoutConstraintEClass, BLOCK_LAYOUT_CONSTRAINT__FLIPPED);
		createEAttribute(blockLayoutConstraintEClass, BLOCK_LAYOUT_CONSTRAINT__ROTATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		NotationPackage theNotationPackage = (NotationPackage)EPackage.Registry.INSTANCE.getEPackage(NotationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		blockLayoutConstraintEClass.getESuperTypes().add(theNotationPackage.getBounds());

		// Initialize classes and features; add operations and parameters
		initEClass(blockLayoutConstraintEClass, BlockLayoutConstraint.class, "BlockLayoutConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBlockLayoutConstraint_Flipped(), ecorePackage.getEBoolean(), "flipped", null, 0, 1, BlockLayoutConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlockLayoutConstraint_Rotation(), ecorePackage.getEInt(), "rotation", null, 0, 1, BlockLayoutConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //BlockDiagramNotationPackageImpl
