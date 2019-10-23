
//  CREATING A SORTED INTEGER LINKED LISTLink
//	CSUN Fall 19  COMP182-2 Project 1 Solution
//  
//  Inserting in a sorted linked list and 
//  Performing a sequential search in a sorted list 
//  To Compile: javac jaigarcia.java
//  To execute at command prompt: 
//           java jaigarcia < any data file name 
// PREPARED BY: G. DASTGHAIBYFARD 10/8/19
import java.util.*;
import java.io.*;

//************  Class Definition *********************************
//Please change class name to tour last name.
public class jaigarcia {
	private class Node {
		int data;
		Node next;

		Node() {
			next = null;
		}// end Node
	}// end class Node
		// head is a pointer to head of the list

	private Node head1, head2, head3;

	// Constructor of linked list
	jaigarcia() {
		head2 = null;
		head1 = null;
		head3 = null;
	} // end constructor

	// ******** Member functions definition ************************
	public static void prt(String s) {
		System.out.print(s);
	}

	public String toString(int i) {
		Node t;
		if (i == 1)
			t = head1;
		else if(i == 3)
			t = head3;
		else
			t = head2;
		String s = "";
		for (Node cur = t; cur != null; cur = cur.next)
			s += ", " + cur.data ;
		return "["+ s.substring(2) + "]\n";
	} // end toString
		// Insert x in a sorted list.

	public void insertsortedlist(int x, int i) {
		Node t;
		if (i == 1){
			t = head1;
		}
		else{
			t = head2;
		}
		Node tmp = new Node();
		tmp.data = x;
		// Special case for head node
		if (t == null || t.data >= tmp.data) {
			tmp.next = t;
			t = tmp;
		} else {
			// locate the node before the point of insertion
			Node cur = t;
			while (cur.next != null && cur.next.data < tmp.data){
				cur = cur.next;
			}
			// end while
			tmp.next = cur.next;
			cur.next = tmp;
		} // end else
		if (i == 1){ // set the heads
			head1 = t;
		}
		else{
			head2 = t;
		}
	} // end insertsortedlist

	public void mergeSort(){
		Node tmp1 = head1;
		Node tmp2 = head2;
		//First Insertion Case
		if(head3 == null){
			if(tmp1.data > tmp2.data){
				head3 = tmp2;
				Node cur = tmp1;
				cur.next = null;
				head3.next = cur;
			}
			else{
				head3 = tmp1;
				Node cur = tmp2;
				cur.next = null;
				head3.next = cur;
			}
		}
	}

	public static void main(String args[]) {
		System.out.print("\n\t\tJaime Garcia Project 2");
		int j, k, n, m, x, cnt;
		try {
			Scanner inf = new Scanner(System.in);
			// Create a Linked List of type Integer
			jaigarcia Lint = new jaigarcia();
			cnt = inf.nextInt();
			System.out.printf("\nCreating %d Sorted Linked Lists.", cnt);

			for (k = 1; k <= cnt; k++) {
				// read No. of data
				n = inf.nextInt();
				// Read input from KB/ File
				for (j = 1; j <= n; j++) {
					// read next input
					x = inf.nextInt();
					// Add x to sorted list
					Lint.insertsortedlist(x, k);
				}
				System.out.printf("\n  %d inserted data are as follow:", n);
				// print sorted linked list
				System.out.print(Lint.toString(k));
			}
			Lint.mergeSort();
			System.out.print("Merged:" + Lint.toString(3));
			inf.close();// close input file
		} catch (Exception e) {
			prt("\nException " + e + "\n");
		}
	} // end main method
} // end class dastghaib2