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
	protected int arr[];

	listarr(int n) { // List Constructor
		last = 0;
		capacity = n;
		// Allocate Space
		arr = new int[n + 1];
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
	public void insert(int x, int p) throws invalidinsertion {
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
		return s + "]\n";
	}

	public void insertsorted(int x) {
		int i;
		if(last == 0){
			arr[1] = x;
			last++;
			System.out.printf("\nInsert %d in a sorted list\n", x);
			return;
		}
		for(i = last; i >= 1 && arr[i] > x; i--){
			arr[i + 1] =  arr[i];
		}
		arr[i + 1] = x;
		last++;
		System.out.printf("Insert %d in a sorted list\n", x);
	}

	public int binsearch(int x) {
		int mid = 0;
		System.out.printf("binary search for %d in a sorted list\n", x);
		int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
            // Check if x is present at mid 
            if (arr[m] == x) 
                return 1; 
            // If x greater, ignore left half 
            if (arr[m] < x) 
                l = m + 1; 
            // If x is smaller, ignore right half 
            else
                r = m - 1; 
        } 
        // if we reach here, then element was 
        // not present 
        return 0; 
	}
}// end class listarr