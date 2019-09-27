//	 CSUN Fall 19  COMP182-2
//  sortedlist.java	(NON GENERIC)
//  Inserting in a sorted list and 
//  Performing binary search in a sorted list 
//
//  NAME:						ID:
import java.util.*;
//*************  Class Definition *************
public class sortedlist{
	// class Variables
	protected int last, arr[]; 	

	sortedlist(int n){
		// List Constructor
		last = 0;
		//Allocate n+1 Space for array		 	 
		arr = new int[n+1];
	}

	// insert x in a sorted list
	public void insertsorted(int x){
		int i;
		// Adds the first integer to the array
		if(last == 0){
			arr[1] = x;
			last++;
			System.out.printf("\nInsert %d in a sorted list\n", x);
			return;
		}
		// Place the next integer in the correct order
		for(i = last; i >= 1 && arr[i] > x; i--){
			arr[i + 1] =  arr[i];
		}
		// Assign the next integer in
		arr[i + 1] = x;
		last++;
		// Print the integer that was just inserted
		System.out.printf("Insert %d in a sorted list\n", x);
	}

	// binary search for x in a sorted list
	public int binsearch(int x){
		int mid = 0; // Assume x is not found
		int pointer = 0; // Help point out the which direction the integers is located 
		int getArrayLength = arr.length - 1; // A manipulable variable to help locate the variable
		
		//Prints out the number to to search for
		System.out.printf("binary search for %d in a sorted list\n", x);

		// This loop will track down the desire integer. If that fails then the method will return 0
        while (pointer <= getArrayLength) {
			// Take the length of the array and slip it in half to find the integer.
			// Base off getArrayLength and pointer the midpoint can change to locate the Integer 
            mid = pointer + (getArrayLength - pointer) / 2;
			
			// Check if the integer in the midpoint 
            if (arr[mid] == x){
				// 1 = true
                return 1; 
			}
			
			// If the integer is greater, don't check the left 
            if (arr[mid] < x){
                pointer = mid + 1; 
			}
            // If the integer is less, don't check the right
			else{
				getArrayLength = mid - 1; 
			}
        }
        // if we reach here, then element was not present 
        return mid;
	}

	// This method will take the array and contruct a string in easy to print format
	public String toString() {
		String s = "\n[";
		for (int i = 1; i < arr.length; i++){
			if(i == 1){
				s += arr[i];
			}
			else{
				s += ", " + arr[i];
			}
		}
		return s + "]\n\n";
	}

	public static void main(String args[]){
		int j, n, m, k, x;
		try{
			Scanner inf = new Scanner(System.in);		
			// read No. of data to read
			n = inf.nextInt();
			
			// Create a List of type Integer of size n
			sortedlist Lint = new sortedlist(n);	
			
			// Read n element and insert in a sorted list
			for(j = 1; j <= n; j++){
				x = inf.nextInt(); // read element
				Lint.insertsorted(x);
			}
			
			System.out.printf("\n%d inserted data are as follow:", n);
			System.out.print(Lint.toString());
			// read No. of data to search
			m = inf.nextInt();	
			for(j = 1; j <= m; j++){
                // read data to search
                x = inf.nextInt();
                k = Lint.binsearch(x);
                if(k == 1){
                    System.out.print(x + " is found!\n");
                }
                else{
                    System.out.print(x + " Ooops is not in the list?\n");
                }
            }
			inf.close();
		} 
		catch (Exception e) {
			System.out.printf("Exception %d\n", e);
		}
	}// end main method	
}// end class sortedlist