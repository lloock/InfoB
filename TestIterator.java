import java.util.NoSuchElementException;

/**
 * Test-class for the fail-fast Iterator for a GenericList
 * 
 * @author Louis1
 *
 */
public class TestIterator {

	public static void main(String[] args) {
		GenericList<Number> list = new GenericList<>(); // implementing a new GenericList based on Numbers
		
		for(int i = 1; i <= 100; i++){ 
			list.add(i); 	// adding all numbers within between 1 to 100 to the GenericList
			list.advance(); // the next add should be after this add
		}
	
		ListIterator<Number> iterator = (ListIterator<Number>) list.iterator(); // initializing an iterator
		
		iterator.remove(); // remove the first element
		
		while(iterator.hasNext()){ // going through the GenericList with the iterator
			System.out.println(iterator.next());
		}
		
		try{
			iterator.next();			// trying to get a next element although there is none
		}catch(NoSuchElementException exc){
			System.out.println("The iterator is at its end and there are no furhter elements!");
		}
		
		
		list.reset();
		System.out.println("Current ModCount of the List: " + list.modCount()); // we added 100 items
		for(int i = 0; i < 10; i++){		// delete 10 times
			list.delete();
		}
		System.out.println("ModCount of the List after deleting 10 items: " + list.modCount());
		
		
		try{
			iterator.next(); // trying to get the next element, which is not possible because the GenericList has been changed
		}catch(RuntimeException exc){
			System.out.println("The List has been changed, therefore the Iterator failed!");
		}
		
		try{
			iterator.remove();
		}catch(NoSuchElementException exc){
			System.out.println("We cannot remove the next element, because there is none!");
		}
	}
}
