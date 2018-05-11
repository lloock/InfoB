package library;

public class Book extends LibraryItem {

	/**
	 * Attribute of this book
	 * @param title
	 * @param author
	 */
	private String title;
	private String author;
	
	/**
	 * Constructor of a book gets the title and the author
	 * @param title
	 * @param author
	 */
	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}
	
	/**
	 * Method getTitle() returns the title of this book
	 * @return title of this book
	 */
	public String getTitle(){
		return this.title;
	}

	/**
	 * Method getAuthor() returns the author of this book
	 * @return author of this book
	 */
	public String getAuthor(){
		return this.author;
	}
	
	/**
	 * Method getDescription() returns the full description of this book
	 * @return description of the book (with title and author)
	 */
	public String getDescription(){
		return ("Book: " + this.getTitle() + " written by " + this.getAuthor());
	}
}
