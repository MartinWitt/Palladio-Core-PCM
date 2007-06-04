package de.uka.ipd.sdq.pcm.gmf.composite;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;


/**
 * Represents the UML style --( ) border figure
 * which rotates depending on the side the figure
 * is located in relation to it's parent. *
 */
public class BallFigure extends DefaultSizeNodeFigure {
	
	BallAnchor myAnchor;

	/**
	 * @param size width and hight of the figure in logical units (LP)
	 */
	public BallFigure(int logicalSize) {
		super(logicalSize, logicalSize);
		myAnchor = new BallAnchor(this);
	}
	
	/**
	 * Helper function to get the parent's border item locator
	 * 
	 * @return the parent's border item locator
	 */
	private IBorderItemLocator getBorderItemLocator() {
		IFigure parentFigure = this.getParent().getParent();
		if (parentFigure != null && parentFigure.getLayoutManager() != null) {
			Object constraint = parentFigure.getLayoutManager().getConstraint(
				this.getParent());
			if (constraint instanceof IBorderItemLocator) {
				return (IBorderItemLocator) constraint;
			}
		}
		return null;
	}
	
	@Override
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		int side = (getBorderItemLocator() == null ? PositionConstants.WEST : getBorderItemLocator().getCurrentSideOfParent());
		
		Rectangle rect = new Rectangle();
		graphics.getClip(rect);
		rect.shrink(1, 1);
		
		switch(side){
		case PositionConstants.EAST:
			graphics.drawLine(rect.getLeft().x,rect.getCenter().y,rect.getCenter().x,rect.getCenter().y);
			graphics.drawArc(rect.getCenter().x, rect.getTop().y+rect.height/4, rect.height/2, rect.height/2, 0, 360);
			break;
		case PositionConstants.WEST:
			graphics.drawLine(rect.getRight().x,rect.getCenter().y,rect.getCenter().x,rect.getCenter().y);
			graphics.drawArc(rect.getLeft().x, rect.getTop().y+rect.height/4, rect.height/2, rect.height/2, 0, 360);
			break;
		case PositionConstants.NORTH:
			graphics.drawLine(rect.getCenter().x,rect.getBottom().y,rect.getCenter().x,rect.getCenter().y);
			graphics.drawArc(rect.getCenter().x-rect.width/4, rect.getTop().y, rect.height/2, rect.height/2, 0, 360);
			break;
		case PositionConstants.SOUTH:
			graphics.drawLine(rect.getCenter().x,rect.getTop().y,rect.getCenter().x,rect.getCenter().y);
			graphics.drawArc(rect.getCenter().x-rect.width/4, rect.getCenter().y, rect.height/2, rect.height/2, 0, 360);
			break;
		}
	}
	
	/**
	 * @return the rectangle surrounding the ( ) part of the figure
	 * relative to the position of the figure
	 */
	private Rectangle getBallBounds() {
		int side = (getBorderItemLocator() == null ? PositionConstants.WEST : getBorderItemLocator().getCurrentSideOfParent());
	
		Rectangle rect = getBounds();
		Rectangle result = null;
		
		switch(side){
		case PositionConstants.EAST:
			result = new Rectangle(rect.getCenter().x, rect.getTop().y+rect.height/4, rect.height/2, rect.height/2);
			break;
		case PositionConstants.WEST:
			result = new Rectangle(rect.getLeft().x, rect.getTop().y+rect.height/4, rect.height/2, rect.height/2);
			break;
		case PositionConstants.NORTH:
			result = new Rectangle(rect.getCenter().x-rect.width/4, rect.getTop().y, rect.height/2, rect.height/2);
			break;
		case PositionConstants.SOUTH:
			result = new Rectangle(rect.getCenter().x-rect.width/4, rect.getCenter().y, rect.height/2, rect.height/2);
			break;
		}
		return result;
	}
	
	@Override
	public ConnectionAnchor getConnectionAnchor(String terminal) {
		return myAnchor;
	}			
	
	/**
	 * locates the anchor point around the ( ) part of the figure
	 * which is closest to the reference point
	 */
	private class BallAnchor extends AbstractConnectionAnchor {

		public BallAnchor(IFigure owner) {
			super(owner);
		}
		
		public Point getLocation(Point reference) {
			Point p = getAnchorPoint(reference);
			return p;
		}
		
		private Point getAnchorPoint(Point reference) {
			Rectangle r = Rectangle.SINGLETON;
			r.setBounds(getBallBounds());
			r.translate(-1, -1);
			r.resize(1, 1);
			getOwner().translateToAbsolute(r);
			
			Point ref = r.getCenter().negate().translate(reference);
			
			if (ref.x == 0)
				return new Point(reference.x, (ref.y > 0) ? r.bottom() : r.y);
			if (ref.y == 0)
				return new Point((ref.x > 0) ? r.right() : r.x, reference.y);
			
			float dx = (ref.x > 0) ? 0.5f : -0.5f;
			float dy = (ref.y > 0) ? 0.5f : -0.5f;
			  
			// ref.x, ref.y, r.width, r.height != 0 => safe to proceed
			  
			float k = (float)(ref.y * r.width) / (ref.x * r.height);
			k = k * k;
			  
			return r.getCenter().translate((int)(r.width * dx / Math.sqrt(1 + k)),
			                                (int)(r.height * dy / Math.sqrt(1 + 1 / k)));
		}		

	};
}