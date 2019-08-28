import java.util.Scanner;
import java.lang.Math;

public class GenerateRandomNumbers{
    public static void main(String[] args) {
        int inputMin;
        int inputMax;
        int inputNumOfRandomNumbers;
        Scanner myScanner = new Scanner(System.in);

        //Gather Inputs
        System.out.println("You can generate a random amount of numbers with this program");

        do{
            System.out.println("Enter the amount of random numbers you want.");
            inputNumOfRandomNumbers = myScanner.nextInt();
            if(inputNumOfRandomNumbers < 0){
                System.out.println("Number must be greater than 0");
            }
        }
        while(inputNumOfRandomNumbers < 0);

        System.out.println("Enter a minimum");
        inputMin = myScanner.nextInt();

        do{
            System.out.println("Enter a maximum");
            inputMax = myScanner.nextInt();
            if(inputMax < inputMin){
                System.out.println("Number must be greater than " + inputMin);
            }
        }
        while(inputMax < inputMin);
        
        myScanner.close();

        for(int i = 1; i <= inputNumOfRandomNumbers; i++){
            int randomInt = (int) (Math.random() * (inputMax - inputMin + 1) + inputMin);
            System.out.println("Random Numbers: " + randomInt);
            if(i % 10 == 0){
                System.out.println("-------------------------");
            }
        }
    }
}