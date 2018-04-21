/**
 * 
 * @author Louis Loock
 *
 */
public class Fibonacci {

	private static int fn1 = 0;
	private static int fn2 = 1;
	private static int counter = 0; // counts which fibonacci number will be the next
	
	/**
	 * Method next() returns the next fibonacci number chronologically
	 * The program starts with 0  and 1 (see: fn1 and fn2)
	 * It also increments the counter which counts at which point of the fibonacci sequence we currently are
	 * @return next fibonacci number
	 */
	public static int next() {
		if(counter == 0) {
			counter++;
			return fn1;
		}
		if (counter == 1) {
			counter++;
			return fn2;
		}
		else {
			int fnext = fn1 +fn2;
			fn1 = fn2;		
			fn2 = fnext;
			counter++;
			return fnext;
		}
	}
	
	/**
	 * Method counter() returns the number at which fibonacci sequence point we are
	 * Important: the returned number says which is the next fibonacci position which will be returned
	 * Example: if it returnes '3', next() will at its next call return the 3. fibonacci number 
	 * @return count of the fibonacci sequence
	 */
	public static int counter() {
		return counter;
	}
}
