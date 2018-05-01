/**
 * Test-class for task 3.1 to test class Person and class Student
 * 
 * @author Nina Mainusch
 * 
 */
public class TestPerson {

	public static void main(String[] args) {

		// Initializing some instances and values
		Person p1 = new Person("Nina");
		Person p2 = new Person("Nina");
		Person p4 = new Person("Nina");
		Person p5 = new Person("Louis");

		Student s1 = new Student("Nina", 001);
		Student s2 = new Student("Nina", 001);
		Student s2_2 = new Student("Nina", 001);
		Student s4 = new Student("Louis", 007);


		System.out.println(" Part 1: Test equality method.");
		System.out.println(" Equality is defined by reflexiveness, symmetry, transitivity, consistency.");

		// Test 1: reflexiveness
		System.out.println(" Test 1: reflexiveness: ");
		if(p1.equals(p1)){
			System.out.println("Test 1 was successful for Person!");
		}else {
			System.out.println("Test 1 was not successful for Person p1!");
		}
		if(s1.equals(s1)){
			System.out.println("Test 1 was successful for Student!"+ '\n');
		}else {
			System.out.println("Test 1 was not successful for Student!" + '\n');
		}

		// Test 2: symmetry
		System.out.println(" Test 2: symmetry");
		if(p1.equals(p2) && p2.equals(p1) ) {										// p1 is not equal to p3
			System.out.println("Test 2 was successful for person!");
		}else {
			System.out.println("Test 2 was not successful for person!");
		}

		if(s1.equals(s2) && s2.equals(s1) ) {										// p1 is not equal to p3
			System.out.println("Test 2 was successful for student!");
		}else {
			System.out.println("Test 2 was not successful for student!");
		}
		// symmetry for negations
		System.out.println(" Test 2: no symmetry");
		if(!p5.equals(p4) && !p4.equals(p5) ) {										// p1 is not equal to p3
			System.out.println("Test 2 (negative) was successful for person!");
		}else {
			System.out.println("Test 2 (negative) was not successful for person!");
		}

		if(!s1.equals(s4) && !s4.equals(s1) ) {										// p1 is not equal to p3
			System.out.println("Test 2 (negative) was successful for student!"+ '\n');
		}else {
			System.out.println("Test 2 (negative) was not successful for student!" + '\n');
		}

		// Test 3: transitivity
		System.out.println(" Test 3: transitivity");
		if(p1.equals(p2) && p2.equals(p4) && p1.equals(p4) ) {										// p1 is not equal to p3
			System.out.println("Test 3 was successful for person!");
		}else {
			System.out.println("Test 3 was not successful for person!");
		}

		if(s1.equals(s2) && s2.equals(s2_2) && s1.equals(s2_2)) {										// p1 is not equal to p3
			System.out.println("Test 3 was successful for student!"+ '\n');
		}else {
			System.out.println("Test 3 was not successful for student!" + '\n');
		}


		// Test 4: consistency
		System.out.println(" Test 4: consistency");
		if(p1.equals(p2) && p1.equals(p2) ) {										// p1 is not equal to p3
			System.out.println("Test 4 was successful for person!");
		}else {
			System.out.println("Test 4 was not successful for person!");
		}

		if(s1.equals(s2) && s1.equals(s2) ) {										// p1 is not equal to p3
			System.out.println("Test 4 was successful for student!");
		}else {
			System.out.println("Test 4 was not successful for student!");
		}
		// Test 4 for negative consistency
		System.out.println(" Test 4: no consistency");
		if(!p1.equals(p5) && !p1.equals(p5) ) {										// p1 is not equal to p3
			System.out.println("Test 4 (negative) was successful for person!");
		}else {
			System.out.println("Test 4 (negative) was not successful for person!");
		}

		if(!s1.equals(s4) && !s1.equals(s4) ) {										// p1 is not equal to p3
			System.out.println("Test 4 (negative) was successful for student!" + '\n');
		}else {
			System.out.println("Test 4 (negative) was not successful for student!" + '\n');
		}


		System.out.println();
		System.out.println(" Part 2: Test hashCode method.");
		System.out.println(" The HashCode method needs to fulfill the attributes consistency and equality;");
		System.out.println(" the hashCode for the same object should stay the same and if 2 objects are ");
		System.out.println(" equal according to equals method, they should have the same HashCode. ");

		// Test 5
		System.out.println("Test 5: equality test of HashCode method: ");
		if(p1.hashCode() == p2.hashCode() && p1.equals(p2)){
			System.out.println("Test 5 was successful for person!");
		}else {
			System.out.println("Test 5 was not successful for person!");
		}
		if(s1.hashCode() == s2.hashCode() && s1.equals(s2)){
			System.out.println("Test 5 was successful for student!" + '\n');
		}else {
			System.out.println("Test 5 was not successful for student!" + '\n');
		}

		// Test 6
		System.out.println("Test 6: consistency test of HashCode method: ");
		if((p1.hashCode() == p1.hashCode())){
			System.out.println("Test 6 was successful for person!");
		}else {
			System.out.println("Test 6 was not successful for person!");
		}
		if((s1.hashCode() == s1.hashCode())){
			System.out.println("Test 6 was successful for student!"+ '\n');
		}else {
			System.out.println("Test 6 was not successful for student!"+ '\n');
		}
		// Solution: delete the equals method of subclass student?
		// then: s1.equals(p1): true
		// && p1.equals(s1): true; which might not be what was desired
		System.out.println("Test 7: Test symmetry of student and person:  ");
		System.out.println("s1.equals(p1): " + s1.equals(p1));
		System.out.println("p1.equals(s1): " + p1.equals(s1));
		if((s1.equals(p1) == p1.equals(s1))){
			System.out.println("Test 7 was successful!"+ '\n');
		}else {
			System.out.println("Test 7 was not successful!"+ '\n');
		}
	}
}
