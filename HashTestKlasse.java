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

        // Check the basic methods like insert, delete, contains
        GenericHashing<String> t = new GenericHashing<>();
        System.out.println("t.insert(\"Nina\") = " + t.insert("Nina"));
        System.out.println("t.insert(\"Louis\") = " + t.insert("Louis"));
        //t.insert(77);

        System.out.println("t.contains(\"Nina\") = " + t.contains("Nina"));
        System.out.println("t.delete(\"Nina\") = " + t.delete("Nina"));
        System.out.println("t.contains(\"Nina\") = " + t.contains("Nina"));
        System.out.println("t.delete(\"Nina\") = " + t.delete("Nina"));
        System.out.println("t.contains(\"Louis\") = " + t.contains("Louis"));

        GenericHashing<Integer> another = new GenericHashing<>(99);
        // Check what happens if you want to insert the same element twice
        System.out.println("another.insert(42) = " + another.insert(42));
        System.out.println("another.insert(42) (should be false) = " + another.insert(42));
        System.out.println("another.insert(313) = " + another.insert(313));
        Object o = new Object();
        //System.out.println("another.insert(313) = " + another.insert((Object) o));
        //System.out.println("another.insert(300d) = " + another.insert(300d));

        GenericHashing<Number> third = new GenericHashing<>(2);
        System.out.println("third.insert(42) = " + third.insert(42));
        //System.out.println("third.insert(42) = " + third.insert(o));
        System.out.println("third.insert(3.141592653589793) = " + third.insert(3.141592653589793));
        System.out.println("third.contains(3.141592653589793) = " + third.contains(3.141592653589793));
        System.out.println("third.delete(3.141592) = " + third.delete(3.141592));
        System.out.println("third.delete(3.141592653589793) = " + third.delete(3.141592653589793));
        
    }
}
