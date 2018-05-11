package library;

public abstract class LibraryItem {

	/**
	 * Attribute of Library is the status weather it is borrowed or not
	 * @param isBorrowed informs weather the item is borrowed or not
	 */
	private boolean isBorrowed;
	
	/**
	 * Constructor of a LibraryItem
	 * The default-value of 'is borrowed' is false (not borrowed)
	 */
	public LibraryItem() {
		this.isBorrowed = false; // default-value: Item is not borrowed
	}
	
	/**
	 * The method isBorrowed() returns the status weather the item is borrowed or not
	 * @return isBorrowed as a boolean (true = is borrowed; false = is not borrowed)
	 */
	public boolean isBorrowed(){
		return this.isBorrowed;
	}
	
	/**
	 * Method setBorrowed gets a boolean as the new status for 'isBorrowed'
	 * @param isBorrowed
	 */
	public void setBorrowed(boolean isBorrowed){
		this.isBorrowed = isBorrowed;
	}
	
	/**
	 * Abstract method for inherited class of LibraryItem
	 * They have to implement this method which returns the full description of the item
	 * @return description of the item
	 */
	public abstract String getDescription();

}
