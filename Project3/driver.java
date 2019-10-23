/*
    CSUN Department of Computer Science
    COMP 182 Data Structures and Program Design Fall 2019
    Project 3 (100 Pts), Infix to Postfix - Due: Oct. 31, 19

    NOTE: Projects will not be graded if:
    - Your complete project is not in a SINGLE xxxxx.java file, where xxxxx is the first 5 characters of your last name.
    - It does not read input from System.in. i.e. command prompt.

    Write an efficient java program to convert and print an infix expression to postfix expression. You can use Java stack methods. Assume your java program is in xxxxx.java file, where xxxxx is the first 5 characters of your last name.
    
    To compile: 
    ```bash
    $ javac xxxxx.java
    ```
    
    To execute:
    ```bash 
    $ java xxxxx < any data file name
    ```

    Your main method should be as follow:
    ```java
        public static void main(String args[]) {
            xxxxx p = new xxxxx (); // xxxxx is the first 5 characters of your last name
            String iexp, pexp;  //infix postfix expression            
            try{
                Scanner inf = new Scanner (System.in);                    
                // Read input from KB/ File
                while(inf.hasNext()){
                    // read next infix expression                                
                    iexp = inf.next();
                    // Assume method name to convert infix to postfix is postfix
                    pexp = p.postfix(iexp);
                    System.out.printf("\nPosfix of %s is: %s", iexp, pexp);
                }// end while
                inf.close();// close input file
            }
            catch (Exception e) {
                prt("\nException " + e + "\n");
            }
        }// end main method
    ```
*/

import java.util.Stack;
import java.util.Scanner;

public class driver {

    public String postfix(String infixToPostfixString){
        char tempchar;
        Stack<Character> operandStack = new Stack<Character>();
        Stack<Character> outputStack = new Stack<Character>();
        for(int i = 0; i < infixToPostfixString.length(); i++){
            tempchar = infixToPostfixString.charAt(i);
            if(Character.isLetter(tempchar)){
                outputStack.push(tempchar);
            }
            else{
                while(!operandStack.empty()){
                    if(operandStack.peek() > tempchar){
                        outputStack.push(tempchar);
                    }
                    else{
                        outputStack.push(infixToPostfixString.charAt(i+1));
                    }
                }
            }
        }
        infixToPostfixString = outputStack.toString();
        return infixToPostfixString.replaceAll("\\[", "").replaceAll("]", "").replaceAll(",", "");
    }

    public static void main(String[] args) {
        driver p = new driver();
        String iexp = "", pexp = ""; // infix postfix expression
        try {
            Scanner inf = new Scanner(System.in);

            // Read input from KB/ File
            while (inf.hasNext()) {
                // read next infix expression
                iexp = inf.next();

                // Assume method name to convert infix to postfix is postfix
                pexp = p.postfix(iexp);

                System.out.printf("\nPosfix of %s is: %s\n", iexp, pexp);
            } // end while

            inf.close();// close input file
        } catch (Exception e) {
            System.out.print("\nException " + e + "\n");
        }
    }
}