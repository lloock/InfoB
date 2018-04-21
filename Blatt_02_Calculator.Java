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

        Fraction result;

        if(operator.equals("+")) {
            return left.add(right);
        } else if(operator.equals("-")) {
            result = left.subtract(right);
        } else if(operator.equals("*")) {
            result = left.multiply(right);
        } else if(operator.equals("/")) {
            if(right.getNumerator() == 0) {
                error = (" Never divide by 0.");
                return null;
            } else {
                result = left.divide(right);
            }
        } else {
            error = (" Please use a defined operator.");
            return null;
        }

        return result;
    }
    /**
     * In case one entered the fractions as Strings, use the new method parseFraction
     * then procedure as usual
     * @param left first fraction as a String
     * @param operator
     * @param right second fraction as a String
     * @return result or if something did not work null
     **/
    public Fraction calculate(String left, String operator, String right) {

        Fraction fracLeft = Fraction.parseFraction(left);
        Fraction fracRight = Fraction.parseFraction(right);

        Fraction result = calculate(fracLeft, operator, fracRight);

        if(result == null) {
            return null;
        }
        return result;
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

        // There have to be three arguments for performing a calculation
        if(args.length != 3) {
            System.err.println(" There have to be three arguments to perform a calculation");
            operatingInstruction();
            System.exit(1);
        }

        Calculator calculator = new Calculator();

        Fraction result = calculator.calculate(args[0], args[1], args[2]);
        //System.out.println(args[0] + args[1] + args[2]);
        if(result == null) {
            System.out.println(Calculator.getError());
            Calculator.operatingInstruction();
        } else {
            System.out.println("Result = " + result);
        }

    }


}
