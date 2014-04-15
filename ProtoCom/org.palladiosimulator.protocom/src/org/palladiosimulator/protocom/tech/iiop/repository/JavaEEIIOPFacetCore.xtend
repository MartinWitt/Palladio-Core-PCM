package org.palladiosimulator.protocom.tech.iiop.repository

import de.uka.ipd.sdq.pcm.repository.BasicComponent
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import org.palladiosimulator.protocom.tech.iiop.JavaEEIIOPFacetCoreFile

class JavaEEIIOPFacetCore extends JavaEEIIOPFacetCoreFile<BasicComponent>{
	
	new(BasicComponent pcmEntity) {
		super(pcmEntity)
	}
	
	override runtimeName() {
		"GlassFish 4.0"
	}
	
	
	override fixedFacet() {
		#["java","jst.ejb"]
	}
		
	override installedFacet() {
		newHashMap(
			"java"-> "1.7",
			"jst.ejb" ->"3.1",
			"glassfish.ejb"-> "4.0"
		)
	}
	
	override filePath() {
		JavaNames::fqnJavaEEPreferencesPath(pcmEntity) + "org.eclipse.wst.common.project.facet.core.xml"
	}
	
	override projectName() {
		JavaNames::fqnJavaEEDescriptorProjectName(pcmEntity)
	}
}