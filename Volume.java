import org.omg.SendingContext.RunTime;

public class Volume extends Geometry implements Comparable{

    private double[] point_1;
    private double[] point_2;

    /**
     * Constructor for building volume
     * @param one first point
     * @param two second point
     */
    public Volume(Point one, Point two){
        super(one.dimensions());
        if(one.dimensions() != two.dimensions()) {
            throw new RuntimeException(" You can't create a Volume if the points have different dimensions! ");
        }

        // write the points in the array
        point_1 = new double[one.dimensions()];
        point_2 = new double[two.dimensions()];
        setVolume(point_1);
        setVolume(point_2);
    }

    public void setVolume(double... points){
        int i = 0;
        for(double p: points){
            points[i] = p;
            i++;
        }
    }
    
    /**
     * Method volume() calculates the volume of this volume.
     * @param volume which represents the calculated volume of the Volume
     */
    public double volume() {
        double volume = 1;
        for(int i = 0; i <= point_1.length; i++) {
            volume *= point_1[i] * point_2[i];
        }
        return volume;
    }

    /**
     * Method encapsulate(Geometry other) returns a new geometry which encapsulates this volume and the given geometry
     * @throw RuntimeException if given Geometry is not a volume and not a point
     * @return depending on the type of Geometry of other
     */
    public Geometry encapsulate(Geometry other) {
        if(this.dimensions() != other.dimensions()) {
            return null;
        }
        // No clue how to do this
        if(other instanceof Point){			// volume and point
            // TODO: How to span over a n-dimensional volumen and point?		
        }					
        if(other instanceof Volume){
            //TODO: How to build a new volume based on two distinct volumes?
            // Maybe go through the lists and take the min/ max? But when to switch? difficult for hugher dimensions ..
            return null;
        }
        // given geometry is unknown
        throw new RuntimeException(" Something went wrong, the Geometry is unknown to the system.");
    }

    /**
     * Method compareTo(Object o) compares a given object and this volume and returns an adequate integer value
     * @throw RuntimeException if the given object is a geometry but not known
     * @throw RuntimeException if the given object is not a geometry
     * @return depends on the type of o
     */
    @Override
    public int compareTo(Object o) {
        // test if they are the same
        if(this == o) {
            return 0;
        }
        if(o instanceof Geometry){
            if(o instanceof Point){
                return 1;								// TODO: How to compare a n-dimensional point and a volume
            }else if(o instanceof Rectangle){
                return 0;								// TODO: How to compare a plane surface and a volume
            }else if (o instanceof Volume){
                return (int) (this.volume() - ((Volume) o).volume()); 	// difference between this volume and the given volume as an integer value
            }else{
                throw new RuntimeException("The given geometry is unknown!");
            }
        }else{
            throw new RuntimeException("Volume cannot be compared to this type of object!");
        }
    }
}
