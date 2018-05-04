/**
 * Assumption: The rectangle can be localized by the coordinates of the lower left corner point and the upper right corner point!
 * A rectangle extends the Volume, which extends Geometry and implements Comparable.
 * So it is a specialization of Volume and we can use all its methods etc.
 *
 * @author Louis1
 * @author Nina Mainusch
 */
public class Rectangle extends Volume {

    /**
     * Constructor for a rectangle. It gets two 2D points which span the rectangle in two extremes.
     * @param p1 should represent the lower left corner of the rectangle
     * @param p2 should represent the upper right corner of the rectangle
     */
    public Rectangle(Point2D p1, Point2D p2){
        super(p1, p2);

    }

}
