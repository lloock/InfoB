public class Fraction {

  private int numerator;
  private int denominator;

  /**
  * First Constructor: creates an object with just a numerator
  * @param numerator
  **/
  public Fraction(int numerator) {
    this.numerator = numerator;
    this.denominator = 1;

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
  
  // I did not really get what they want from me
    
    return new Fraction(1);
  }

  public String toString() {
    return numerator + " / " + denominator;
  }
}

/***********TESTKLASSE***********************/

public class FractionTestklasse {

  public static void main(String[]  args) {

    Fraction a = new Fraction(4, 2);
    Fraction b = new Fraction(2, -3);
    Fraction c = new Fraction(5);
    Fraction d = new Fraction(-1, 5);

    System.out.println(" a = " + a);
    System.out.println(" b = " + b);
    System.out.println(" c = " + c);


  // Hab länger nicht in Java programmiert, ich weiß nicht genau wie es das macht was ich von Java will, noch in progress
  
    int eins = a.Fraction.multiply(2);
    if (eins == 2) {
      System.out.println("Multiply(int factor) works!");
    } else {
      System.out.println("Multiply(int factor) does not work!");
    }
    //assert 1 = b.multiply(new Fraction(3, -2));
    //System.out.println("Multiply(Fraction factor) works!");
    //assert -1 = d.divide(new Fraction(5, 1));
    //assert 1 = c.multiply(a,b);



  }

}

