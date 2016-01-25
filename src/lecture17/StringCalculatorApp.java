/**
 * SE1021
 * Winter 2016
 * Lecture 16
 * Name: Brad Dennis
 * Created: 1/21/2016
 */
package lecture17;

import java.util.Scanner;

/**
 * A Simple String Calculator App
 */
public class StringCalculatorApp {
    private static final String ADD_OPTION = "1";
    private static final String SUBTRACT_OPTION = "2";
    private static final String EXIT_OPTION = "0";


    StringCalculator calculator;


    public StringCalculatorApp() {
        calculator = new StringCalculator();

    }

    public void startApp() {
        System.out.println("Welcome to the Calculator!");
        Scanner stdIn = new Scanner(System.in);
        boolean exiting = false;

        do {
            displayMenu();
            String response = stdIn.nextLine();

            switch(response) {
                case ADD_OPTION:
                    System.out.println(calculator.add(getOperands(stdIn)));
                    break;
                case SUBTRACT_OPTION:
                    System.out.println(calculator.subtract(getOperands(stdIn)));
                    break;
                case EXIT_OPTION:
                    System.out.println("Bye!");
                    exiting = true;
                    break;
                default:
                    System.out.println("Unrecognized menu option.");
            }
        } while (!exiting);

    }

    private void displayMenu() {
        System.out.println("Calculator menu");
        System.out.println("**************");
        System.out.println("\t" + ADD_OPTION + " : Add");
        System.out.println("\t" + SUBTRACT_OPTION + " : Subtract");
        System.out.println("\t" + EXIT_OPTION + " : Exit");
        System.out.println("**************");
        System.out.println("Enter menu option: ");
    }

    private String getOperands(Scanner in) {
        System.out.println("Enter in a list of numbers separated by commas:");
        return in.nextLine();
    }


    public static void main(String[] args) {
       StringCalculatorApp app = new StringCalculatorApp();
        //app.startApp();
        app.executeTests();

    }

    protected void executeTests() {
        testAdd();
        testSubtract();

    }

    private void testSubtract() {
        //Simple test, does it work with 2 operands.
        System.out.print("Test: Subtracting two strings");
        int expected = 0;
        if (calculator.subtract("1,1") == expected) {
            System.out.println("...passed!");
        } else {
            System.out.println("...failed");
        }

        // Simple test, does it throw an exception for one or no operands?
        System.out.print("Test: Throws IllegalArgumentException if no operands.");
        try {
            calculator.add("1");
            System.out.println("...failed!");
        } catch (IllegalArgumentException ex){
            System.out.println("...passed!");
        }

        //Simple test, does it throw an exception if an operand isn't a number?
        System.out.print("Test: Throws NumberFormatException if operand isn't a number.");
        try {
            calculator.add("1, a");
            System.out.println("...failed!");
        } catch (NumberFormatException ex){
            System.out.println("...passed!");
        }


    }

    private void testAdd() {
        //Simple test, does it work with 2 operands.
        System.out.print("Test: Adding two strings");
        int expected = 2;
        if (calculator.add("1,1") == expected) {
            System.out.println("...passed!");
        } else {
            System.out.println("...failed");
        }

        // Simple test, does it throw an exception for one or no operands?
        System.out.print("Test: Throws IllegalArgumentException if no operands.");
        try {
            calculator.add("1");
            System.out.println("...failed!");
        } catch (IllegalArgumentException ex){
            System.out.println("...passed!");
        }

        //Simple test, does it throw an exception if an operand isn't a number?
        System.out.print("Test: Throws NumberFormatException if operand isn't a number.");
        try {
            calculator.add("1, a");
            System.out.println("...failed!");
        } catch (NumberFormatException ex){
            System.out.println("...passed!");
        }


    }
}
