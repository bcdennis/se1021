/**
 * SE1021
 * Winter 2016
 * Lecture 10
 * Name: Brad Dennis
 * Created: 1/06/2016
 */
package lecture10;


import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

/**
 * This is class that shows implementing an action listener
 * as a separate class.
 */
public class Validator implements FocusListener {

    private final JTextField source;
    private final JTextArea target;
    private final ArrayList<String> values;

    public Validator(JTextField source, JTextArea target, ArrayList<String> values) {
        this.source = source;
        this.target = target;
        this.values = values;
    }

    @Override
    public void focusGained(FocusEvent e) {
        target.setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {

        Font font = new Font("Arial", Font.ITALIC, 12);
        target.setFont(font);

        target.setForeground(Color.RED);
        String message = "A username is required.";

        if (values.contains(source.getText())) {
            target.setForeground(Color.GREEN);
            message = "User '" + source.getText() + "' in the roster.";
        } else if (!source.getText().isEmpty()) {
            message = "User '" + source.getText() + "' is not in the roster.";
        }

        target.setText(message);

    }
}
