 // CSUN COMP 182-02 Fall 2019  Version 2 (No private variables)
 // bublle sort program that:
 //   generates n integer numbers in the range of a...b
 //   stores them in array arr
 //   prints input k numbers per line
 //   sorts input using bubble sort and computes number of
 //   comparisons and swaps and
 //   prints sorted, k numbers per line
 //   Author : Dr. Gh. Dastghaibyfard
 //
 //   Name:
 public class sort2{
	public static void prt(String s){System.out.print(s);}

	// Generate and print n integers in the range of a....b
	private void genarr(int arr[],int n, int a, int b, int k){
		int range = b-a+1;
		for (int i = 0; i < n; i++)
			arr[i] = ((int) (Math.random() * range)) + b;
		prt("\n        Input before sorting...\n");
		printarr(arr, n, k);
	}

	// print arr, k numbers per line
	private void printarr(int arr[], int n, int k){
		int j = 0;
		for (int i : arr){
			prt(i + " ");
			j++;
			if (j % k == 0) prt("\n");
		}
	}

	// sort arr using bubble sort, compute number of
	// comparison and swaps and print sorted array
	private void bubblesort(int arr[], int n, int k){
		int swaps = 0;
		int comps = n * (n-1) / 2;
		for (int i = 1; i < n; i++)
		  for (int j = 0; j < n-i; j++)
			if(arr[j] > arr[j+1]){
			  int tmp = arr[j];
			  arr[j] = arr[j+1];
			  arr[j+1] = tmp;
			  swaps ++;
			}
		prt("\n        Input after sorting...\n");
		printarr(arr, n, k);
		prt("\n    No. of comparisons = " + comps);
		prt("\n    No. of       swaps = " + swaps + "\n");
	}

	public static void main(String[] args) throws Exception {
		sort2 bb = new sort2();//No private variables
		// set variables 
		int n = 20, a = 10, b = 20, k = 10;
		int arr[] = new int[n];
		bb.genarr(arr, n, a, b, k);// generate and print
		bb.bubblesort(arr, n, k); // sort and print
	}
 }