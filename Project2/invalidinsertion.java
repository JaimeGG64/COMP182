/*	invalidinsertion.java	*/
public class invalidinsertion extends RuntimeException {  
  public invalidinsertion(int p) {
    System.out.print("\n" + p + " is invalid Positions for insertion.\n");
  }
}// end class invalidinsertion