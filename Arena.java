import java.lang.Math;
/**
 * The class Arena has only one method. The method getArea gets a coordinate (x,y) and then calculates weather this is in the arena
 * 
 * @author Louis Loock
 */
public class Arena {

	/**
	 * Method getArea(double x, double y) gets two coordinates and calculates in which section the tribute is in
	 * @param x is the x-coordinate in the game table 
	 * @param y is the y-coordinate in the game table
	 * @param section is the return value and informs in which section the given coordinate is
	 * @param degree is the degree where the coordinate is
	 * @throw RuntimeException if coordinate cannot be localized
	 * @return section is a number between 1 and 12 (so 12 sections ordered after the degree of the position)
	 */
	public static int getArea(double x, double y) {
		int section = -1; 								// default value: tribute is out of the arena
		double degree = 0.0;							// default value: 0.0 
		double distance = Math.sqrt((x*x) + (y*y)); 	// calculating the distance to the center
														// formula is based on: c^2 = a^2 + b^2 (a=x and b=y and c=distance)
		
		// Is the tribute out of bound?
		if(distance > 1.5) { 							// if distance to the center is larger than 1.5 
			return section; 							// then tribute is out of bound
		}
		
		// First, determining the quadrant and then calculating the degree with an appropriate equation
		if(x == 0 && y == 0) degree= 0.0;											// Special case: (0,0) has degree = 0
		else if(x>= 0 && y >= 0) {													// Quadrant 1
			degree = (Math.atan(Math.abs(x) / Math.abs(y)) * 180 / Math.PI);
		}else if(x < 0 && y > 0) {													// Quadrant 2
			if(x >= y)
				degree = (Math.atan(Math.abs(x) / Math.abs(y)) * 180 / Math.PI) + 270;
			else
				degree = (Math.atan(Math.abs(y) / Math.abs(x)) * 180 / Math.PI) + 270;
		}else if(x <= 0 && y <= 0) {												// Quadrant 3
			degree = (Math.atan(Math.abs(x) / Math.abs(y)) * 180 / Math.PI) + 180;
		}else if(x > 0 && y < 0) {													// Quadrant 4
			if(x >= y)
				degree = (Math.atan(Math.abs(y) / Math.abs(x)) * 180 / Math.PI) + 90;
			else
				degree = (Math.atan(Math.abs(x) / Math.abs(y)) * 180 / Math.PI) + 90;
		}else 
			throw new RuntimeException("Coordinate cannot be localized!");

		// connecting the degree of the position with the section the tribute is in
		if(degree >= 0d && degree < 30d || degree == 360)	return section= 1;
		else if(degree >= 30d && degree < 60d) 				return section= 2;
		else if(degree >= 60d && degree < 90d) 	 			return section= 3;
		else if(degree >= 90d && degree < 120d)  			return section= 4;
		else if(degree >= 120d && degree < 150d) 			return section= 5;
		else if(degree >= 150d && degree < 180d) 			return section= 6;
		else if(degree >= 180d && degree < 210d) 			return section= 7;
		else if(degree >= 210d && degree < 240d) 			return section= 8;
		else if(degree >= 240d && degree < 270d) 			return section= 9;
		else if(degree >= 270d && degree < 300d) 			return section= 10;
		else if(degree >= 300d && degree < 330d) 			return section= 11;
		else if(degree >= 330d && degree < 360d) 			return section= 12;
		else throw new RuntimeException("Degree has no corresponding position");
	}	
}
