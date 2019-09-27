//	listlink.java(Non-Generic)	CSUN Fall 19  COMP182-2

//ADT LIST (Link list implementation & no header in JAVA
import java.util.*;
import java.io.*;

//************  Class Definition *********************************
/**
  * Implementation of the  ADT List using a Linked List.  
  * Exception is thrown:
  *     if delete operation is attempted when List is empty.
  *     if position of insert or delete is out of range.
  */
	public class listlink implements list{
		private class Node{
			int data; 
			Node next;
			Node(){next = null;}
		}// class Node<T>
		private Node head; //head is a pointer to head of the list
		private int count = 0;  // no. of elements in the list
		listlink(){head = null;}  // Constructor of List class

//************ Member functions definition   ************************
		public int     length() {return count;}
		public boolean isEmpty() {return (head == null);}
		public static void prt(String s){System.out.print(s);}

		public String toString() {
			String s  = "[";
			for (Node cur = head; cur != null ; cur = cur.next)
				s += cur.data + ", ";
            return s + "]";
		}

		// insert x at position p
		public void insert(int x, int p) throws invalidinsertion {
			prt("\nInsert " + x + " at position " + p);
			if (p < 1 || p > length()+1) throw new invalidinsertion(p);
	
			Node tmp = new Node();
			tmp.data = x;
			if (p == 1){ // Insert to front of list
				tmp.next = head;
				head = tmp;
			}
			else {
				Node cur = head;
				//Find Node before p
				for (int i = 2;  i < p; i ++, cur = cur.next);
			    // insert node after cur node
				tmp.next = cur.next;
				cur.next = tmp;
			}
			count ++; // increment no of list elements
		}

        // Delete Pth element	
		public void delete(int p)throws invaliddeletion {
			prt("\nDelete " + p + "th element, ");
			if (isEmpty() || p < 1 || p > length())
				throw new invaliddeletion(p);
	
			Node tmp = head;
			if (p == 1){    // Delete Front of List
				head = head.next;
				tmp.next = null;
			}
			else {//Find Node before p
				Node cur = head;
				for (int i = 2; i < p; i ++, cur = cur.next);
				// Delete node after cur node
				tmp = cur.next;
				cur.next = tmp.next;
				tmp.next = null;  //	 delete tmp;
			}
		    count --; // decrement no of list elements	
		}

		public static void main(String args[]) {
			int j, p, n, x, MaxNum = 5;
			Random rand = new Random();

			n = rand.nextInt(MaxNum) + 1;
		
			// Create a Linked List of type Integer
			listlink Lint = new  listlink();
			
			// Generate n element and position randomly and insert in the list
			for(j = 1; j <= n; j++){
				p = rand.nextInt(n)+1; // generate position
				x = rand.nextInt(MaxNum * 4); // generate element
				try {
					Lint.insert(x,p);
				}catch (Exception e) {prt("Exception " + e + "\n");}
			}
			
			prt("\nList: " + Lint.toString() + "\n");// print list
			
			//Delete n element from linked list randomly and print list
			prt("Delete " + n + " elements from list:\n"); 
			for(j = 1; j <= n; j++){
				p = rand.nextInt(n);
				try {
					Lint.delete(p);
					prt(" List: " + Lint.toString()); 
				} catch (Exception e) {prt("Exception " + e + "\n");}
			}
		}
	}// end class listlink	