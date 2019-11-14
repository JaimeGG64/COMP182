/*
    Program: Binary Search Tree
    Name: Jaime Garcia Garcia
    Date: 11-14-2019
    Description: Program reads a data file with a list of English and French words and. 
    Then, it will construct a BST of the words. Finally the program will translate the sentence from English to French.

    How to Run The Program:
    1. How to Compile:
        ```bash
        $ javac garciaj5.java
        ```

    2. How to Execute
        ```bash
        $ java garciaj5 < <YourTextFile>.txt
        ```
*/

import java.util.Scanner;

public class driver5 {
    // BST Constructor
    private class Node {
        String English = "";
        String French = "";
		Node ll, rl;

		Node(String English, String French) {
            this.English = English;
            this.French = French;
			rl = ll = null;
		}
    }// end class Node
    private Node root;
    driver5(){
        root = null;
    }

    // Insert English and French word to Binary Tree.
    public void insert(String englishWord, String frenchWord){
        root = insert(root, englishWord, frenchWord);
    }

    public Node insert(Node languageTree, String English, String French){
        if(languageTree == null){
            languageTree = new Node(English, French);
            return languageTree;
        }
        else if(English.compareTo(languageTree.English) < 0) {
            languageTree.ll = insert(languageTree.ll, English, French);
        }
        else{
            languageTree.rl = insert(languageTree.rl, English, French);
        }
        return languageTree;
    }

    // Recursive search Method find the french eqvalient
	public int search(String englishToFrenchWordToFind) {
		if (root == null)
			return 0; // tree is empty
		else{
			return search(englishToFrenchWordToFind, root);
        }
	}

	public int search(String findFrenchWord, Node languageTree) {
		if(languageTree == null){
			return 0; // search was unsuccesful.
        }
        // search was successful
		else if(languageTree.English.equals(findFrenchWord)){
            System.out.print(languageTree.French);
			return 1;
		}
		// search left subtree
		else if(languageTree.English.compareTo(findFrenchWord) > 0){
			return search(findFrenchWord, languageTree.ll);
		}
		// search right subtree
		else{
			return search(findFrenchWord, languageTree.rl);
		}
    }

    public static void main(String args[]) {
        driver5 bst = new driver5 ();
        
        try{
            Scanner inf = new Scanner(System.in);  
            String english, french; 
            int n;
            // read no. of words
            n = inf.nextInt();
            for (int i = 1; i <= n; i++){
                // read English word
                english = inf.next();
                
                // read corresponding word
                french = inf.next();
                
                bst.insert(english, french);
            }

            while(inf.hasNext()){
                // read next English word
                english = inf.next();

                // search in BST and print its corresponding French if it exist.
                if(1 == bst.search(english)){
                    System.out.print(" ");
                }
            }// end while
        
            inf.close();// close input file
        
        }// End try
        catch (Exception e) {
            System.out.print("\nException " + e + "\n");
        }
    }// end main method
}