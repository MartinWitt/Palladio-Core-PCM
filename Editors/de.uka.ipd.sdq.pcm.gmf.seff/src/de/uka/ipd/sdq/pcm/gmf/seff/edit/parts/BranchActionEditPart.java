/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.BranchActionItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class BranchActionEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2005;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public BranchActionEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new BranchActionItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		BranchFigure figure = new BranchFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public BranchFigure getPrimaryShape() {
		return (BranchFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof BranchActionEntityNameEditPart) {
			((BranchActionEntityNameEditPart) childEditPart).setLabel(getPrimaryShape().getFigureBranchNameLabelFigure());
			return true;
		}
		if (childEditPart instanceof BranchActionBranchTransitionCompartment2EditPart) {
			IFigure pane = getPrimaryShape().getFigureBranchTransitionCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((BranchActionBranchTransitionCompartment2EditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof BranchActionEntityNameEditPart) {
			return true;
		}
		if (childEditPart instanceof BranchActionBranchTransitionCompartment2EditPart) {
			IFigure pane = getPrimaryShape().getFigureBranchTransitionCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((BranchActionBranchTransitionCompartment2EditPart) childEditPart).getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof BranchActionBranchTransitionCompartment2EditPart) {
			return getPrimaryShape().getFigureBranchTransitionCompartment();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(PalladioComponentModelVisualIDRegistry.getType(BranchActionEntityNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof StartActionEditPart) {
			types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof StopActionEditPart) {
			types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof ExternalCallActionEditPart) {
			types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof LoopActionEditPart) {
			types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.BranchActionEditPart) {
			types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof InternalActionEditPart) {
			types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof CollectionIteratorActionEditPart) {
			types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof SetVariableActionEditPart) {
			types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof AcquireActionEditPart) {
			types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof ReleaseActionEditPart) {
			types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof ForkActionEditPart) {
			types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof StartAction2EditPart) {
			types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof StopAction2EditPart) {
			types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof LoopAction2EditPart) {
			types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof InternalAction2EditPart) {
			types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof BranchAction2EditPart) {
			types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof ExternalCallAction2EditPart) {
			types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof AcquireAction2EditPart) {
			types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof ReleaseAction2EditPart) {
			types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof ForkAction2EditPart) {
			types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof CollectionIteratorAction2EditPart) {
			types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		if (targetEditPart instanceof SetVariableAction2EditPart) {
			types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.StartAction_2001);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.StopAction_2002);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.ExternalCallAction_2003);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.LoopAction_2004);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.BranchAction_2005);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.InternalAction_2006);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.CollectionIteratorAction_2007);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.SetVariableAction_2008);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.AcquireAction_2012);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.ReleaseAction_2010);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.ForkAction_2011);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.StartAction_3004);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.StopAction_3005);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.LoopAction_3006);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.InternalAction_3007);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.BranchAction_3009);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.ExternalCallAction_3012);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.AcquireAction_3026);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.ReleaseAction_3020);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.ForkAction_3023);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.CollectionIteratorAction_3013);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.SetVariableAction_3024);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.StartAction_2001);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.StopAction_2002);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.ExternalCallAction_2003);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.LoopAction_2004);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.BranchAction_2005);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.InternalAction_2006);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.CollectionIteratorAction_2007);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.SetVariableAction_2008);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.AcquireAction_2012);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.ReleaseAction_2010);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.ForkAction_2011);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.StartAction_3004);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.StopAction_3005);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.LoopAction_3006);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.InternalAction_3007);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.BranchAction_3009);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.ExternalCallAction_3012);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.AcquireAction_3026);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.ReleaseAction_3020);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.ForkAction_3023);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.CollectionIteratorAction_3013);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AbstractActionSuccessor_AbstractAction_4001) {
			types.add(PalladioComponentModelElementTypes.SetVariableAction_3024);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class BranchFigure extends RoundedRectangle {
		/**
		 * @generated
		 */
		private WrappingLabel fFigureBranchNameLabelFigure;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureBranchTransitionCompartment;

		/**
		 * @generated
		 */
		public BranchFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			layoutThis.horizontalSpacing = 0;
			layoutThis.verticalSpacing = 0;
			layoutThis.marginWidth = 0;
			layoutThis.marginHeight = 0;
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(8), getMapMode().DPtoLP(8)));
			this.setLineWidth(1);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			WrappingLabel branchStereotype0 = new WrappingLabel();
			branchStereotype0.setText("<<BranchAction>>");
			branchStereotype0.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode().DPtoLP(0), getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

			GridData constraintBranchStereotype0 = new GridData();
			constraintBranchStereotype0.verticalAlignment = GridData.CENTER;
			constraintBranchStereotype0.horizontalAlignment = GridData.CENTER;
			constraintBranchStereotype0.horizontalIndent = 0;
			constraintBranchStereotype0.horizontalSpan = 1;
			constraintBranchStereotype0.verticalSpan = 1;
			constraintBranchStereotype0.grabExcessHorizontalSpace = false;
			constraintBranchStereotype0.grabExcessVerticalSpace = false;
			this.add(branchStereotype0, constraintBranchStereotype0);

			fFigureBranchNameLabelFigure = new WrappingLabel();
			fFigureBranchNameLabelFigure.setText("myBranch");
			fFigureBranchNameLabelFigure.setBorder(new MarginBorder(getMapMode().DPtoLP(2), getMapMode().DPtoLP(0), getMapMode().DPtoLP(2), getMapMode()
					.DPtoLP(0)));

			GridData constraintFFigureBranchNameLabelFigure = new GridData();
			constraintFFigureBranchNameLabelFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureBranchNameLabelFigure.horizontalAlignment = GridData.CENTER;
			constraintFFigureBranchNameLabelFigure.horizontalIndent = 0;
			constraintFFigureBranchNameLabelFigure.horizontalSpan = 1;
			constraintFFigureBranchNameLabelFigure.verticalSpan = 1;
			constraintFFigureBranchNameLabelFigure.grabExcessHorizontalSpace = false;
			constraintFFigureBranchNameLabelFigure.grabExcessVerticalSpace = false;
			this.add(fFigureBranchNameLabelFigure, constraintFFigureBranchNameLabelFigure);

			fFigureBranchTransitionCompartment = new RectangleFigure();
			fFigureBranchTransitionCompartment.setFill(false);
			fFigureBranchTransitionCompartment.setOutline(false);
			fFigureBranchTransitionCompartment.setLineWidth(1);

			GridData constraintFFigureBranchTransitionCompartment = new GridData();
			constraintFFigureBranchTransitionCompartment.verticalAlignment = GridData.FILL;
			constraintFFigureBranchTransitionCompartment.horizontalAlignment = GridData.FILL;
			constraintFFigureBranchTransitionCompartment.horizontalIndent = 0;
			constraintFFigureBranchTransitionCompartment.horizontalSpan = 1;
			constraintFFigureBranchTransitionCompartment.verticalSpan = 1;
			constraintFFigureBranchTransitionCompartment.grabExcessHorizontalSpace = true;
			constraintFFigureBranchTransitionCompartment.grabExcessVerticalSpace = true;
			this.add(fFigureBranchTransitionCompartment, constraintFFigureBranchTransitionCompartment);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureBranchNameLabelFigure() {
			return fFigureBranchNameLabelFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureBranchTransitionCompartment() {
			return fFigureBranchTransitionCompartment;
		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

	}

}
