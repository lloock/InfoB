
public class GeometryTest {

	public static void main(String[] args) {
		// Test 1: Initializing some instances of Point2D, Point (different dimensions), Rectangles and Volumes
		Point2D p1 = new Point2D();
		Point2D p2 = new Point2D(1d,1d);
		
		Point origin = new Point();
		Point p3 = new Point(1, 3d);
		Point p4 = new Point(2, 0d, 0d);
		Point p5 = new Point(3, 0d, 2d, 3d);
		Point p6 = new Point(4, 0d, -1d, 4d, -5d);
		Point p7 = new Point(5, 1d, 1d, 1d, 1d, 1d);
		
		Rectangle r1 = new Rectangle(p1, p2);
		Rectangle r2 = new Rectangle(new Point2D(-1,-2) , new Point2D(2,2));
	
		// Test 2: Getter amd setter methoden
		
		// Test 3: Ask for the volume of some Geometries
		
		// Task 4: Encapsulating some geometries with each other (two 2D points, 2D point and rectangle, two rectangle, two volumes...?)
		
		// Task 5: CompareTo Method 
	}
}
