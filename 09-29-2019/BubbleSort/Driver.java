public class Driver{
    public static void main(String[] args) {
        int[] myArrayToBeGenerated;
        myArrayToBeGenerated = new int[0];
        myArrayToBeGenerated = generateArrayOfNumbers(myArrayToBeGenerated, 20, 10, 50);
        printArray(myArrayToBeGenerated, myArrayToBeGenerated.length, 5);
    }
    public static int[] generateArrayOfNumbers(int[] arrayOfIntegers, int lenghtOfArray, int minValue, int maxValue){
        arrayOfIntegers = new int[lenghtOfArray];
        for(int i = 0; i < arrayOfIntegers.length; i++){
            int randomInt;
            randomInt = (int) (Math.random() * (maxValue - minValue + 1) + minValue);
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
}