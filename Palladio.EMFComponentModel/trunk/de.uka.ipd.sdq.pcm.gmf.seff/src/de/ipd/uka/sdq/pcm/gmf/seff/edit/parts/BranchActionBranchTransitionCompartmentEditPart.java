/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.ipd.uka.sdq.pcm.gmf.seff.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import de.ipd.uka.sdq.pcm.gmf.seff.edit.policies.BranchActionBranchTransitionCompartmentCanonicalEditPolicy;
import de.ipd.uka.sdq.pcm.gmf.seff.edit.policies.BranchActionBranchTransitionCompartmentItemSemanticEditPolicy;

import org.eclipse.draw2d.IFigure;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;

import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;

import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;

/**
 * @generated
 */
public class BranchActionBranchTransitionCompartmentEditPart extends
		ShapeCompartmentEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 5004;

	/**
	 * @generated
	 */
	public BranchActionBranchTransitionCompartmentEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	public String getCompartmentName() {
		return "BranchTransitionCompartment";
	}

	/**
	 * @generated
	 */
	public IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure) super
				.createFigure();
		result.setTitleVisibility(false);
		return result;
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new BranchActionBranchTransitionCompartmentItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DragDropEditPolicy());
		installEditPolicy(
				EditPolicyRoles.CANONICAL_ROLE,
				new BranchActionBranchTransitionCompartmentCanonicalEditPolicy());
	}

	/**
	 * @generated
	 */
	protected void setRatio(Double ratio) {
		if (getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
			super.setRatio(ratio);
		}
	}
}
