/**
 * Schreiben Sie einen Testklassse, die die grundlegenden Funktionen des
 * HashSet automatisch testet. Sie können sich sehr viel Arbeit ersparen,
 * wenn Sie zuerst die Testklasse implementieren und dann Ihr
 * HashSet solange verändern, bis die Testklasse nicht mehr fehlschlägt.
 * Sie können die Testklasse besser kontrollieren, wenn Sie einen
 * extra Typen implementieren, bei dem Sie den Hash-Wert
 * festlegen können.
 */

public class HashTestKlasse {
    public static void main(String[] args) {

        GenericHashing<String> t = new GenericHashing<>();
        t.insert("Nina");
        t.insert("Louis");
        System.out.println(t.contains("Nina"));
        System.out.println(t.delete("Nina"));
        System.out.println(t.contains("Nina"));





        /**
        // Default
        GenericHashing<> t;

        HashFunction<? super Number> ts; // Upper bound
        <? extends Number> // Lower bound
        HashSet<Number> hs;
        }
         */

    }
}
