import java.util.Scanner;
import java.lang.Math;

public class garciaL2{
    // Node Constructor
    private class Node{
        int data, bf;
        Node ll, rl;
        Node(int x){
            data = x;
            rl = ll = null;
            bf = 0;
        }
    }
    private Node root;
    garciaL2(){
        root = null;
    }

    // Insert
    public void insert(int x){
        root = insert(root, x);
    }
    public Node insert(Node t, int x){
        if(t == null){
            t = new Node(x);
            return t;
        }
        else if(t.data > x) {
            t.ll = insert(t.ll, x);
        }
        else{
            t.rl = insert(t.rl, x);
        }
        return t;
    }

    //Balance Factor
    private void balancefactor(Node t){
        if(t.ll == null && t.rl == null){
            t.bf = 0;
        }
        else{
            t.bf = Math.abs(height(t.ll) - height(t.rl));
            System.out.print("Balance Factor: " + t.bf + "\n");
        }
    }
    private int height(Node t){
        if(t != null){
            if(t.ll == null && t.rl == null){
                return 0;
            }
            int leftHeight = height(t.ll);
            int rightHeight = height(t.rl);
            if(leftHeight > rightHeight){
                return leftHeight + 1;
            }
            else{
                return rightHeight + 1;
            }
        }
        return 0;
    }

    //Print inorder
    void inorder(){inorder(root);} 
    void inorder(Node t) { 
        if (t == null){
            return; 
        }
        inorder(t.ll); 
        System.out.print(t.data + " "); 
        inorder(t.rl);
    } 

    //Print Print Median element

    public static void main(String[] args) {
        garciaL2 bst = new garciaL2();
        try{
            Scanner inf = new Scanner(System.in);
            while(inf.hasNext()){
                int n = inf.nextInt();
                bst.insert(n);
            }
            bst.inorder();
            inf.close();
        }catch(Exception e){
            System.out.print("Error");
        }
    }
}