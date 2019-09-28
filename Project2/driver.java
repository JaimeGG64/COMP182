import java.util.Scanner;

public class driver {
    public static void main(String[] args) {
        int j, n, m, k, x;
        try{
            Scanner inf = new Scanner(System.in);                 
            // read No. of data to read
            n = inf.nextInt();

            // Create a List of type Integer of size n
            listlink Lint = new listlink();

            // Read n element and insert in a sorted list position randomly in the list
            for(j = 1; j <= n; j++){
                // read element
                x = inf.nextInt();
                Lint.insertsorted(x);
            }
            System.out.print(Lint.toString());

            // read No. of data to search
            m = inf.nextInt(); 
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