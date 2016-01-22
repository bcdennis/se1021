/**
 * SE1021
 * Winter 2016
 * Lecture 16
 * Name: Brad Dennis
 * Created: 1/21/2016
 */
package package17;

import java.util.ArrayList;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * A Simple String Calculator
 */
public class StringCalculator {

    private static final Logger LOGGER = Logger.getLogger(StringCalculator.class.getName());
    private ArrayList<String> history;

    public StringCalculator() {
        setupLogger();
        history = new ArrayList<>();

    }

    public int add(String input) throws IllegalArgumentException {
        String[] operands = input.split(",");

        if (operands.length < 2) {
            LOGGER.warning("IllegalArgumentException: Add requires 2 or more operands.");
            throw new IllegalArgumentException("Add requires 2 or more operands.");
        }

        int total = 0;

        for (String operand : operands) {
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

    public int subtract(String input) throws IllegalArgumentException {
        String[] operands = input.split(",");

        if (operands.length < 2) {
            LOGGER.warning("IllegalArgumentException: Subtract requires 2 or more operands.");
            throw new IllegalArgumentException("Subtract requires 2 or more operands.");
        }
        int total = 0;

        try {
            total = Integer.parseInt(operands[0]);
            for (int i = 1; i < operands.length; i++) {
                total -= Integer.parseInt(operands[i]);
            }
        } catch (NumberFormatException e) {
            LOGGER.warning(e.getMessage());
            LOGGER.info("NumberFormatException: Add requires each argument to be a number.");
            LOGGER.info(historyAsString());
            throw e;
        } finally {
            //The finally block ALWAYS executes when the try block exits.
            history.add("add: " + input);
        }

        return total;

    }

    private void setupLogger() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        SimpleFormatter consoleFormatter = new SimpleFormatter();

        consoleHandler.setFormatter(consoleFormatter);

        LOGGER.setUseParentHandlers(false);
        LOGGER.addHandler(consoleHandler);
    }

    private String historyAsString() {
        String buffer = "";
        for (String s : history) {
            buffer += s;
            buffer += "\n";
        }

        return buffer;
    }
}
