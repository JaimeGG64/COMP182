import java.util.Scanner;

public class driver5 {
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
    public void insert(String english, String french){
        root = insert(root, english, french);
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

    // search for x in BST
	public int search(String word) {
		if (root == null)
			return 0; // tree is empty
		else{
			return search(word, root);
        }
	}

	public int search(String English, Node t) {
		if(t == null){
			return 0;
		}
		else if(t.English.equals(English)){
            System.out.println(t.French);
			return 1;
		}
		// search left subtree
		else if(t.English.compareTo(t.English) < 0){
			return search(English, t.ll);
		}
		// search right subtree
		else{
			return search(English, t.rl);
		}
    }

    public static void main(String args[]) {
        driver5 bst = new driver5 ();
        
        try{
            Scanner inf = new Scanner(System.in);  
            String english = "";
            String french = ""; 
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
                // search in BST and print its corresponding French if exist.
                if(1 == bst.search(english)){
                    System.out.println(" ");
                }
            }// end while
        
            inf.close();// close input file
        
        }// End try
        catch (Exception e) {
            System.out.print("\nException " + e + "\n");
        }
    }// end main method
}