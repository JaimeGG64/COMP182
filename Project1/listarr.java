//	listarr.java	CSUN Fall 19  COMP182-2

//  Array implementation of list in JAVA 
import java.util.*;

//***************  Class Definition *********************************
/**
 * Implementation of the ADT List using a fixed-length array. Exception is
 * thrown: if insert operation is attempted when List is full. if delete
 * operation is attempted when List is empty. if position of insert or delete is
 * out of range.
 */
public class listarr<T> implements list<T> {
	// class Variables
	protected int capacity, last;
	protected T arr[];

	listarr(int n) { // List Constructor
		last = 0;
		capacity = n;
		// Allocate Space
		arr = (T[]) new Object[n + 1];
		prt("List size = " + n + "\n");
	}

	public boolean isEmpty() {
		return (last == 0);
	}

	public int length() {
		return last;
	}

	public boolean isFull() {
		return (last == capacity);
	}

	public static void prt(String s) {
		System.out.print(s);
	}

	// insert x at position p (valid p's 1 <= p <= last+1 && last != capacity)
	public void insert(T x, int p) throws invalidinsertion {
		prt("\nInsert " + x + " at position " + p);
		if (isFull() || p < 1 || p > last + 1)
			throw new invalidinsertion(p);
		// Shift from position p to right
		for (int i = last; i >= p; i--)
			arr[i + 1] = arr[i];
		arr[p] = x;
		last++;
	}

	// delete element at position p (1...last)
	public void delete(int p) throws invaliddeletion {
		prt("\nDelete " + p + "th element, ");
		if (isEmpty() || p < 1 || p > last)
			throw new invaliddeletion(p);
		// Shift from position p + 1 to left
		for (int i = p; i < last; i++)
			arr[i] = arr[i + 1];
		last--;
	}

	public String toString() {
		String s = "[";
		for (int i = 1; i < arr.length; i++){
			if(i == 1){
				s += arr[i];
			}
			else{
				s += ", " + arr[i];
			}
		}
		return s + "]";
	}

	public void insertsorted(T x, int index) {
		arr[index] = x;
	}

	public static void main(String args[]) {
		int j, p, n, x, MaxNum = 5;
		Random rand = new Random();

		n = rand.nextInt(MaxNum) + 1; // generate n randomly

		// Create a List of type Integer of size n
		listarr<Integer> Lint = new listarr<Integer>(n);

		// Generate n element and position randomly and insert in the list
		for (j = 1; j <= n; j++) {
			p = rand.nextInt(n); // generate position
			x = rand.nextInt(MaxNum * 4); // generate element

			try {
				Lint.insert(x, p);
			} catch (Exception e) {
				prt("Exception " + e + "\n");
			}
		}

		prt("\nList: " + Lint.toString() + "\n"); // print list

		// Delete n element from list randomly and print list
		for (j = 1; j <= n; j++) {
			p = rand.nextInt(n); // generate position to delete
			try {
				Lint.delete(p);
				prt("\nList: " + Lint.toString() + "\n");
			} catch (Exception e) {
				prt("Exception " + e + "\n");
			}
		}

		// Create a List of type String
		n = rand.nextInt(MaxNum) + 1; // generate n randomly
		listarr<String> Lstr = new listarr<String>(n);
		try {
			Lstr.insert("Sarah", 1);
			Lstr.insert("Jerry", 1);
			Lstr.insert("Tom", 2);
		} catch (Exception e) {
			prt("Exception " + e + "\n");
		}
		prt("\nList: " + Lstr.toString() + "\n");
	}
}// end class listarr