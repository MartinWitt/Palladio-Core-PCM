/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.parts;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.ExternalCallAction2ItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class ExternalCallAction2EditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3012;

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
	public ExternalCallAction2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ExternalCallAction2ItemSemanticEditPolicy());
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
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
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
		ExternalCallActionFigure figure = new ExternalCallActionFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ExternalCallActionFigure getPrimaryShape() {
		return (ExternalCallActionFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ExternalCallActionEntityName2EditPart) {
			((ExternalCallActionEntityName2EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureComponentExternalCallName());
			return true;
		}
		if (childEditPart instanceof ExternalCallActionInputVariableUsage2EditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureExternalCallActionCompartmentRectangle();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane
					.add(((ExternalCallActionInputVariableUsage2EditPart) childEditPart)
							.getFigure());
			return true;
		}
		if (childEditPart instanceof ExternalCallActionOutputVariableUsage2EditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureExternalCallActionCompartmentRectangle();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane
					.add(((ExternalCallActionOutputVariableUsage2EditPart) childEditPart)
							.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof ExternalCallActionInputVariableUsage2EditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureExternalCallActionCompartmentRectangle();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane
					.remove(((ExternalCallActionInputVariableUsage2EditPart) childEditPart)
							.getFigure());
			return true;
		}
		if (childEditPart instanceof ExternalCallActionOutputVariableUsage2EditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureExternalCallActionCompartmentRectangle();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane
					.remove(((ExternalCallActionOutputVariableUsage2EditPart) childEditPart)
							.getFigure());
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

		if (editPart instanceof ExternalCallActionInputVariableUsage2EditPart) {
			return getPrimaryShape()
					.getFigureExternalCallActionCompartmentRectangle();
		}
		if (editPart instanceof ExternalCallActionOutputVariableUsage2EditPart) {
			return getPrimaryShape()
					.getFigureExternalCallActionCompartmentRectangle();
		}
		return super.getContentPaneFor(editPart);
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode()
				.DPtoLP(40), getMapMode().DPtoLP(40));
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
			layout.setSpacing(getMapMode().DPtoLP(5));
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
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(PalladioComponentModelVisualIDRegistry
				.getType(ExternalCallActionEntityName2EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class ExternalCallActionFigure extends RoundedRectangle {
		/**
		 * @generated
		 */
		private WrappingLabel fFigureComponentExternalCallName;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureExternalCallActionCompartmentRectangle;

		/**
		 * @generated
		 */
		public ExternalCallActionFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			layoutThis.horizontalSpacing = 0;
			layoutThis.verticalSpacing = 0;
			layoutThis.marginWidth = 0;
			layoutThis.marginHeight = 0;
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(8),
					getMapMode().DPtoLP(8)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			WrappingLabel stereotypeLabel0 = new WrappingLabel();
			stereotypeLabel0.setText("<<ExternalCallAction>>");
			stereotypeLabel0.setBorder(new MarginBorder(getMapMode().DPtoLP(2),
					getMapMode().DPtoLP(0), getMapMode().DPtoLP(2),
					getMapMode().DPtoLP(0)));

			GridData constraintStereotypeLabel0 = new GridData();
			constraintStereotypeLabel0.verticalAlignment = GridData.CENTER;
			constraintStereotypeLabel0.horizontalAlignment = GridData.CENTER;
			constraintStereotypeLabel0.horizontalIndent = 0;
			constraintStereotypeLabel0.horizontalSpan = 1;
			constraintStereotypeLabel0.verticalSpan = 1;
			constraintStereotypeLabel0.grabExcessHorizontalSpace = false;
			constraintStereotypeLabel0.grabExcessVerticalSpace = false;
			this.add(stereotypeLabel0, constraintStereotypeLabel0);

			fFigureComponentExternalCallName = new WrappingLabel();
			fFigureComponentExternalCallName.setText("myCall");
			fFigureComponentExternalCallName.setBorder(new MarginBorder(
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

			GridData constraintFFigureComponentExternalCallName = new GridData();
			constraintFFigureComponentExternalCallName.verticalAlignment = GridData.CENTER;
			constraintFFigureComponentExternalCallName.horizontalAlignment = GridData.CENTER;
			constraintFFigureComponentExternalCallName.horizontalIndent = 0;
			constraintFFigureComponentExternalCallName.horizontalSpan = 1;
			constraintFFigureComponentExternalCallName.verticalSpan = 1;
			constraintFFigureComponentExternalCallName.grabExcessHorizontalSpace = false;
			constraintFFigureComponentExternalCallName.grabExcessVerticalSpace = false;
			this.add(fFigureComponentExternalCallName,
					constraintFFigureComponentExternalCallName);

			fFigureExternalCallActionCompartmentRectangle = new RectangleFigure();
			fFigureExternalCallActionCompartmentRectangle.setFill(false);
			fFigureExternalCallActionCompartmentRectangle.setOutline(false);

			GridData constraintFFigureExternalCallActionCompartmentRectangle = new GridData();
			constraintFFigureExternalCallActionCompartmentRectangle.verticalAlignment = GridData.FILL;
			constraintFFigureExternalCallActionCompartmentRectangle.horizontalAlignment = GridData.FILL;
			constraintFFigureExternalCallActionCompartmentRectangle.horizontalIndent = 0;
			constraintFFigureExternalCallActionCompartmentRectangle.horizontalSpan = 1;
			constraintFFigureExternalCallActionCompartmentRectangle.verticalSpan = 1;
			constraintFFigureExternalCallActionCompartmentRectangle.grabExcessHorizontalSpace = true;
			constraintFFigureExternalCallActionCompartmentRectangle.grabExcessVerticalSpace = true;
			this.add(fFigureExternalCallActionCompartmentRectangle,
					constraintFFigureExternalCallActionCompartmentRectangle);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureComponentExternalCallName() {
			return fFigureComponentExternalCallName;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureExternalCallActionCompartmentRectangle() {
			return fFigureExternalCallActionCompartmentRectangle;
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