/**
 * Assumption: The rectangle can be localized by the coordinates of the lower left corner point and the upper right corner point!
 * @author Louis1
 *
 */
public class Rectangle extends Geometry implements Comparable {

	Point2D p1;		// coordinates of the lower left corner point
	Point2D p2; 	// coordinates of the upper right corner point
	
	/**
	 * Constructor for a rectangle. It gets two 2D points which span the rectangle in two extremes.
	 * @param p1 should represent the lower left corner of the rectangle
	 * @param p2 should represent the upper right corner of the rectangle
	 */
	public Rectangle(Point2D p1, Point2D p2){
		super(2); // a rectangle is always 2-dimensional
		//TODO: Take care that p1 is in the lower left corner and p2 is in the upper right corner
		this.p1 = p1;
		this.p2 = p2;
		
	}

	/**
	 * Method getUpperRight() returns the upper right corner as a 2D point
	 * @return p2 as the upper right corner point
	 */
	public Point2D getUpperRight(){
		return p2;
	}
	
	/**
	 * Method getLowerLeft() returns the lower left corner as a 2D point
	 * @return p1 as the lower left corner point
	 */
	public Point2D getLowerLeft(){
		return p1;
	}
	
	/**
	 * Method setUpperRight(Point2D p2) gets a 2D point as the new point in the upper right corner
	 * @param p2 is the new upper right corner point
	 * @return true after process was sucessful
	 */
	public boolean setUpperRight(Point2D p2){
		this.p2 = p2;
		return true;
	}
	
	/**
	 * Method setLowerLeft(Point2D p1) gets a 2D point as the new point in the lower left corner
	 * @param p1 is the new lower left corner point
	 * @return true after process was sucessful
	 */
	public boolean setLowerLeft(Point2D p1){
		this.p1 = p1;
		return true;
	}
	
	/**
	 * Method volume() calculates and returns the volume of this rectangle as a double value
	 * @param length is the difference between the points on the x-axis
	 * @param width is the difference between the points on the y-axis
	 * @return volume of the rectangle
	 */
	@Override
	public double volume() {
		double length = this.p1.getCoordinate(0) - this.p2.getCoordinate(0);// difference between p1 and p2 on the x-axis
		double width = this.p1.getCoordinate(1) - this.p2.getCoordinate(1); // difference between p1 and p2 on the y-axis
		return Math.abs(length * width); 									// the volume of a rectangle is length times width
	}

	/**
	 * Method encapsulate(Geometry other) returns an Geometry which spans over this rectangle and another Geometry
	 * There are four possible cases: 'other' is a n-dimensional point, 'other' is another rectangle, 'other' is a volume, 'other' is neither
	 * @return a Geometry which spans over all coordinates of the two Geometries (returns null if there is no spanning Geometry)
	 */
	@Override
	public Geometry encapsulate(Geometry other) {
		if(other instanceof Point){							// cases for Point
			if(other.dimensions() == 2){
				return ((Point) other).encapsulate(this); 	// simply using the already implemented method of Point
			}else if(other.dimensions() == 3){
				return null; 								// TODO: Needs to return a volume which spans over the rectangle and the 3D point
			}else{
				return null; 								// the dimension of the point is too high to span a geometry with it
			}
		}else if(other instanceof Rectangle){				// spanning over two rectangles
			double greatestX, greatestY, smallestX, smallestY; // variables for the extreme points in the 2D surface
			smallestX = this.getLowerLeft().getCoordinate(0) < ((Rectangle) other).getLowerLeft().getCoordinate(0) ? this.getLowerLeft().getCoordinate(0) : ((Rectangle) other).getLowerLeft().getCoordinate(0);
			greatestX = this.getUpperRight().getCoordinate(0) > ((Rectangle) other).getUpperRight().getCoordinate(0) ? this.getUpperRight().getCoordinate(0) : ((Rectangle) other).getUpperRight().getCoordinate(0);
			smallestY = this.getLowerLeft().getCoordinate(1) < ((Rectangle) other).getLowerLeft().getCoordinate(1) ? this.getLowerLeft().getCoordinate(1) : ((Rectangle) other).getLowerLeft().getCoordinate(1);
			greatestY = this.getUpperRight().getCoordinate(1) > ((Rectangle) other).getUpperRight().getCoordinate(1) ? this.getUpperRight().getCoordinate(1) : ((Rectangle) other).getUpperRight().getCoordinate(1);
			return new Rectangle(new Point2D(smallestX,smallestY),new Point2D(greatestX,greatestY));
		}else if (other instanceof Volume){
			return null;									// TODO: How to build a new volume which spans over a plane rectangle and antoher volume?
		}else{												// The given geometry is neither of the defined Geometries
			return null; 
		}
	}

	/**
	 * Method compareTo(Object o) returns an integer value to indicate the difference between the volumes of the compared geometries.
	 * The result makes only sense if we compare two rectangles. All other returns are senseless solutions. It is also senseless that the return is an integer.
	 * @param o is the object to which we compare this rectangle
	 * @throw RuntimeException when the object is an unknown Geometry
	 * @throw RuntimeException when the given object is clearly no Geometry at all
	 */
	@Override
	public int compareTo(Object o) {
		if(o instanceof Geometry){
			if(o instanceof Point){
				return (int) this.volume();									// just return the volumen of this rectangle
			}else if (o instanceof Rectangle){
				return (int) (this.volume() - ((Rectangle) o).volume()); 	// difference between this volume and the volume of the other rectangle
			}else if (o instanceof Volume){
				return (int) ((Volume) o).volume();							// just return the volume of the Volume as an int
			}else{
				throw new RuntimeException("The given Geometry is unknown!");
			}
		}else{
			throw new RuntimeException("This rectangle cannot be compared to the given object!");
		}
	}
}
