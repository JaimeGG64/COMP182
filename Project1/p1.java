import java.util.Scanner;

public class p1 {
    public static void main(String args[]) {
        int j, n, m, k, x;
        try{
            Scanner inf = new Scanner(System.in);
            n = inf.nextInt();// read No. of data to read

            // Create a List of type Integer of size n
            listarr<Integer> listarr2 = new listarr<Integer>(n);
            
            // Read n element and insert in a sorted listposition randomly in the list
            for(j = 1; j <= n; j++){
                x = inf.nextInt(); // read element
                listarr2.insertsorted(x,j);
            }
            System.out.print(listarr2.toString());
            System.out.printf("The %d inserted data are as follow:", n);
            // System.out.print(listarr.toString());
            // read No. of data to search
            m = inf.nextInt();
            for(j = 1; j <= m; j++){
                x = inf.nextInt(); // read data to search
                // k = Lint.binsearch(x);
                // if(k){

                // }
                inf.close();
            } 
        }
        catch (Exception e) {
            prt("Exception " + e + "\n");
        }
    }// end main method
    public static void prt(String s){
        System.out.print(s);
    }
}