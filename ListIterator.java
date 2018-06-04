import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator<E> implements Iterator<E> {

	private GenericEntry<E> current;
	private GenericList<E> list;
	private int currentModCount;
	
	public ListIterator (GenericList<E> list, GenericEntry<E> begin){
		this.list = list;
		this.current = begin;
		currentModCount = list.modCount();
	}
	
	@Override
	public boolean hasNext() {
		return this.current != null; // if current is null, then false (no furhter elements)
	}

	@Override
	public E next() {
		if(currentModCount != list.modCount()){ // fail-fast iterator: only returns the next element, if the list did not changed
			throw new RuntimeException("ModCount of the Iterator is not equal to the modCount of the List!");
		}
		
		if(hasNext()){				// if there is a next element
			E o = current.o;		// save current object of type E
			current = current.next; // go one element further
			return o;				// return current object
		}else{
			throw new NoSuchElementException(); // there is no next element
		}
	}
	
	@Override
	public void remove(){
		if(hasNext()){
			current.next = current.next.next; // the current pointer to the next element skips the next element
			// this does not delete anything of the original list
		}else{
			throw new NoSuchElementException("Cannot delete the next element, because there is none!");
		}
	}

}
