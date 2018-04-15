
public class TestFraction {
	/**
	 * Open problems:
	 * - First test: we cannot initialize the fraction (0,1), because the mehtod gcd will run in an endless loop
	 * - Third test: how to check: yes, there is a RuntimeException?
	 * - Seventh test: no idea :D
	 */

	public static void main(String[] args) {

		// First test: initializing fractions of different types
		Fraction f1 = new Fraction(1, 1);
		Fraction f2 = new Fraction(1, 2);
		Fraction f3 = new Fraction(2, 1);
		Fraction f4 = new Fraction(-1, -3);
		Fraction f5 = new Fraction(-1, 4);
		Fraction f6 = new Fraction(2, -3);

		// Second test: method toString()
		System.out.println("F1: " + f1);
		System.out.println("F2: " + f2);
		System.out.println("F3: " + f3);
		System.out.println("F4: " + f4);
		System.out.println("F5: " + f5);
		System.out.println("F6: " + f6);

		// Third test: initializing an disallowed fraction
		//Fraction errorFraction = new Fraction(1, 0);
		
		// Fourth test: method multiply(int factor)
		int factor = 5;
		Fraction r1 = f2.multiply(factor);
		Fraction t1 = new Fraction(5,2);   // result must be: 1/2 * 5 = 5/2
		System.out.println(f2 + " * " + factor + " = " + r1 + " which is " + r1.equals(t1));
		
		// Fifth test: method multiply(Fraction factor)
		Fraction r2 = f3.multiply(f6);
		Fraction t2 = new Fraction(-4,3);   // result must be: 2/1 * 2/-3 = -4/3
		System.out.println(f3 + " * " + f6 + " = " + r2 + " which is " + r2.equals(t2));
		
		// Sixth test: method division(Fraction factor)
		Fraction r3 = f2.divide(f5);
		Fraction t3 = new Fraction(-2,1);	// result must be: 1/2 / -1/4 = -2/1 
		System.out.println(f2 + " / " + f5 + " = " + r3 + " which is " + r3.equals(t3));
		
		// Seventh test: method multiply(Fraction... factor)
		
	}

}
