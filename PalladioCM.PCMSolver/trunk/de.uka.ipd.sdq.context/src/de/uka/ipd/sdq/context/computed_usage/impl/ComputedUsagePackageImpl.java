/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_usage.impl;

import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationPackage;

import de.uka.ipd.sdq.context.computed_allocation.impl.ComputedAllocationPackageImpl;

import de.uka.ipd.sdq.context.computed_usage.BranchProbability;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsage;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageFactory;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage;
import de.uka.ipd.sdq.context.computed_usage.ExternalCallInput;
import de.uka.ipd.sdq.context.computed_usage.ExternalCallOutput;
import de.uka.ipd.sdq.context.computed_usage.Input;
import de.uka.ipd.sdq.context.computed_usage.LoopIteration;

import de.uka.ipd.sdq.context.computed_usage.Output;
import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;

import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;

import de.uka.ipd.sdq.pcm.core.connectors.ConnectorsPackage;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;

import de.uka.ipd.sdq.pcm.protocol.ProtocolPackage;

import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;

import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import de.uka.ipd.sdq.pcm.system.SystemPackage;

import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

import de.uka.ipd.sdq.stoex.StoexPackage;

import de.uka.ipd.sdq.units.UnitsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComputedUsagePackageImpl extends EPackageImpl implements ComputedUsagePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computedUsageContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass branchProbabilityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopIterationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalCallOutputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalCallInputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computedUsageEClass = null;

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
	 * @see de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ComputedUsagePackageImpl() {
		super(eNS_URI, ComputedUsageFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ComputedUsagePackage init() {
		if (isInited) return (ComputedUsagePackage)EPackage.Registry.INSTANCE.getEPackage(ComputedUsagePackage.eNS_URI);

		// Obtain or create and register package
		ComputedUsagePackageImpl theComputedUsagePackage = (ComputedUsagePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ComputedUsagePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ComputedUsagePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IdentifierPackage.eINSTANCE.eClass();
		EntityPackage.eINSTANCE.eClass();
		ConnectorsPackage.eINSTANCE.eClass();
		CompositionPackage.eINSTANCE.eClass();
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
		StoexPackage.eINSTANCE.eClass();
		UnitsPackage.eINSTANCE.eClass();
		ProbfunctionPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ComputedAllocationPackageImpl theComputedAllocationPackage = (ComputedAllocationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ComputedAllocationPackage.eNS_URI) instanceof ComputedAllocationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ComputedAllocationPackage.eNS_URI) : ComputedAllocationPackage.eINSTANCE);

		// Create package meta-data objects
		theComputedUsagePackage.createPackageContents();
		theComputedAllocationPackage.createPackageContents();

		// Initialize created meta-data
		theComputedUsagePackage.initializePackageContents();
		theComputedAllocationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theComputedUsagePackage.freeze();

		return theComputedUsagePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComputedUsageContext() {
		return computedUsageContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputedUsageContext_BranchProbabilities_ComputedUsageContext() {
		return (EReference)computedUsageContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputedUsageContext_Loopiterations_ComputedUsageContext() {
		return (EReference)computedUsageContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputedUsageContext_AssemblyContext_ComputedUsageContext() {
		return (EReference)computedUsageContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputedUsageContext_Input_ComputedUsageContext() {
		return (EReference)computedUsageContextEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputedUsageContext_ExternalCallOutput_ComputedUsageContext() {
		return (EReference)computedUsageContextEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputedUsageContext_ExternalCallInput_ComputedUsageContext() {
		return (EReference)computedUsageContextEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputedUsageContext_Output_ComputedUsageContext() {
		return (EReference)computedUsageContextEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBranchProbability() {
		return branchProbabilityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBranchProbability_Probability() {
		return (EAttribute)branchProbabilityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBranchProbability_Branchtransition_BranchProbability() {
		return (EReference)branchProbabilityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopIteration() {
		return loopIterationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopIteration_Loopaction_LoopIteration() {
		return (EReference)loopIterationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopIteration_Specification_LoopIteration() {
		return (EReference)loopIterationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInput() {
		return inputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInput_ParameterChacterisations_Input() {
		return (EReference)inputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalCallOutput() {
		return externalCallOutputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalCallOutput_ParameterCharacterisations_ExternalCallOutput() {
		return (EReference)externalCallOutputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalCallOutput_ExternalCallAction_ExternalCallOutput() {
		return (EReference)externalCallOutputEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExternalCallInput() {
		return externalCallInputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalCallInput_ParameterCharacterisations_ExternalCallInput() {
		return (EReference)externalCallInputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExternalCallInput_ExternalCallAction_ExternalCallInput() {
		return (EReference)externalCallInputEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutput() {
		return outputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutput_ParameterCharacterisations_Output() {
		return (EReference)outputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComputedUsage() {
		return computedUsageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputedUsage_UsageContexts_ComputedUsage() {
		return (EReference)computedUsageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputedUsageFactory getComputedUsageFactory() {
		return (ComputedUsageFactory)getEFactoryInstance();
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
		computedUsageContextEClass = createEClass(COMPUTED_USAGE_CONTEXT);
		createEReference(computedUsageContextEClass, COMPUTED_USAGE_CONTEXT__BRANCH_PROBABILITIES_COMPUTED_USAGE_CONTEXT);
		createEReference(computedUsageContextEClass, COMPUTED_USAGE_CONTEXT__LOOPITERATIONS_COMPUTED_USAGE_CONTEXT);
		createEReference(computedUsageContextEClass, COMPUTED_USAGE_CONTEXT__ASSEMBLY_CONTEXT_COMPUTED_USAGE_CONTEXT);
		createEReference(computedUsageContextEClass, COMPUTED_USAGE_CONTEXT__INPUT_COMPUTED_USAGE_CONTEXT);
		createEReference(computedUsageContextEClass, COMPUTED_USAGE_CONTEXT__EXTERNAL_CALL_OUTPUT_COMPUTED_USAGE_CONTEXT);
		createEReference(computedUsageContextEClass, COMPUTED_USAGE_CONTEXT__EXTERNAL_CALL_INPUT_COMPUTED_USAGE_CONTEXT);
		createEReference(computedUsageContextEClass, COMPUTED_USAGE_CONTEXT__OUTPUT_COMPUTED_USAGE_CONTEXT);

		branchProbabilityEClass = createEClass(BRANCH_PROBABILITY);
		createEAttribute(branchProbabilityEClass, BRANCH_PROBABILITY__PROBABILITY);
		createEReference(branchProbabilityEClass, BRANCH_PROBABILITY__BRANCHTRANSITION_BRANCH_PROBABILITY);

		loopIterationEClass = createEClass(LOOP_ITERATION);
		createEReference(loopIterationEClass, LOOP_ITERATION__LOOPACTION_LOOP_ITERATION);
		createEReference(loopIterationEClass, LOOP_ITERATION__SPECIFICATION_LOOP_ITERATION);

		inputEClass = createEClass(INPUT);
		createEReference(inputEClass, INPUT__PARAMETER_CHACTERISATIONS_INPUT);

		externalCallOutputEClass = createEClass(EXTERNAL_CALL_OUTPUT);
		createEReference(externalCallOutputEClass, EXTERNAL_CALL_OUTPUT__PARAMETER_CHARACTERISATIONS_EXTERNAL_CALL_OUTPUT);
		createEReference(externalCallOutputEClass, EXTERNAL_CALL_OUTPUT__EXTERNAL_CALL_ACTION_EXTERNAL_CALL_OUTPUT);

		externalCallInputEClass = createEClass(EXTERNAL_CALL_INPUT);
		createEReference(externalCallInputEClass, EXTERNAL_CALL_INPUT__PARAMETER_CHARACTERISATIONS_EXTERNAL_CALL_INPUT);
		createEReference(externalCallInputEClass, EXTERNAL_CALL_INPUT__EXTERNAL_CALL_ACTION_EXTERNAL_CALL_INPUT);

		outputEClass = createEClass(OUTPUT);
		createEReference(outputEClass, OUTPUT__PARAMETER_CHARACTERISATIONS_OUTPUT);

		computedUsageEClass = createEClass(COMPUTED_USAGE);
		createEReference(computedUsageEClass, COMPUTED_USAGE__USAGE_CONTEXTS_COMPUTED_USAGE);
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
		EntityPackage theEntityPackage = (EntityPackage)EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI);
		CompositionPackage theCompositionPackage = (CompositionPackage)EPackage.Registry.INSTANCE.getEPackage(CompositionPackage.eNS_URI);
		SeffPackage theSeffPackage = (SeffPackage)EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);
		StoexPackage theStoexPackage = (StoexPackage)EPackage.Registry.INSTANCE.getEPackage(StoexPackage.eNS_URI);
		ParameterPackage theParameterPackage = (ParameterPackage)EPackage.Registry.INSTANCE.getEPackage(ParameterPackage.eNS_URI);

		// Add supertypes to classes
		computedUsageContextEClass.getESuperTypes().add(theEntityPackage.getEntity());

		// Initialize classes and features; add operations and parameters
		initEClass(computedUsageContextEClass, ComputedUsageContext.class, "ComputedUsageContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComputedUsageContext_BranchProbabilities_ComputedUsageContext(), this.getBranchProbability(), null, "branchProbabilities_ComputedUsageContext", null, 0, -1, ComputedUsageContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComputedUsageContext_Loopiterations_ComputedUsageContext(), this.getLoopIteration(), null, "loopiterations_ComputedUsageContext", null, 0, -1, ComputedUsageContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComputedUsageContext_AssemblyContext_ComputedUsageContext(), theCompositionPackage.getAssemblyContext(), null, "assemblyContext_ComputedUsageContext", null, 1, 1, ComputedUsageContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComputedUsageContext_Input_ComputedUsageContext(), this.getInput(), null, "input_ComputedUsageContext", null, 1, 1, ComputedUsageContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComputedUsageContext_ExternalCallOutput_ComputedUsageContext(), this.getExternalCallOutput(), null, "externalCallOutput_ComputedUsageContext", null, 0, -1, ComputedUsageContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComputedUsageContext_ExternalCallInput_ComputedUsageContext(), this.getExternalCallInput(), null, "externalCallInput_ComputedUsageContext", null, 0, -1, ComputedUsageContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComputedUsageContext_Output_ComputedUsageContext(), this.getOutput(), null, "output_ComputedUsageContext", null, 1, 1, ComputedUsageContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(branchProbabilityEClass, BranchProbability.class, "BranchProbability", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBranchProbability_Probability(), ecorePackage.getEDouble(), "probability", null, 1, 1, BranchProbability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBranchProbability_Branchtransition_BranchProbability(), theSeffPackage.getAbstractBranchTransition(), null, "branchtransition_BranchProbability", null, 1, 1, BranchProbability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(loopIterationEClass, LoopIteration.class, "LoopIteration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoopIteration_Loopaction_LoopIteration(), theSeffPackage.getAbstractLoopAction(), null, "loopaction_LoopIteration", null, 1, 1, LoopIteration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getLoopIteration_Specification_LoopIteration(), theStoexPackage.getPCMRandomVariable(), null, "specification_LoopIteration", null, 1, 1, LoopIteration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(inputEClass, Input.class, "Input", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInput_ParameterChacterisations_Input(), theParameterPackage.getVariableUsage(), null, "parameterChacterisations_Input", null, 0, -1, Input.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(externalCallOutputEClass, ExternalCallOutput.class, "ExternalCallOutput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExternalCallOutput_ParameterCharacterisations_ExternalCallOutput(), theParameterPackage.getVariableUsage(), null, "parameterCharacterisations_ExternalCallOutput", null, 0, -1, ExternalCallOutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExternalCallOutput_ExternalCallAction_ExternalCallOutput(), theSeffPackage.getExternalCallAction(), null, "externalCallAction_ExternalCallOutput", null, 1, 1, ExternalCallOutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(externalCallInputEClass, ExternalCallInput.class, "ExternalCallInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExternalCallInput_ParameterCharacterisations_ExternalCallInput(), theParameterPackage.getVariableUsage(), null, "parameterCharacterisations_ExternalCallInput", null, 0, -1, ExternalCallInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExternalCallInput_ExternalCallAction_ExternalCallInput(), theSeffPackage.getExternalCallAction(), null, "externalCallAction_ExternalCallInput", null, 1, 1, ExternalCallInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(outputEClass, Output.class, "Output", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutput_ParameterCharacterisations_Output(), theParameterPackage.getVariableUsage(), null, "parameterCharacterisations_Output", null, 0, -1, Output.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(computedUsageEClass, ComputedUsage.class, "ComputedUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComputedUsage_UsageContexts_ComputedUsage(), this.getComputedUsageContext(), null, "usageContexts_ComputedUsage", null, 0, -1, ComputedUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ComputedUsagePackageImpl
