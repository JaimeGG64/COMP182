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
		if(last == 0){
			arr[1] = x;
			last++;
			System.out.printf("\nInsert %d in a sorted list\n", x);
			return;
		}
		for(i = last; i >= 1 && arr[i] > x; i--){
			arr[i + 1] =  arr[i];
		}
		arr[i + 1] = x;
		last++;
		System.out.printf("Insert %d in a sorted list\n", x);
	}
	// binary search for x in a sorted list
	public int binsearch(int x){
		int mid = 0; // Assume x is not found
		System.out.printf("binary search for %d in a sorted list\n", x);
		int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
            // Check if x is present at mid 
            if (arr[m] == x) 
                return 1; 
            // If x greater, ignore left half 
            if (arr[m] < x) 
                l = m + 1; 
            // If x is smaller, ignore right half 
            else
                r = m - 1; 
        } 
        // if we reach here, then element was 
        // not present 
        return mid; 
	}

	public String toString() {
		String s = "[";
		for (int i = 1; i < arr.length; i++){
			if(i == 1){
				s += arr[i];
			}
			else{
				s += ", " + arr[i];
			}
		}
		return s + "]\n";
	}

	public static void main(String args[]){
		int j, n, m, k, x;
		try{
			Scanner inf = new Scanner(System.in);		
			n = inf.nextInt();// read No. of data to read
			
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
                    System.out.print(x + " Found\n");
                }
                else{
                    System.out.print(x + " Not\n");
                }
            }
			inf.close();
		} 
		catch (Exception e) {
			System.out.printf("Exception %d\n", e);
		}
	}// end main method	
}// end class sortedlist