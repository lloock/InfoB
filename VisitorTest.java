public class VisitorTest {

    /**
     * Testen Sie Ihre Implementierung durch mindestens eine Visitor-Implementierung und lassen Sie
     * das Testprogramm prüfen, ob auch wirklich alle Elemente durchlaufen wurden.
     */
    public static void main(String[] args) {

        GenericList<String> list = new GenericList<>();
        GenericList<String> listDouble = new GenericList<>();
        list.add("Nina");
        list.add("Louis");
        list.add("Freitag");
        list.add("Gustav");
        list.add("Domingo");

        Visitor<String> visitString = new Visitor<String>() {
            @Override
            public boolean visit(String s) {
                if(s != null) {
                    System.out.println(s);
                    listDouble.add(s);
                    listDouble.advance();
                }
                return true;
            }
        };
        System.out.println("The original list:  ");
        list.accept(visitString);

        System.out.println("List duplicate is now supposed to contain the same Strings:  ");
        for (String elem : listDouble) {
            System.out.println(elem);
        }
        System.out.println();

        // Second list consisting of Ints
        GenericList<Integer> ints = new GenericList<>();
        // Write values in the list
        for (int i = 0; i < 10; i++) {
            ints.add(i);
            ints.advance();
        }


        System.out.println();

        Visitor<Integer> visitInts = new Visitor<Integer>() {
            @Override
            public boolean visit(Integer o) {
                if(o != null) {
                    System.out.print(o);
                }
                return true;

            }
        };

        ints.accept(visitInts);
        System.out.println();
    }
}
