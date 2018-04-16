public class CompanyTest {

  public static void main(String[] args) {

    Company facebook = new Company("Facebook");
    facebook.changeStockPrice(2000);
    Company amazon = new Company("Amazon");
    amazon.changeStockPrice(2300);

    facebook.finalize();

    amazon = null;			// when the gc drops in, this will open up the method finalize of the class company
    
    // Thread.sleep(10);
    System.gc();			// when the program is really over, the method finalize will be used
  }
}