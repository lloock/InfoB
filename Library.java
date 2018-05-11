package library;

import java.util.ArrayList;
import java.util.List;

public class Library {

	/**
	 * Attribute of a Library is its inventory as a list
	 * @param inventory as a list (represents all items of the library)
	 */
	List<LibraryItem> inventory;
	
	/**
	 * Default constructor for a Library
	 */
	public Library(){
		inventory = new ArrayList<LibraryItem>();
	}

	/**
	 * Method addItem(LibraryItem item) gets a LibraryItem and adds it to the inventory list of the Library
	 * @param item as a LibraryItem
	 */
	public void addItem(LibraryItem item){
		System.out.println("New item: " + item.getDescription());
		inventory.add(item);
	}
	
	/**
	 * Method deleteItem(LibraryItem item) deletes the given LibraryItem from the inventory list 
	 * @param item which should be deleted
	 */
	public void deleteItem(LibraryItem item){
		System.out.println("Delete item: " + item.getDescription());
		inventory.remove(item);
	}
	
	/**
	 * Method search(String text) goes through the entire inventory and returns all matching results (to the text given) as a list
	 * @param text which is searched for in the descriptions of the item in the inventory of the Library
	 * @return result is a list of search results
	 */
	public List<LibraryItem> search(String text){
		List<LibraryItem> result = new ArrayList<LibraryItem>();
		for(int i = 0; i < inventory.size(); i++){  								// iterating through the inventory of this library
			String compare = ((LibraryItem)inventory.get(i)).getDescription();		// the description of the LibraryItem will be compared
			if(compare.matches(".*" + text + ".*")){								// the compare String must contain the text
				result.add(inventory.get(i));										// if match was successfull: add element of the inventor to the result list
			}
		}
		return result;
	}
	
}
