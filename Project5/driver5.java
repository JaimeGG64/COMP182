import java.util.Scanner;

public class driver5 {
    public void insert(String English, String French){
        System.out.print(English + French);
    }

    public static void main(String args[]) {
        driver5 bst = new driver5 (); // xxxxx is the first 5 characters of your last name
        
        try{
            Scanner inf = new Scanner(System.in);  
            String english = "";
            String french = "";                  
            
            // Read input from KB/ File
            
            // read no. of words
            
            int n = inf.nextInt();
            
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
            }// end while
        
            inf.close();// close input file
        
        }// End Try
        catch (Exception e) {
            System.out.print("\nException " + e + "\n");
        }
        
    }// end main method
}