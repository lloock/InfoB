public class FractionTest {

    /**
     * Erweitern Sie die Klasse Fraction der vorherigen Aufgabenblätter um die Eigenschaft, dass
     * Fraction - Instanzen mit gleichem Nenner und Zähler innerhalb einer Virtual Machine auch immer
     * dieselbe Referenz haben. Beispielsweise soll der Ausdruck
     * Fraction.parseFraction("1/2") == Fraction.parseFraction("2/4")
     * true liefern. Es soll weiterhin auch möglich sein, Fraction - Instanzen anhand zweier (für Zähler
     * und Nenner) oder nur einem (für den Zähler) int zu erzeugen. Testen Sie Ihre Implementation.
     *
     */

    /**
     * geeignete Collection: HasMap
     *
     */
    public static void main(String[] args) {

        //Fraction firstFraction = Fraction.parseFraction("1/2");
        Fraction firstFraction = Fraction.newFraction(1,2);
        Fraction secondFraction = Fraction.newFraction(2, 4);
        Fraction thirdFraction = Fraction.newFraction(4, 8);
        Fraction otherFraction = Fraction.newFraction(4);

        System.out.println(" " + firstFraction.toString());
        System.out.println(" " + secondFraction.toString());
        System.out.println(" " + thirdFraction.toString());
        System.out.println(" " + otherFraction.toString());
        System.out.println("");

        // Test if two fractions are the same
        System.out.println(" firstFraction.equals(secondFraction) : Should be true: " + firstFraction.equals(secondFraction));
        System.out.print(" firstFraction == secondFraction : Should be true: ");
        System.out.println(firstFraction == secondFraction);
        System.out.println();


        System.out.println(" secondFraction.equals(thirdFraction): Should be true: " + secondFraction.equals(thirdFraction));
        System.out.print(" secondFraction == thirdFraction : Should be true: ");
        System.out.println(secondFraction == thirdFraction);
        System.out.println();

        // Test if equals and == yields false if they are different
        //System.out.println(" thirdFraction.equals(otherFraction): Should be false" + thirdFraction.equals(otherFraction));
        System.out.print(" thirdFraction != otherFraction: Should be true: ");
        System.out.println(thirdFraction != otherFraction);
        System.out.println();
        System.out.print("Fraction.parseFraction(\"1/2\") == Fraction.parseFraction(\"2/4\"): Should be true: ");
        System.out.println(Fraction.parseFraction("1/2") == Fraction.parseFraction("2/4"));
    }
}
