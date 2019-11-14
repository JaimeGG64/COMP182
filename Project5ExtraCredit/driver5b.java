/*
    Program: Binary Search Tree Extra Credit
    Name: Jaime Garcia Garcia
    Date: 11-14-2019
    Description: Program will create two BST tree for French to English and English to French from a data file. 
    The program will then determine if the word is English or French and translate it to the opposite language.

    How to Run The Program:
    1. How to Compile:
        ```bash
        $ javac garciaj5b.java
        ```

    2. How to Execute
        ```bash
        $ java garciaj5b < <YourTextFile>.txt
        ```
*/

import java.util.Scanner;

public class driver5b {
    // Binary Tree Constructor
    private class Node {
        String originalWord = "";
        String translatedWord = "";
        Node ll, rl;

        Node(String originalWord, String translatedWord) {
            this.originalWord = originalWord;
            this.translatedWord = translatedWord;
            rl = ll = null;
        }
    }// end class Node

    private Node root;

    driver5b() {
        root = null;
    }

    // Insert English and French word to Binary Tree.
    public void insert(String originalWord, String translatedWord) {
        root = insert(root, originalWord, translatedWord);
    }

    public Node insert(Node languageTree, String originalWord, String translatedWord) {
        if (languageTree == null) {
            languageTree = new Node(originalWord, translatedWord);
            return languageTree;
        } else if (originalWord.compareTo(languageTree.originalWord) < 0) {
            languageTree.ll = insert(languageTree.ll, originalWord, translatedWord);
        } else {
            languageTree.rl = insert(languageTree.rl, originalWord, translatedWord);
        }
        return languageTree;
    }

    // Recursive search Method find the french eqvalient
    public int search(String wordToTranslate) {
        if (root == null)
            return 0; // tree is empty
        else {
            return search(wordToTranslate, root);
        }
    }

    public int search(String wordToFind, Node languageTree) {
        if (languageTree == null) {
            return 0; // search was unsuccesful.
        }
        // search was successful
        else if (languageTree.originalWord.equals(wordToFind)) {
            System.out.print(languageTree.translatedWord);
            return 1;
        }
        // search left subtree
        else if (languageTree.originalWord.compareTo(wordToFind) > 0) {
            return search(wordToFind, languageTree.ll);
        }
        // search right subtree
        else {
            return search(wordToFind, languageTree.rl);
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

                // First find English word to translate to French.
                if(1 == englishToFrench.search(wordToSearch)){
                    System.out.print(" ");
                }
                // If it not an English find the French word to translate to English
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