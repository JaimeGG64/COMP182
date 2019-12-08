import java.util.Scanner;
import java.lang.Math;

public class garciaL2 {
    // Node Constructor
    private class Node {
        int data, bf;
        Node ll, rl;

        Node(int x) {
            data = x;
            rl = ll = null;
            bf = 0;
        }
    }

    private Node root;

    garciaL2() {
        root = null;
    }

    // Insert
    public void insert(int x) {
        if (root == null) {
            root = new Node(x);
        } else {
            insert(root, x);
        }
    }

    public void insert(Node t, int x) {
        Node cur = t;
        while (t != null) {
            cur = t;
            if (x <= t.data) {
                t = t.ll;
            } else {
                t = t.rl;
            }
        }
        if (x <= cur.data) {
            cur.ll = new Node(x);
        } else {
            cur.rl = new Node(x);
        }
    }


    // Balance Factor
    private void balancefactor() {
        if(root == null){
            return;
        }
        else{
            balancefactor(root);
        }
    }

    private void balancefactor(Node t) {
        if (t == null) 
            return;
        int leftHeight = height(t.ll);
        int rightHeight = height(t.rl);
        t.bf = Math.abs(leftHeight - rightHeight);
        balancefactor(t.ll);
        balancefactor(t.rl);
    }

    private int height() {
        if (root == null) {
            return 0;
        } else {
            return height(root);
        }
    }

    private int height(Node t) {
        if (t == null || (t.ll == null && t.rl == null))
            return 0;
        int leftHeight = height(t.ll);
        int rightHeight = height(t.rl);
        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        } else {
            return rightHeight + 1;
        }
    }

    // Print inorder
    void inorder() {
        inorder(root);
    }

    void inorder(Node t) {
        if (t == null) {
            return;
        }
        inorder(t.ll);
        System.out.print(t.data + "(" + t.bf + ")" ) ;
        inorder(t.rl);
    }

    // Print Median element
    void getMedianElement(){
        int numOfNodes = getNumOfNodes(root);
        int[] arrayOfNodes = new int[numOfNodes];
        System.out.print("\nNumber Of Nodes: " + numOfNodes + "\n");
        insertNodeToArray(root, 0, arrayOfNodes);
        for(int i = 0; i < arrayOfNodes.length; i++){
            System.out.print(arrayOfNodes[i] + " ");
        }
    }

    int getNumOfNodes(Node tree)  {  
        if (tree == null){
            return 0;
        }
        int leftNode = getNumOfNodes(tree.ll);
        int rightNodes = getNumOfNodes(tree.rl);
        return rightNodes + leftNode + 1;  
    }

    public void insertNodeToArray(Node tree, int index, int[] array){
        if (tree == null) {
            return;
        }
        insertNodeToArray(tree.ll,  2*index+1, array);
        array[index] = tree.data;
        insertNodeToArray(tree.rl,  2*index+2, array);
    }

    public static void main(String[] args) {
        garciaL2 bst = new garciaL2();
        try {
            Scanner inf = new Scanner(System.in);
            while (inf.hasNext()) {
                int n = inf.nextInt();
                bst.insert(n);
            }
            System.out.print("BST height: " + bst.height() + "\n");
            bst.balancefactor();
            bst.inorder();
            bst.getMedianElement();
            inf.close();
        } catch (Exception e) {

            System.out.print("Error" + e);
        }
    }
}