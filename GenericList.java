
/**
 * This class
 * A simple linked list. One may go through this list by {@link #advance()} until
 * the last position ({@link #endpos()}) is reached. One also may
 * {@link #delete()} and {@link #add(Object)} elements. After advancing it is
 * possible to go back to the beginning by {@link #reset()}.
 *
 * @author Nina Mainusch
 */
public class GenericList<E> implements Cloneable {

    /**
     * Reference on the first Entry of this List
     */
    private GenericEntry<E> begin;

    /**
     * References before the actual Entry of this List
     */
    private GenericEntry<E> pos;

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
            throw new RuntimeException(" You're already at the end of this List");
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
    }


    /**
     * The clone() method creates a deep copy of the list
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
        }
        catch(CloneNotSupportedException e) {
            throw new Error();
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
        if(this == null) {
            return false;
        }
        if(this.getClass() == object.getClass()) {
            return true;
        } else {
            return false;

        }
    }
}



