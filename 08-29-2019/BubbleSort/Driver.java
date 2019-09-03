//Program: Number

import java.util.Scanner;
public class Driver{
    public static void main(String[] args) {
        //pre-set values
        int[] myArrayToBeGenerated = new int[0];
        int countSwaps = 0;
        int countComps = 0;

        Scanner getUserInput = new Scanner(System.in);
        int getAmountOfNumberToBeGenerated;
        int getMinValue;
        int getMaxValue;
        int getAmountOfNumbersPerLine;
        
        //Get amount of numbers to be generated
        do{
            System.out.println("Enter the amount of numbers you want generated");
            getAmountOfNumberToBeGenerated = getUserInput.nextInt();
            if(getAmountOfNumberToBeGenerated <= 0){
                System.out.println("Amount must be greater than 0");
            }
        }
        while(getAmountOfNumberToBeGenerated <= 0);

        //Get Min and max from user
        System.out.println("Enter a minimum");
        getMinValue = getUserInput.nextInt();
        
        System.out.println("Enter a maximum");
        do{
            getMaxValue = getUserInput.nextInt();
            if(getMaxValue < getMinValue){
                System.out.println("Number must be greater than " + getMinValue);
            }
        }
        while(getMaxValue < getMinValue);

        //Get amount of numbers per line
        do{
            System.out.println("Enter the amount of numbers you want per line");
            getAmountOfNumbersPerLine = getUserInput.nextInt();
            if(getAmountOfNumbersPerLine <= 0){
                System.out.println("Amount must be greater than 0");
            }
        }
        while(getAmountOfNumbersPerLine <= 0);
        getUserInput.close();

        //Prepare to generate and print array
        printLineSeperator();
        System.out.println("Unsorted Array:");
        myArrayToBeGenerated = generateArrayOfNumbers(myArrayToBeGenerated, getAmountOfNumberToBeGenerated, getMinValue, getMaxValue);
        printArray(myArrayToBeGenerated, myArrayToBeGenerated.length, getAmountOfNumbersPerLine);
        printLineSeperator();

        //Print sorted array
        System.out.println("Sorted Array:");
        bubbleSortAscending(myArrayToBeGenerated, myArrayToBeGenerated.length, countComps, countSwaps);
        printArray(myArrayToBeGenerated, myArrayToBeGenerated.length, getAmountOfNumbersPerLine);
        printLineSeperator();
    }//end main

    public static int[] generateArrayOfNumbers(int[] arrayOfIntegers, int lenghtOfArray, int minValue, int maxValue){
        arrayOfIntegers = new int[lenghtOfArray];
        int range = maxValue - minValue + 1;
        for(int i = 0; i < lenghtOfArray; i++){
            int randomInt;
            randomInt = (int) (Math.random() * range + minValue);
            arrayOfIntegers[i] = randomInt;
        }
        return arrayOfIntegers;
    }//end generateArrayOfNumbers()

    public static void printArray(int[] arrayToPrint, int lenghtOfArray, int numberOfSpaces){
        for(int i = 0; i < lenghtOfArray; i++){
            if(i % numberOfSpaces == 0 && i != 0){
                System.out.print("\n");
            }
            System.out.print(arrayToPrint[i] + " ");
        }
        System.out.print("\n");
    }//end printArray()

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
        numberOfComparison = (lenghtOfArray *( lenghtOfArray - 1)) / 2;
        System.out.println("Number of swaps " + numberOfSwaps);
        System.out.println("Number of comparisons " + numberOfComparison);
        return arrayToBeSorted;
    }//end bubbleSortAscending()

    public static int[] bubbleSortDescending(int arrayToBeSorted[], int lenghtOfArray, int numberOfComparison, int numberOfSwaps){
        for(int i = 0; i < lenghtOfArray - 1; i++){
            for(int j = 0; j < lenghtOfArray - i - 1; j++){
                if(arrayToBeSorted[j] < arrayToBeSorted[j + 1]){
                    int temporaryLargeNumber = arrayToBeSorted[j];
                    arrayToBeSorted[j] = arrayToBeSorted[j + 1];
                    arrayToBeSorted[j + 1] = temporaryLargeNumber;
                    numberOfSwaps ++;
                }
            }
        }
        numberOfComparison = (lenghtOfArray *( lenghtOfArray - 1)) / 2;
        System.out.println("Number of swaps " + numberOfSwaps);
        System.out.println("Number of comparisons " + numberOfComparison);
        return arrayToBeSorted;
    }//end bubbleSortDescending
    
    public static void printLineSeperator(){
        int maxChar = 40;
        for(int i = 0; i <= maxChar; i++){
            System.out.print("-");
            if(i == maxChar){
                System.out.print("\n");
            }
        }
    }//end printLineSeperator()
}