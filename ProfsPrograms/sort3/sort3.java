import java.io.*;
import java.util.*;

//Implementing internal buble sort Algorithms
// CSUN COMP 182-02 Fall 2019  Version 3 (private variables)
// bublle sort program that:
//   Reads input from KB or data file and stores them in array
//    arr, prints input k numbers per line
//   sorts input using bubble sort and computes number of
//   comparisons and swaps and
//   prints sorted, k numbers per line
//   Author : Dr. Gh. Dastghaibyfard
//
// Name:
public class sort3 {
	// public class bubsort{
	protected int arr[], n, k;
	// protected int n, k;

	// Constructor of sort3
	sort3(int size, int kk) {
		n = size;
		k = kk;
		arr = arr = new int[n];
	}

	public static void prt(String s) {
		System.out.print(s);
	}

	// print arr, k numbers per line
	private void printarr(String s) {
		prt("\n k = " + k);
		prt(s);// Array is as follows:\n");
		for (int i = 0; i < n; i++) {
			prt(arr[i] + " ");
			if ((i + 1) % k == 0)
				prt("\n");
		}
		prt("\n");
	}

	// sort arr using bubble sort, compute number of
	// comparison and swaps and print sorted array
	private void bublesort() {
		int swaps = 0;
		int comps = n * (n - 1) / 2;
		for (int i = 1; i < n; i++)
			for (int j = 0; j < n - i; j++)
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
					swaps++;
				}
		printarr("\ninput after sorting...\n");
		prt("\nNo. of comparisons = " + comps);
		prt("\nNo. of       swaps = " + swaps + "\n");
	}

	// main program
	public static void main(String args[]) throws Exception {
		int i, m, p;
		try {
			// To read input from KB just type: java sort3
			// To read input from File just type: java sort3 < filename
			// and comment lines 64, 66 and 71
			Scanner inf = new Scanner(new InputStreamReader(System.in));

			prt("\nPlease enter no. data to sort.. n >= 5: ");
			m = inf.nextInt();// read No. of data to read

			prt("\nPlease enter how many data per line: ");
			p = inf.nextInt();// read How many data to print per line

			sort3 bb = new sort3(m, p);// call sort3 constructor

			for (i = 0; i < m; i++) {// read m input from KB/File
				System.out.printf("\nPlease enter data %2d: ", i + 1);
				bb.arr[i] = inf.nextInt();
			}
			bb.printarr("\n  Input before sorting...\n");
			bb.bublesort();

			inf.close();
		} catch (Exception e) {
			prt("\nOops! Read Exception: " + e);
		}
	} // end main
}// end class sort3