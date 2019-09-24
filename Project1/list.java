// list.java  CSUN Fall 19  COMP182-2
/**
 * A List is a mutable list ADT. No implementation is provided. DO NOT CHANGE
 * THIS FILE.
 **/
public interface list<T> {
  /**
   * isEmpty() returns true if this List is empty, false otherwise.
   **/
  public boolean isEmpty();

  /**
   * length() returns the length of this List.
   * 
   * @return the length of this List.
   **/
  public int length();

  /**
   * insert(x, p) inserts x at position p in the List. if p is invalid throws an
   * exception (p > 0 && p <= length()+1).
   **/
  public void insert(int x, int p) throws invalidinsertion;

  /**
   * delete(p) deletes element at position p(p > 0 && p <= length()) in the List.
   * if p is invalid throws an exception.
   **/
  public void delete(int p) throws invaliddeletion;

  /**
   * toString() returns a String representation of this List.
   * 
   * @return a String representation of this List.
   */
  public String toString();

  public void insertsorted(int x);
  
  public int binsearch(int x);
} // end List