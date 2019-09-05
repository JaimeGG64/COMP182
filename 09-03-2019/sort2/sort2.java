
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
//   Name: Jaime Garcia

import java.io.InputStreamReader;
import java.util.Scanner;
import java.text.DecimalFormat;

public class sort2 {
	public static void prt(String s) {
		System.out.print(s);
	}

	// Generate and print n integers in the range of a....b
	private void genarr(double arr[], int n, double a, double b, int k) {
		double range = b - a + 1;
		for (int i = 0; i < n; i++)
			arr[i] = ((double) (Math.random() * range)) + a;
		prt("\n        Input before sorting...\n");
		printarr(arr, n, k);
	}

	// print arr, k numbers per line
	private void printarr(double arr[], int n, int k) {
		int j = 0;
		DecimalFormat formatDec = new DecimalFormat("0.00");
		try{
			for (double i : arr) {
				prt(formatDec.format(i) + " ");
				j++;
				if (j % k == 0)
					prt("\n");
			}
		}
		catch(Exception e){
			System.out.print("Cannot print numbers");
		}
	}

	// sort arr using bubble sort, compute number of
	// comparison and swaps and print sorted array
	private void bubblesort(double arr[], int n, int k) {
		int swaps = 0;
		int comps = n * (n - 1) / 2;
		for (int i = 1; i < n; i++)
			for (int j = 0; j < n - i; j++)
				if (arr[j] > arr[j + 1]) {
					double tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
					swaps++;
				}
		prt("\n        Input after sorting...\n");
		printarr(arr, n, k);
		prt("\n    No. of comparisons = " + comps);
		prt("\n    No. of       swaps = " + swaps + "\n");
	}

	public static void main(String[] args) throws Exception {
		sort2 bb = new sort2();
		int n = 0, k = 0;
		double a = 0, b = 0;
		try {
			Scanner getUserInput = new Scanner(new InputStreamReader(System.in));
			System.out.println("The number of integers you want generated");
			do {
				n = getUserInput.nextInt();
				if (n < 50) {
					System.out.println("Must be greater than " + Integer.toString(50));
				}
			} while (n < 50);
			System.out.println("Enter a minimum");
			a = getUserInput.nextDouble();

			System.out.println("Enter a maximum");
			do {
				b = getUserInput.nextDouble();
				if (a > b) {
					System.out.println("Number must be greater than " + Double.toString(a));
				}
			} while (a > b);

			System.out.println("How many integers do you want per line");
			do {
				k = getUserInput.nextInt();
				if (n < 0) {
					System.out.println("Must be greater than " + Double.toString(0));
				}
			} while (n < 0);

			getUserInput.close();
		} 
		catch (Exception e) {
			System.out.println("You broke the program.");
		}
		double arr[] = new double[n];
		bb.genarr(arr, n, a, b, k);// generate and print
		bb.bubblesort(arr, n, k); // sort and print
	}
}