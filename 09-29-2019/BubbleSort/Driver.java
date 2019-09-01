import java.util.Scanner;
public class Driver{
    public static void main(String[] args) {
        int[] myArrayToBeGenerated = new int[0];
        int countSwaps = 0;
        int countComps = 0;
        Scanner getUserInput = new Scanner(System.in);
        int getAmountOfNumberToBeGenerated;
        int getMinValue;
        int getMaxValue;
        do{
            System.out.println("Enter the amount of numbers you want generated");
            getAmountOfNumberToBeGenerated = getUserInput.nextInt();
            if(getAmountOfNumberToBeGenerated < 0){
                System.out.println("Amount must be greater than 0");
            }
        }
        while(getAmountOfNumberToBeGenerated < 0);

        System.out.println("Enter a minimum");
        getMinValue = getUserInput.nextInt();

        do{
            System.out.println("Enter a maximum");
            getMaxValue = getUserInput.nextInt();
            if(getMaxValue < getMinValue){
                System.out.println("Number must be greater than " + getMinValue);
            }
        }
        while(getMaxValue < getMinValue);
        myArrayToBeGenerated = generateArrayOfNumbers(myArrayToBeGenerated, getAmountOfNumberToBeGenerated, getMinValue, getMaxValue);
        printArray(myArrayToBeGenerated, myArrayToBeGenerated.length, 5);
    }
    public static int[] generateArrayOfNumbers(int[] arrayOfIntegers, int lenghtOfArray, int minValue, int maxValue){
        arrayOfIntegers = new int[lenghtOfArray];
        int range = maxValue - minValue + 1;
        for(int i = 0; i < lenghtOfArray; i++){
            int randomInt;
            randomInt = (int) (Math.random() * range + minValue);
            arrayOfIntegers[i] = randomInt;
        }
        return arrayOfIntegers;
    }
    public static void printArray(int[] arrayToPrint, int lenghtOfArray, int numberOfSpaces){
        for(int i = 0; i < lenghtOfArray; i++){
            if(i % numberOfSpaces == 0 && i != 0){
                System.out.print("\n");
            }
            System.out.print(arrayToPrint[i] + " ");
        }
        System.out.print("\n");
    }
    public static int[] bubbleSortAscending(int arrayToBeSorted[], int lenghtOfArray, int numberOfComparison, int numberOfSwaps){
        for(int i = 0; i < lenghtOfArray - 1; i++){
            for(int j = 0; j < lenghtOfArray - i - 1; j++){
                if(arrayToBeSorted[j] > arrayToBeSorted[j + 1]){
                    int temporaryLargeNumber = arrayToBeSorted[j];
                    arrayToBeSorted[j] = arrayToBeSorted[j + 1];
                    arrayToBeSorted[j + 1] = temporaryLargeNumber;
                    numberOfSwaps++;
                }
            }
        }
        numberOfComparison = (lenghtOfArray *( lenghtOfArray + 1)) / 2;
        System.out.println("Number of swaps " + numberOfSwaps);
        System.out.println("Number of comparisons " + numberOfComparison);
        return arrayToBeSorted;
    }
}