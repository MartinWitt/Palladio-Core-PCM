package com.palladio_simulator.protocom.tech.rmi

import com.palladio_simulator.protocom.lang.java.impl.JMethod
import com.palladio_simulator.protocom.lang.java.util.JavaNames
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario
import com.palladio_simulator.protocom.lang.java.util.PcmCalls

class PojoSystemMain extends PojoClass<UsageScenario> {

	new(UsageScenario pcmEntity) {
		super(pcmEntity)
	}
	
	override superClass() {
		"com.palladio_simulator.protocom.framework.AbstractMain"
	}
		
	override packageName() {
		"ProtoComBootstrap"
	}
	
	override compilationUnitName() {
		"Main"
	}
	
	override methods() {
		#[
			new JMethod()
				.withName("initialiseThreads")
				.withParameters("de.uka.ipd.sdq.sensorframework.entities.Experiment exp, de.uka.ipd.sdq.sensorframework.entities.ExperimentRun expRun")
				.withImplementation('''
					int count = 1;
					if (runProps.hasOption("c")) {
						count = (Integer) runProps.getOptionObject("c");
					}
					for (int i = 0; i < count; i++) {
						threads.add(new «JavaNames::fqn(pcmEntity)»Thread(exp, expRun,
								runProps));
					}
				'''),
				
			new JMethod()
				.withName("setupResources")
				.withImplementation('''
					ResourceEnvironment.setUpResources(runProps.getOptionValue('p'),
					runProps.getOptionValue('H'), runProps.getOptionValue('s'),
					getAccuracy());
				'''),
				
			new JMethod()
				.withName("initialiseSystems")
				.withImplementation('''
					«FOR system : PcmCalls::getSystemsFromCalls(PcmCalls::querySystemCalls(pcmEntity.scenarioBehaviour_UsageScenario))»
						«JavaNames::fqn(system)».main(runProps.getOptionValue('R'), runProps.getOptionValue('O'));
					«ENDFOR»
					'''),
				
//				«FOREACH this.usageScenario_UsageModel.querySystemCalls().getSystemsFromCalls() AS us»
//					«us.fqn()».main(runProps.getOptionValue('R'), runProps.getOptionValue('O'));
//				«ENDFOREACH»
				
				
			new JMethod()
				.withName("initAllocationStorage")
				.withImplementation('''AllocationStorage.initSingleton(new AllocationStorage());'''),
				
			new JMethod()
				.withName("getSystems")
				.withReturnType("String[][]")
				.withImplementation('''
					String[][] systems = {
						{ 
						«FOR system : PcmCalls::getSystemsFromCalls(PcmCalls::querySystemCalls(pcmEntity.scenarioBehaviour_UsageScenario))»
							"«JavaNames::fqn(system)»", "«JavaNames::javaName(system)»"
						«ENDFOR»
						}
					};
					return systems;'''),
					
			new JMethod()
				.withName("main")
				.withParameters("String[] args")
				.withImplementation('''new Main().run(args);''')
				.withStaticModifier
				
			
		]
	}
	
	override filePath() {
		"ProtoComBootstrap/Main.java"
	}
	
	
}