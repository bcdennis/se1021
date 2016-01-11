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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
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

    public PasswordApp() {
        // Step 1:  Configure the frame
        setTitle("Password Generator");
        setSize(400, 200);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 3));

        // Step 2: Create components

        JMenuBar appMenu = new JMenuBar(); //https://docs.oracle.com/javase/8/docs/api/javax/swing/JMenuBar.html

        JMenu fileMenu = new JMenu("File"); //https://docs.oracle.com/javase/8/docs/api/javax/swing/JMenu.html
        fileMenu.setMnemonic(KeyEvent.VK_F);  //https://docs.oracle.com/javase/8/docs/api/java/awt/event/KeyEvent.html

        //https://docs.oracle.com/javase/8/docs/api/javax/swing/JMenuItem.html
        JMenuItem fileExitMenuItem = new JMenuItem("Exit", KeyEvent.VK_X);
        fileExitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        fileExitMenuItem.addActionListener(e-> System.exit(0));

        JMenuItem fileSimplePasswordMenuItem = new JMenuItem("Generate Simple Password", KeyEvent.VK_S);
        fileSimplePasswordMenuItem.addActionListener(e-> simplePasswordLabel.setText((makeSimplePassword())));

        // Add menu components to the menu.
        fileMenu.add(fileSimplePasswordMenuItem);
        fileMenu.add(fileExitMenuItem);

        // Add menus to the app menu.
        appMenu.add(fileMenu);

        JButton simpleButton = new JButton("Simple >>");
        simpleButton.addActionListener(e-> simplePasswordLabel.setText((makeSimplePassword())));

        simplePasswordLabel = new JLabel("");

        // Step 3: Add components to the GUI
        //Set the app's menu bar.
        setJMenuBar(appMenu);

        //Row 1
        add(new JLabel("Description:"));
        add(new JLabel("Command:"));
        add(new JLabel("Output:"));

        //Row 2
        add(new JLabel("<html>A simple password is 8 characters.</html>"));
        add(simpleButton);
        add(simplePasswordLabel);

   }

    private String makeSimplePassword() {
        String word = "";
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            word += LOWER_CASE[new Random().nextInt(LOWER_CASE.length)];
        }

       return word;
    }


    public static void main(String[] args) {
        PasswordApp app = new PasswordApp();
        app.setVisible(true);

    }
}
