
/**
 * An Entry holds an generic Object o and a reference next to
 * the next Entry such that a linked List of Entry elements is generated.
 * Implements Cloneable interface (marker Interface)
 * @author Nina Mainusch
 */
public class GenericEntry<E> implements Cloneable {

    public E o;
    public GenericEntry<E> next;

    GenericEntry() {
        this(null, null);
    }

    GenericEntry(E o) {
        this(o, null);
    }

    GenericEntry(E o, GenericEntry<E> e) {
        this.o = o;
        this.next = e;
    }

    /**
     * The clone method calls super.clone() to obtain the cloned object reference
     * the clone() method should perform any required modifications
     * on the object before returning it, in this case it clones the entries of the Generic List
     *
     * @catch CloneNotSupportedException unless the object is an instance of a class that implements the marker interface Cloneable
     * @throw Error if Exception got caught
     * @return the cloned entry
     */

    @Override
    public GenericEntry<E> clone() {
        try {

            // Every class that implements clone() should call
            // super.clone() to obtain the cloned object reference
            GenericEntry<E> clone = (GenericEntry<E>) super.clone();
            // Clone also the next entry
            if (next != null) {
                clone.next = next.clone();
            }
            return clone;
        } catch(CloneNotSupportedException e) { // Checked Exception
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
        if(o.getClass() == object.getClass()){
            return true;
        } else {
            return false;
        }
    }

}
