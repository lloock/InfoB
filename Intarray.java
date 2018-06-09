import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Class Intarray is constituted by a name, a RandomAccessFile and an array which is saved in the file
 * @author Louis Loock
 *
 * Problems:
 * - Certain characters are not allowed to be used for a file name
 * - Programm runs into trouble if the main does not close the Intarray Object
 * - How do I print an error (red code) instead of using System.out.println()
 * - In method fileToArray(): cannot use readInt(), instead i have to use read() (only ints from 0 to 255)
 *
 */
public class Intarray {

	/**
	 * An Intarray has the following three parameters
	 * @param name is file name
	 * @param file is the reference to the RandomAccessFile
	 * @param array is where the ints are temporarily saved in
	 */
	private String name;
	private RandomAccessFile file;
	private int[] array;
	
	/**
	 * Constructor for an Intarray with no data but a name.
	 * An already saved file will not be overwritten.
	 * @param name is the name of the file
	 */
	public Intarray(String name){
		setName(name);
		// trying to initialize the RandomAccessFile
		try{
			this.file = new RandomAccessFile(name, "rw");
		}catch(IOException e){
			System.out.println("A problem occured while the program initialized the file!");
			e.printStackTrace();
		}finally{
			fileToArray();
		}
	}
	
	/**
	 * Spezial constructor for an Intarray which gets the name of the file and some integers as an array.
	 * This method will overwrite an already existing file
	 * @param name is the name of the file
	 * @param array represents the ints which should be saved in the new file
	 * @throw IllegalArgumentException whenever the given array cannot be inserted
	 */
	public Intarray(String name,int[] array){
		this(name);
		if(!insert(array)){
			throw new IllegalArgumentException("The given array cannot be inserted!");
		}
	}
	
	/**
	 * Method insert() gets an array of ints which should be inserted in the file.
	 * Method overwrites all the integers in the already existing file
	 * @param insertion is the array with the integers which should be inserted
	 * @return false if insertion is empty and true if insertion was successful
	 */
	private boolean insert(int[] insertion){
		if(insertion == null){ // a null array cannot be inserted
			return false;
		}
		clearFile(); 								// we clear the file before we insert a new dataset	
		
		this.array = insertion; 					// array will be substituted by the given insertion array
		
		for(int i = 0; i < insertion.length; i++){ 	// iterating throught the array which should be inserted
			try {
				this.file.write(insertion[i]);
			} catch (IOException e) {
				System.out.println("A problem occured while we inserted the array into the file!");
				e.printStackTrace();
			}
		}
		return true;
	}
	
	/**
	 * Method inserAt inserts a single integer at a specific point of the array 
	 * @param pos represents the position in the array where the numbers should be inserted
	 * @param number represents the number which should be inserted
	 * @return true if insertion was successful
	 */
	public boolean insertAt(int pos, int number){
		if(pos < 0 || pos >= array.length){
			throw new IndexOutOfBoundsException("The given position is not valid!");
		}
		fileToArray();			// update the current array (there might were some changes)
		array[pos] = number; 	// change the array at the right position
		insert(this.array); 	// change the file through overwriting it with the new array
		return true;			// if this point is reached, everything worked out fine
	}
	
	/**
	 * Method getArray returns the array which is saved in the file
	 * @return array of the object Intarray
	 */
	public int[] getArray(){
		fileToArray(); // we read out the file and save in the class variable 'array' (all in the method)
		return this.array;
	}
	
	/**
	 * Method getAt() returns the number at the given position
	 * @param pos represents the position from which the client wants the integer
	 * @throw IndexOutOfBoundsException if the pos variable has an invalid position of the array
	 * @return the integer at the asked position
	 */
	public int getAt(int pos){
		if(pos < 0 || pos >= array.length){
			throw new IndexOutOfBoundsException("There is no such position at this array!");
		}
		fileToArray(); 		// we update the array, because something form the file might have changed
		return array[pos]; 	// return the value an the given position
	}
	
	/**
	 * Method clearFile() deletes all integers in the file
	 * @return true if clear process was successful
	 */
	public boolean clearFile(){
		try {
			file.setLength(0); // clear = set the length of the file to 0
		} catch (IOException e) {
			System.out.println("A problem occured while the program cleared the file!");
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * Method size() measures the size of the array
	 * @return size of the array as an integer
	 */
	public int size(){
		fileToArray(); 	// before we measure the length, we have to actualize the array
						// (maybe something changed from outside the program)
		return this.array.length;
	}
	
	/**
	 * Method fileToArray() reads out the file and saves the integers in the array of the object
	 */
	private void fileToArray(){
		try {
			this.file.seek(0); 								// start from position 0
			this.array = new int[(int)this.file.length()]; 	// file-length = array-length
			for(int i = 0; i < this.array.length; i++){ 	// iterating through the new array
				array[i] = this.file.read();				// method read() reads the ints and advances automtically
			}
		} catch (IOException e) {
			System.out.println("A problem occured while the program converted to file into an int array!");
			e.printStackTrace();
		}
	}
	
	/**
	 * Method setName gets a new name for the file
	 * But it does not instantiate a new file (this is done by the constructor)
	 * It also checks weather the name is valid
	 * @param name is the new name of the file
	 * @return true if process was successful
	 */
	private boolean setName(String name){
		if(!name.endsWith(".txt")){ // the name of the file has to end with ".txt"
			throw new IllegalArgumentException("Name of the file must end with: \".txt\"!");
		}
		this.name = name;
		return true;
	}
	
	/**
	 * Method getName() returns the name of the file
	 * @return name of the file
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Method closeFIle() closes the file so that no further access is possible
	 */
	public void closeFile(){
		try {
			this.file.close();
		} catch (IOException e) {
			System.out.println("During the closing of the IntArray something went wrong!");
			e.printStackTrace();
		}
	}
	
}
