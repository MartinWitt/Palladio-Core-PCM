/**
 * 
 */
package de.uka.ipd.sdq.dialogs.selection;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProviderAdapterFactory;

/**
 * @author Snowball
 *
 */
public class PalladioSelectEObjectDialog extends SelectEObjectDialog {

	/**
	 * @param parent
	 * @param adapterFactory
	 * @param filterList
	 * @param input
	 */
	public PalladioSelectEObjectDialog(Shell parent,
			Collection<Object> filterList,
			Collection<Object> additionalChildReferences, Object input) {
		super(parent);
		create();
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory();
		adapterFactory
				.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new RepositoryItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		setViewerContentProvider(new AdapterFactoryContentProvider(
				new FilteredItemsAdapterFactory(adapterFactory, filterList,
						additionalChildReferences)));
		setViewerLabelProvider(new AdapterFactoryLabelProvider(
				new PalladioItemProviderAdapterFactory(adapterFactory)));
		setViewerInput(input);
	}

	public PalladioSelectEObjectDialog(Shell parent,
			Collection<Object> filterList, Object input) {
		this(parent,filterList,new ArrayList<Object>(),input);
	}
}
