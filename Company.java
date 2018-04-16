public class Company {

  private String name;

  public Company(String name) {
    this.name = name;
  }
  public String getName() {
    return this.name;
  }

  public void changeStockPrice(double d) {
	 // to change the stock price, we simply print it
	 // therefore we need a ticker (so its instance) and then use the method print
    Ticker.getInstance().print(this.name + " " + d);	
  }
  
  protected void finalize() {
	  // we have to print that the company is insolvent
    Ticker.getInstance().print(this.name + " is insolvent");
  }
}