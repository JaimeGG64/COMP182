public class sort{
    public static void merge1(int arrA[], int i, int j, int arrB[], int m, int n, int arrC[], int p){
        // elements of Array A from i to j are sorted
        // elements of Array B from k to l are sorted
        // merge them and store the from C[m]
        while(i < j && m < n){
            if(arrA[i] < arrB[m]){
                arrC[p] = arrA[i];
                p++;
                i++;
            }
            else{
                arrC[p] = arrB[m];
                p++;
                m++;
            }
        }
        while(i < j){
            arrC[p] = arrA[i];
            p++;
            i++;
        }
        while(m < n){
            arrC[p] = arrB[m];
            p++;
            m++;
        }
    }

    public static void merge2(int arrA[], int arrB[], int arrC[]){
        // Array A & B are sorted
        // merge them in array C
        int n = arrA.length;
        int m = arrB.length;
        int p = 0;
        int i = 0;
        int j = 0;

        while(i < n && j < m){
            if(arrA[i] < arrB[j]){
                arrC[p] = arrA[i];
                p++;
                i++;
            }
            else{
                arrC[p] = arrB[j];
                p++;
                j++;
            }
        }
        while(i < n){
            arrC[p] = arrA[i];
            p++;
            i++;
        }
        while(j < m){
            arrC[p] = arrB[j];
            p++;
            j++;
        }
    }

    public static void merge3(int arrA[], int i, int j, int k){
        // elements of i thru j of ArrayA is sorted
        // elements j+1 thru k of ArrayA is sorted
        // merge them & store them, int arrayA from i thru k


    }
    public static void main(String[] args) {
        int a[] = {1 ,2, 3, 4, 5, 6, 45};
        int b[] = {10, 20, 30, 40, 50};

        int[] c = new int[a.length + b.length];
        // merge2(a, b, c);

        
        int i = 0, j = a.length, k = 0, l = b.length, m = 0;
        
        merge1(a, i, j, b, k, l, c, m);
        
        for(int u = 0; u < c.length; u++){
            System.out.print(c[u] + " ");
        }

    }
}