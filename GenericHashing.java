
import java.util.HashSet;

/**
 * Implementieren Sie eine Klasse in der Objekte typsicher nach dem Prinzip des
 offenen Hashings ab- gelegt werden können. Die Klasse soll das gegebene Interface
 HashSet implementieren und alle vorgegeben Methoden vollständig umsetzen.
 Der Hash-Wert und die Gleichheit von Objekten soll
 entweder über die Methode equals(Object) und hashCode() aus der Klasse Object
 oder über die Methoden equals(Object,Object) und
 hashCode(Object) einer bei der Instanziierung des HashSet
 gegebenen Instanz vom Typ HashFunction erfolgen.
 */

public class GenericHashing<T> implements util.HashSet<T> {

    private GenericList<T>[] array;
    private T value;


    public GenericHashing() {
        this(10);
    }

    public GenericHashing(int arraylength) {
        this.array = new GenericList[arraylength];
        for (int i = 0; i < arraylength; i++) {
            this.array[i] = new GenericList<T>();
            
        }
    }
    /**
     * @param o the object that may be contained in this <code>HashSet</code>.
     * @return returns <code>true</code> if the given object is contained in this
     * <code>HashSet</code>, <code>false</code> otherwise
     */
    public boolean contains(T o){
        if(o == null) {
            throw new NullPointerException();
        }
        int code = hashCode(o);
        GenericList list = array[code];
        while(!list.endpos()) {
            if (list.elem().equals(o)) {
                return true;
            }
            list.advance();
        }
        list.reset();
        return false;
    }

    /**
     * @param o inserts the given object into this <code>HashSet</code> if it is
     *          not already contained
     * @return returns <code>true</code> if the object has been inserted and <code>false</code>
     * if it already is contained
     */
    public boolean insert(T o) {
        if(o == null) {
            throw new NullPointerException();
        }
        if(contains(o)) {
            return false;
        }
        int code = hashCode((T) o);
        GenericList list = array[code];
        list.add((T) o);
        list.reset();
        return true;

    }

    /**
     * @param o deletes the given object from this <code>HashSet</code> if it is contained
     * @return returns <code>true</code> if the object has been deleted and <code>false</code>
     * if the object has not be contained
     */
    public boolean delete(T o) {
        if(!contains(o)) {
            return false;
        }
        int code = hashCode(o);
        GenericList list = array[code];
        while(!list.endpos()) {
            if (list.elem().equals(o)) {
                list.delete();
                list.reset();
                return true;
            }
            list.advance();
        }
        list.reset();
        //return false;
    }

    /**
     * Defines the equality of two objects as defined by {@link Object#equals(Object)}
     * but in relation to the {@link HashFunction#hashCode(Object)} method in this
     * <code>HashFunction</code>.
     */
    public boolean equals(T o1, T o2) {
      // TODO how to implement this? Even necessary? OR at the right place here?
    }

    /**
     * Defines the hash code of an object as defined by {@link Object#hashCode()}
     * but in relation to the {@link HashFunction#equals(Object, Object)} method in
     * this <code>HashFunctions</code>.
     */
    public int hashCode(T o) {
    
      // TODO how to implement this? Even necessary? OR at the right place here?

    }

}
