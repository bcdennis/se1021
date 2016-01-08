package lecture08;

/**
 * JOptionPane.java
 *
 * This is a simple program that will be used to demonstrate
 * more JOptionPane.
 *
 * @author Brad Dennis
 * Created:  1/4/2015
 * Modified: --
 */
import javax.swing.JOptionPane;

public class JOptionPaneDemo {

    public static void main(String[] args) {

        // showMessageDialog is the simplest, it just delivers a message to the user.

        // The first argument is the parent for the dialog.
        // null indicates the default "frame" should be used.
        //
        // The second argument is the message to display in the dialog.

       // JOptionPane.showMessageDialog(null, "Hello World");


        //
        // The third argument is the title of the dialog.
        // We can also change the icon in the dialog by adding an optional fourth argument.
        //
        //JOptionPane.showMessageDialog(null, "ERROR", "Title", JOptionPane.ERROR_MESSAGE);
//
 //       JOptionPane.showMessageDialog(null, "Default Icon", "", JOptionPane.INFORMATION_MESSAGE);
 //       JOptionPane.showMessageDialog(null, "Warning Icon", "", JOptionPane.WARNING_MESSAGE);
 //       JOptionPane.showMessageDialog(null, "Question Icon", "", JOptionPane.QUESTION_MESSAGE);
 //       JOptionPane.showMessageDialog(null, "No Icon", "", JOptionPane.PLAIN_MESSAGE);

        //
        // showConfirmDialog adds yes/no/cancel buttons to the dialog box
        //
/*        JOptionPane.showConfirmDialog(null, "Default buttons", "", JOptionPane.DEFAULT_OPTION);
//        JOptionPane.showConfirmDialog(null, "Yes/No buttons", "", JOptionPane.YES_NO_OPTION);
        JOptionPane.showConfirmDialog(null, "Yes/No/Cancel buttons", "", JOptionPane.YES_NO_CANCEL_OPTION);
        JOptionPane.showConfirmDialog(null, "OK/Cancel buttons", "", JOptionPane.OK_CANCEL_OPTION);

        //
        // we can also interrogate the responses from the user:
        //
        int response = JOptionPane.showConfirmDialog(null, "Shall we play a game?", "WOPR", JOptionPane.YES_NO_CANCEL_OPTION);

        switch (response) {
            case JOptionPane.CANCEL_OPTION:
                System.out.println("User cancelled.");
                break;
            case JOptionPane.YES_OPTION:
                System.out.println("User clicked 'Yes'.");
                break;
            case JOptionPane.NO_OPTION:
                System.out.println("User clicked 'No'.");
                break;
        }

*/        //
        // showInputDialog  allows us to get input from the user
        //
/*        String input = JOptionPane.showInputDialog(null, "What is your name?",
                "Title", JOptionPane.QUESTION_MESSAGE);

        System.out.println("You entered: " + input);

        //
        // showOptionDialog gives us a combo of all the above.
        //
*/
        Object[] buttons = {"A lot", "Somewhat", "A little", "Not at all"};
        String prompt = "How happy are you to be back from break?";
        String title = "Happiness Survey";

        int choice = JOptionPane.showOptionDialog(null,
                            prompt,
                            title,
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            buttons,
                            buttons[0]);

        String output = "No selection made.";

        if (choice > 0) {
            output = "You selected: " + buttons[choice];
        }

        System.out.println(output);


    }
}