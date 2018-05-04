
/**
 * Class 'Point' represents a n-dimensional point in an n-dimensional space
 * @author Louis Loock
 * @author Nina Mainusch
 */
public class Point extends Geometry implements Comparable{
    // coordinates is an array which represents the coordinates of the n-dimensional point
    private double[] coordinates;

    /**
     * Constructor of a n-dimensional point.
     * This constructor gets the dimension of the point and its coordinates chronologically
     * @param coordinates is a list of coordinates
     */
    public Point(double... coordinates) {
        super(coordinates.length);
        coordinates = new double[coordinates.length];
        setCoordinates(coordinates);
    }

    /**
     * Default Constructor the coordinates are the origin of the coordinate system (0,0)
     */
    public Point(){
        this(0d, 0d);
    }

    /**
     * Method setCoordinates(double.. coordinates) sets the coordinates of this n-dimensional point
     * @param coordinates
     */
    public void setCoordinates(double... coordinates){
        int i = 0;
        for(double c: coordinates){
            coordinates[i] = c;
            i++;
        }
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
    public double volume() {
        return 0d;
    }

    /**
     * Method encapsulate(Geometry other) returns an Geometry which spans over the point and another Geometry
     * There are four possible cases: other is another point (needs to be same dimension), other is a rectangle, other is a volume, other is neither
     * @return a Geometry which spans over all coordinates of the two Geometries
     * @throws RuntimeException if the Geometry is unknown
     */

    public Geometry encapsulate(Geometry other) {
        // the dimension of both Geometries must be equal, otherwise we can stop
        if (super.dimensions() != other.dimensions()) {
            return null;
        }
        if(other instanceof Point) {                        // spanning over two n-dimensional points

                if (other.dimensions() == 2) {                // spanning over 2D points
                    // creating and returning a new Rectangle based on the both points
                    return new Rectangle(new Point2D(this.getCoordinate(0), this.getCoordinate(1)), new Point2D(((Point) other).getCoordinate(0), ((Point) other).getCoordinate(1)));
                }
                if (other.dimensions() >= 3) {            // spanning over more dimensional points
                    return new Volume(this, (Point) other);
                }
        }
        // Problematic, Point could also be above rectangle then we would not have fulfilled the conditions
        // the encapsulate method requires
        // --> since a rectangle is also a volume, wouldn't that work automatically?
        //if(other instanceof Rectangle){
        //    return new Rectangle((Point2D)this,((Rectangle) other).getUpperRight()); 	// Rectangle is spanning from this point over to the upperRight Corner of the given rectangle (other)
        //}
        if (other instanceof Volume){
            return ((Volume)other).encapsulate(this);
        }
        // If none of the above applied, the Geometry is unknown
        throw new RuntimeException(" Something went wrong, the Geometry is unknown to the system.");
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
            }
            if(o instanceof Volume){
                return -1; // volume of a point is smaller than volume of a Volume
            } else { // a geometry which is not a point, not a rectangle and not a volume
                throw new RuntimeException("The given object is an unknown Geometry! We cannot identify a volume.");
            }
        }else{																		// o is not a geometry and has therefore no volume
            throw new RuntimeException("Given object is not a Geometry! We cannot compare a point and this object.");
        }
    }
}
