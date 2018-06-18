import java.io.*;

class TestOHSSerialization {

	public static void main(String[] args) {
		/* Initialization */
		OpenHashSet<String> set = new OpenHashSet<>();
		set.insert("Babbage");
		set.insert("Lovelace"); 
		set.insert("Neumann"); 
		set.insert("Zuse"); 
		set.insert("Turing"); 
		set.insert("Gates");
		set.insert("Jobs"); 

		/* Content check of original set */
		System.out.println("-- The following Strings have been inserted in the set: ");
		for(int i = 0; i < 10; i++){
			MyList<String> bucket = (MyList<String>) set.getBucket(i);
			bucket.reset();
			while (!bucket.endpos()) {									
		       System.out.println((String) bucket.elem()); 
				bucket.advance();
		      }
		}
		
		/* Serialization */
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("set.ser"))) {
	         out.writeObject(set);
	         System.out.println("-- The set has been serialized to the file 'set.ser'!");
	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
		
		
		/* Deserialization */
		 OpenHashSet<String> newSet = new OpenHashSet<>();
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("set.ser"))) {
		         newSet = (OpenHashSet<String>) in.readObject(); // there is only one object (OpenHashSet) in this file
		         System.out.println("-- The file 'set.ser' has been deserilaized to the variable 'newSet'!");
		      } catch (FileNotFoundException e) {
		         e.printStackTrace();
		      } catch (IOException e) {
		         e.printStackTrace();
		      } catch (ClassNotFoundException e) {
		         e.printStackTrace();
		      }
	
		/* Comparison*/
		System.out.println("-- Comparison of the two sets: ");
		for(int i = 0; i < 10; i++){
			MyList<String> bucketold = (MyList<String>) set.getBucket(i);
			MyList<String> bucketnew = (MyList<String>) newSet.getBucket(i);
			System.out.println(i + ". buckets are equal: " + bucketold.equals(bucketnew));
		}
		
		/* Content check */
		System.out.println("-- The following Strings are in the new set: ");
		for(int i = 0; i < 10; i++){
			MyList<String> bucket = (MyList<String>) newSet.getBucket(i);
			bucket.reset();
			while (!bucket.endpos()) {									
		       System.out.println((String) bucket.elem()); 
				bucket.advance();
		      }
		}
		
	}

}
