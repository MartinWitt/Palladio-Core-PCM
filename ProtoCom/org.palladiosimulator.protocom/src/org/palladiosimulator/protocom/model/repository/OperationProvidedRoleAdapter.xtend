package org.palladiosimulator.protocom.model.repository

import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole
import org.palladiosimulator.protocom.model.ModelAdapter

/**
 * Adapter class for PCM OperationProvidedRole entities.
 * @author Christian Klaussner
 */
class OperationProvidedRoleAdapter extends ModelAdapter<OperationProvidedRole> {
	new(OperationProvidedRole entity) {
		super(entity)
	}
	
	// Translation methods
	
	def getPortClassName() {
		entity.providedInterface__OperationProvidedRole.safeName
		+ "_"
		+ entity.providingEntity_ProvidedRole.safeName
	}
}