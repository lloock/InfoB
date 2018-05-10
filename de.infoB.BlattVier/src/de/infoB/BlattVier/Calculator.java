package de.infoB.BlattVier;

public class Calculator {

    private static String error;

    /**
     * Core of the calculator, performs the operations.
     * Returns null if something went wrong
     *
     * @param left first fraction
     * @param operator
     * @param right second fraction
     * @return result or if something did not work null
     **/
    private Fraction calculate(Fraction left, String operator, Fraction right) {

        switch(operator) {

            case("+"):
                return left.add(right);
            //break;
            case("-"):
                return left.subtract(right);
            case("*"):
                return left.multiply(right);
            case("/"):
                return left.divide(right);
            default:
                error = (" Please use a defined operator.");
                return null;
        }
    }

    /**
     * Takes two numbers and an operator, calculates not only fractions but normal numbers
     * @param left
     * @param operator
     * @param right
     * @return a number
     */
    private Number calculate(Number left, String operator, Number right) {

        if (left instanceof Fraction && right instanceof Fraction) {
            return calculate((Fraction) left, operator, (Fraction) right);
        }
        switch(operator) {

            case("+"):
                return left.doubleValue() + right.doubleValue();

            case("-"):
                return left.doubleValue() - right.doubleValue();

            case("*"):
                return left.doubleValue() * right.doubleValue();

            case("/"):
                return left.doubleValue() / right.doubleValue();

            default:
                error = (" Please use a defined operator.");
                return null;
        }
    }

    /**
     * Since one entered the Numbers as Strings, use the new method parseFraction
     * then procedure as usual
     * @param left first fraction as a String
     * @param operator
     * @param right second fraction as a String
     * @return result or if something did not work null
     **/
    public Number calculate(String left, String operator, String right) {

        Number numLeft = parseNumber(left);
        Number numRight = parseNumber(right);

        if(numLeft == null | numRight == null) {
            return null;
        }
        return calculate(numLeft, operator, numRight);
    }

    /**
     * Parses a fraction represented as a string to a fraction represented by integers
     * @param numberString The Number represented as a string
     * @return parsed Number or Fraction
     **/
    private Number parseNumber(String numberString) {
        // checks whether the string is really a fraction
        // The parameter matches gets is the regular expression representing a fraction
        //? stands for optional sign, \d for [0-9]
        if(numberString.matches("-?\\d*/\\d*")) {
            return Fraction.parseFraction(numberString);
        }
        if(!numberString.matches("-?\\d+(\\.\\d+)?")){
            if(!numberString.matches("-?\\d*\\.\\d+?")) {
                error = "You have not entered a Double";
                return null;
            }
        }
        return Double.parseDouble(numberString);
    }

    public static String getError() {
        return error;
    }

    /**
     * How to use a calculator
     */
    public static void operatingInstruction() {
        System.out.println(" You should insert your calculation in the following way:");
        System.out.println(" fraction - operator(+,-,*,/) - fraction" + "\n");
    }

    public static void main(String[] args) {
        //Fraction f1 = new Fraction(1, 1);
        //System.out.println("F1: " + f1.getClass());
        // There have to be three arguments for performing a calculation
        if(args.length != 3) {
            System.err.println(" There have to be three arguments to perform a calculation");
            operatingInstruction();
            System.exit(1);
        }
        Calculator calculator = new Calculator();
        Number result = calculator.calculate(args[0], args[1], args[2]);

        //System.out.println(args[0] + args[1] + args[2]);
        if(result == null) {
            System.out.println(Calculator.getError());
            Calculator.operatingInstruction();
        } else {
            System.out.println("Result = " + result.toString());
        }
    }
}