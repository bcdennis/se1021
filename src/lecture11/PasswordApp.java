/**
 * SE1021
 * Winter 2016
 * Lecture 11
 * Name: Brad Dennis
 * Created: 1/10/2016
 */
package lecture11;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.nio.charset.Charset;
import java.util.Random;

/**
 * This is a simple program that will be used to generate passwords.
 */
public class PasswordApp extends JFrame {
    private static final String[] LOWER_CASE = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m"};
    private static final String[] UPPER_CASE = {"A", "B", "C", "D", "E", "F", "G", "H","I", "J", "K", "L", "M"};
    private static final String[] SYMBOLS = {"!", "@", "#", "$", "%", "&", "-"};
    private static final int  MAX_DIGIT = 9;
    private static final int PASSWORD_LENGTH = 8;

    private JLabel simplePasswordLabel;
    private JLabel complexPasswordLabel;
    private JLabel compoundPasswordLabel;
    private JLabel strongPasswordLabel;

    public PasswordApp() {
        // Step 1:  Configure the frame
        setTitle("Password Generator");
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 3));

        // Step 2: Create components
        JButton simpleButton = new JButton("Simple >>");
        JButton complexButton = new JButton("Complex >>");
        JButton compoundButton = new JButton("Compound >>");
        JButton strongButton = new JButton("Strong >>");

        simpleButton.addActionListener(e->makeSimplePassword());
        complexButton.addActionListener(e->makeComplexPassword());
        compoundButton.addActionListener(e->makeCompoundPassword());
        strongButton.addActionListener(e->makeStrongPassword());

        simplePasswordLabel = new JLabel("");
        complexPasswordLabel = new JLabel("");
        compoundPasswordLabel = new JLabel("");
        strongPasswordLabel = new JLabel("");

        // Step 3: Add components to the GUI
        //Row 1
        add(new JLabel("Description:"));
        add(new JLabel("Command:"));
        add(new JLabel("Output:"));

        //Row 2
        add(new JLabel("<html>A simple password is 8 characters.</html>"));
        add(simpleButton);
        add(simplePasswordLabel);

        //Row 3
        add(new JLabel("<html>A complex password is 8 random upper or lower case characters.</html>"));
        add(complexButton);
        add(complexPasswordLabel);

        //Row 4
        add(new JLabel("<html>A compound password is 8 random upper or lower case characters and numbers.</html>"));
        add(compoundButton);
        add(compoundPasswordLabel);


        //Row 5
        add(new JLabel("<html>A strong  password is 8 random  upper or lower case characters and numbers and symbols.</html>"));
        add(strongButton);
        add(strongPasswordLabel);
    }

    private void makeSimplePassword() {
        String word = "";
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            word += LOWER_CASE[new Random().nextInt(LOWER_CASE.length)];
        }

        simplePasswordLabel.setText(word);
    }

    private void makeComplexPassword() {
        String word = "";
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            if (new Random().nextBoolean()) {
                word += LOWER_CASE[new Random().nextInt(LOWER_CASE.length)];
            } else {
                word += UPPER_CASE[new Random().nextInt(UPPER_CASE.length)];
            }
        }

        complexPasswordLabel.setText(word);
    }

    private void makeCompoundPassword() {
        String word = "";
        for (int i = 0; i < PASSWORD_LENGTH; i++) {

            switch (new Random().nextInt(3)) {
                case 0:
                    word += LOWER_CASE[new Random().nextInt(LOWER_CASE.length)];
                    break;
                case 1:
                    word += UPPER_CASE[new Random().nextInt(UPPER_CASE.length)];
                    break;
                case 2:
                    word += new Random().nextInt(MAX_DIGIT);
                    break;
            }
        }

        compoundPasswordLabel.setText(word);
    }

    private void makeStrongPassword() {
        String word = "";
        for (int i = 0; i < PASSWORD_LENGTH; i++) {

            switch (new Random().nextInt(4)) {
                case 0:
                    word += LOWER_CASE[new Random().nextInt(LOWER_CASE.length)];
                    break;
                case 1:
                    word += UPPER_CASE[new Random().nextInt(UPPER_CASE.length)];
                    break;
                case 2:
                    word += new Random().nextInt(MAX_DIGIT);
                    break;
                case 3:
                    word += SYMBOLS[new Random().nextInt(SYMBOLS.length)];
                    break;
            }
        }

        strongPasswordLabel.setText(word);
    }

    public static void main(String[] args) {
        PasswordApp app = new PasswordApp();
        app.setVisible(true);

    }
}
