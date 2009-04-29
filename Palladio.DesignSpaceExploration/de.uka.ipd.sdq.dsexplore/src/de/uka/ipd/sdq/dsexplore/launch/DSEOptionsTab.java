package de.uka.ipd.sdq.dsexplore.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.uka.ipd.sdq.codegen.runconfig.RunConfigPlugin;
import de.uka.ipd.sdq.workflow.launchconfig.ConstantsContainer;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.FileNamesInputTab;
import de.uka.ipd.sdq.dsexplore.DSEPluginActivator;

public class DSEOptionsTab extends FileNamesInputTab {
	
	private Text maximumIterations; 

	private Text numberOfIndividualsPerGeneration;
	
	private Image icon;

	private Text meanResponseTimeRequirement;

	private Text threshold;

	private Text increaseFactor;

	private Text textCostModel;

	private Text maxCost;


	@Override
	public void createControl(Composite parent) {
		final ModifyListener modifyListener = new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				DSEOptionsTab.this.setDirty(true);
				DSEOptionsTab.this.updateLaunchConfigurationDialog();
			}
		};
		
		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout());
		
		final Group maximumIterationsGroup = new Group(container, SWT.NONE);
		final GridLayout glmaximumIterationsGroup = new GridLayout();
		glmaximumIterationsGroup.numColumns = 2;
		maximumIterationsGroup.setLayout(glmaximumIterationsGroup);
		maximumIterationsGroup.setText("Stop criteria");
		maximumIterationsGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false));

		final Label maxIterationLabel = new Label(maximumIterationsGroup, SWT.NONE);
		maxIterationLabel.setText("Maximum number of iterations:");
		
		maximumIterations = new Text(maximumIterationsGroup, SWT.SINGLE	| SWT.BORDER);
		maximumIterations.setEnabled(true);
		maximumIterations.addModifyListener(modifyListener);
		
		final Label numberOfIndividualsPerGenerationLabel = new Label(maximumIterationsGroup, SWT.NONE);
		numberOfIndividualsPerGenerationLabel.setText("Number of individuals per generation:");
		
		numberOfIndividualsPerGeneration = new Text(maximumIterationsGroup, SWT.SINGLE	| SWT.BORDER);
		numberOfIndividualsPerGeneration.setEnabled(true);
		numberOfIndividualsPerGeneration.addModifyListener(modifyListener);
		
		final Label meanRespTimeLabel = new Label(maximumIterationsGroup, SWT.NONE);
		meanRespTimeLabel.setText("Maximal response time:");

		meanResponseTimeRequirement = new Text(maximumIterationsGroup, SWT.SINGLE	| SWT.BORDER);
		meanResponseTimeRequirement.setEnabled(true);
		meanResponseTimeRequirement.addModifyListener(modifyListener);
		
		final Label maxCostLabel = new Label(maximumIterationsGroup, SWT.NONE);
		maxCostLabel.setText("Maximal cost:");

		maxCost = new Text(maximumIterationsGroup, SWT.SINGLE	| SWT.BORDER);
		maxCost.setEnabled(true);
		maxCost.addModifyListener(modifyListener);
		
		final Label thresholdLabel = new Label(maximumIterationsGroup, SWT.NONE);
		thresholdLabel.setText("Threshold for strengthen resource:");

		threshold = new Text(maximumIterationsGroup, SWT.SINGLE	| SWT.BORDER);
		threshold.setEnabled(true);
		threshold.addModifyListener(modifyListener);
		
		final Label increaseFactorLabel = new Label(maximumIterationsGroup, SWT.NONE);
		increaseFactorLabel.setText("Increase factor for strengthen resource:");

		increaseFactor = new Text(maximumIterationsGroup, SWT.SINGLE	| SWT.BORDER);
		increaseFactor.setEnabled(true);
		increaseFactor.addModifyListener(modifyListener);
		
		/**
		 * Add cost model input section
		 */
		this.textCostModel = new Text(container, SWT.SINGLE | SWT.BORDER);
		this.createFileInputSection(container, modifyListener, "Cost Model File", DSEConstantsContainer.COST_MODEL_EXTENSION, textCostModel);
		
	}

	@Override
	public String getName() {
		return "DSE Options";
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#getImage()
	 */
	public Image getImage() {
		if (icon == null){
			icon = DSEPluginActivator.getImageDescriptor("icons/dse_launch.gif").createImage(); 
		}
		return icon;
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			maximumIterations.setText(configuration.getAttribute(
					DSEConstantsContainer.MAX_ITERATIONS, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"maximum iterations", e.getMessage());
		}
		try {
			numberOfIndividualsPerGeneration.setText(configuration.getAttribute(
					DSEConstantsContainer.INDIVIDUALS_PER_GENERATION, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"numberOfIndividualsPerGeneration", e.getMessage());
		}
		try {
			meanResponseTimeRequirement.setText(configuration.getAttribute(
					DSEConstantsContainer.MRT_REQUIREMENTS, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"mean response time", e.getMessage());
		} 
		try {
			maxCost.setText(configuration.getAttribute(
					DSEConstantsContainer.MAX_COST, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),"max cost", e.getMessage());
		}
		try {
			this.threshold.setText(configuration.getAttribute(
					DSEConstantsContainer.THRESHOLD, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),DSEConstantsContainer.THRESHOLD, e.getMessage());
		}
		try {
			this.increaseFactor.setText(configuration.getAttribute(
					DSEConstantsContainer.INCR_FACTOR, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),DSEConstantsContainer.INCR_FACTOR, e.getMessage());
		}
		try {
			this.textCostModel.setText(configuration.getAttribute(
					DSEConstantsContainer.COST_FILE, ""));
		} catch (CoreException e) {
			RunConfigPlugin.errorLogger(getName(),DSEConstantsContainer.COST_FILE, e.getMessage());
		}

	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				DSEConstantsContainer.MAX_ITERATIONS,
				this.maximumIterations.getText());
		configuration.setAttribute(
				DSEConstantsContainer.INDIVIDUALS_PER_GENERATION,
				this.numberOfIndividualsPerGeneration.getText());
		configuration.setAttribute(
				DSEConstantsContainer.MRT_REQUIREMENTS, 
				this.meanResponseTimeRequirement.getText());
		configuration.setAttribute(
				DSEConstantsContainer.MAX_COST, 
				this.maxCost.getText());
		configuration.setAttribute(
				DSEConstantsContainer.THRESHOLD,
				this.threshold.getText());
		configuration.setAttribute(
				DSEConstantsContainer.INCR_FACTOR, 
				this.increaseFactor.getText());
		configuration.setAttribute(
				DSEConstantsContainer.COST_FILE, 
				this.textCostModel.getText());
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				DSEConstantsContainer.THRESHOLD,
				"0.7");
		configuration.setAttribute(
				DSEConstantsContainer.INCR_FACTOR, 
				"1.1");
		configuration.setAttribute(
				DSEConstantsContainer.INDIVIDUALS_PER_GENERATION,
				"3");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.AbstractLaunchConfigurationTab#isValid(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		setErrorMessage(null);

		// check this.maxIterations
		if (this.maximumIterations.getText().length() != 0) {
			try {
				Integer.parseInt(this.maximumIterations.getText());
			} catch (NumberFormatException e) {
				setErrorMessage("Maximum iterations must be an integer value or empty.");
				return false;
			}
		}
		
		// check this.numberOfIndividualsPerGeneration
		if (this.numberOfIndividualsPerGeneration.getText().length() != 0) {
			try {
				Integer.parseInt(this.numberOfIndividualsPerGeneration.getText());
			} catch (NumberFormatException e) {
				setErrorMessage("Number of individuals per generation must be an integer value or empty.");
				return false;
			}
		}
		
		if (this.meanResponseTimeRequirement.getText().length() != 0) {
			try {
				Double.parseDouble(this.meanResponseTimeRequirement.getText());
			} catch (NumberFormatException e) {
				setErrorMessage("Mean response time requirement must be a double value or empty.");
				return false;
			}
		}
		
		if (this.maxCost.getText().length() != 0) {
			try {
				Double.parseDouble(this.maxCost.getText());
			} catch (NumberFormatException e) {
				setErrorMessage("Maximal cost must be a double value or empty.");
				return false;
			}
		}
		
		try {
			Double.parseDouble(this.threshold.getText());
		} catch (NumberFormatException e) {
			setErrorMessage("Threshold must be a double value.");
			return false;
		}
	
		try {
			Double.parseDouble(this.increaseFactor.getText());
		} catch (NumberFormatException e) {
			setErrorMessage("InreaseFactor must be a double value.");
			return false;
		}
		
		String extension = DSEConstantsContainer.COST_MODEL_EXTENSION[0].replace("*", "");
		if (this.textCostModel.getText().equals("") || !this.textCostModel.getText().contains(extension)){
			setErrorMessage("Cost model is missing!");
			return false;
		}

		return true;
	}
	
	/**
	 * Disposes the image for the DSE options tab.
	 * 
	 * @see ILaunchConfigurationTab#dispose()
	 */
	public void dispose() {
		if (icon != null){
			icon.dispose();
		}
	}

}