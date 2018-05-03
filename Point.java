/**
 * Class 'Point' represents a n-dimensional point in an n-dimensional space
 * @param coordinates is a double array which represents the coordinates of the n-dimensional point
 * 
 * @author Louis Loock
 */
public class Point extends Geometry implements Comparable{

	private double[] coordinates;	
	
	/**
	 * Constructor of a n-dimensional point. 
	 * This constructor gets the dimension of the point and its coordinates chronologically
	 * @param dimension
	 * @param coordinates is a list of coordinates
	 * @throw RuntimeExcepiton if number of coordinates and the dimension is unequal
	 */
	public Point(int dimension, double... coordinates) {
		super(dimension);
		coordinates = new double[dimension];
		setCoordinates(coordinates);
	}
	
	/**
	 * Default Constructor sets the dimension as 2 and the coordinates are the origin of the coordinate system (0,0)
	 */
	public Point(){
		this(2, 0d, 0d);
	}
	
	/**
	 * Method setCoordinates(double.. coordinates) sets the coordinates of this n-dimensional point
	 * @param coordinates
	 * @throw RuntimeException if the number of coordinates is unequal to the dimension of this point
	 * @return true if process succeeds 
	 */
	public boolean setCoordinates(double... coordinates){
		int i = 0;
		for(double c: coordinates){
			coordinates[i] = c;
			i++;
		}	
		if(i != super.dimensions()){		// cheaking weather the number of coordinates is equal to the dimension
			throw new RuntimeException("Number of coordinates is unequal to the dimension of this point!");
		}
		return true;
	}
	
	/**
	 * Method getCoordinate(int i) returns the coordinate at the i-th position
	 * @param i is the position of the coordinate (1. dimension or 2. dimension or ...)
	 * @throw RuntimeException if i is not a valid position in the cooridnate array
	 * @return the coordinate at the i-th position
	 */
	public double getCoordinate(int i){
		if (i < 0 || i >= super.dimensions()){ // i must be between 0 and the dimension (e.g. there are only 0 and 1 allowed if the dimension is 2)
			throw new RuntimeException("This position is not valid!");
		}
		return coordinates[i];
	}
	
	/**
	 * Method volume() returns the volume of a point which is always zero
	 * @return 0 -> a point has always a volume of zero
	 */
	@Override
	public double volume() {
		return 0d;
	}

	/**
	 * Method encapsulate(Geometry other) returns an Geometry which spans over the point and another Geometry
	 * There are four possible cases: other is another point (needs to be same dimension), other is a rectangle, other is a volume, other is neither
	 * @return a Geometry which spans over all coordinates of the two Geometries (returns null if there is no spanning Geometry)
	 */
	@Override
	public Geometry encapsulate(Geometry other) {
		if(other instanceof Point){  						// spanning over two n-dimensional points
			if(super.dimensions() == other.dimensions()){	// the dimension of both points must be equal
				if(other.dimensions() == 2){				// spanning over 2D points
					// creating and returning a new Rectangle based on the both points
					return new Rectangle(new Point2D(this.getCoordinate(0),this.getCoordinate(1)), new Point2D(((Point) other).getCoordinate(0),((Point) other).getCoordinate(1)));
				}else if(other.dimensions() == 3){			// spanning over 3D points
					return new Volume(this, (Point) other);
				}else{
					return null; 							// we do not have a Geomatry which spans over a dimenision greater 3
				}
			}else{											// dimension of the two points is unequal
				return null;
			}
		}else if(other instanceof Rectangle && this.dimensions() == 2){ 				// spanning over a 2D point and a rectangle
			return new Rectangle((Point2D)this,((Rectangle) other).getUpperRight()); 	// Rectangle is spanning from this point over to the upperRight Corner of the given rectangle (other)
		}else if (other instanceof Volume && this.dimensions() == 3){					// spanning over a 3D point and a volume
			return new Volume(this, ((Volume) other).getC1(),((Volume) other).getC2());	// TODO: How to span in 3D space
		}else{ 																			// the Geometry is unknown
			return null;
		}
	}

	/**
	 * Implementation of the method compareTo(Object o) form the interface comparable
	 * It compares the volumes of these Geometries
	 * @param o is an object to which we compare this point
	 */
	@Override
	public int compareTo(Object o) {
		if(o instanceof Geometry){
			if(o instanceof Point){
				if(this.dimensions() == ((Point) o).dimensions()){
					return 0; // TODO: Howt to compare two points of the same dimension
				}else{
					throw new RuntimeException("The two compared points are uncomparable, because they have different dimensions!");
				}
			}else if(o instanceof Rectangle){
				return (int) ((Rectangle) o).volume(); // we simply return the difference between zero and the volumen of the rectangle, which is simply the volume of the rectangle
			}else if(o instanceof Volume){
				return (int) ((Volume) o).volume();
			}else{ // a geometry which is not a point, not a rectangle and not a volume
				throw new RuntimeException("The given object is an unknown Geometry! We cannot identify a volume.");
			}
		}else{																		// o is not a geometry and has therefore no volume
			throw new RuntimeException("Given object is not a Geometry! We cannot compare a point and this object.");
		}
	}
}
