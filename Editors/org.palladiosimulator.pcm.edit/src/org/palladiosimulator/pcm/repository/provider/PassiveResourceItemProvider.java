/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.repository.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.palladiosimulator.pcm.core.CoreFactory;
import org.palladiosimulator.pcm.core.entity.provider.EntityItemProvider;
import org.palladiosimulator.pcm.repository.PassiveResource;
import org.palladiosimulator.pcm.repository.RepositoryPackage;

/**
 * This is the item provider adapter for a
 * {@link org.palladiosimulator.pcm.repository.PassiveResource} object. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 *
 * @generated
 */
public class PassiveResourceItemProvider extends EntityItemProvider {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * This constructs an instance from a factory and a notifier. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public PassiveResourceItemProvider(final AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(final Object object) {
        if (this.itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            this.addResourceTimeoutFailureType__PassiveResourcePropertyDescriptor(object);
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Resource Timeout Failure Type Passive Resource
     * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addResourceTimeoutFailureType__PassiveResourcePropertyDescriptor(final Object object) {
        this.itemPropertyDescriptors.add(this.createItemPropertyDescriptor(
                ((ComposeableAdapterFactory) this.adapterFactory).getRootAdapterFactory(), this.getResourceLocator(),
                this.getString("_UI_PassiveResource_resourceTimeoutFailureType__PassiveResource_feature"),
                this.getString("_UI_PropertyDescriptor_description",
                        "_UI_PassiveResource_resourceTimeoutFailureType__PassiveResource_feature",
                        "_UI_PassiveResource_type"),
                RepositoryPackage.Literals.PASSIVE_RESOURCE__RESOURCE_TIMEOUT_FAILURE_TYPE_PASSIVE_RESOURCE, true,
                false, true, null, null, null));
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate
     * feature for an {@link org.eclipse.emf.edit.command.AddCommand},
     * {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures(final Object object) {
        if (this.childrenFeatures == null) {
            super.getChildrenFeatures(object);
            this.childrenFeatures.add(RepositoryPackage.Literals.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE);
        }
        return this.childrenFeatures;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature(final Object object, final Object child) {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

    /**
     * This returns PassiveResource.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object getImage(final Object object) {
        return this.overlayImage(object, this.getResourceLocator().getImage("full/obj16/PassiveResource"));
    }

    /**
     * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    @Override
    public String getText(final Object object) {
        final String label = ((PassiveResource) object).getId();
        return label == null || label.length() == 0 ? this.getString("_UI_PassiveResource_type")
                : this.getString("_UI_PassiveResource_type") + " " + label;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}
     * . <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void notifyChanged(final Notification notification) {
        this.updateChildren(notification);

        switch (notification.getFeatureID(PassiveResource.class)) {
        case RepositoryPackage.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE:
            this.fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
            return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children that
     * can be created under this object. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(final Collection<Object> newChildDescriptors, final Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);

        newChildDescriptors
                .add(this.createChildParameter(RepositoryPackage.Literals.PASSIVE_RESOURCE__CAPACITY_PASSIVE_RESOURCE,
                        CoreFactory.eINSTANCE.createPCMRandomVariable()));
    }

}