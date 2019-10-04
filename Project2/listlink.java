//	listlink.java(Non-Generic)	CSUN Fall 19  COMP182-2

//ADT LIST (Link list implementation & no header in JAVA
import java.util.*;
import java.io.*;

//************  Class Definition *********************************
/*
	* Implementation of the  ADT List using a Linked List.  
	* Exception is thrown:
	* if delete operation is attempted when List is empty.
	* if position of insert or delete is out of range.
*/
public class listlink{
	private class Node{
		int data; 
		Node next;
		Node(){next = null;}
	}// class Node<T>
	private Node head; //head is a pointer to head of the list
	private Node sorted;
	private int count = 0;  // no. of elements in the list
	listlink(){head = null;}  // Constructor of List class

//************ Member functions definition   ************************
	public int     length() {return count;}
	public boolean isEmpty() {return (head == null);}
	public static void prt(String s){System.out.print(s);}

	public String toString() {
		String s  = "";
		for (Node cur = head; cur != null ; cur = cur.next){
			s += ", " +  cur.data;
		}
		return "[" + s.substring(2) + "]";
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

	public int deleteKey(int key){
		Node tmp = head; 
		Node prev = null;
		if(tmp != null && key == tmp.data){
			head = tmp.next;
			return 1;
		}
		while(tmp != null && key != tmp.data){
			prev = tmp;
			tmp = tmp.next;
		}
		if(tmp == null){
			return -1;
		}
		prev.next = tmp.next;
		return 1;
	}

	public void insertsorted(int data) {
		Node insertedNode = new Node();
		insertedNode.next = head;
		insertedNode.data = data;
		head = insertedNode;
		System.out.print("{");
		for (Node cur = head; cur != null; cur = cur.next){
			if(cur.data != insertedNode.data){
				System.out.print("current: " + cur.data + " " + ",inserted: " + insertedNode.data + " ");
			}
		}
		System.out.print("}\n ");
		// head = sorted;
		// System.out.printf("Insert %d in a sorted list\n", data);
	}
}// end class listlink	