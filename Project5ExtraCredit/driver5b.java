/*
    Program: Binary Search Tree Extra Credit
    Name: Jaime Garcia Garcia
    Date: 11-14-2019
    Description: 

    How to Run The Program:
    1. How to Compile:
        ```bash
        $ javac garciaj.java
        ```

    2. How to Execute
        ```bash
        $ java garcia < <YourTextFile>.txt
        ```
*/

import java.util.Scanner;

public class driver5b {
    // Binary Tree Constructor
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

    driver5b() {
        root = null;
    }

    // Insert English and French word to Binary Tree.
    public void insert(String englishWord, String frenchWord) {
        root = insert(root, englishWord, frenchWord);
    }

    public Node insert(Node languageTree, String English, String French) {
        if (languageTree == null) {
            languageTree = new Node(English, French);
            return languageTree;
        } else if (English.compareTo(languageTree.English) < 0) {
            languageTree.ll = insert(languageTree.ll, English, French);
        } else {
            languageTree.rl = insert(languageTree.rl, English, French);
        }
        return languageTree;
    }

    // Recursive search Method find the french eqvalient
    public int search(String translateToFrench) {
        if (root == null)
            return 0; // tree is empty
        else {
            return search(translateToFrench, root);
        }
    }

    public int search(String findFrench, Node languageTree) {
        if (languageTree == null) {
            return 0; // search was unsuccesful.
        }
        // search was successful
        else if (languageTree.English.equals(findFrench)) {
            System.out.print(languageTree.French);
            return 1;
        }
        // search left subtree
        else if (languageTree.English.compareTo(findFrench) > 0) {
            return search(findFrench, languageTree.ll);
        }
        // search right subtree
        else {
            return search(findFrench, languageTree.rl);
        }
    }

    public static void main(String args[]) {
        driver5b englishToFrench = new driver5b();
        driver5b frenchToEnglish = new driver5b();
        
        try{
            Scanner inf = new Scanner(System.in);  
            String english, french, wordToSearch; 
            int n;
            // read no. of words
            n = inf.nextInt();
            for (int i = 1; i <= n; i++){
                // read English word
                english = inf.next();
                
                // read corresponding word
                french = inf.next();
                
                englishToFrench.insert(english, french);
                frenchToEnglish.insert(french, english);
            }

            while(inf.hasNext()){
                // read next English word
                wordToSearch = inf.next();

                // search in BST and print its corresponding French if exist.
                if(1 == englishToFrench.search(wordToSearch)){
                    System.out.print(" ");
                }
                else if(1 == frenchToEnglish.search(wordToSearch)){
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