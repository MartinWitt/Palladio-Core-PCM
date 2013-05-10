package de.uka.ipd.sdq.pcm.gmf.allocation.custom.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.allocation.Allocation;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.gmf.allocation.custom.edit.commands.CustomAllocationContextCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.commands.AllocationContextCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies.ResourceContainerAllocationCompartmentItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.allocation.providers.PalladioComponentModelElementTypes;

/**
 * A custom resource container allocation compartment item semantic EditPolicy.
 */
public class CustomResourceContainerAllocationCompartmentItemSemanticEditPolicy extends
        ResourceContainerAllocationCompartmentItemSemanticEditPolicy {

    /**
     * Gets the CreateCommand.
     * 
     * FIXME: This custom code is never called!?!
     *      
     * @param req
     *            a CreateElementRequest
     * @return the CreateCommand
     */

    protected Command getCreateCommand(CreateElementRequest req) {
		if (PalladioComponentModelElementTypes.AllocationContext_3002 == req
				.getElementType()) {
//			return getGEFWrapper(new AllocationContextCreateCommand(req));
			// Instead, added the following two lines:
            Allocation a = (Allocation) ((View) getHost().getParent().getParent().getModel()).getElement();
            return getGEFWrapper(new AllocationContextCreateCommand(req, a));
		}
		return super.getCreateCommand(req);
    }
}
