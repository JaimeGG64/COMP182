public class sortingCollection<T extends Comparable<? super T>>{

    void bubbleSort(T[] array){
        int n = array.length;
        while (n > 0)
        {
            int lastModifiedIndex = 0;
            for (int currentIndex = 1; currentIndex < n; currentIndex++){
                // if the item at the previous index is greater than the item at the `currentIndex`, swap them
                if (array[currentIndex - 1].compareTo(array[currentIndex]) > 0){
                    // swap
                    T temp = array[currentIndex - 1];
                    array[currentIndex - 1] = array[currentIndex];
                    array[currentIndex] = temp;
                    lastModifiedIndex = currentIndex;
                }
            }
            n = lastModifiedIndex;
        }
    }
    public static void main(String[] args) {
        Double[] arrayOfDoubles = {0.35, 0.02, 0.36, 0.82, 0.27, 0.49, 0.41, 0.17, 0.30, 0.89, 0.37, 0.66, 0.82, 0.17, 0.20, 0.96, 0.18, 0.25, 0.37, 0.52};
        sortingCollection<Double> doubleSorter   = new sortingCollection<Double>();
        doubleSorter.bubbleSort(arrayOfDoubles);
        System.out.println(java.util.Arrays.toString(arrayOfDoubles));
    }
}