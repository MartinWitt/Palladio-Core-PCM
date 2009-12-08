/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.parts;

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

import de.uka.ipd.sdq.pcm.gmf.usage.edit.policies.EntryLevelSystemCallItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.usage.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.usage.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class EntryLevelSystemCallEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3003;

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
	public EntryLevelSystemCallEditPart(View view) {
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
								if (type == PalladioComponentModelElementTypes.VariableUsage_3012) {
									EditPart compartmentEditPart = getChildBySemanticHint(PalladioComponentModelVisualIDRegistry
											.getType(EntryLevelSystemCallParameterUsageEditPart.VISUAL_ID));
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
				new EntryLevelSystemCallItemSemanticEditPolicy());
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
		SystemCallFigure figure = new SystemCallFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public SystemCallFigure getPrimaryShape() {
		return (SystemCallFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ComponentExternalCallNameLabelEditPart) {
			((ComponentExternalCallNameLabelEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureSystemCallNameLabelFigure());
			return true;
		}
		if (childEditPart instanceof EntryLevelSystemCallParameterUsageEditPart) {
			IFigure pane = getPrimaryShape().getFigureSystemCallCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane
					.add(((EntryLevelSystemCallParameterUsageEditPart) childEditPart)
							.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof EntryLevelSystemCallParameterUsageEditPart) {
			IFigure pane = getPrimaryShape().getFigureSystemCallCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane
					.remove(((EntryLevelSystemCallParameterUsageEditPart) childEditPart)
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

		if (editPart instanceof EntryLevelSystemCallParameterUsageEditPart) {
			return getPrimaryShape().getFigureSystemCallCompartment();
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
				.getType(ComponentExternalCallNameLabelEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class SystemCallFigure extends RoundedRectangle {
		/**
		 * @generated
		 */
		private WrappingLabel fFigureSystemCallNameLabelFigure;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureSystemCallCompartment;

		/**
		 * @generated
		 */
		public SystemCallFigure() {

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

			WrappingLabel systemCallStereotypeLabelFigure0 = new WrappingLabel();
			systemCallStereotypeLabelFigure0.setText("<<SystemCallAction>>");
			systemCallStereotypeLabelFigure0.setBorder(new MarginBorder(
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

			GridData constraintSystemCallStereotypeLabelFigure0 = new GridData();
			constraintSystemCallStereotypeLabelFigure0.verticalAlignment = GridData.CENTER;
			constraintSystemCallStereotypeLabelFigure0.horizontalAlignment = GridData.CENTER;
			constraintSystemCallStereotypeLabelFigure0.horizontalIndent = 0;
			constraintSystemCallStereotypeLabelFigure0.horizontalSpan = 1;
			constraintSystemCallStereotypeLabelFigure0.verticalSpan = 1;
			constraintSystemCallStereotypeLabelFigure0.grabExcessHorizontalSpace = false;
			constraintSystemCallStereotypeLabelFigure0.grabExcessVerticalSpace = false;
			this.add(systemCallStereotypeLabelFigure0,
					constraintSystemCallStereotypeLabelFigure0);

			fFigureSystemCallNameLabelFigure = new WrappingLabel();
			fFigureSystemCallNameLabelFigure.setText("");
			fFigureSystemCallNameLabelFigure.setBorder(new MarginBorder(
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

			GridData constraintFFigureSystemCallNameLabelFigure = new GridData();
			constraintFFigureSystemCallNameLabelFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureSystemCallNameLabelFigure.horizontalAlignment = GridData.CENTER;
			constraintFFigureSystemCallNameLabelFigure.horizontalIndent = 0;
			constraintFFigureSystemCallNameLabelFigure.horizontalSpan = 1;
			constraintFFigureSystemCallNameLabelFigure.verticalSpan = 1;
			constraintFFigureSystemCallNameLabelFigure.grabExcessHorizontalSpace = false;
			constraintFFigureSystemCallNameLabelFigure.grabExcessVerticalSpace = false;
			this.add(fFigureSystemCallNameLabelFigure,
					constraintFFigureSystemCallNameLabelFigure);

			fFigureSystemCallCompartment = new RectangleFigure();
			fFigureSystemCallCompartment.setFill(false);
			fFigureSystemCallCompartment.setOutline(false);

			GridData constraintFFigureSystemCallCompartment = new GridData();
			constraintFFigureSystemCallCompartment.verticalAlignment = GridData.FILL;
			constraintFFigureSystemCallCompartment.horizontalAlignment = GridData.FILL;
			constraintFFigureSystemCallCompartment.horizontalIndent = 0;
			constraintFFigureSystemCallCompartment.horizontalSpan = 1;
			constraintFFigureSystemCallCompartment.verticalSpan = 1;
			constraintFFigureSystemCallCompartment.grabExcessHorizontalSpace = true;
			constraintFFigureSystemCallCompartment.grabExcessVerticalSpace = true;
			this.add(fFigureSystemCallCompartment,
					constraintFFigureSystemCallCompartment);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureSystemCallNameLabelFigure() {
			return fFigureSystemCallNameLabelFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureSystemCallCompartment() {
			return fFigureSystemCallCompartment;
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