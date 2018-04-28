/**
 * Test-class for task 3.1 to test class Person and class Student
 * 
 * @author Louis Loock
 * 
 * Optimization in Student and Person:
 * - Equals could work with the hash values
 * - Or: in method hashCode() we also use equals() and in method equals() we also use hashCode()
 *
 */
public class TestPerson {

	public static void main(String[] args) {
		
		// Initializing some instances and values
		Person p1 = new Person("Peter");
		Person p2 = new Person("Peter");
		Person p3 = new Person("Andrew");
		
		String peter = "peter";
		String nina = "nina";
		
		Student s1 = new Student("Nina", 001);
		Student s2 = new Student("Nina", 001);
		Student s3 = new Student("Alfonso", 003);

		// Test 1: equals of Persons: should yield true
		if(p1.equals(p2) && !(p1.equals(peter))){ 					// p1 is equal to p2 && p1 is not equal to the string peter
			System.out.println("Test 1 was successful!");	
		}else {
			System.out.println("Test 1 was not successful!");
		}
		
		// Test 2: equals of Person: should yield false
		if(!(p1.equals(p3))) {										// p1 is not equal to p3
			System.out.println("Test 2 was successful!");
		}else {
			System.out.println("Test 2 was not successful!");
		}
		
		// Test 3: equals of Student: should yield true
		if(s1.equals(s2) && !(s1.equals(nina))){					// s1 is equal to s2 && s1 is not equal to the string nina
			System.out.println("Test 3 was successful!");
		}else {
			System.out.println("Test 3 was not successful!");
		}
		
		// Test 4: equals of Student: should yield false
		if(!(s1.equals(s3))){										// s3 is not equal to s3
			System.out.println("Test 4 was successful!");
		}else {
			System.out.println("Test 4 was not successful!");
		}
		
		// Test 5: Comparing HashCodes of Person
		if(p1.hashCode() == p2.hashCode()){							// p1 and p2 have the same HashCode
			System.out.println("Test 5 was successful!");
		}else {
			System.out.println("Test 5 was not successful!");
		}
		
		// Test 6: Comparing HashCodes of Person
		if(!(p1.hashCode() == p3.hashCode())){						// p1 and p3 have different HashCodes
			System.out.println("Test 6 was successful!");
		}else {
			System.out.println("Test 6 was not successful!");
		}	
			
		// Test 7: Comparing HashCodes of Student
		if(s1.hashCode() == s2.hashCode()){							// p1 and p2 have the same HashCode
			System.out.println("Test 7 was successful!");
		}else {
			System.out.println("Test 7 was not successful!");
		}
		
		// Test 8: Comparing HashCodes of Student
		if(!(s1.hashCode() == s3.hashCode())){						// p1 and p3 have different HashCodes
			System.out.println("Test 8 was successful!");
		}else {
			System.out.println("Test 8 was not successful!");
		}	
			
	}

}
