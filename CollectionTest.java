import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * This main methods tests and compares the three Collections: LinkedList, ArrayList and HashSet
 * It compares the processing time for multiple adds, removes and contains.
 * 
 * @author Louis Loock
 * 
 * Problems and Ideas:
 * - Can there be string variable saying which type the test is using 
 *   (insteand of all occurences of 'Number' we type in this variable?!)
 * - The processing time for add is way too long
 * - The processing time for remove is way too short
 * 
 * 
 * What to do if we want to work with different objects in the test phase?
 * 1. Change the generic type of the Collection Objects (ll, al, hs).
 * 2. Change the array where all the objects which will be added are in.
 * 3. In each for-each-loop: change the type of the iteration variable
 *
 */
public class CollectionTest {

	public static void main(String[] args) {
	/* Initialization Phase  */
		// Initializing the collections
		LinkedList<Number> ll = new LinkedList<>();
		ArrayList<Number> al = new ArrayList<>();
		HashSet<Number> hs = new HashSet<>();
		
		
		// Initializing an array for the items which will be inserted in the test phase
		final int ITERATIONS = 10000;
		Number[] items = new Number[ITERATIONS];
		for(int i = 0; i < ITERATIONS; i++){				// adding 10,000 items to 'items'
			items[i] = i;
		}
		
		// Time variables
		long ll_add = 0, ll_contains = 0, ll_remove = 0;
		long al_add = 0, al_contains = 0, al_remove = 0;
		long hs_add = 0, hs_contains = 0, hs_remove = 0;
		
		
	/* LinkedList */
		// Testing add for LinkedList	
		for(Number i: items){						// we add 10,000 items
			long start = System.nanoTime();			// measuring the start time
			ll.add(i);								// execution
			long time = System.nanoTime() - start;	// measuring the difference in time
			ll_add += time;							// adding to the total time 
		}
		ll_add /= ITERATIONS;						// forming the mean over 10,000 iterations
		
		// Testing contains for LinkedList
		for(Number i: items){  						// we check 10,000 items weather they are contained
			long start = System.nanoTime();			// measuring the start time
			ll.contains(i);							// execution
			long time = System.nanoTime() - start;	// measuring the difference in time
			ll_contains += time;					// adding to the total time
		}
		ll_contains /= ITERATIONS;					// forming the mean over 10,000 iterations
		
		// Testing remove for LinkedList
		for(Number i: items){						// we remove 10,000 items
			long start = System.nanoTime();			// measuring the start time
			ll.remove(i);							// execution
			long time = System.nanoTime() - start;	// measuring the difference in time
			ll_remove += time;						// adding to the total time
		}
		ll_remove /= ITERATIONS;					// forming the mean over 10,000 iterations
		
		
	/* ArrayList*/
		// Testing add for ArrayList	
		for(Number i: items){						// we add 10,000 items
			long start = System.nanoTime();			// measuring the start time
			al.add(i);								// execution
			long time = System.nanoTime() - start;	// measuring the difference in time
			al_add += time;							// adding to the total time 
		}
		al_add /= ITERATIONS;						// forming the mean over 10,000 iterations
		
		// Testing contains for ArrayList
		for(Number i: items){  						// we check 10,000 items weather they are contained
			long start = System.nanoTime();			// measuring the start time
			al.contains(i);							// execution
			long time = System.nanoTime() - start;	// measuring the difference in time
			al_contains += time;					// adding to the total time
		}
		al_contains /= ITERATIONS;					// forming the mean over 10,000 iterations
		
		// Testing remove for ArrayLIst
		for(Number i: items){						// we remove 10,000 items
			long start = System.nanoTime();			// measuring the start time
			al.remove(i);							// execution
			long time = System.nanoTime() - start;	// measuring the difference in time
			al_remove += time;						// adding to the total time
		}
		al_remove /= ITERATIONS;					// forming the mean over 10,000 iterations
		
		
	/* HashSet*/
		// Testing add for HashSet	
		for(Number i: items){						// we add 10,000 items
			long start = System.nanoTime();			// measuring the start time
			hs.add(i);								// execution
			long time = System.nanoTime() - start;	// measuring the difference in time
			hs_add += time;							// adding to the total time 
		}
		hs_add /= ITERATIONS;						// forming the mean over 10,000 iterations
		
		// Testing contains for HashSet
		for(Number i: items){  						// we check 10,000 items weather they are contained
			long start = System.nanoTime();			// measuring the start time
			hs.contains(i);							// execution
			long time = System.nanoTime() - start;	// measuring the difference in time
			hs_contains += time;					// adding to the total time
		}
		hs_contains /= ITERATIONS;					// forming the mean over 10,000 iterations
		
		// Testing remove for HashSet
		for(Number i: items){						// we remove 10,000 items
			long start = System.nanoTime();			// measuring the start time
			hs.remove(i);							// execution
			long time = System.nanoTime() - start;	// measuring the difference in time
			hs_remove += time;						// adding to the total time
		}
		hs_remove /= ITERATIONS;					// forming the mean over 10,000 iterations
		
		
	/* Printing Results */
		System.out.println("            |     mean_add    mean_remove    mean_contains");
		System.out.println("------------+---------------------------------------------");
		System.out.print("LinkedList  |");
		System.out.printf("%13d  %13d    %13d\n", ll_add, ll_remove, ll_contains);
		System.out.print("ArrayList   |");
		System.out.printf("%13d  %13d    %13d\n", al_add, al_remove, al_contains);
		System.out.print("HashSet     |");
		System.out.printf("%13d  %13d    %13d\n", hs_add, hs_remove, hs_contains);
		
		
		
		
	}

}
