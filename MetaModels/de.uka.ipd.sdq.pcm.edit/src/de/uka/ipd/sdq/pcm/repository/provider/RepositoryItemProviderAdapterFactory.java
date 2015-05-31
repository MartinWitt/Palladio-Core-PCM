/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ChildCreationExtenderManager;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import de.uka.ipd.sdq.pcm.core.provider.PalladioComponentModelEditPlugin;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.util.RepositoryAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers. The
 * adapters generated by this factory convert EMF adapter notifications into calls to
 * {@link #fireNotifyChanged fireNotifyChanged}. The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class RepositoryItemProviderAdapterFactory extends RepositoryAdapterFactory implements
ComposeableAdapterFactory, IChangeNotifier, IDisposable, IChildCreationExtender {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * This keeps track of the root adapter factory that delegates to this adapter factory. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ComposedAdapterFactory parentAdapterFactory;

    /**
     * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected IChangeNotifier changeNotifier = new ChangeNotifier();

    /**
     * This helps manage the child creation extenders. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ChildCreationExtenderManager childCreationExtenderManager = new ChildCreationExtenderManager(
            PalladioComponentModelEditPlugin.INSTANCE, RepositoryPackage.eNS_URI);

    /**
     * This keeps track of all the supported types checked by {@link #isFactoryForType
     * isFactoryForType}. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected Collection<Object> supportedTypes = new ArrayList<Object>();

    /**
     * This constructs an instance. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public RepositoryItemProviderAdapterFactory() {
        this.supportedTypes.add(IEditingDomainItemProvider.class);
        this.supportedTypes.add(IStructuredItemContentProvider.class);
        this.supportedTypes.add(ITreeItemContentProvider.class);
        this.supportedTypes.add(IItemLabelProvider.class);
        this.supportedTypes.add(IItemPropertySource.class);
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.repository.Repository} instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected RepositoryItemProvider repositoryItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.Repository}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createRepositoryAdapter() {
        if (this.repositoryItemProvider == null) {
            this.repositoryItemProvider = new RepositoryItemProvider(this);
        }

        return this.repositoryItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.repository.RequiredCharacterisation} instances. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected RequiredCharacterisationItemProvider requiredCharacterisationItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.RequiredCharacterisation}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createRequiredCharacterisationAdapter() {
        if (this.requiredCharacterisationItemProvider == null) {
            this.requiredCharacterisationItemProvider = new RequiredCharacterisationItemProvider(this);
        }

        return this.requiredCharacterisationItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.repository.Parameter} instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected ParameterItemProvider parameterItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.Parameter}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createParameterAdapter() {
        if (this.parameterItemProvider == null) {
            this.parameterItemProvider = new ParameterItemProvider(this);
        }

        return this.parameterItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.repository.OperationInterface} instances. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected OperationInterfaceItemProvider operationInterfaceItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.OperationInterface}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createOperationInterfaceAdapter() {
        if (this.operationInterfaceItemProvider == null) {
            this.operationInterfaceItemProvider = new OperationInterfaceItemProvider(this);
        }

        return this.operationInterfaceItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.repository.OperationSignature} instances. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected OperationSignatureItemProvider operationSignatureItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.OperationSignature}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createOperationSignatureAdapter() {
        if (this.operationSignatureItemProvider == null) {
            this.operationSignatureItemProvider = new OperationSignatureItemProvider(this);
        }

        return this.operationSignatureItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.repository.ExceptionType} instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected ExceptionTypeItemProvider exceptionTypeItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.ExceptionType}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createExceptionTypeAdapter() {
        if (this.exceptionTypeItemProvider == null) {
            this.exceptionTypeItemProvider = new ExceptionTypeItemProvider(this);
        }

        return this.exceptionTypeItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.repository.OperationRequiredRole} instances. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected OperationRequiredRoleItemProvider operationRequiredRoleItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.OperationRequiredRole}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createOperationRequiredRoleAdapter() {
        if (this.operationRequiredRoleItemProvider == null) {
            this.operationRequiredRoleItemProvider = new OperationRequiredRoleItemProvider(this);
        }

        return this.operationRequiredRoleItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.repository.SinkRole} instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected SinkRoleItemProvider sinkRoleItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.SinkRole}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createSinkRoleAdapter() {
        if (this.sinkRoleItemProvider == null) {
            this.sinkRoleItemProvider = new SinkRoleItemProvider(this);
        }

        return this.sinkRoleItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.repository.EventGroup} instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected EventGroupItemProvider eventGroupItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.EventGroup}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createEventGroupAdapter() {
        if (this.eventGroupItemProvider == null) {
            this.eventGroupItemProvider = new EventGroupItemProvider(this);
        }

        return this.eventGroupItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.repository.EventType} instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected EventTypeItemProvider eventTypeItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.EventType}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createEventTypeAdapter() {
        if (this.eventTypeItemProvider == null) {
            this.eventTypeItemProvider = new EventTypeItemProvider(this);
        }

        return this.eventTypeItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.repository.SourceRole} instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected SourceRoleItemProvider sourceRoleItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.SourceRole}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createSourceRoleAdapter() {
        if (this.sourceRoleItemProvider == null) {
            this.sourceRoleItemProvider = new SourceRoleItemProvider(this);
        }

        return this.sourceRoleItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole} instances. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected InfrastructureProvidedRoleItemProvider infrastructureProvidedRoleItemProvider;

    /**
     * This creates an adapter for a
     * {@link de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole}. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createInfrastructureProvidedRoleAdapter() {
        if (this.infrastructureProvidedRoleItemProvider == null) {
            this.infrastructureProvidedRoleItemProvider = new InfrastructureProvidedRoleItemProvider(this);
        }

        return this.infrastructureProvidedRoleItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.repository.BasicComponent} instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected BasicComponentItemProvider basicComponentItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.BasicComponent}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createBasicComponentAdapter() {
        if (this.basicComponentItemProvider == null) {
            this.basicComponentItemProvider = new BasicComponentItemProvider(this);
        }

        return this.basicComponentItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.repository.CompleteComponentType} instances. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected CompleteComponentTypeItemProvider completeComponentTypeItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.CompleteComponentType}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createCompleteComponentTypeAdapter() {
        if (this.completeComponentTypeItemProvider == null) {
            this.completeComponentTypeItemProvider = new CompleteComponentTypeItemProvider(this);
        }

        return this.completeComponentTypeItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.repository.ProvidesComponentType} instances. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ProvidesComponentTypeItemProvider providesComponentTypeItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.ProvidesComponentType}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createProvidesComponentTypeAdapter() {
        if (this.providesComponentTypeItemProvider == null) {
            this.providesComponentTypeItemProvider = new ProvidesComponentTypeItemProvider(this);
        }

        return this.providesComponentTypeItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.repository.OperationProvidedRole} instances. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected OperationProvidedRoleItemProvider operationProvidedRoleItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.OperationProvidedRole}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createOperationProvidedRoleAdapter() {
        if (this.operationProvidedRoleItemProvider == null) {
            this.operationProvidedRoleItemProvider = new OperationProvidedRoleItemProvider(this);
        }

        return this.operationProvidedRoleItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.repository.PassiveResource} instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected PassiveResourceItemProvider passiveResourceItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.PassiveResource}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createPassiveResourceAdapter() {
        if (this.passiveResourceItemProvider == null) {
            this.passiveResourceItemProvider = new PassiveResourceItemProvider(this);
        }

        return this.passiveResourceItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.repository.CompositeDataType} instances. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected CompositeDataTypeItemProvider compositeDataTypeItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.CompositeDataType}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createCompositeDataTypeAdapter() {
        if (this.compositeDataTypeItemProvider == null) {
            this.compositeDataTypeItemProvider = new CompositeDataTypeItemProvider(this);
        }

        return this.compositeDataTypeItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.repository.InnerDeclaration} instances. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected InnerDeclarationItemProvider innerDeclarationItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.InnerDeclaration}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createInnerDeclarationAdapter() {
        if (this.innerDeclarationItemProvider == null) {
            this.innerDeclarationItemProvider = new InnerDeclarationItemProvider(this);
        }

        return this.innerDeclarationItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.repository.InfrastructureSignature} instances. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected InfrastructureSignatureItemProvider infrastructureSignatureItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.InfrastructureSignature}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createInfrastructureSignatureAdapter() {
        if (this.infrastructureSignatureItemProvider == null) {
            this.infrastructureSignatureItemProvider = new InfrastructureSignatureItemProvider(this);
        }

        return this.infrastructureSignatureItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole} instances. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected InfrastructureRequiredRoleItemProvider infrastructureRequiredRoleItemProvider;

    /**
     * This creates an adapter for a
     * {@link de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole}. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createInfrastructureRequiredRoleAdapter() {
        if (this.infrastructureRequiredRoleItemProvider == null) {
            this.infrastructureRequiredRoleItemProvider = new InfrastructureRequiredRoleItemProvider(this);
        }

        return this.infrastructureRequiredRoleItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.repository.InfrastructureInterface} instances. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected InfrastructureInterfaceItemProvider infrastructureInterfaceItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.InfrastructureInterface}.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Adapter createInfrastructureInterfaceAdapter() {
        if (this.infrastructureInterfaceItemProvider == null) {
            this.infrastructureInterfaceItemProvider = new InfrastructureInterfaceItemProvider(this);
        }

        return this.infrastructureInterfaceItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.repository.CompositeComponent} instances. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected CompositeComponentItemProvider compositeComponentItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.CompositeComponent}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createCompositeComponentAdapter() {
        if (this.compositeComponentItemProvider == null) {
            this.compositeComponentItemProvider = new CompositeComponentItemProvider(this);
        }

        return this.compositeComponentItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.repository.PrimitiveDataType} instances. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PrimitiveDataTypeItemProvider primitiveDataTypeItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.PrimitiveDataType}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createPrimitiveDataTypeAdapter() {
        if (this.primitiveDataTypeItemProvider == null) {
            this.primitiveDataTypeItemProvider = new PrimitiveDataTypeItemProvider(this);
        }

        return this.primitiveDataTypeItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link de.uka.ipd.sdq.pcm.repository.CollectionDataType} instances. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected CollectionDataTypeItemProvider collectionDataTypeItemProvider;

    /**
     * This creates an adapter for a {@link de.uka.ipd.sdq.pcm.repository.CollectionDataType}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createCollectionDataTypeAdapter() {
        if (this.collectionDataTypeItemProvider == null) {
            this.collectionDataTypeItemProvider = new CollectionDataTypeItemProvider(this);
        }

        return this.collectionDataTypeItemProvider;
    }

    /**
     * This returns the root adapter factory that contains this factory. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ComposeableAdapterFactory getRootAdapterFactory() {
        return this.parentAdapterFactory == null ? this : this.parentAdapterFactory.getRootAdapterFactory();
    }

    /**
     * This sets the composed adapter factory that contains this factory. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setParentAdapterFactory(final ComposedAdapterFactory parentAdapterFactory) {
        this.parentAdapterFactory = parentAdapterFactory;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean isFactoryForType(final Object type) {
        return this.supportedTypes.contains(type) || super.isFactoryForType(type);
    }

    /**
     * This implementation substitutes the factory itself as the key for the adapter. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter adapt(final Notifier notifier, final Object type) {
        return super.adapt(notifier, this);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object adapt(final Object object, final Object type) {
        if (this.isFactoryForType(type)) {
            final Object adapter = super.adapt(object, type);
            if (!(type instanceof Class<?>) || (((Class<?>) type).isInstance(adapter))) {
                return adapter;
            }
        }

        return null;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public List<IChildCreationExtender> getChildCreationExtenders() {
        return this.childCreationExtenderManager.getChildCreationExtenders();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Collection<?> getNewChildDescriptors(final Object object, final EditingDomain editingDomain) {
        return this.childCreationExtenderManager.getNewChildDescriptors(object, editingDomain);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return this.childCreationExtenderManager;
    }

    /**
     * This adds a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void addListener(final INotifyChangedListener notifyChangedListener) {
        this.changeNotifier.addListener(notifyChangedListener);
    }

    /**
     * This removes a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void removeListener(final INotifyChangedListener notifyChangedListener) {
        this.changeNotifier.removeListener(notifyChangedListener);
    }

    /**
     * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void fireNotifyChanged(final Notification notification) {
        this.changeNotifier.fireNotifyChanged(notification);

        if (this.parentAdapterFactory != null) {
            this.parentAdapterFactory.fireNotifyChanged(notification);
        }
    }

    /**
     * This disposes all of the item providers created by this factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void dispose() {
        if (this.passiveResourceItemProvider != null) {
            this.passiveResourceItemProvider.dispose();
        }
        if (this.basicComponentItemProvider != null) {
            this.basicComponentItemProvider.dispose();
        }
        if (this.parameterItemProvider != null) {
            this.parameterItemProvider.dispose();
        }
        if (this.repositoryItemProvider != null) {
            this.repositoryItemProvider.dispose();
        }
        if (this.requiredCharacterisationItemProvider != null) {
            this.requiredCharacterisationItemProvider.dispose();
        }
        if (this.eventGroupItemProvider != null) {
            this.eventGroupItemProvider.dispose();
        }
        if (this.eventTypeItemProvider != null) {
            this.eventTypeItemProvider.dispose();
        }
        if (this.exceptionTypeItemProvider != null) {
            this.exceptionTypeItemProvider.dispose();
        }
        if (this.infrastructureSignatureItemProvider != null) {
            this.infrastructureSignatureItemProvider.dispose();
        }
        if (this.infrastructureInterfaceItemProvider != null) {
            this.infrastructureInterfaceItemProvider.dispose();
        }
        if (this.infrastructureRequiredRoleItemProvider != null) {
            this.infrastructureRequiredRoleItemProvider.dispose();
        }
        if (this.operationSignatureItemProvider != null) {
            this.operationSignatureItemProvider.dispose();
        }
        if (this.operationInterfaceItemProvider != null) {
            this.operationInterfaceItemProvider.dispose();
        }
        if (this.operationRequiredRoleItemProvider != null) {
            this.operationRequiredRoleItemProvider.dispose();
        }
        if (this.sourceRoleItemProvider != null) {
            this.sourceRoleItemProvider.dispose();
        }
        if (this.sinkRoleItemProvider != null) {
            this.sinkRoleItemProvider.dispose();
        }
        if (this.operationProvidedRoleItemProvider != null) {
            this.operationProvidedRoleItemProvider.dispose();
        }
        if (this.infrastructureProvidedRoleItemProvider != null) {
            this.infrastructureProvidedRoleItemProvider.dispose();
        }
        if (this.completeComponentTypeItemProvider != null) {
            this.completeComponentTypeItemProvider.dispose();
        }
        if (this.providesComponentTypeItemProvider != null) {
            this.providesComponentTypeItemProvider.dispose();
        }
        if (this.compositeComponentItemProvider != null) {
            this.compositeComponentItemProvider.dispose();
        }
        if (this.primitiveDataTypeItemProvider != null) {
            this.primitiveDataTypeItemProvider.dispose();
        }
        if (this.collectionDataTypeItemProvider != null) {
            this.collectionDataTypeItemProvider.dispose();
        }
        if (this.compositeDataTypeItemProvider != null) {
            this.compositeDataTypeItemProvider.dispose();
        }
        if (this.innerDeclarationItemProvider != null) {
            this.innerDeclarationItemProvider.dispose();
        }
    }

}
