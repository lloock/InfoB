package library;

import java.util.List;

public class TestLibrary {

	public static void main(String[] args) {
		// Instanziating a new library
		Library library = new Library();
		
		// Creating some books (all the same author)
		Book andorra = new Book("Andorra", "Max Frisch");
		Book biedermann = new Book("Biedermann und die Brandstifter", "Max Frisch");
		Book homofaber = new Book("Homo faber", "Max Frisch");
		Book montauk = new Book("Montauk", "Max Frisch");
		
		// Creating some BluRays (different title and author)
		BluRay lotr = new BluRay("The Lord of the Rings","Peter Jackson");
		BluRay starwars = new BluRay("Star Wars","George Lucas");
		BluRay indiana = new BluRay("Indiana Jones","Steven Spielberg");
		BluRay interstellar = new BluRay("Interstellar","Christopher Nolan");
		
		// Adding the created items to the library
		System.out.println("-- Adding eight new entries to the library:");
		library.addItem(andorra);
		library.addItem(biedermann);
		library.addItem(homofaber);
		library.addItem(montauk);
		library.addItem(lotr);
		library.addItem(starwars);
		library.addItem(indiana);
		library.addItem(interstellar);
		
		// Deleting one item of the library
		System.out.println("\n-- Deleting one entry from the library: ");
		library.deleteItem(montauk);
		
		// Searching for some items
		System.out.println("\n-- We are looking for entries which contain the String: 'Max Frisch'");
		List<LibraryItem> searchResults = library.search("Max Frisch");
		for(int i = 0; i < searchResults.size(); i++){  								// iterating through the searchResults
			System.out.println((i+1) + ". result: " + ((LibraryItem)searchResults.get(i)).getDescription());
		}
		
		System.out.println("\n-- We are looking for entries which contain the String: 'l'");
		searchResults = library.search("l");
		for(int i = 0; i < searchResults.size(); i++){  								// iterating through the searchResults
			System.out.println((i+1) + ". result: " + ((LibraryItem)searchResults.get(i)).getDescription());
		}

	}

}
