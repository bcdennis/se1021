/*
 * SE1021
 * Winter 2017
 * Lecture 16
 * Name: Brad Dennis
 */
package lecture11;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Scanner;

/**
 * A Simple String Calculator App
 */
public class StringCalculatorApp {

    private StringCalculator calculator;


    public StringCalculatorApp() {
        calculator = new StringCalculator();

    }

    public void startApp() {
        System.out.println("Welcome to the Calculator!");

    }


    public static void main(String[] args) throws Exception {
       StringCalculatorApp app = new StringCalculatorApp();
        //app.startApp();
        app.executeTests();


    }

    protected void executeTests() {
       // testAdd();
        testAddFromFile();
    }

    private void testAddFromFile()  {
        try {
            //Step 1:  Read in the contents of the file into memory.
            List<String> lines = Files.readAllLines(Paths.get("add-tests.txt"));
            //Step 2:  Process the contents of the file, line by line.
            for(String line: lines) {
                //Step 3: Parse the line into it's constituent parts.
               String[] parts = line.split(":");
                //Step 4: Verify data
                if (parts.length == 2) {
                    //Step 5:  Do stuff with the data.
                    if (calculator.add(parts[1]) == Integer.parseInt(parts[0])) {
                        System.out.println("Testing " + parts[1] + " = " + parts[0] + "...passed!");
                    } else {
                        System.out.println("...failed");
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
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

        //Another test, does it work with 3 operands.
        System.out.print("Test: Adding two strings");
        expected = 3;
        if (calculator.add("1,1,1") == expected) {
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
