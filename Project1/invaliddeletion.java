/*	invaliddeletion.java	*/
public class invaliddeletion extends RuntimeException {
  public invaliddeletion(int p) {
    System.out.print("\n" + p + " is ivalid Positions for deletion.\n");
  }
}// end class invaliddeletion