/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.protocol.ProtocolPackage;
import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkPackage;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.PCMLinkPackageImpl;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.AfterExternalCallLoggingPositionLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeExternalCallLoggingPositionLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeReturnValueLoggingPositionLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BranchLoggingPositionLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.InputLoggingPositionLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkFactory;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggingPositionIdLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoopLoggingPositionLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.MethodCallLoggingPositionLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.OutputLoggingPositionLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourcecodedecoratorPackage;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourcecodedecoratorPackageImpl;
import de.uka.ipd.sdq.pcm.subsystem.SubsystemPackage;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LoggerlinkPackageImpl extends EPackageImpl implements LoggerlinkPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass beforeReturnValueLoggingPositionLinkEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputLoggingPositionLinkEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass beforeExternalCallLoggingPositionLinkEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodCallLoggingPositionLinkEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputLoggingPositionLinkEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass afterExternalCallLoggingPositionLinkEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass branchLoggingPositionLinkEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopLoggingPositionLinkEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loggingPositionIdLinkEClass = null;
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
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private LoggerlinkPackageImpl() {
		super(eNS_URI, LoggerlinkFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link LoggerlinkPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static LoggerlinkPackage init() {
		if (isInited) return (LoggerlinkPackage)EPackage.Registry.INSTANCE.getEPackage(LoggerlinkPackage.eNS_URI);

		// Obtain or create and register package
		LoggerlinkPackageImpl theLoggerlinkPackage = (LoggerlinkPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LoggerlinkPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LoggerlinkPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		RepositoryPackage.eINSTANCE.eClass();
		ProtocolPackage.eINSTANCE.eClass();
		ParameterPackage.eINSTANCE.eClass();
		SeffPackage.eINSTANCE.eClass();
		ResourcetypePackage.eINSTANCE.eClass();
		AllocationPackage.eINSTANCE.eClass();
		ResourceenvironmentPackage.eINSTANCE.eClass();
		SystemPackage.eINSTANCE.eClass();
		QosannotationsPackage.eINSTANCE.eClass();
		UsagemodelPackage.eINSTANCE.eClass();
		SubsystemPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		SourcecodedecoratorPackageImpl theSourcecodedecoratorPackage = (SourcecodedecoratorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SourcecodedecoratorPackage.eNS_URI) instanceof SourcecodedecoratorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SourcecodedecoratorPackage.eNS_URI) : SourcecodedecoratorPackage.eINSTANCE);
		PCMLinkPackageImpl thePCMLinkPackage = (PCMLinkPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PCMLinkPackage.eNS_URI) instanceof PCMLinkPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PCMLinkPackage.eNS_URI) : PCMLinkPackage.eINSTANCE);

		// Create package meta-data objects
		theLoggerlinkPackage.createPackageContents();
		theSourcecodedecoratorPackage.createPackageContents();
		thePCMLinkPackage.createPackageContents();

		// Initialize created meta-data
		theLoggerlinkPackage.initializePackageContents();
		theSourcecodedecoratorPackage.initializePackageContents();
		thePCMLinkPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theLoggerlinkPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(LoggerlinkPackage.eNS_URI, theLoggerlinkPackage);
		return theLoggerlinkPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBeforeReturnValueLoggingPositionLink() {
		return beforeReturnValueLoggingPositionLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBeforeReturnValueLoggingPositionLink_LinkedSetVariableAction() {
		return (EReference)beforeReturnValueLoggingPositionLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputLoggingPositionLink() {
		return outputLoggingPositionLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBeforeExternalCallLoggingPositionLink() {
		return beforeExternalCallLoggingPositionLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBeforeExternalCallLoggingPositionLink_LinkedExternalCallAction() {
		return (EReference)beforeExternalCallLoggingPositionLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMethodCallLoggingPositionLink() {
		return methodCallLoggingPositionLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMethodCallLoggingPositionLink_LinkedServiceEffectSpecification() {
		return (EReference)methodCallLoggingPositionLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputLoggingPositionLink() {
		return inputLoggingPositionLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAfterExternalCallLoggingPositionLink() {
		return afterExternalCallLoggingPositionLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAfterExternalCallLoggingPositionLink_LinkedExternalCallAction() {
		return (EReference)afterExternalCallLoggingPositionLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBranchLoggingPositionLink() {
		return branchLoggingPositionLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBranchLoggingPositionLink_LinkedGuardedBranchTransition() {
		return (EReference)branchLoggingPositionLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopLoggingPositionLink() {
		return loopLoggingPositionLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopLoggingPositionLink_LinkedLoopAction() {
		return (EReference)loopLoggingPositionLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoggingPositionIdLink() {
		return loggingPositionIdLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoggingPositionIdLink_LoggingPositionId() {
		return (EAttribute)loggingPositionIdLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoggerlinkFactory getLoggerlinkFactory() {
		return (LoggerlinkFactory)getEFactoryInstance();
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
		beforeReturnValueLoggingPositionLinkEClass = createEClass(BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK);
		createEReference(beforeReturnValueLoggingPositionLinkEClass, BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__LINKED_SET_VARIABLE_ACTION);

		outputLoggingPositionLinkEClass = createEClass(OUTPUT_LOGGING_POSITION_LINK);

		beforeExternalCallLoggingPositionLinkEClass = createEClass(BEFORE_EXTERNAL_CALL_LOGGING_POSITION_LINK);
		createEReference(beforeExternalCallLoggingPositionLinkEClass, BEFORE_EXTERNAL_CALL_LOGGING_POSITION_LINK__LINKED_EXTERNAL_CALL_ACTION);

		methodCallLoggingPositionLinkEClass = createEClass(METHOD_CALL_LOGGING_POSITION_LINK);
		createEReference(methodCallLoggingPositionLinkEClass, METHOD_CALL_LOGGING_POSITION_LINK__LINKED_SERVICE_EFFECT_SPECIFICATION);

		inputLoggingPositionLinkEClass = createEClass(INPUT_LOGGING_POSITION_LINK);

		afterExternalCallLoggingPositionLinkEClass = createEClass(AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK);
		createEReference(afterExternalCallLoggingPositionLinkEClass, AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__LINKED_EXTERNAL_CALL_ACTION);

		branchLoggingPositionLinkEClass = createEClass(BRANCH_LOGGING_POSITION_LINK);
		createEReference(branchLoggingPositionLinkEClass, BRANCH_LOGGING_POSITION_LINK__LINKED_GUARDED_BRANCH_TRANSITION);

		loopLoggingPositionLinkEClass = createEClass(LOOP_LOGGING_POSITION_LINK);
		createEReference(loopLoggingPositionLinkEClass, LOOP_LOGGING_POSITION_LINK__LINKED_LOOP_ACTION);

		loggingPositionIdLinkEClass = createEClass(LOGGING_POSITION_ID_LINK);
		createEAttribute(loggingPositionIdLinkEClass, LOGGING_POSITION_ID_LINK__LOGGING_POSITION_ID);
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
		SeffPackage theSeffPackage = (SeffPackage)EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);
		IdentifierPackage theIdentifierPackage = (IdentifierPackage)EPackage.Registry.INSTANCE.getEPackage(IdentifierPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		beforeReturnValueLoggingPositionLinkEClass.getESuperTypes().add(this.getOutputLoggingPositionLink());
		outputLoggingPositionLinkEClass.getESuperTypes().add(this.getLoggingPositionIdLink());
		beforeExternalCallLoggingPositionLinkEClass.getESuperTypes().add(this.getOutputLoggingPositionLink());
		methodCallLoggingPositionLinkEClass.getESuperTypes().add(this.getInputLoggingPositionLink());
		inputLoggingPositionLinkEClass.getESuperTypes().add(this.getLoggingPositionIdLink());
		afterExternalCallLoggingPositionLinkEClass.getESuperTypes().add(this.getInputLoggingPositionLink());
		branchLoggingPositionLinkEClass.getESuperTypes().add(this.getOutputLoggingPositionLink());
		loopLoggingPositionLinkEClass.getESuperTypes().add(this.getOutputLoggingPositionLink());
		loggingPositionIdLinkEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());

		// Initialize classes and features; add operations and parameters
		initEClass(beforeReturnValueLoggingPositionLinkEClass, BeforeReturnValueLoggingPositionLink.class, "BeforeReturnValueLoggingPositionLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBeforeReturnValueLoggingPositionLink_LinkedSetVariableAction(), theSeffPackage.getSetVariableAction(), null, "linkedSetVariableAction", null, 1, 1, BeforeReturnValueLoggingPositionLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(outputLoggingPositionLinkEClass, OutputLoggingPositionLink.class, "OutputLoggingPositionLink", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(beforeExternalCallLoggingPositionLinkEClass, BeforeExternalCallLoggingPositionLink.class, "BeforeExternalCallLoggingPositionLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBeforeExternalCallLoggingPositionLink_LinkedExternalCallAction(), theSeffPackage.getExternalCallAction(), null, "linkedExternalCallAction", null, 1, 1, BeforeExternalCallLoggingPositionLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(methodCallLoggingPositionLinkEClass, MethodCallLoggingPositionLink.class, "MethodCallLoggingPositionLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMethodCallLoggingPositionLink_LinkedServiceEffectSpecification(), theSeffPackage.getResourceDemandingSEFF(), null, "linkedServiceEffectSpecification", null, 1, 1, MethodCallLoggingPositionLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(inputLoggingPositionLinkEClass, InputLoggingPositionLink.class, "InputLoggingPositionLink", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(afterExternalCallLoggingPositionLinkEClass, AfterExternalCallLoggingPositionLink.class, "AfterExternalCallLoggingPositionLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAfterExternalCallLoggingPositionLink_LinkedExternalCallAction(), theSeffPackage.getExternalCallAction(), null, "linkedExternalCallAction", null, 1, 1, AfterExternalCallLoggingPositionLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(branchLoggingPositionLinkEClass, BranchLoggingPositionLink.class, "BranchLoggingPositionLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBranchLoggingPositionLink_LinkedGuardedBranchTransition(), theSeffPackage.getGuardedBranchTransition(), null, "linkedGuardedBranchTransition", null, 1, 1, BranchLoggingPositionLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(loopLoggingPositionLinkEClass, LoopLoggingPositionLink.class, "LoopLoggingPositionLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoopLoggingPositionLink_LinkedLoopAction(), theSeffPackage.getLoopAction(), null, "linkedLoopAction", null, 1, 1, LoopLoggingPositionLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(loggingPositionIdLinkEClass, LoggingPositionIdLink.class, "LoggingPositionIdLink", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLoggingPositionIdLink_LoggingPositionId(), ecorePackage.getEString(), "loggingPositionId", null, 1, 1, LoggingPositionIdLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //LoggerlinkPackageImpl