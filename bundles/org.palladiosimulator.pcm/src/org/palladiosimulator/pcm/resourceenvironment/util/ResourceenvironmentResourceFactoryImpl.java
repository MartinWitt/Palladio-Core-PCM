/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.resourceenvironment.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;

/**
 * <!-- begin-user-doc --> The <b>Resource Factory</b> associated with the package. <!--
 * end-user-doc -->
 * 
 * @see org.palladiosimulator.pcm.resourceenvironment.util.ResourceenvironmentResourceImpl
 * @generated
 */
public class ResourceenvironmentResourceFactoryImpl extends ResourceFactoryImpl {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2017 by palladiosimulator.org";

    /**
     * Creates an instance of the resource factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ResourceenvironmentResourceFactoryImpl() {
        super();
    }

    /**
     * Creates an instance of the resource. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Resource createResource(final URI uri) {
        final XMLResource result = new ResourceenvironmentResourceImpl(uri);
        return result;
    }

} // ResourceenvironmentResourceFactoryImpl
