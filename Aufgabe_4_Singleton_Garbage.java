public class Ticker {
  // The singleton of a ticker
  private static Ticker ticker;

  // The default constructor
  private Ticker() { }

  public static Ticker getInstance() {
    if(ticker == null) {
      ticker = new Ticker();
    }
      return ticker;
  }

  public void print(String text) {
    text = text.replaceAll("\n", " ");
    System.out.print("+++" + text);
  }
}


//*********************************************************************************************

public class Company {

  private String name;

  public Company(String name) {
    this.name = name;
  }
  public String getName() {
    return this.name;
  }

  public void changeStockPrice(double d) {
    Ticker.getInstance().print(name + " " + d);
  }
  protected void finalize() {
    Ticker.getInstance().print(name + " is insolvent");
  }
}

//*********************************************************************************************

public class CompanyTest {

  public static void main(String[] args) {

    Company facebook = new Company("Facebook");
    facebook.changeStockPrice(2000);
    Company amazon = new Company("Amazon");
    amazon.changeStockPrice(2300);

    //facebook.finalize();

    amazon = null;
    facebook = null;
    // Thread.sleep(10);
    System.gc();

    System.out.println();

  }
}

