/*
 * SE1021
 * Winter 2017
 * Lecture 16
 * Name: Brad Dennis
 */
package lecture11;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * A Simple String Calculator.  It accepts operands in the form of "n,n.." and performs
 * mathematical operations on them.
 */
public class StringCalculator {

    private static final Logger LOGGER = Logger.getLogger(StringCalculator.class.getName());
    public static final String DELIMITER = ",";
    private ArrayList<String> history;

    public StringCalculator(){
        setupLogger();
        history = new ArrayList<>();

    }

    /**
     * Adds a string of numbers together.
     * @param input a list of atleast 2 operands delimited by a ','.
     * @return the result of the add
     * @throws IllegalArgumentException
     */
    public int add(String input) throws  IllegalArgumentException {
        String[] operands = input.split(DELIMITER);

        if (operands.length < 2) {
            LOGGER.warning("IllegalArgumentException: Add requires 2 or more operands.");
            throw new IllegalArgumentException("Add requires 2 or more operands.");
        }

        int total = 0;

        for (String operand: operands ) {
            try {
                total += Integer.parseInt(operand);
            } catch (NumberFormatException e) {
                LOGGER.warning(e.getMessage());
                LOGGER.info("NumberFormatException: Add requires each argument to be a number.");
                LOGGER.info(historyAsString());
                throw e;
            } finally {
                //The finally block ALWAYS executes when the try block exits.
                history.add("add: " + input);
            }
        }

        return total;
    }

    private void setupLogger() {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "%1$tF %1$tT %4$s %2$s %5$s%6$s%n");
        LOGGER.setUseParentHandlers(false);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        SimpleFormatter formatter = new SimpleFormatter();
        consoleHandler.setFormatter(formatter);
        consoleHandler.setLevel(Level.SEVERE);

        try {
            FileHandler fileHandler = new FileHandler("calculator.%u.%g.log");
            fileHandler.setFormatter(formatter);

            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }


        LOGGER.addHandler(consoleHandler);

    }

    private String historyAsString() {
        String buffer = "";
        for (String s: history ) {
            buffer += s;
            buffer += "\n";
        }

        return buffer;
    }
}
