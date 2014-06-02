package org.palladiosimulator.protocom.traverse.jeeservlet;

import org.palladiosimulator.protocom.traverse.framework.CommonConfigurationModule;
import org.palladiosimulator.protocom.traverse.framework.allocation.XAllocation;
import org.palladiosimulator.protocom.traverse.framework.repository.XBasicComponent;
import org.palladiosimulator.protocom.traverse.framework.repository.XOperationInterface;
import org.palladiosimulator.protocom.traverse.framework.resourceenvironment.XResourceEnvironment;
import org.palladiosimulator.protocom.traverse.framework.system.XSystem;
import org.palladiosimulator.protocom.traverse.framework.usage.XUsageScenario;
import org.palladiosimulator.protocom.traverse.jee.repository.JeeOperationInterface;
import org.palladiosimulator.protocom.traverse.jeeservlet.allocation.JeeServletAllocation;
import org.palladiosimulator.protocom.traverse.jeeservlet.repository.JeeServletBasicComponent;
import org.palladiosimulator.protocom.traverse.jeeservlet.resourceenvironment.JeeServletResourceEnvironment;
import org.palladiosimulator.protocom.traverse.jeeservlet.system.JeeServletSystem;
import org.palladiosimulator.protocom.traverse.jeeservlet.usage.JeeServletUsageScenario;

/**
 * 
 * @author Christian Klaussner
 */
public class JeeServletConfigurationModule extends CommonConfigurationModule {
	
	@Override
	protected void configure() {
		super.configure();
		
		bind(XBasicComponent.class).to(JeeServletBasicComponent.class);
		bind(XOperationInterface.class).to(JeeOperationInterface.class);
		bind(XSystem.class).to(JeeServletSystem.class);
		bind(XAllocation.class).to(JeeServletAllocation.class);
		bind(XResourceEnvironment.class).to(JeeServletResourceEnvironment.class);
		bind(XUsageScenario.class).to(JeeServletUsageScenario.class);
	}
}
