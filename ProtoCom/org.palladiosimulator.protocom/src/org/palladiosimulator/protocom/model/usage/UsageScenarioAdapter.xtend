package org.palladiosimulator.protocom.model.usage

import org.palladiosimulator.protocom.model.ModelAdapter
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario

/**
 * Adapter class for PCM UsageScenario entities.
 * @author Christian Klaussner
 */
class UsageScenarioAdapter extends ModelAdapter<UsageScenario> {
	new(UsageScenario entity) {
		super(entity)
	}
	
	/**
	 * Gets the ID.
	 * @return a string containing the ID
	 */
	def getId() {
		return entity.id
	}
}