/*
    Name: Jaime Garcia Garcia
    Date: 10-27-2019
    Application: Infix to Postfix
    Description: This program accepts a text file with infix math expression and convert them into postfix expression.
    
    How to Run the Program:
    1. Compile Program
        ```bash
        $ javac driver.java
        ```

    2. Execute Program with text file
        ```bash
        $ java driver < <YourTextFile>.txt
        ```
*/

import java.util.Stack;
import java.util.Scanner;

public class driver {
    public String postfix(String infixToPostfixString){
        // Preparing variables and data structure the postfix()  
        char tempchar;
        Stack<Character> operatorStack = new Stack<Character>();
        Stack<Character> outputStack = new Stack<Character>();
        int lengthOfString =  infixToPostfixString.length();
        
        // The For Loop goes through the Infix string one character at the time.
        for(int i = 0; i < lengthOfString; i++){
            // Temporarly sort the inputed string character base of index i
            tempchar = infixToPostfixString.charAt(i);
            
            // Check if character is a Letter, then the character is push to the output stack.
            if(Character.isLetter(tempchar)){
                outputStack.push(tempchar);
            }
            // If character is '(' it will be push to the operatorStack 
            else if(tempchar == '('){
                operatorStack.push(tempchar);
            }
            // If character is ')' it will push the operator to the output until it reach the ')' which will be pop off after the loop 
            else if(tempchar == ')'){
                while(!operatorStack.isEmpty() && operatorStack.peek() != '('){
                    outputStack.push(operatorStack.pop());
                }
                operatorStack.pop();
            }
            // Base off the presedence of the operators and operator stack, the operator stack will pop and the push to the output stack. 
            // Then the operator character will be pushed to operator stack 
            else{
                while (!operatorStack.isEmpty() && checkPresedence(operatorStack.peek()) >= checkPresedence(tempchar)){ 
                    outputStack.push(operatorStack.pop()); 
                } 
                operatorStack.push(tempchar); 
            }
        }// End For Loop

        // Clear out any remaining operators in the operator stack to the output stack
        while(!operatorStack.isEmpty()){
            outputStack.push(operatorStack.pop()); 
        }

        // Convert the output stack to a string and strip out all special text formating.
        infixToPostfixString = outputStack.toString().replaceAll("\\[", "").replaceAll("]", "").replaceAll(",", "").replaceAll(" ", "");
        
        return infixToPostfixString;
    }

    // checkPresedence() will check which operator has the hightest precedence
    public int checkPresedence(char charToCheck){
        if(charToCheck == '^'){
            return 3;
        }
        else if(charToCheck == '*' || charToCheck == '/'){
            return 2;
        }
        else if(charToCheck == '-' || charToCheck == '+'){
            return 1;
        }
        return -1;
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