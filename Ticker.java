public class Ticker {
  // The singleton of a ticker
  private static Ticker ticker;

  // The default constructor which is private, because there should be only one static ticker
  private Ticker() { }

  public static Ticker getInstance() {
    if(ticker == null) {				// if there there has not been initialized a ticker
      ticker = new Ticker();			// then initialize a ticker
    }
      return ticker;					// returning the reference of the static ticker
  }

  public void print(String text) {		// method to print one string with the ticker
    text = text.replaceAll("\n", " ");	// replacing line breaks with spaces
    System.out.print("+++" + text);
  }
}
