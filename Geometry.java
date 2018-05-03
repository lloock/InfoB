/**
 * Abstract superclass Geometry is the basis for representing points, planes or even volumes
 * Assumption about all geometries: A 2D plane is flat and a 3D body has as basis this 2D plane and then grows into the height
 * @author Nina Mainusch
 *
 */
public  abstract class Geometry  {

    private int dimension;

    /**
     * Create a new Geometry. Every Geometry must have a dimension of at least 2.
     * @param dimensions
     */
    public Geometry(int dimensions) {
        if(dimensions < 2) {
            throw new RuntimeException(" Dimensions cannot be smaller than 2!");
        }
        this.dimension = dimensions;
    }
    /**
     * Returns the number of dimensions of the data space of this Geometry.
     */
    public int dimensions() {
        return this.dimension;
    }

    /**
     * Returns the volume of this Geometry. If dimensions() is 2, the volume is the area.
     * @return volume of this Geometry
     */
    public abstract double volume();

    /**
     * Encapsulates this Geometry and the given Geometry by a new Geometry and returns the new Geometry.
     * Thus the new Geometry then contains at least this and the given Geometry. If other and this have a
     * different number of dimensions null is returned.
     * @param other the Geometry to be encapsulated together with this Geometry
     * @return a new Geometry containing this and other or null
     * @throws java.lang.RuntimeException - if the type of other is unknown
     */
    public abstract Geometry encapsulate(Geometry other);
    
}
