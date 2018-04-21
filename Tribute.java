/**
 * Extra test class for class Arena which produces tributes
 * 
 * @author Louis Loock
 */
public class Tribute {
	private double x;			// x-coordinate
	private double y;			// y-coordinate
	private int section;		// section the tribute is in
	private final String NAME;		// name of the tribute

	/**
	 * Constructor of an tribute. It gets the coordinates and a name
	 * The section where the tribute is will also be calculated (using the class Arena)
	 * @param x coordinate
	 * @param y coordinate
	 * @param name
	 */
	public Tribute(double x, double y, String name) {
		this.x = x;
		this.y = y;
		this.NAME = name;
		section = Arena.getArea(x, y);
	}

	/**
	 * getX() returns the x coordinate
	 * @return x coordinate
	 */
	public double getX() {
		return this.x;
	}

	/**
	 * getY() returns the y coordinate
	 * @return y coordinate
	 */
	public double getY() {
		return this.y;
	}

	/**
	 * setX() sets the x coordinate
	 * @return true if successful
	 */
	public boolean setX(double x) {
		this.x = x;
		return true;
	}

	/**
	 * setY() sets the y coordinate
	 * @return true if successful
	 */
	public boolean setY(double y) {
		this.y = y;
		return true;
	}

	/**
	 * getSection returns the section of the tribute
	 * @return section
	 */
	public int getSection() {
		return this.section;
	}

	/**
	 * getName() returns the name of the tribute
	 * @return name
	 */
	public String getName() {
		return NAME;
	}

	/**
	 * Method toString returns all informations about the tribute as a string
	 * @return String of all informations
	 */
	public String toString() {
		return (NAME + ": (" + x + "," + y + ") is in section: " + section);
	}

}
