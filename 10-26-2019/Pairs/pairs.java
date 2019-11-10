import java.util.Scanner;
import java.util.LinkedList;

public class pairs{
    public static void main(String[] args) {
        Scanner fileToInput = new Scanner(System.in);
        
        LinkedList<String> dictionary = new LinkedList<String>();

        String getNext = "";

        while(fileToInput.hasNext()){
            getNext = fileToInput.nextLine();
            dictionary.add(getNext);
        }

        
        for(int num=0; num < dictionary.size(); num++){
            System.out.print(dictionary.get(num));
        }
        fileToInput.close();
        }
}