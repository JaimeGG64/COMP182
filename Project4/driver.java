/*
    Program: Doubly Linked List Dequeue 
    Name: Jaime Garcia Garcia
    Date: 10-31-2019
    Description: 

    How to Run The Program:
    1. How to Compile:
        ```bash
        $ javac garciaj.java
        ```

    2. How to Execute
        ```bash
        $ java garcia < <YourTextFile>.txt
        ```
*/

import java.util.Scanner;

public class driver {
    Node front, rear;
    class Node {
		Node ll, rl;
		int data;

		Node(int x) {
			data = x;
			ll = rl = null;
		}
	}

    public void addfront(int x) {
        Node tmp = new Node(x);
		if(front == null){
            front = tmp;
            rear = tmp;
        }
        else{
            tmp.rl = front;
            front.ll = tmp;
            front = tmp;
        }
    }

    public void printfwd() {
        for(Node cur = front; cur != null; cur = cur.rl){
            System.out.print(cur.data + " ");
        }
        System.out.print("\n");
    }

    public int delfront() {
        if(front == null){
            return 0;
        }
        else{
            if(front == rear){
                front = null;
                rear = null;
                return 1;
            }
            else{
                Node tmp = front.rl;
                front = tmp;
                front.ll = null;
                return 1;
            }
        }
    }

    public void addrear(int x) {
        Node tmp = new Node(x);
		if(rear == null){
            rear = tmp;
            front = tmp;
        }
        else{
            tmp.ll = rear;
            rear.rl = tmp;
            rear = tmp;
        }
    }

    public int delrear() {
        if(rear == null){
            return 0;
        }
        else{
            if(rear == front){
                rear = front = null;
                return 1;
            }
            else{
                Node tmp = rear.ll;
                rear = tmp;
                rear.rl = null;
                return 1;
            }
        }
    }

    public void printbwd() {
        for(Node cur = rear; cur != null; cur = cur.ll){
            System.out.print(cur.data + " ");
        }
        System.out.print("\n");
    }

    public static void main(String args[]) {
        // driver is the first 5 characters of your last name
        driver dq = new driver(); 
        try {
            Scanner inf = new Scanner(System.in);
            int x, j;
            // Read input from KB/ File
            while (inf.hasNext()) {
                // read operation type (optype):
                /*
                    1:add front 
                    2:delete front 
                    3:add rear and delete rear
                 */
                int optype = inf.nextInt();

                switch (optype) {
                case 1: 
                    // read x
                    x = inf.nextInt(); 
                    dq.addfront(x);
                    dq.printfwd(); // print forward dequeuer elements
                    break;
                case 2:
                    j = dq.delfront();// delete front
                    if (j == 1) {
                        dq.printbwd(); // print backward dequeuer elements
                    }
                    break;
                case 3: 
                    x = inf.nextInt(); // read x
                    dq.addrear(x);
                    dq.printfwd(); // print forward dequeuer elements
                    break;
                default:
                    j = dq.delrear();// delete front
                    if (j == 1) {
                        dq.printbwd(); // print backward dequeuer elements
                    }
                }// end switch
            } // end while
            inf.close();// close input file
        } catch (Exception e) {
            System.out.print("\nException " + e + "\n");
        }
    }// end main method
}