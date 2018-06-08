import java.util.Iterator;
import java.util.Objects;

/**
 * This class
 * A simple linked list. One may go through this list by {@link #advance()} until
 * the last position ({@link #endpos()}) is reached. One also may
 * {@link #delete()} and {@link #add(Object)} elements. After advancing it is
 * possible to go back to the beginning by {@link #reset()}.
 *
 * @author Nina Mainusch
 */
public class GenericList<E> implements Cloneable, Iterable<E>, Visitable<E> {




    /**
     * Reference on the first Entry of this List
     */
    private GenericEntry<E> begin;

    /**
     * References before the actual Entry of this List
     */
    private GenericEntry<E> pos;

    private int modCount = 0;


    /**
     * Create a new empty List.
     */
    public GenericList() {
        pos = begin = new GenericEntry<E>();
    }

    /**
     * Determines if this List is empty or not.
     *
     * @return true, if there are no elements in this List
     */
    public boolean empty() {
        return begin.next == null;
    }

    /**
     * Determines if it is possible to {@link #advance()} in this List. Returns
     * true if the last position of this List has been reached. An
     * {@link #empty()} List will always deliver true
     *
     * @return true if the last Entry in this List already has been reached.
     */
    public boolean endpos() {
        return pos.next == null;
    }

    /**
     * Returns to the beginning of this List.
     */
    public void reset() {
        pos = begin;
    }

    /**
     * Advances one step in this List.
     *
     * @throws RuntimeException if the last Entry of this List already has been reached.
     */
    public void advance() {
        if(endpos()) {
            throw new RuntimeException(" You cannot advance further since you're already at the end of this List");
        }
        pos = pos.next;
    }

    /**
     * Returns the actual element of this List.
     *
     * @return the actual element
     *
     * @throws RuntimeException if the last Entry of this List already has been reached.
     */
    public E elem() {
        if(endpos()) {
            throw new RuntimeException("You are already at the end of this List");
        }
        return pos.next.o;
    }

    /**
     * Inserts o in this List. It will be placed before the actual
     * element. After insertion the inserted element will become the actual
     * element.
     *
     * @param x the element to be inserted
     */
    public void add(E x) {
        GenericEntry<E> newone = new GenericEntry<E>(x, pos.next);

        pos.next = newone;
        modCount++;
    }

    /**
     * Deletes the actual element of this List. The element after the actual
     * element will become the new actual element.
     *
     * @throws RuntimeException if the last Entry of this List already has been reached.
     */
    public void delete() {
        if(endpos()) {
            throw new RuntimeException(" You cannot delete an element since you're already at the end of this List");
        }

        pos.next = pos.next.next;
        modCount++;
    }


    /**
     * The clone() method creates a shallow copy of the list with the behaviour of a deep copy since we also copy the entries
     * class Object's clone() method creates and returns a copy of the object, with the same class and
     * with all the fields having the same values.
     *
     * @catch CloneNotSupportedException unless the object is an instance of a class that implements the marker interface Cloneable
     * @throw Error if Exception got caught
     * @return the cloned list
     */
    @Override
    public GenericList<E> clone() {
        try {
            // super.clone() goes up to Object.clone() and creates and returns a copy of the object
            GenericList<E> clone = (GenericList<E>) super.clone();

            // clone the beginning and the actual position to get a deep copy
            clone.begin = begin.clone();
            clone.pos = pos.clone();

            return clone;
        } catch(CloneNotSupportedException e) { // Checked exception
            throw new InternalError(e);
        }
    }

    @Override
    public boolean equals(Object object) {

        if(this == object) {
            return true;
        }
        if(object == null) {
            return false;
        }
        return this.getClass() == object.getClass();
    }

    @Override
    public int hashCode() {

        return Objects.hash(begin, pos, modCount);
    }

    public int modCount(){
        return modCount;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator<E>(this, begin);
    }
    /**
     * Implementieren Sie das Interface Visitable in der Liste aus der Lösung des letzten Aufgabenblattes,
     * so dass mit einem Aufruf von accept die Liste einmal vollständig durchlaufen wird, wenn der
     * Visitor dies mit seiner Rückgabe zulässt
     */

    @Override
    public void accept(Visitor<E> v) {
        GenericEntry<E> current = this.begin;
        while(current != null && v.visit(current.o)) {
            current = current.next;
        }
    }


}



