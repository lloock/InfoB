public class TestklasseList {

    public static void main(String[] args) {

        // Create some generic lists and instances
        GenericList<Integer> integers = new GenericList<>();
        System.out.println("GenericList<Integer> integers = new GenericList<>();");
        GenericList<Integer> integersClone = integers.clone();
        System.out.println("GenericList<Integer> integersClone = integers.clone();");
        GenericList<String> strings = new GenericList<>();
        System.out.println("GenericList<String> strings = new GenericList<>();");
        GenericList<String> stringsClone = strings.clone();
        System.out.println("GenericList<String> stringsClone = strings.clone();");
        System.out.println();

        // Add some elements to the lists
        integers.add(1);
        strings.add("a");
        System.out.println("integers.add(1)");
        System.out.println("strings.add(a)");
        System.out.println();

        // See if clone is independent (does not have the added instances)
        System.out.println("integers.elem(): " + integers.elem());
        System.out.println("strings.elem(): " + strings.elem());
        System.out.println("integersClone.empty(): " + integersClone.empty());
        System.out.println("stringsClone.empty(): " + stringsClone.empty());
        integers.add(2);
        strings.add("b");
        System.out.println("integers.add(2)");
        System.out.println("strings.add(b)");
        System.out.println();

        // Create another clone to see if the entries are copied too
        GenericList<Integer> integersClone2 = integers.clone();
        System.out.println("GenericList<Integer> integersClone2 = integers.clone();");
        GenericList<String> stringsClone2 = strings.clone();
        System.out.println("GenericList<String> stringsClone2 = strings.clone();");
        System.out.println("integersClone2.empty(): " + integersClone2.empty());
        System.out.println("stringsClone2.empty(): " + stringsClone2.empty());
        System.out.println("integersClone2.elem(): " + integersClone2.elem());
        System.out.println("stringsClone2.elem(): " + stringsClone2.elem());
        System.out.println();

        // delete something from the original list, see if entries are deleted in copy too
        integers.delete();
        strings.delete();
        System.out.println("integers.elem(): " + integers.elem());
        System.out.println("strings.elem(): " + strings.elem());
        System.out.println("integersClone2.elem(): " + integersClone2.elem());
        System.out.println("stringsClone2.elem(): " + stringsClone2.elem());
        System.out.println();

        // Test operation delete and add some element to clone
        integersClone2.delete();
        integersClone2.add(313);
        System.out.println("integers.elem(): " + integers.elem());
        System.out.println("integersClone2.elem(): " + integersClone2.elem());


        // Test getClass and inequality for clone elements
        System.out.println("integers.clone().getClass() == integers.getClass(): (should be true) ");
        System.out.println(integers.clone().getClass() == integers.getClass());
        System.out.println("integers.clone() != integers: (should be true) ");
        System.out.println(integers.clone() != integers);

        // Test the equality of instance and clone
        System.out.println("integers.clone().equals(integers): (should be true) " + integers.clone().equals(integers));
        System.out.println("strings.clone().equals(strings): (should be true) " + strings.clone().equals(strings));
        System.out.println();

    }
}
