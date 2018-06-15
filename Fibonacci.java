package Blatt8;

import java.util.HashMap;
import java.io.IOException;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

/**
 * Aufgabe 8.2: Standard-Serialisierung (18 Punkte)
 * Betrachten Sie das Programm zum Berechnen der Fibonacci-Zahlen Fibonacci.java, das bereits
 * berechnete Fibonacci-Zahlen in einer HashMap vorhält.
 * Verändern Sie dieses Programm dahingehend, dass die eingesetzte java.util.HashMap beim
 * Start aus einer Datei gelesen und nach der Beendigung des Programms wieder in diese Datei zurückgeschrieben
 * wird. Sollte das Programm zum ersten Mal überhaupt aufgerufen werden, soll eine neue
 * java.util.HashMap erzeugt werden.
 */

/**
 * Class to calculate the Fibonacci number. Uses a HashMap to reduce the
 * calculation cost.
 *
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 */
public class Fibonacci {

    private static HashMap<Integer, Long> fibonacciHash;
    private final static String fileString = "./fibonacciHash.ser";

    /**
     * Calculates the fibonacci value of n.
     *
     * @param n a natural number >= 0 to calculate the fibonacci value of
     * @return fibonacci value of n
     */
    private static long fibonacci(int n) throws IOException, ClassNotFoundException {
        if (n < 0) {
            throw new IllegalArgumentException("n = " + n);
        }

        else if(fibonacciHash == null) {
            // If no HashMap existed before: create new HashMap
            File file = new File(fileString);
            if (!file.exists()) {
                fibonacciHash = new HashMap<>();
                fibonacciHash.put(0, 0L);
                fibonacciHash.put(1, 1L);
            } else {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream input = new ObjectInputStream(fis);
                fibonacciHash = (HashMap<Integer, Long>) input.readObject();
                input.close();
            }
        }

        File file = new File(fileString);

        // HashMap wird nach Beendigung wieder in file zurückgeschrieben
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream output = new ObjectOutputStream(fos);
        output.writeObject(fibonacciHash);
        output.flush();
        output.close();

        return getFibonacci(n);
    }

    private static long getFibonacci(int n) {
        if (fibonacciHash.containsKey(n)) {
            return fibonacciHash.get(n);
        } else {
            long nMinus1 = getFibonacci(n - 1);
            long nMinus2 = getFibonacci(n - 2);
            long fibonacci = nMinus1 + nMinus2;

            fibonacciHash.put(n, fibonacci);
            return fibonacci;
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            printUsage();
        } else {
            try {
                System.out.println(fibonacci(Integer.parseInt(args[0])));

            } catch (IllegalArgumentException ex) {
                printUsage();
            } catch (ClassNotFoundException | IOException e) {
                System.out.println(e);
            }
        }
    }

    private static void printUsage() {
        System.out.println("java calc/Fiboncci n");
        System.out.println("n must be a natural number >= 0");
    }

}
