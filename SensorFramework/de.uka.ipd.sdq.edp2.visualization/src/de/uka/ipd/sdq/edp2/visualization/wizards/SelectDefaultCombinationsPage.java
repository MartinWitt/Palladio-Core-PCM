/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.wizards;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;

import de.uka.ipd.sdq.edp2.visualization.IAdapter;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.IDataSource;
import de.uka.ipd.sdq.edp2.visualization.IFilter;

/**
 * @author Dominik Ernst TODO change such that it allows to select from a list
 *         of wizards see {@link WizardListSelectionPage}
 */
public class SelectDefaultCombinationsPage extends WizardPage implements
		ISelectionChangedListener {

	private final static Logger logger = Logger
			.getLogger(SelectDefaultCombinationsPage.class.getCanonicalName());

	private final static String FILTER_EXTENSION_POINT_ID = "de.uka.ipd.sdq.edp2.visualization.filter";
	private final static String ADAPTER_EXTENSION_POINT_ID = "de.uka.ipd.sdq.edp2.visualization.adapter";

	private final static String CLASS_ATTRIBUTE = "class";
	private final static String WIZARD_ATTRIBUTE = "wizard";

	Object currentSelection;
	IDataSource selectedSource;
	IStatus selectionStatus;
	Status statusOK;
	TableViewer choiceViewer;

	protected SelectDefaultCombinationsPage(String pageName,
			IDataSource selectedSource) {
		super(pageName);
		this.selectedSource = selectedSource;
		setDescription("Choose a combination of Filters/Adapters + Editor to display"
				+ "the selected Data.");
		statusOK = new Status(IStatus.OK, "not_used", 0, "", null);
		selectionStatus = statusOK;
	}

	@Override
	public boolean canFlipToNextPage() {
		((DefaultViewsWizard) getWizard()).setFinishable(updatePageStatus()
				.isOK());
		return updatePageStatus().isOK();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		// create the composite to hold the widgets
		GridData gd;
		Composite composite = new Composite(parent, SWT.NONE);

		// create the desired layout for this wizard page
		GridLayout gl = new GridLayout();
		composite.setLayout(gl);

		Label label = new Label(composite, SWT.NONE);
		label.setText("Available Choices:");

		SashForm sashForm = new SashForm(composite, SWT.HORIZONTAL);
		gd = new GridData(GridData.FILL_BOTH);
		gd.widthHint = 200;
		sashForm.setLayoutData(gd);

		choiceViewer = new TableViewer(sashForm, SWT.BORDER);
		choiceViewer.setContentProvider(new IStructuredContentProvider() {

			@Override
			public void dispose() {
				// TODO Auto-generated method stub

			}

			@Override
			public Object[] getElements(Object inputElement) {
				return getApplicableChoices(selectedSource).toArray();
			}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
				// TODO Auto-generated method stub

			}
		});
		choiceViewer.setLabelProvider(new ILabelProvider() {

			@Override
			public void addListener(ILabelProviderListener listener) {
				// TODO Auto-generated method stub

			}

			@Override
			public void dispose() {
				// TODO Auto-generated method stub

			}

			@Override
			public Image getImage(Object element) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getText(Object element) {
				if (element != null) {
					return ((IWizard) element).getWindowTitle();
				}
				return null;
			}

			@Override
			public boolean isLabelProperty(Object element, String property) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void removeListener(ILabelProviderListener listener) {
				// TODO Auto-generated method stub

			}
		});

		choiceViewer.setInput(getApplicableChoices(selectedSource));
		choiceViewer.addSelectionChangedListener(this);

		// set the composite as the control for this page
		setControl(composite);
		updatePageStatus();
	}

	protected HashSet<ArrayList<IDataSink>> getApplicableChoices(
			IDataSource forSource) {
		//get list of registered filters - assume that the basic filters exist
		final IConfigurationElement[] filterExtensions = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						FILTER_EXTENSION_POINT_ID);
		ArrayList<IFilter> filters = new ArrayList<IFilter>();
		for (IConfigurationElement e : filterExtensions) {
			Object o = null;
			try {
				o = e.createExecutableExtension(CLASS_ATTRIBUTE);
				filters.add((IFilter) o);
			} catch (CoreException e1) {
				logger
						.log(Level.SEVERE,
								"Error in creating an Object referenced in an extension.");
				throw new RuntimeException();
			}
		}
		//get list of registered adapters - assume that the basic adapters exist
		final IConfigurationElement[] adapterExtensions = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						ADAPTER_EXTENSION_POINT_ID);
		ArrayList<IAdapter> adapters = new ArrayList<IAdapter>();
		for (IConfigurationElement e : adapterExtensions) {
			Object o = null;
			try {
				o = e.createExecutableExtension(CLASS_ATTRIBUTE);
				adapters.add((IAdapter) o);
			} catch (CoreException e1) {
				logger
						.log(Level.SEVERE,
								"Error in creating an Object referenced in an extension.");
				throw new RuntimeException();
			}
		}
		return null;
	}

	/**
	 * Method which is called when the "Next" Button in the Wizard is clicked.
	 * Must call
	 * {@link IFilterWizard#setSourceFromCaller(IDataSource, SelectDefaultCombinationsPage)}
	 * , where the {@link IDataSource} is the source handed from the
	 * RawMeasurements object, which was selected in the first place and
	 * SelectFilterPage is a reference to {@link this} page.
	 */
	@Override
	public IWizardPage getNextPage() {
		return null;
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		selectionStatus = statusOK;
		IStructuredSelection selection = (IStructuredSelection) event
				.getSelection();
		currentSelection = null;
		if (selection == null) {
			selectionStatus = new Status(IStatus.ERROR, "", 0,
					"Must select a Filter to proceed.", null);
		} else {
		}

		updatePageStatus();
		getContainer().updateButtons();

	}

	public IStatus updatePageStatus() {
		IStatus pageStatus = statusOK;
		switch (selectionStatus.getSeverity()) {
		case IStatus.OK:
			setErrorMessage(null);
			setMessage(selectionStatus.getMessage());
			pageStatus = statusOK;
			break;
		case IStatus.WARNING:
			setErrorMessage(null);
			setMessage(selectionStatus.getMessage(), WizardPage.WARNING);
			pageStatus = selectionStatus;
			break;
		case IStatus.INFO:
			setErrorMessage(null);
			setMessage(selectionStatus.getMessage(), WizardPage.INFORMATION);
			pageStatus = selectionStatus;
			break;
		default:
			setErrorMessage(selectionStatus.getMessage());
			setMessage(null);
			pageStatus = selectionStatus;
			break;
		}
		return pageStatus;
	}

	public void setFilter(IFilter filter) {
		logger.log(Level.INFO, "Filter of FilterWizard set");
	}

}