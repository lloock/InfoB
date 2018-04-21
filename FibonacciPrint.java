/**
 * Class is responsible for printing fibonacci numbers in a structured table
 * Open problems:
 * - Die Übergabe einer Zahl passiert momentan über eine separate Testklasse (ich glaube die Aufgabe meint das anders, aber ich weiß nicht wie)
 * 
 * @author Louis Loock
 */

public class FibonacciPrint {
	/**
	 * Method printFibonacci(int limit) gets a number (limit) and prints every fibonacci number up to this point
	 * in a structured table.
	 * @param limit is maximum fibonacci number position (0-39
	 * @throws RuntimeException if limit is smaller 0 (impossible)
	 * @throws RuntimeException if limit is higher than 39 (result could not be printed in this format
	 */
	public static void printFibonacci(int limit) {
		// RuntimeExceptions
		if(limit < 0) {
			throw new RuntimeException("There is no fibonacci number at point: " + limit);
		}
		if(limit > 39) {
			throw new RuntimeException("The fibonacci number at this point (" + limit + ") is too large!");
		}
		
		// Head of table
		System.out.println("| n |  f(n)  |");
		System.out.println("+---+--------+");
		
		// Rows of table
		for(int i = 0; i <= limit; i++) {					// iterating through the fibonacci numbers until 'limit' 
			System.out.print("|");
			System.out.printf("%3d", Fibonacci.counter()); 	// the counter has three slots to fill
			System.out.print("|");
			System.out.printf("%8d", Fibonacci.next());		// the fibonacci number has eight slots to fill
			System.out.println("|");
		}
	}
}
