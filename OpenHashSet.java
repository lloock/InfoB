import java.io.*;
/**
 * Implementation of an open hash set: one bucket holds all entries with the
 * same {@link Object#hashCode()}.
 * 
 * Problem:
 *  - Some inserted String lead to an ArrayIndexOutOfBoundsException, because the following formula lead to an negative int:
 *  	hashCode(o) % buckets.length
 *  
 *  Changes:
 *  - added serialVersionUID
 *  - added Method: getBucket(int i)
 *  - added Method: readObject(ObjectInputStream oin) (Deseriliaztion)
 *  - added Method: writeObject(ObjectOutputStream oout) (Serialization)
 */
public class OpenHashSet<T> implements HashSet<T>, Serializable {

   private MyList<T>[] buckets; // an array of list (each bucket is a list)
   private HashFunction<? super T> hashFunction;
   private static final long serialVersionUID = 56779563587947996L;
   
   /**
    * An <code>OpenHashSet</code> with a hash table of length 10.
    */
   public OpenHashSet() {
      this(10);
   }

   /**
    * An <code>OpenHashSet</code> with a hash table of length <code>size</code>
    *
    * @param size length of the hash table
    */
   public OpenHashSet(int size) {
      this(size, null);
   }

   /**
    * An <code>OpenHashSet</code> with a hash table of length <code>size</code>
    * which uses <code>hashFunction</code> to define the equality of two objects.
    *
    * @param size         length of the hash table
    * @param hashFunction representation of the used hash function
    */
   public OpenHashSet(int size, HashFunction<? super T> hashFunction) {
	  this.buckets = new MyList[size];
      for (int i = 0; i < buckets.length; i++) {
         buckets[i] = new MyList<T>(); // initializing the the buckets with a list
      }
      this.hashFunction = hashFunction;
   }


   @Override
   public boolean contains(T o) {
	  int position = hashCode(o) % buckets.length;
	  if(position < 0) position *= -1;
	  MyList<T> bucket = buckets[position];									// indentifying the correct bucket
      bucket.reset(); 														// bucket is a list
      while (!bucket.endpos()) {											// going through the bucket
         if (equals(o, bucket.elem())) {
            return true;
         }
         bucket.advance();													// next element in the bucket
      }
      return false;															// no element found											
   }

   @Override
   public boolean insert(T o) {	
      if (contains(o)) {													// if the element is already in the bucket
         return false;
      } else {
    	  int position = hashCode(o) % buckets.length;
    	  if(position < 0) position *= -1;
    	 buckets[position].add(o);											// at correct position: add
         return true;
      }
   }

   @Override
   public boolean delete(T o) {
	  int position = hashCode(o) % buckets.length;
	  if(position < 0) position *= -1;
	  MyList<T> bucket = buckets[position]; 			// bucket list at the correct position in the array
      bucket.reset();
      while (!bucket.endpos()) {											// going through the bucket list
         if (equals(o, bucket.elem())) {									// if the found element equals the searched element
            bucket.delete();												
            return true;
         }
         bucket.advance();
      }
      return false;															// no element found
   }
   
   /**
    * Method getBucket(int i) gets an int and returns the bucket list at the corresponding position
    * @param i is the variable for the array buckets
    * @return the list at the correct position in the array buckets
    */
   public MyList<T> getBucket(int i){
	   if(i < 0 || i >= buckets.length){
		   throw new ArrayIndexOutOfBoundsException("There is no bucket at the position: " + i);
	   }
	   return buckets[i];
   }

   private int hashCode(T o) {
      return hashFunction == null ? o.hashCode() : hashFunction.hashCode(o);
   }

   private boolean equals(T o1, T o2) {
      if (hashFunction == null) {
         return o1.equals(o2);
      } else {
         return hashFunction.equals(o1, o2);
      }
   }
   
   /* Methoden der Aufgabe  */
   
   private void writeObject(ObjectOutputStream oout) throws IOException {
	   int numberOfElements = 0;
	   for(int i = 0; i < buckets.length; i++){				// iterating through the buckets
		   	MyList<T> bucketList = buckets[i]; 				// get each list of the buckets
		   	bucketList.reset();
		   	while(!bucketList.endpos()){					// going through the bucketList
		   		numberOfElements++;
		   		bucketList.advance();
		   	}
	   }
	   oout.writeInt(numberOfElements);
	   oout.writeInt(buckets.length);
	   oout.writeObject(this.hashFunction);
	   
	   for(int i = 0; i < buckets.length; i++){				// iterating through the buckets
		   	MyList<T> bucketList = buckets[i]; 				// get each list of the buckets
		   	bucketList.reset();
		   	while(!bucketList.endpos()){					// going through the bucketList
		   		oout.writeObject(bucketList.elem());		// each element gets into the ObjectOutputStream
		   		bucketList.advance();
		   	}
	   }
	   
   }
   
   private void readObject(ObjectInputStream oin) throws IOException, ClassNotFoundException {
	 int numberOfElements = oin.readInt();
	 this.buckets = new MyList[oin.readInt()];
	 this.hashFunction = (HashFunction<? super T>) oin.readObject();
	 for (int i = 0; i < buckets.length; i++) {
         this.buckets[i] = new MyList<T>(); // initializing the the buckets with a list
      }
	 for(int i = 1; i <= numberOfElements; i++){
		 insert((T) oin.readObject());
	 }
	   
   }
   
   
}
