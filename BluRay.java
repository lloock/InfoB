package library;

public class BluRay extends LibraryItem{

	/**
	 * Attributes of a BluRay
	 * @param title
	 * @param director
	 */
	private String title;
	private String director;
	
	/**
	 * Constructor of a BluRay
	 * @param title
	 * @param director
	 */
	public BluRay(String title, String director) {
		super();
		this.title = title;
		this.director = director;
	}
	
	/**
	 * Method getTitle() returns the title of this BluRay
	 * @return title of this BluRay
	 */
	public String getTitle(){
		return this.title;
	}
	
	/**
	 * Method getDirector() returns the director of this BluRay
	 * @return director of this BluRay
	 */
	public String getDirector(){
		return this.director;
	}
	
	/**
	 * Method getDescription() returns the full description of this BluRay
	 * @return description of this BluRay (with title and director)
	 */
	public String getDescription(){
		return ("Movie(BluRay): " + this.getTitle() + " directed by " + this.getDirector());
	}

}
