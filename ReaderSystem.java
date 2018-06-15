package Blatt8;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;


public class ReaderSystem {

    /**
     * Das Programm soll jede Zeile der Datei, die den regulären Ausdruck mindestens einmal enthält, zusammen
     * mit der Zeilennummer auf der Standardkonsole ausgeben. Zusätzlich soll für jede ausgegebene Zeile
     * die Anzahl der Vorkommen des regulären Ausdrucks ausgeben werden.
     *
     * @param args
     */
    public static void main(String[] args) {

        if (!(args.length == 1)) {
            throw new IllegalArgumentException(" You should enter exactly one argument.");

        }


        String searchPattern = args[0];
        // Initialize a reader for the finally part
        DecoratedReader reader = null;

        try {
            // Use System.in to open the file after the Pipe Operator
            //BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            reader = new DecoratedReader(input, searchPattern);
            // Iterate through the programm and print out matches
            try {
                int line = 0;
                while (reader.readLine() != null) {
                    if (reader.getAmountOfMatches() != 0) {
                        line = reader.getLineNumber();
                        System.out.print("Line " + line + "\t");
                        System.out.println(" Number of matches here: " + reader.getAmountOfMatches());
                    }

                }
            } catch (IOException e) {
                System.out.println(" An Error occured while reading a line.");
            } finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println(" An Error occured while closing the reader.");
                }
            }
        } catch (RuntimeException e) {
            System.out.println(" An Error occured while reading the input.");
        }

    }
}
