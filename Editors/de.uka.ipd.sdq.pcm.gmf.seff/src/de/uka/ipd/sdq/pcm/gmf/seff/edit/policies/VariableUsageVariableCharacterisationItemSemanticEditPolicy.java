/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.VariableCharacterisationCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * The Class VariableUsageVariableCharacterisationItemSemanticEditPolicy.
 *
 * @generated
 */
public class VariableUsageVariableCharacterisationItemSemanticEditPolicy extends
        PalladioComponentModelBaseItemSemanticEditPolicy {

    /**
     * Instantiates a new variable usage variable characterisation item semantic edit policy.
     *
     * @generated
     */
    public VariableUsageVariableCharacterisationItemSemanticEditPolicy() {
        super(PalladioComponentModelElementTypes.VariableUsage_3042);
    }

    /**
     * Gets the creates the command.
     *
     * @param req the req
     * @return the creates the command
     * @generated
     */
    protected Command getCreateCommand(CreateElementRequest req) {
        if (PalladioComponentModelElementTypes.VariableCharacterisation_3033 == req.getElementType()) {
            return getGEFWrapper(new VariableCharacterisationCreateCommand(req));
        }
        return super.getCreateCommand(req);
    }
}
