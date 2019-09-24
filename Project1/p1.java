import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        int j, n, m, k, x;
        try{
            Scanner inf = new Scanner(System.in);                 
            // read No. of data to read
            n = inf.nextInt();

            // Create a List of type Integer of size n
            listarr<Integer> Lint = new listarr<Integer>(n);

            // Read n element and insert in a sorted list position randomly in the list
            for(j = 1; j <= n; j++){
                // read element
                x = inf.nextInt();
                Lint.insertsorted(x);
            }
            System.out.printf("The %d inserted data are as follow:", n);
            System.out.print(Lint.toString());

            // read No. of data to search
            m = inf.nextInt(); 

            for(j = 1; j <= m; j++){
                // read data to search
                x = inf.nextInt(); 
                // k = Lint.binsearch(x);
                /*if(k???){}*/ //complete it
            }
            inf.close();
        }
        catch(Exception e){
            prt("Exception " + e + "\n");
        }
    }// end main method
    public static void prt(String s){
        System.out.print(s);
    }
}