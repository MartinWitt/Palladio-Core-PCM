package de.uka.ipd.sdq.dsexplore.analysis.simucom.launch;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.uka.ipd.sdq.codegen.runconfig.tabs.FeatureOptionsTab;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComConfigurationTab;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuConfigurationTab;

/**
 * Provides a configuration tab group for the SimuCom analysis method.
 * 
 * @author pmerkle
 * 
 */
public class SimuComAnalysisTabGroup extends AbstractLaunchConfigurationTabGroup {

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
				new SimuComConfigurationTab(), 
				new SimuConfigurationTab(),
				new FeatureOptionsTab(),
				new CommonTab()
		};
		setTabs(tabs);
	}
	
}