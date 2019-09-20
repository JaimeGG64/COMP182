import java.io.*;
import java.util.*;

// CSUN COMP 182-02 Fall 2019  (No private variables)
// buble sort program that:
//   reads n no. of data from KB/File
//   reads k no. of data to print per line from KB/File
//   reads n data from KB/File and stores them in array arr
//   prints array arr, k numbers per line before sorting
//   sorts input using bubble sort
//   prints array arr, k numbers per line after  sorting
//   Author : Dr. Gh. Dastghaibyfard
//   To compile:  javac sortd.java
//   To excecute: java sortd < inputfile name
//   Name:
public class sortd {
	public static void prt(String s) {
		System.out.print(s);
	}

	// print arr, k numbers per line
	private void printarr(double arr[], int n, int k) {
		int j = 0;
		for (double i : arr) {
			System.out.printf("%.3f ", i);
			j++;
			if (j % k == 0)
				prt("\n");
		}
	}

	// sort arr using bubble sort,
	private void bubblesort(double arr[], int n) {
		for (int i = 1; i < n; i++)
			for (int j = 0; j < n - i; j++)
				if (arr[j] > arr[j + 1]) {
					double tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
	}

	public static void main(String[] args) throws Exception {
		// try{
		sortd bb = new sortd();// No private variables
		int i, n, k;
		Scanner inf = new Scanner(System.in);
		// read No. of data to read
		n = inf.nextInt();
		double arr[] = new double[n];
		// read How many data to print per line
		k = inf.nextInt();
		// read n input from KB/File
		for (i = 0; i < n; i++) {
			// read n input from KB/File
			// System.out.printf("\nPlease enter data %4d: ", i+1);
			arr[i] = inf.nextDouble();
		}
		prt("\n  Input before sorting...\n");
		bb.printarr(arr, n, k);
		bb.bubblesort(arr, n);
		prt("\n  Input before sorting...\n");
		bb.printarr(arr, n, k);

		inf.close();
		// }catch(Exception e){prt("\nOops! Read Exception: " + e);}
	}
}