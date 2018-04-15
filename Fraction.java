
public class Fraction {

	// Instance-variables for an object of the class 'Fraction'
	private int numerator;
	private int denominator;

	/**
	 * First Constructor: creates an object with just a numerator
	 * 
	 * @param numerator
	 **/
	public Fraction(int numerator) {
		this(numerator, 1);
	}

	/**
	 * Second Constructor: creates an object with a numerator and a denominator
	 * Method also cancels the fraction and therefore has to calculate the gcd To
	 * calculate the gcd, the fraction has to be positive
	 * 
	 * @param numerator
	 *            will be the value of the numerator of the created instance
	 * @param denominator
	 *            will be the value of the denominator of the created instance
	 * @throws RuntimeException
	 *             if denominator is zero (this cannot be)
	 **/
	public Fraction(int numerator, int denominator) {
		if (denominator == 0) {
			throw new RuntimeException("\nIt is not possible to divide something by 0.");
		}

		// check if there are negative numbers, since euclid would not work for them
		boolean fractionIsNegative = false; // default: fraction is positive
		if (numerator < 0 && denominator < 0) { // -/- = +
			numerator *= -1;
			denominator *= -1;
		} else if (numerator < 0) {
			numerator *= -1;
			fractionIsNegative = true;

		} else if (denominator < 0) {
			denominator *= -1;
			fractionIsNegative = true;
		}

		int gcd = Fraction.gcd(numerator, denominator); // Can't we just delete Fraction and make the method ggt
														// unstatic???
		this.numerator = numerator / gcd;
		this.denominator = denominator / gcd;

		if (fractionIsNegative) {
			this.numerator *= -1; // making the fraction negative again
		}
	}

	/**
	 * Method gcd calculates the greatest common divisor with the simple Euclidean
	 * algorithm
	 * 
	 * @param x
	 *            temporal parameter representing the numerator
	 * @param y
	 *            temporal parameter representing the denominator
	 * @throws RuntimeException
	 *             if one or both values are smaller zero
	 * @throws RuntimeException
	 *             if y as the denominator is zero
	 * @return x as the gcd
	 */
	private static int gcd(int x, int y) {
		if (x < 0 || y < 0) {
			throw new RuntimeException("We cannot calculate the gcd if one or both values are smaller zero!");
		}
		if (y == 0) {
			throw new RuntimeException("The expected denominator is zero. That is impossible!");
		}

		// Using the simple Euclidean algorithm
		while (y != 0) {
			if (x > y) {
				x = x - y;
			} else {
				y = y - x;
			}
		}
		return x;
	}	
	
	public int getDenominator() {
		return this.denominator;
	}

	public int getNumerator() {
		return this.numerator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public Fraction multiply(int factor) {
		return new Fraction(this.numerator * factor, this.denominator);
	}

	public Fraction multiply(Fraction factor) {
		return new Fraction(this.numerator * factor.getNumerator(), this.denominator * factor.getDenominator());
	}

	public Fraction divide(Fraction divisor) {
		return new Fraction(this.numerator * divisor.getDenominator(), this.denominator * divisor.getNumerator());
	}

	public Fraction multiply(Fraction... factors) {
		// I have no idea if this works
		int numerator = this.numerator;
		int denominator = this.denominator;

		for (Fraction factor : factors) {
			numerator *= factor.getNumerator();
			denominator *= factor.getDenominator();
		}
		Fraction result = new Fraction(numerator, denominator);
		return result;
	}

	public String toString() {
		return numerator + "/" + denominator;
	}
	
	public boolean equals(Fraction f2) {
		if(this.denominator == f2.getDenominator() && this.numerator == f2.getNumerator()) {
			return true;
		}else {
			return false;
		}
		
	}
}
