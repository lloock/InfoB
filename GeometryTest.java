public class GeometryTest {

    public static void main(String[] args) {
        // Test 1: Initializing some instances of Point2D, Point (different dimensions), Rectangles and Volumes
        // Test only Points2D and Rectangles, since they extend Points and Volumes and 
        // automatically test them too
        
        Point2D p1 = new Point2D(4d,3d);
        Point2D p2 = new Point2D(-1d,1d);
        Point2D p3 = new Point2D(3d, 4d);
        System.out.println(" Points 2D: ");
        System.out.println("p1: (4, 3)" );
        System.out.println("p2: (-1, 1)" );

        Point origin = new Point();
        Point p8 = new Point(1, 3d);
        Point p4 = new Point(2, 0d, 0d);
        Point p5 = new Point(3, 0d, 2d, 3d);
        Point p6 = new Point(4, 0d, -1d, 4d, -5d);
        Point p7 = new Point(5, 1d, 1d, 1d, 1d, 1d);

        Rectangle r1 = new Rectangle(p1, p2);
        Rectangle r3 = new Rectangle(p2, p1);
        Rectangle r2 = new Rectangle(new Point2D(-1,-2) , new Point2D(2,2));
        System.out.println(" Rectangles: ");
        System.out.println("r1: (4, 3)(3,4)" );
        System.out.println("r2: (-1, 1)(2,2)" );
        System.out.println("r3: (3,4)(4,3)" );

        // Test 2: Getter amd setter methods

        // Test 3: Ask for the volume of some Geometry
        System.out.println("p1.volume(): (should be 0) " + p1.volume());
        System.out.println("r1.volume():  " + r1.volume());
        System.out.println("r3.volume(): same as r1.volume " + r3.volume());
        // Task 4: Encapsulating some geometries with each other (two 2D points, 2D point and rectangle, two rectangle, two volumes...?)
        
        // Task 5: CompareTo Method
        System.out.println("p1.compareTo(p1): (should be 0) " + p1.compareTo(p1));
        System.out.println("p2.compareTo(p1): (should be < 0) " + p2.compareTo(p1));
        System.out.println("r1.compareTo(r1): (should be 0) " + r1.compareTo(r1));
        System.out.println("r1.compareTo(r2): (should be > 0) " + r1.compareTo(r2));
    }
}
