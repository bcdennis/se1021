/**
 * SE1021
 * Winter 2016
 * Lecture 14
 * Name: Brad Dennis
 * Created: 1/15/2016
 */
package lecture14;


import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

/**
 * This is a simple program to demonstrate Box & BorderLayouts.
 */
public class GridBagDemoApp extends JFrame {

    public GridBagDemoApp() {
        // Step 1:  Configure the frame
        setTitle("Gridbag Demo");
        setSize(500, 300);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        // Step 2: Create components
        JLabel termsLabel = new JLabel("Terms:");

        JTextArea instructionsText = new JTextArea();
        instructionsText.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor "
         + "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco "
         + "laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit "
         + "esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa "
         + "qui officia deserunt mollit anim id est laborum.");

        instructionsText.setSize(300,400);

        instructionsText.setLineWrap(true);
        instructionsText.setEditable(false);

        JLabel agreeLabel = new JLabel("Do you agree to the terms?");
        JCheckBox yesCheckbox = new JCheckBox("Yes");
        JCheckBox noCheckbox = new JCheckBox("No");

        JButton submitButton = new JButton("Submit");

        // Step 3: Add components to the GUI

        c.gridx = 0;
        c.gridy = 0;
        add(termsLabel, c);

        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 5;
        add(instructionsText,c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        add(agreeLabel, c);

        c.gridx = 3;
        c.gridy = 2;
        add(yesCheckbox, c);

        c.gridx = 4;
        c.gridy = 2;
        add(noCheckbox, c);

        c.gridx = 5;
        c.gridy = 3;
        add(submitButton, c);




    }


    public static void main(String[] args) {
        GridBagDemoApp app = new GridBagDemoApp();
        app.setVisible(true);
    }
}
