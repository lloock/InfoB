
/**
 * An Entry holds an generic Object o and a reference next to
 * the next Entry such that a linked List of Entry elements is generated.
 *
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

    @Override
    public GenericEntry<E> clone() {
        try {
            GenericEntry<E> clone;

            clone = (GenericEntry<E>) super.clone();

            if (next != null) {
                clone.next = next.clone();
            }
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
        if(o.getClass() == object.getClass()){
            return true;
        } else {
            return false;
        }
    }

}
