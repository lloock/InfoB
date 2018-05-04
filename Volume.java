import org.omg.SendingContext.RunTime;

public class Volume extends Geometry implements Comparable{

    private double[] point_1;
    private double[] point_2;
    //private Point c2; // 3D point which is on the bottom of the volume in the upper right corner
    //private Point c3; // 3D point which is on the top of the volume right above c1

     // TODO: How to infer from two points in a 3D space the 3 points to describe the volume (here: cube)
        // Perhaps a new method is necessary which checks weather the given three points have the right order or are correct to describe the volume
        // And perhaps we even need a method which gets three random corners (3D points) of the volume and uses this as a basis to infer c1-c3
        // Keep in mind: 3 random 3D points cannot span in our case a volume (they must have a specific relation to each other)
        // - c1 and c2 have the same z-level, but the x- and y-values are different
        // - c1 and c3 have the same x- and y-values, but c3 is on a higher z-level
        // - c2 and c3 are diagonal points in the volume (all values are different)

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
     *
     */
    public double volume() {
        double volume = 1;
        for(int i = 0; i <= point_1.length; i++) {
            volume *= point_1[i] * point_2[i];
        }
        return volume;
    }

    /**
     * Method getC1() returns the 3D point of c1
     * @return c1 is the point at the bottom of the volume in the lower left corner
     *
    public Point getC1(){
        return c1;
    }

    /**
     * Method getC2() returns the 3D point of c2
     * @return c2 is the point at the bottom of the volume in the upper right corner
     *
    public Point getC2(){
        return c2;
    }

    /**
     * Method getC3() returns the 3D point of c3
     * @return c3 is the point at the top of the volume right above c1
     *
    public Point getC3(){
        return c3;
    }
    */

    /**
     * Method setC1(Point c1) sets the point c1 to a new position
     * @param c1  is the point at the bottom of the volume in the lower left corner
     * @throw RuntimeException if the new point has not three dimensions
     * @return true if process was successful
     *
    public boolean setC1(Point c1){
        if(c1.dimensions() != 3){
            throw new RuntimeException("c1 has an incorrect dimension to set this point of the volume!");
        }
        this.c1 = c1;
        return true;
    }

    /**
     * Method setC2(Point c2) sets the point c2 to a new position
     * @param c2  is the point at the bottom of the volume in the upper right corner
     * @throw RuntimeException if the new point has not three dimensions
     * @return true if process was successful
     *
    public boolean setC2(Point c2){
        if(c2.dimensions() != 3){
            throw new RuntimeException("c2 has an incorrect dimension to set this point of the volume!");
        }
        this.c2 = c2;
        return true;
    }

    /**
     * Method setC3(Point c3) sets the point c3 to a new position
     * @param c3 is the point at the top of the volume right above c1
     * @throw RuntimeException if the new point has not three dimensions
     * @return true if process was successful
     *
    public boolean setc3(Point c3){
        if(c3.dimensions() != 3){
            throw new RuntimeException("c3 has an incorrect dimension to set this point of the volume!");
        }
        this.c3 = c3;
        return true;
    }
    */

    /**
     * Method encapsulate(Geometry other) returns a new geometry which encapsulates this volume and the given geometry
     * @return depending on the type of Geometry of other
     */
    public Geometry encapsulate(Geometry other) {
        if(this.dimensions() != other.dimensions()) {
            return null;
        }
        // No clue how to do this
        if(other instanceof Point){										// volume and point
            								// delegating this task to the class Point
        }							// delegating this task to the class Rectangle
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
                return 1;												// TODO: How to compare a n-dimensional point and a volume
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
