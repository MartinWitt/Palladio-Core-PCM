/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.CollectionDataType;
import de.uka.ipd.sdq.pcm.repository.CompleteComponentType;
import de.uka.ipd.sdq.pcm.repository.ComponentType;
import de.uka.ipd.sdq.pcm.repository.CompositeComponent;
import de.uka.ipd.sdq.pcm.repository.CompositeDataType;
import de.uka.ipd.sdq.pcm.repository.EventGroup;
import de.uka.ipd.sdq.pcm.repository.EventType;
import de.uka.ipd.sdq.pcm.repository.ExceptionType;
import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface;
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole;
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.ParameterModifier;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.repository.PrimitiveDataType;
import de.uka.ipd.sdq.pcm.repository.PrimitiveTypeEnum;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.RequiredCharacterisation;
import de.uka.ipd.sdq.pcm.repository.SinkRole;
import de.uka.ipd.sdq.pcm.repository.SourceRole;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class RepositoryFactoryImpl extends EFactoryImpl implements RepositoryFactory {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static RepositoryFactory init() {
        try {
            RepositoryFactory theRepositoryFactory = (RepositoryFactory) EPackage.Registry.INSTANCE
                    .getEFactory(RepositoryPackage.eNS_URI);
            if (theRepositoryFactory != null) {
                return theRepositoryFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new RepositoryFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public RepositoryFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
        case RepositoryPackage.PASSIVE_RESOURCE:
            return (EObject) createPassiveResource();
        case RepositoryPackage.BASIC_COMPONENT:
            return (EObject) createBasicComponent();
        case RepositoryPackage.PARAMETER:
            return (EObject) createParameter();
        case RepositoryPackage.REPOSITORY:
            return (EObject) createRepository();
        case RepositoryPackage.REQUIRED_CHARACTERISATION:
            return (EObject) createRequiredCharacterisation();
        case RepositoryPackage.EVENT_GROUP:
            return (EObject) createEventGroup();
        case RepositoryPackage.EVENT_TYPE:
            return (EObject) createEventType();
        case RepositoryPackage.EXCEPTION_TYPE:
            return (EObject) createExceptionType();
        case RepositoryPackage.INFRASTRUCTURE_SIGNATURE:
            return (EObject) createInfrastructureSignature();
        case RepositoryPackage.INFRASTRUCTURE_INTERFACE:
            return (EObject) createInfrastructureInterface();
        case RepositoryPackage.INFRASTRUCTURE_REQUIRED_ROLE:
            return (EObject) createInfrastructureRequiredRole();
        case RepositoryPackage.OPERATION_SIGNATURE:
            return (EObject) createOperationSignature();
        case RepositoryPackage.OPERATION_INTERFACE:
            return (EObject) createOperationInterface();
        case RepositoryPackage.OPERATION_REQUIRED_ROLE:
            return (EObject) createOperationRequiredRole();
        case RepositoryPackage.SOURCE_ROLE:
            return (EObject) createSourceRole();
        case RepositoryPackage.SINK_ROLE:
            return (EObject) createSinkRole();
        case RepositoryPackage.OPERATION_PROVIDED_ROLE:
            return (EObject) createOperationProvidedRole();
        case RepositoryPackage.INFRASTRUCTURE_PROVIDED_ROLE:
            return (EObject) createInfrastructureProvidedRole();
        case RepositoryPackage.COMPLETE_COMPONENT_TYPE:
            return (EObject) createCompleteComponentType();
        case RepositoryPackage.PROVIDES_COMPONENT_TYPE:
            return (EObject) createProvidesComponentType();
        case RepositoryPackage.COMPOSITE_COMPONENT:
            return (EObject) createCompositeComponent();
        case RepositoryPackage.PRIMITIVE_DATA_TYPE:
            return (EObject) createPrimitiveDataType();
        case RepositoryPackage.COLLECTION_DATA_TYPE:
            return (EObject) createCollectionDataType();
        case RepositoryPackage.COMPOSITE_DATA_TYPE:
            return (EObject) createCompositeDataType();
        case RepositoryPackage.INNER_DECLARATION:
            return (EObject) createInnerDeclaration();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
        case RepositoryPackage.PARAMETER_MODIFIER:
            return createParameterModifierFromString(eDataType, initialValue);
        case RepositoryPackage.COMPONENT_TYPE:
            return createComponentTypeFromString(eDataType, initialValue);
        case RepositoryPackage.PRIMITIVE_TYPE_ENUM:
            return createPrimitiveTypeEnumFromString(eDataType, initialValue);
        default:
            throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
        case RepositoryPackage.PARAMETER_MODIFIER:
            return convertParameterModifierToString(eDataType, instanceValue);
        case RepositoryPackage.COMPONENT_TYPE:
            return convertComponentTypeToString(eDataType, instanceValue);
        case RepositoryPackage.PRIMITIVE_TYPE_ENUM:
            return convertPrimitiveTypeEnumToString(eDataType, instanceValue);
        default:
            throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PassiveResource createPassiveResource() {
        PassiveResourceImpl passiveResource = new PassiveResourceImpl();
        return passiveResource;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public BasicComponent createBasicComponent() {
        BasicComponentImpl basicComponent = new BasicComponentImpl();
        return basicComponent;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Repository createRepository() {
        RepositoryImpl repository = new RepositoryImpl();
        return repository;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RequiredCharacterisation createRequiredCharacterisation() {
        RequiredCharacterisationImpl requiredCharacterisation = new RequiredCharacterisationImpl();
        return requiredCharacterisation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Parameter createParameter() {
        ParameterImpl parameter = new ParameterImpl();
        return parameter;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ComponentType createComponentTypeFromString(EDataType eDataType, String initialValue) {
        ComponentType result = ComponentType.get(initialValue);
        if (result == null)
            throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
                    + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertComponentTypeToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public OperationSignature createOperationSignature() {
        OperationSignatureImpl operationSignature = new OperationSignatureImpl();
        return operationSignature;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ExceptionType createExceptionType() {
        ExceptionTypeImpl exceptionType = new ExceptionTypeImpl();
        return exceptionType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public OperationInterface createOperationInterface() {
        OperationInterfaceImpl operationInterface = new OperationInterfaceImpl();
        return operationInterface;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public InfrastructureSignature createInfrastructureSignature() {
        InfrastructureSignatureImpl infrastructureSignature = new InfrastructureSignatureImpl();
        return infrastructureSignature;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public InfrastructureRequiredRole createInfrastructureRequiredRole() {
        InfrastructureRequiredRoleImpl infrastructureRequiredRole = new InfrastructureRequiredRoleImpl();
        return infrastructureRequiredRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EventType createEventType() {
        EventTypeImpl eventType = new EventTypeImpl();
        return eventType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EventGroup createEventGroup() {
        EventGroupImpl eventGroup = new EventGroupImpl();
        return eventGroup;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CompleteComponentType createCompleteComponentType() {
        CompleteComponentTypeImpl completeComponentType = new CompleteComponentTypeImpl();
        return completeComponentType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ProvidesComponentType createProvidesComponentType() {
        ProvidesComponentTypeImpl providesComponentType = new ProvidesComponentTypeImpl();
        return providesComponentType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public OperationRequiredRole createOperationRequiredRole() {
        OperationRequiredRoleImpl operationRequiredRole = new OperationRequiredRoleImpl();
        return operationRequiredRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public SourceRole createSourceRole() {
        SourceRoleImpl sourceRole = new SourceRoleImpl();
        return sourceRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public InfrastructureProvidedRole createInfrastructureProvidedRole() {
        InfrastructureProvidedRoleImpl infrastructureProvidedRole = new InfrastructureProvidedRoleImpl();
        return infrastructureProvidedRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public OperationProvidedRole createOperationProvidedRole() {
        OperationProvidedRoleImpl operationProvidedRole = new OperationProvidedRoleImpl();
        return operationProvidedRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CompositeComponent createCompositeComponent() {
        CompositeComponentImpl compositeComponent = new CompositeComponentImpl();
        return compositeComponent;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public SinkRole createSinkRole() {
        SinkRoleImpl sinkRole = new SinkRoleImpl();
        return sinkRole;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PrimitiveDataType createPrimitiveDataType() {
        PrimitiveDataTypeImpl primitiveDataType = new PrimitiveDataTypeImpl();
        return primitiveDataType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CollectionDataType createCollectionDataType() {
        CollectionDataTypeImpl collectionDataType = new CollectionDataTypeImpl();
        return collectionDataType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CompositeDataType createCompositeDataType() {
        CompositeDataTypeImpl compositeDataType = new CompositeDataTypeImpl();
        return compositeDataType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public InnerDeclaration createInnerDeclaration() {
        InnerDeclarationImpl innerDeclaration = new InnerDeclarationImpl();
        return innerDeclaration;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public InfrastructureInterface createInfrastructureInterface() {
        InfrastructureInterfaceImpl infrastructureInterface = new InfrastructureInterfaceImpl();
        return infrastructureInterface;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ParameterModifier createParameterModifierFromString(EDataType eDataType, String initialValue) {
        ParameterModifier result = ParameterModifier.get(initialValue);
        if (result == null)
            throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
                    + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertParameterModifierToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PrimitiveTypeEnum createPrimitiveTypeEnumFromString(EDataType eDataType, String initialValue) {
        PrimitiveTypeEnum result = PrimitiveTypeEnum.get(initialValue);
        if (result == null)
            throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
                    + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public String convertPrimitiveTypeEnumToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RepositoryPackage getRepositoryPackage() {
        return (RepositoryPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static RepositoryPackage getPackage() {
        return RepositoryPackage.eINSTANCE;
    }

} // RepositoryFactoryImpl
