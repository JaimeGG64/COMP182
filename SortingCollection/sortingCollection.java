public class sortingCollection<T extends Comparable<? super T>>{

    public void bubbleSort(T[] array){
        int n = array.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j + 1 < n; j++){
                if (array[j + 1].compareTo(array[j]) > 0){
                    // swap
                    T tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }// end bubbleSort

    public void insertionSort(T[] array){
        int n = array.length;
        for(int i = 1; i < n; i++){
            T key = array[i];
            int j = i - 1;
            while(j >= 0 && array[j].compareTo(key) > 0){
                array[j + 1] = array[j];
                j--;
            }// end while
            array[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Double[] arrayOfDoubles = {0.35, 0.02, 0.36, 0.82, 0.27, 0.49, 0.41, 0.17, 0.30, 0.89, 0.37, 0.66, 0.82, 0.17, 0.20, 0.96, 0.18, 0.25, 0.37, 0.52};
        sortingCollection<Double> doubleSorter   = new sortingCollection<Double>();
        doubleSorter.insertionSort(arrayOfDoubles);
        System.out.println(java.util.Arrays.toString(arrayOfDoubles));
    }
}