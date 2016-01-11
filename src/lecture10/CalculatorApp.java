/**
 * SE1021
 * Winter 2016
 * Lecture 10
 * Name: Brad Dennis
 * Created: 1/06/2016
 */
package lecture10;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

/**
 * This is a simple program that will be used as part of the
 * student workshop.
 */
public class CalculatorApp extends JFrame {
    private int currentTotal = 0;
    private final JLabel totalLabel;
    private final JTextField operatorField;
    private final JButton addButton;
    private final JButton subtractButton;
    private final JButton multiplyButton;
    private final JButton divideButton;

    public CalculatorApp() {
        // Step 1:  Configure the frame
        setTitle("Simple Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Step 2: Create components
        totalLabel = new JLabel("Total: 0");
        operatorField = new JTextField(30);
        addButton = new JButton(" + ");
        subtractButton = new JButton(" - ");
        multiplyButton = new JButton(" * ");
        divideButton = new JButton(" / ");

        // Step 3: Add components to the GUI
        add(totalLabel);
        add(operatorField);
        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);

    }

    public static void main(String[] args) {
        CalculatorApp calculatorApp = new CalculatorApp();
        calculatorApp.setVisible(true);
    }
}
