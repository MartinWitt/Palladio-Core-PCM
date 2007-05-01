package de.uka.ipd.sdq.pcm.gmf.usage.edit.policies;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.usagemodel.OpenWorkload;
import de.uka.ipd.sdq.stoex.RandomVariable;

// Manually written open policy to open the StoEx Dialog. It's
// called via a CustomBehaviour in the genmap
public class OpenInterArrivalTimeDialog extends OpenStoExDialog {

	
	@Override
	protected RandomVariable getRandomVariable(EObject parent) {
		OpenWorkload ow = (OpenWorkload) parent;
		RandomVariable rv = ow.getInterArrivalTime_OpenWorkload();
		return rv;
	}
}
