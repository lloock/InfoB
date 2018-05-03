
public class Volume extends Geometry implements Comparable{

	Point c1; // 3D point which is on the buttom of the volume in the lower left corner
	Point c2; // 3D point which is on the buttom of the volume in the upper right corner
	Point c3; // 3D point which is on the top of the volume right above c1
	
	
	/**
	 * Spezial case consturctor for building a cube. This only needs two points.
	 * It infers with the diagonal between these two points the 3D structure of this cube.
	 * @param c1 first starting point in a 3D space
	 * @param c2 second end
	 */
	public Volume(Point c1, Point c2) {
		super(3);							// a volume is represented in a 3D space
		// TODO: How to infer from two points in a 3D space the 3 points to describe the volume (here: cube)
		// Perhaps a new method is necessary which checks weather the given three points have the right order or are correct to describe the volume
		// And perhaps we even need a method which gets three random corners (3D points) of the volume and uses this as a basis to infer c1-c3
		// Keep in mind: 3 random 3D points cannot span in our case a volume (they must have a specific relation to each other)
		// - c1 and c2 have the same z-level, but the x- and y-values are different
		// - c1 and c3 have the same x- and y-values, but c3 is on a higher z-level
		// - c2 and c3 are diagonal points in the volume (all values are different)
		
	}
	
	/**
	 * Constructor for building a 3D volume based on three given 3D points
	 * @param c1 should be at the buttom of the volume in the lower left corner
	 * @param c2 should be at the buttom of the volume in the upper right corner
	 * @param c3 should be at the top of the volume right above c1
	 */
	public Volume(Point c1, Point c2, Point c3){
		super(3);							// a volume is represented in a 3D space
		// Error test: all three points must have three dimension
		if(c1.dimensions() != 3){
			throw new RuntimeException("The given point for c1 has: " + c1.dimensions() + " dimensions");
		}
		if(c2.dimensions() != 3){
			throw new RuntimeException("The given point for c2 has: " + c2.dimensions() + " dimensions");
		}
		if(c3.dimensions() != 3){
			throw new RuntimeException("The given point for c3 has: " + c3.dimensions() + " dimensions");
		}
		// TODO: Check weather the given points are really localized as specified above (see: variable declaration)
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;
	}

	/**
	 * Method volume() calculates the volume of this volume. Therefore it calculates the length, width and height.
	 * @param length of the volume
	 * @param width of the volume
	 * @param widht of the volume
	 */
	@Override
	public double volume() {
		double length = this.getC1().getCoordinate(0) - this.getC2().getCoordinate(0); // calculating on the x-axis
		double width = this.getC1().getCoordinate(1) - this.getC2().getCoordinate(1);  // calculating on the y-axis
		double height = this.getC1().getCoordinate(2) - this.getC3().getCoordinate(2); // calculaitn on the z-axis
		return Math.abs(length * width * height);
	}

	/**
	 * Method getC1() returns the 3D point of c1
	 * @return c1 is the point at the bottom of the volume in the lower left corner
	 */
	public Point getC1(){
		return c1;
	}
	
	/**
	 * Method getC2() returns the 3D point of c2
	 * @return c2 is the point at the bottom of the volume in the upper right corner
	 */
	public Point getC2(){
		return c2;
	}
	
	/**
	 * Method getC3() returns the 3D point of c3
	 * @return c3 is the point at the top of the volume right above c1
	 */
	public Point getC3(){
		return c3;
	}
	
	/**
	 * Method setC1(Point c1) sets the point c1 to a new position
	 * @param c1  is the point at the bottom of the volume in the lower left corner
	 * @throw RuntimeException if the new point has not three dimensions
	 * @return true if process was successful
	 */
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
	 */
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
	 */
	public boolean setc3(Point c3){
		if(c3.dimensions() != 3){
			throw new RuntimeException("c3 has an incorrect dimension to set this point of the volume!");
		}
		this.c3 = c3;
		return true;
	}
	
	/**
	 * Method excapsulate(Geometry other) returns a new geometry which encapsulates this volume and the given geometry
	 * @return depending on the type of Geometry of other
	 */
	@Override
	public Geometry encapsulate(Geometry other) {
		if(other instanceof Point){										// volume and point
			return other.encapsulate(this);								// delegating this task to the class Point
		}else if (other instanceof Rectangle){							// volume and rectangle
			return other.encapsulate(this);								// delegating this task to the class Rectangle
		}else if(other instanceof Volume){
			//TODO: How to build a new volume based on two distinct volumes?
			return null;
		}else{
			return null; 												// given geometry is unknown
		}
	}

	/**
	 * Method compareTo(Object o) compares a given object and this volume and returns an adequate integer value
	 * @throw RuntimeException if the given object is a geometry but not known
	 * @throw RuntimeException if the given object is not a geometry
	 * @return depends on the type of o
	 */
	@Override
	public int compareTo(Object o) {
		if(o instanceof Geometry){
			if(o instanceof Point){
				return 0;												// TODO: How to compare a n-dimensional point and a volume
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
