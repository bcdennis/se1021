/**
 * SE1021
 * Winter 2016
 * Lecture 16
 * Name: Brad Dennis
 * Created: 1/21/2016
 */
package Winter2016.lecture16;

/**
 * A Simple String Calculator App
 */
public class StringCalculatorApp {

    StringCalculator calculator;


    public StringCalculatorApp() {
        calculator = new StringCalculator();

    }

    public void startApp() {
        System.out.println("Welcome to the Calculator!");

    }


    public static void main(String[] args) {
       StringCalculatorApp app = new StringCalculatorApp();
        //app.startApp();
        app.executeTests();

    }

    protected void executeTests() {
        testAdd();


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
