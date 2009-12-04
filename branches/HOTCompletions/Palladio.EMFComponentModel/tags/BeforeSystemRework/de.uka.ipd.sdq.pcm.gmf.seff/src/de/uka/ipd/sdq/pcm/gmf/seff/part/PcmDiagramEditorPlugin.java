/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import de.uka.ipd.sdq.identifier.provider.IdentifierItemProviderAdapterFactory;

import de.uka.ipd.sdq.pcm.allocation.provider.AllocationItemProviderAdapterFactory;

import de.uka.ipd.sdq.pcm.assembly.provider.AssemblyItemProviderAdapterFactory;

import de.uka.ipd.sdq.pcm.core.connectors.provider.ConnectorsItemProviderAdapterFactory;

import de.uka.ipd.sdq.pcm.core.entity.provider.EntityItemProviderAdapterFactory;

import de.uka.ipd.sdq.pcm.core.stochastics.provider.StochasticsItemProviderAdapterFactory;

import de.uka.ipd.sdq.pcm.parameter.provider.ParameterItemProviderAdapterFactory;

import de.uka.ipd.sdq.pcm.protocol.provider.ProtocolItemProviderAdapterFactory;

import de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory;

import de.uka.ipd.sdq.pcm.resourceenvironment.provider.ResourceenvironmentItemProviderAdapterFactory;

import de.uka.ipd.sdq.pcm.resourcetype.provider.ResourcetypeItemProviderAdapterFactory;

import de.uka.ipd.sdq.pcm.seff.provider.SeffItemProviderAdapterFactory;

import de.uka.ipd.sdq.pcm.system.provider.SystemItemProviderAdapterFactory;

import de.uka.ipd.sdq.pcm.usagemodel.provider.UsagemodelItemProviderAdapterFactory;

/**
 * @generated
 */
public class PcmDiagramEditorPlugin extends AbstractUIPlugin {

	/**
	 * @generated
	 */
	public static final String ID = "de.uka.ipd.sdq.pcm.gmf.seff"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final PreferencesHint DIAGRAM_PREFERENCES_HINT = new PreferencesHint(
			ID);

	/**
	 * @generated
	 */
	private static PcmDiagramEditorPlugin instance;

	/**
	 * @generated
	 */
	private ComposedAdapterFactory adapterFactory;

	/**
	 * @generated
	 */
	public PcmDiagramEditorPlugin() {
	}

	/**
	 * @generated
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		instance = this;
		PreferencesHint.registerPreferenceStore(DIAGRAM_PREFERENCES_HINT,
				getPreferenceStore());
		adapterFactory = createAdapterFactory();
	}

	/**
	 * @generated
	 */
	public void stop(BundleContext context) throws Exception {
		adapterFactory.dispose();
		adapterFactory = null;
		instance = null;
		super.stop(context);
	}

	/**
	 * @generated
	 */
	public static PcmDiagramEditorPlugin getInstance() {
		return instance;
	}

	/**
	 * @generated
	 */
	protected ComposedAdapterFactory createAdapterFactory() {
		List factories = new ArrayList();
		fillItemProviderFactories(factories);
		return new ComposedAdapterFactory(factories);
	}

	/**
	 * @generated
	 */
	protected void fillItemProviderFactories(List factories) {
		factories.add(new AssemblyItemProviderAdapterFactory());
		factories.add(new StochasticsItemProviderAdapterFactory());
		factories.add(new EntityItemProviderAdapterFactory());
		factories.add(new ConnectorsItemProviderAdapterFactory());
		factories.add(new RepositoryItemProviderAdapterFactory());
		factories.add(new ProtocolItemProviderAdapterFactory());
		factories.add(new SeffItemProviderAdapterFactory());
		factories.add(new ResourcetypeItemProviderAdapterFactory());
		factories.add(new ParameterItemProviderAdapterFactory());
		factories.add(new AllocationItemProviderAdapterFactory());
		factories.add(new ResourceenvironmentItemProviderAdapterFactory());
		factories.add(new UsagemodelItemProviderAdapterFactory());
		factories.add(new SystemItemProviderAdapterFactory());
		factories.add(new IdentifierItemProviderAdapterFactory());
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new ReflectiveItemProviderAdapterFactory());
	}

	/**
	 * @generated
	 */
	public AdapterFactory getItemProvidersAdapterFactory() {
		return adapterFactory;
	}

	/**
	 * @generated
	 */
	public ImageDescriptor getItemImageDescriptor(Object item) {
		IItemLabelProvider labelProvider = (IItemLabelProvider) adapterFactory
				.adapt(item, IItemLabelProvider.class);
		if (labelProvider != null) {
			return ExtendedImageRegistry.getInstance().getImageDescriptor(
					labelProvider.getImage(item));
		}
		return null;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path.
	 *
	 * @generated
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getBundledImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(ID, path);
	}

	/**
	 * Respects images residing in any plug-in. If path is relative,
	 * then this bundle is looked up for the image, otherwise, for absolute 
	 * path, first segment is taken as id of plug-in with image
	 *
	 * @generated
	 * @param path the path to image, either absolute (with plug-in id as first segment), or relative for bundled images
	 * @return the image descriptor
	 */
	public static ImageDescriptor findImageDescriptor(String path) {
		final IPath p = new Path(path);
		if (p.isAbsolute() && p.segmentCount() > 1) {
			return AbstractUIPlugin.imageDescriptorFromPlugin(p.segment(0), p
					.removeFirstSegments(1).makeAbsolute().toString());
		} else {
			return getBundledImageDescriptor(p.makeAbsolute().toString());
		}
	}

	/**
	 * Returns an image for the image file at the given plug-in relative path.
	 * Client do not need to dispose this image. Images will be disposed automatically.
	 *
	 * @generated
	 * @param path the path
	 * @return image instance
	 */
	public Image getBundledImage(String path) {
		Image image = getImageRegistry().get(path);
		if (image == null) {
			getImageRegistry().put(path, getBundledImageDescriptor(path));
			image = getImageRegistry().get(path);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public void logError(String error) {
		logError(error, null);
	}

	/**
	 * @param throwable actual error or null could be passed
	 * @generated
	 */
	public void logError(String error, Throwable throwable) {
		if (error == null && throwable != null) {
			error = throwable.getMessage();
		}
		getLog().log(
				new Status(IStatus.ERROR, PcmDiagramEditorPlugin.ID,
						IStatus.OK, error, throwable));
		debug(error, throwable);
	}

	/**
	 * @generated
	 */
	public void logInfo(String message) {
		logInfo(message, null);
	}

	/**
	 * @param throwable actual error or null could be passed
	 * @generated
	 */
	public void logInfo(String message, Throwable throwable) {
		if (message == null && message != null) {
			message = throwable.getMessage();
		}
		getLog().log(
				new Status(IStatus.INFO, PcmDiagramEditorPlugin.ID, IStatus.OK,
						message, throwable));
		debug(message, throwable);
	}

	/**
	 * @generated
	 */
	private void debug(String message, Throwable throwable) {
		if (!isDebugging()) {
			return;
		}
		if (message != null) {
			System.err.println(message);
		}
		if (throwable != null) {
			throwable.printStackTrace();
		}
	}

}