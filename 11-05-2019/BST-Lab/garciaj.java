
// CSUN COMP 182-02 Fall 2019 
// binary search tree (BST) program that performs:
//   inserting, searching and inorder traversing
//
//   Author : Dr. Gh. Dastghaibyfard
//
//   Name:
// FIRST CHANGE FILE AND CLASS NAME TO xxxxx WHERE xxxxx IS
// THE FIRST 5 CHARACTERS OF YOUR LAST NAME.
// NEXT CREATE AN INPUT FILE FOR THIS FILE.
// THEN COMPLETE INSERT AND SEARCH METHODS.
import java.io.*;
import java.util.*;

//Binary Search Tree (BST)implementation in JAVA 95/01/23
public class garciaj {

	// class Node
	private class Node {
		int data;
		Node ll, rl;

		Node(int x) {
			data = x;
			rl = ll = null;
		}
	}// end class Node

	public static void prt(String s) {
		System.out.print(s);
	}

	// root is a pointer to root of the BST Tree
	Node root;

	// Constructor of BST Tree
	garciaj() {
		root = null;
	}

	// inorder traverse ()
	public void inorder() {
		prt(" Tree(Inorder): ");
		inorder(root);
		prt("\n");
	}

	// Inorder Traverse (Node t)
	private void inorder(Node t) {
		if (t != null) {
			inorder(t.ll);
			prt(t.data + " ");
			inorder(t.rl);
		}
	}

	// insert x into a BST
	public void insert(int x) {
		if (root == null) {
			root = new Node(x);// Allocate space to store x
		} else
			insert(x, root);
	}

	// insert x into a BST with root t(non-recursive)
	public void insert(int x, Node t) {
		Node cur = t;
		while(t != null){
			cur = t;
			if(x <= t.data){
				t = t.ll;
			}
			else{
				t = t.rl;
			}
		}
		if(x <= cur.data){
			cur.ll = new Node(x);
		}
		else{
			cur.rl = new Node(x);
		}
	}

	// search for x in BST
	public int search(int x) {
		if (root == null)
			return 0; // tree is empty
		else
			return search(x, root);
	}

	// search for x in BST
	public int search(int x, Node t) {
		if(t == null){
			return 0;
		}
		else if(t.data == x){
			return 1;
		}
		// search left subtree
		else if(x < t.data){
			return search(x, t.ll);
		}
		// search right subtree
		else{
			return search(x, t.rl);
		}
	}

	public static void main(String args[]) throws Exception {
		int i, k, n, x;
		garciaj t = new garciaj();
		try {
			Scanner inf = new Scanner(System.in);

			// insert n data from file
			n = inf.nextInt(); // read No. of data to insert
			for (i = 1; i <= n; i++) {
				x = inf.nextInt();
				prt("\n insert " + x + " ");
				t.insert(x);
			} // end for
			t.inorder(); // print inorder BST Tree

			// search n data
			n = inf.nextInt(); // read No. of data to search
			for (i = 1; i <= n; i++) {
				x = inf.nextInt();
				prt("\n search for " + x + ": ");
				k = t.search(x);
				if (k == 0)
					prt(" Sorry " + x + " is not in the tree.");
				else
					prt(" fortunately " + x + " exist in the tree.");
			} // end for
			t.inorder(); // print inorder BST Tree
			inf.close();
		} catch (Exception e) {
			prt("\nI/Ot Exception " + e);
		}

	} // end main
}// end class BSTLAB