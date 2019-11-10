import java.util.Scanner;

public class driver{
    class Node {
        String name;
        int val;
        Node ll, rl;

        Node(String s, int n){
            name = s;
            val = n;
            ll = rl = null;
        }

        private void insert(String s, int x){
            System.out.print("Hi");
        }

        private void inorder(){
            System.out.print(" Tree(Inorder): ");
            inorder(tree);
            System.out.print("\n");
        }

        private void inorder(Node t) {
            if (t != null) {
                inorder(t.ll);
                System.out.print(t.name + " ");
                inorder(t.rl);
            }
        }

        private void search(){
            System.out.print("Search");
        }
    }

    Node tree;

	driver() {
		tree = null;
    }
    
    public static void main(String[] args) {
        Scanner inf = new Scanner(System.in);
        int n, y, j;
        n = 0;
        String s = " ";
        // Node tree = new Node("Hello", 3);
        n = inf.nextInt();
        for(int i = 1; i <= n; i++){
            s = inf.next();
            y = inf.nextInt();
            // tree.insert(s, y);
        }
        // tree.inorder();
        n = inf.nextInt();
        for(int i = 1; i <= n; i++){
            s = inf.next();
            // tree.search();
        }
        inf.close();
    }
}