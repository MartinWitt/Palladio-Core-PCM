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

import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.InternalAction2ItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class InternalAction2EditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2006;

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
	public InternalAction2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy() {
					public Command getCommand(Request request) {
						if (understandsRequest(request)) {
							if (request instanceof CreateViewAndElementRequest) {
								CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request)
										.getViewAndElementDescriptor()
										.getCreateElementRequestAdapter();
								IElementType type = (IElementType) adapter
										.getAdapter(IElementType.class);
								if (type == PalladioComponentModelElementTypes.ParametricResourceDemand_3031) {
									EditPart compartmentEditPart = getChildBySemanticHint(PalladioComponentModelVisualIDRegistry
											.getType(InternalActionResourceDemand2EditPart.VISUAL_ID));
									return compartmentEditPart == null ? null
											: compartmentEditPart
													.getCommand(request);
								}
							}
							return super.getCommand(request);
						}
						return null;
					}
				});
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new InternalAction2ItemSemanticEditPolicy());
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
		InternalActionFigure figure = new InternalActionFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public InternalActionFigure getPrimaryShape() {
		return (InternalActionFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof InternalActionEntityName2EditPart) {
			((InternalActionEntityName2EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureInternalActionFigureNameLabel());
			return true;
		}
		if (childEditPart instanceof InternalActionResourceDemand2EditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureInternalActionCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((InternalActionResourceDemand2EditPart) childEditPart)
					.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof InternalActionResourceDemand2EditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureInternalActionCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((InternalActionResourceDemand2EditPart) childEditPart)
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

		if (editPart instanceof InternalActionResourceDemand2EditPart) {
			return getPrimaryShape().getFigureInternalActionCompartment();
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
				.getType(InternalActionEntityName2EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class InternalActionFigure extends RoundedRectangle {
		/**
		 * @generated
		 */
		private WrappingLabel fFigureInternalActionFigureNameLabel;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureInternalActionCompartment;

		/**
		 * @generated
		 */
		public InternalActionFigure() {

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

			WrappingLabel internalActionStereotypeLabelFigure0 = new WrappingLabel();
			internalActionStereotypeLabelFigure0.setText("<<InternalAction>>");
			internalActionStereotypeLabelFigure0.setBorder(new MarginBorder(
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

			GridData constraintInternalActionStereotypeLabelFigure0 = new GridData();
			constraintInternalActionStereotypeLabelFigure0.verticalAlignment = GridData.CENTER;
			constraintInternalActionStereotypeLabelFigure0.horizontalAlignment = GridData.CENTER;
			constraintInternalActionStereotypeLabelFigure0.horizontalIndent = 0;
			constraintInternalActionStereotypeLabelFigure0.horizontalSpan = 1;
			constraintInternalActionStereotypeLabelFigure0.verticalSpan = 1;
			constraintInternalActionStereotypeLabelFigure0.grabExcessHorizontalSpace = false;
			constraintInternalActionStereotypeLabelFigure0.grabExcessVerticalSpace = false;
			this.add(internalActionStereotypeLabelFigure0,
					constraintInternalActionStereotypeLabelFigure0);

			fFigureInternalActionFigureNameLabel = new WrappingLabel();
			fFigureInternalActionFigureNameLabel.setText("<myName>");
			fFigureInternalActionFigureNameLabel.setBorder(new MarginBorder(
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

			GridData constraintFFigureInternalActionFigureNameLabel = new GridData();
			constraintFFigureInternalActionFigureNameLabel.verticalAlignment = GridData.CENTER;
			constraintFFigureInternalActionFigureNameLabel.horizontalAlignment = GridData.CENTER;
			constraintFFigureInternalActionFigureNameLabel.horizontalIndent = 0;
			constraintFFigureInternalActionFigureNameLabel.horizontalSpan = 1;
			constraintFFigureInternalActionFigureNameLabel.verticalSpan = 1;
			constraintFFigureInternalActionFigureNameLabel.grabExcessHorizontalSpace = false;
			constraintFFigureInternalActionFigureNameLabel.grabExcessVerticalSpace = false;
			this.add(fFigureInternalActionFigureNameLabel,
					constraintFFigureInternalActionFigureNameLabel);

			fFigureInternalActionCompartment = new RectangleFigure();
			fFigureInternalActionCompartment.setFill(false);
			fFigureInternalActionCompartment.setOutline(false);

			GridData constraintFFigureInternalActionCompartment = new GridData();
			constraintFFigureInternalActionCompartment.verticalAlignment = GridData.FILL;
			constraintFFigureInternalActionCompartment.horizontalAlignment = GridData.FILL;
			constraintFFigureInternalActionCompartment.horizontalIndent = 0;
			constraintFFigureInternalActionCompartment.horizontalSpan = 1;
			constraintFFigureInternalActionCompartment.verticalSpan = 1;
			constraintFFigureInternalActionCompartment.grabExcessHorizontalSpace = true;
			constraintFFigureInternalActionCompartment.grabExcessVerticalSpace = true;
			this.add(fFigureInternalActionCompartment,
					constraintFFigureInternalActionCompartment);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureInternalActionFigureNameLabel() {
			return fFigureInternalActionFigureNameLabel;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureInternalActionCompartment() {
			return fFigureInternalActionCompartment;
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
