//package de.uos.Binf;
import java.lang.Math;
/**
 * This class produces Fractions (numerator / denominator)
 * @author Nina Mainusch
 * @author Louis Look
 */
public class Fraction extends Number {

  private int numerator;
  private int denominator;

  /**
  * First Constructor: creates an object with just a numerator
  * @param numerator
  **/
  public Fraction(int numerator) {
    this(numerator, 1);

  }

  /**
  * Second Constructor: creates an object with a numerator and a denominator
  * @param numerator
  * @param denominator
  **/
  public Fraction(int numerator, int denominator) {

    // Dividing by 0 is never a good idea
    if (denominator == 0) {
      throw new RuntimeException("\n" + " It is not possible to divide something by 0. Sorry.");
    }

    // check if there are negative numbers, since euclid would not work for them
    boolean isNegative = false;
    if (numerator < 0 && denominator < 0) {
      numerator *= -1;
      denominator *= -1;
    } else if (numerator < 0 ) {
      numerator *= -1;
      isNegative = true;

    } else if (denominator < 0) {
      denominator *= -1;
      isNegative = true;
    }

    int ggt = Fraction.ggt(numerator, denominator);
    this.numerator = numerator / ggt;
    this.denominator = denominator / ggt;

    if (isNegative) {
      this.numerator *= -1;
    }
  }

  /**
   * Finds the greatest common divisor using the euclidean algorithm
   * @param x
   * @param y
   * @return greatest common divisor
   */
  public static int ggt(int x, int y) {
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

  public Fraction multiply(int factor) {
    return new Fraction(numerator * factor, denominator);
  }

  public Fraction multiply(Fraction factor) {
    return new Fraction(numerator * factor.numerator, denominator * factor.denominator);
  }

  public Fraction divide(Fraction divisor) {
    return new Fraction(numerator * divisor.denominator, denominator * divisor.numerator);
  }

  public Fraction multiply(Fraction... factors) {
    Fraction result = new Fraction(1,1);
    for(Fraction elem:factors) {
      result = result.multiply(elem);
    }
    return result;
  }

  public Fraction add(Fraction addend) {
    return new Fraction(this.numerator*addend.denominator + addend.numerator*this.denominator,
            this.denominator*addend.denominator);
  }

  public Fraction subtract(Fraction subtrahend) {
    return new Fraction(this.numerator*subtrahend.denominator - subtrahend.numerator*this.denominator,
            this.denominator*subtrahend.denominator);
  }
  public String toString() {
    return numerator + " / " + denominator;
  }

  public static Fraction parseFraction(String fractionString) {
      // checks whether the string is really a fraction
      // The parameter matches gets is the regular expression representing a fraction
      // ? stands for optional sign, \d for [0-9]
      if(!fractionString.matches("-?\\d+/[1-9]\\d*")) {
            throw new RuntimeException(" The string is not representing a fraction");
      }

      String[] split = fractionString.split("/");
      // Use the method parseInt to change from the character presentation
      // to the corresponding integer
      Fraction parsedFraction = new Fraction(Integer.parseInt(split[0]), Integer.parseInt(split[1]));

      return parsedFraction;
    }
  public boolean equals(Fraction f2) {
    if(this.denominator == f2.getDenominator() && this.numerator == f2.getNumerator()) {
      return true;
    }else {
      return false;
    }

  }

  @Override
  public double doubleValue() {
    return (double) this.getNumerator() / (double) this.getDenominator();
  }

  @Override
  public float floatValue() {
    return (float) doubleValue();
  }

  @Override
  public int intValue() {
    return (int) doubleValue();
  }

  @Override
  public long longValue() {
    return (long) doubleValue();
  }

}
