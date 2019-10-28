/*
    Write an efficient java program to implement an integer doubly linked list
    Dequeue which insertion and deletion can be than at either end. You have to
    write 6 methods: add front, delete front, add rear, delete rear, print
    forward (left to right) and print backward (right to left). After each
    addition or deletion dequeue elements are printed forward or backward
    respectively.

    Assume your java program is in driver.java file, where driver is the first 5
    characters of your last name.

    To compile: javac driver.java

    To execute: java driver < any data file name

    Your main method should be as follow:

    public static void main(String args[]) {

    driver dq = new driver (); // driver is the first 5 characters of your last name

    try{

    Scanner inf = new Scanner (System.in);

    // Read input from KB/ File

    while(inf.hasNext()){

    // read operation type (optype):

    //1:add front, 2:delete front, 3:add rear and delete rear

    optype = inf.nextInt();

    switch (optype){

    case 1: x = inf.nextInt(); // read x

    dq.addfront(x);

    dq.printfwd(); // print forward dequeuer elements

    break;

    case 2: j = dq.delfront();// delete front

    if(j……….

    dq.printbwd(); // print backward dequeuer elements

    break;

    case 3: x = inf.nextInt(); // read x

    dq.addrear(x);

    dq.printfwd(); // print forward dequeuer elements

    break;

    default: j = dq.delrear();// delete front

    if(j……….

    dq.printbwd(); // print backward dequeuer elements

    }//end switch

    }// end while

    inf.close();// close input file

    }catch (Exception e) {prt("\nException " + e + "\n");}

    }// end main method

    NOTE: Projects will not be graded if:

    Your complete project is not in a SINGLE driver.java file, where driver is the
    first 5 characters of your last name.

    It does not read input from System.in. i.e. command prompt.



    Sample data file can be as follow:

    1 100 2 2 3 500 3 600 3 250 4 1 150 1 220 2 4 1 50 3 55 1 20 1 80 3 90
*/

import java.util.Scanner;
import java.util.LinkedList;

public class driver {

    public void addfront(int x) {
        System.out.print("Add Front");
    }

    public void printfwd() {
        System.out.print("Print Forward");
    }

    public int delfront() {
        return 0;
    }

    public int addrear(int x) {
        return 0;
    }

    public int delrear() {
        return 0;
    }

    public void printbwd() {
        System.out.print("hi");
    }

    public static void main(String args[]) {
        driver dq = new driver(); // driver is the first 5 characters of your last name
        try {
            Scanner inf = new Scanner(System.in);

            // Read input from KB/ File
            while (inf.hasNext()) {
                // read operation type (optype):
                /*
                 * 1:add front 2:delete front 3:add rear and delete rear
                 */
                int optype = inf.nextInt();

                switch (optype) {
                case 1:
                    int x = inf.nextInt(); // read x
                    dq.addfront(x);
                    dq.printfwd(); // print forward dequeuer elements
                    break;
                case 2:
                    int j = dq.delfront();// delete front
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