/**
 * This class is simply testing the print of fibonacci numbers
 * @author Louis Loock
 *
 */
public class FibonacciTest {

	public static void main(String[] args) {
		int limit = Integer.parseInt(args[0]);			
		FibonacciPrint.printFibonacci(limit);
	}

}
