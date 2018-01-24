/*
 * SE1021
 * Winter 2018
 * Lecture 19
 * Name: Brad Dennis
 * Created: 1/19/2016
 * Revised: 1/17/2018
 */
package lecture10;

import java.io.FileInputStream;
import java.util.Random;
import java.util.Scanner;

/**
 * A simple app to demonstrate checked and unchecked exceptions.
 */
public class ExceptionsDemoApp {

    public static void main(String[] args) {

        doUncheckedExceptions();
        //doCheckedExceptions();
        //doManuallyCheckedExceptions();
    }


    private static void doUncheckedExceptions() {
        Scanner stdIn = new Scanner(System.in);
        int randomNumber = new Random().nextInt(10) + 1;
        int counter = 0;

        System.out.print("Guess the integer between 1 and 10 that I am thinking (q to quit): ");
        String response = stdIn.next();

        while (!response.equalsIgnoreCase("q")) {
            counter++;
            int number = Integer.parseInt(response);

            if (number == randomNumber) {
                System.out.println("You guessed it in " + counter + " guesses!");
                break;
            } else if (Math.abs(number - randomNumber) < 3) {
                System.out.println("Warm");
            } else {
                System.out.println("Cold");
            }

            System.out.print("Guess again: ");
            response = stdIn.next();
        }

        System.out.println("Game Over!");

        // https://docs.oracle.com/javase/8/docs/api/java/lang/NumberFormatException.html
    }

    private static void doCheckedExceptions() {
        /*

        FileInputStream fis = null;
        // This constructor FileInputStream(File filename)
        // throws FileNotFoundException which is a checked exception
        // CTRL+ALT+T in IntelliJ
        fis = new FileInputStream(".gitignore");
        int k;
	    // Method read() of FileInputStream class also throws
	    // a checked exception: IOException
        while ((k = fis.read()) != -1) {
            System.out.print((char) k);
        }
        // The method close() closes the file input stream
        // It throws IOException
        fis.close();
*/
    }

    private static void doManuallyCheckedExceptions() {

        GameLogic logic = new ExceptionsDemoApp().new GameLogic(10);

        Scanner stdIn = new Scanner(System.in);
        int randomNumber = new Random().nextInt(10) + 1;
        int counter = 0;

        System.out.print("Guess the integer between 1 and 10 that I am thinking (q to quit): ");
        String response = stdIn.next();

        while (!response.equalsIgnoreCase("q")) {
            counter++;

            if (logic.wasGuessed(response)) {
                System.out.println("You guessed it in " + counter + " guesses!");
                break;
            } else if (logic.isWarm(response)) {
                System.out.println("Warm");
            } else if (logic.isCold(response)){
                System.out.println("Cold");
            }

            System.out.print("Guess again: ");
            response = stdIn.next();
        }

        System.out.println("Game Over!");
    }

    class GameLogic {
        private final int randomNumber;

        public GameLogic(int max) {
            randomNumber = new Random().nextInt(max) + 1;
        }

        //http://docs.oracle.com/javase/8/docs/api/java/lang/NumberFormatException.html
        public boolean wasGuessed(String input) throws NumberFormatException  {
            int guess = Integer.parseInt(input);
            return guess == randomNumber;
        }

        public boolean isWarm(String input) /* throws GameException */  {//
            boolean isWarm = false;

            try {
                int guess = Integer.parseInt(input);
                if (Math.abs(guess - randomNumber) < 3) {
                    isWarm = true;
                }
            } catch (NumberFormatException e) {
                //throw new GameException();
            }

            return isWarm;
        }

        public boolean isCold(String input) /*throws GameRuntimeException */ {
            boolean isCold = false;

            try {
                int guess = Integer.parseInt(input);
                if (Math.abs(guess - randomNumber) >= 3) {
                    isCold = true;
                }
            } catch (NumberFormatException e) {
                throw new GameRuntimeException();
            }

            return isCold;
        }
    }

    // When to use checked vs. unchecked?
    // https://docs.oracle.com/javase/tutorial/essential/exceptions/runtime.html
    // Here's the bottom line guideline: If a client can reasonably be
    // expected to recover from an exception, make it a checked exception.
    // If a client cannot do anything to recover from the exception, make
    // it an unchecked exception.

    class GameException extends Exception {
        public GameException() {
            super("The response was not valid.");
        }
    }


    class GameRuntimeException extends RuntimeException {
        public GameRuntimeException() {
            super("The response was not valid.");
        }
    }

}