import java.util.concurrent.ThreadLocalRandom;
/**
 * Test class for testing the class Intarray and all there functions!
 * @author Louis Loock
 * 
 * Problem: Range of ints which can be inserted: 0 up to 255 (e.g. 256 = 0)
 */
public class TestIntarray {

	public static void main(String[] args) {
		
		/* Regular test phase */
		Intarray ia = new Intarray("test.txt");												// instantiate a new Intarray object
		System.out.println("Name of the file: " + ia.getName());							// Print the name of the file
		
		System.out.println("Print out the current " + ia.size() + " integers the file:");
		for(int i = 0; i < ia.size(); i++){													// go through the entire file
			System.out.println("Position " + i + ": " + ia.getAt(i));						// print out each int in the file
		}
		
		int[] array = new int[5];															// new array of 5 ints which should be inserted
		for(int i = 0; i < 5; i++){															// invent 5 random numbers
			array[i] = ThreadLocalRandom.current().nextInt(0, 255);							// a random int ranges from 0 to 255
		}
		
		ia.clearFile();																		// clearFile befor we insert the new array
		ia = new Intarray("test.txt", array);												// instantiate the same file with a new array
		ia.insertAt(4, 255);																// substitue the last integers with '255'
		
		array = ia.getArray();																// get the array which was just inserted
		System.out.println("Print out the new " + ia.size() + " integers in the file:");
		for(int i = 0; i < array.length; i++){												// iterate through this array
			System.out.println("Position " + i +": " + array[i]);							// print out the new integers in this returned array
		}
		
		/* Testing for exceptions */
		try{
			int[] emptyArray = null;
			ia = new Intarray("test.txt", emptyArray);
		}catch(IllegalArgumentException e){
			System.out.println("We cannot insert an empty array!");
		}
		
		try{
			ia.insertAt(-1, 33);
		}catch(IndexOutOfBoundsException e){
			System.out.println("We cannot insert an int at the position '-1'!");
		}
		
		try{
			ia.getAt(-1);
		}catch(IndexOutOfBoundsException e){
			System.out.println("We cannot get the int from the position '-1'!");
		}
		
		try{
			ia = new Intarray("wrongName");
		}catch(IllegalArgumentException e){
			System.out.println("The name 'wrongName' is invalid for a file!");
		}
		
		System.out.println("We now closed the file!");
		ia.closeFile();

	}

}
