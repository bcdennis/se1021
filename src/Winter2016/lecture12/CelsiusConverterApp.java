/**
 * SE1021
 * Winter 2016
 * Lecture 11
 * Name: Brad Dennis
 * Created: 1/10/2016
 */
package Winter2016.lecture12;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.FlowLayout;

/**
 * This is a simple program that will be used to convert Celsius to Fahrenheit.
 */
public class CelsiusConverterApp extends JFrame {
    JTextField temperatureField;


    public CelsiusConverterApp(){
        // Step 1:  Configure the frame
        setTitle("Celsius Converter");
        setSize(250, 100);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Step 2: Create components
        JLabel temperatureLabel = new JLabel("Celsius:");
        temperatureField = new JTextField(5);
        JButton convertButton = new JButton("Convert");

        convertButton.addActionListener(e->convertAndShow());

        add(temperatureLabel);
        add(temperatureField);
        add(convertButton);


    }

    private void convertAndShow() {
        int fahrenheit = (int)((Double.parseDouble(temperatureField.getText()))
                * 1.8 + 32);
        JOptionPane.showMessageDialog(this, temperatureField.getText() + "C ==> " + fahrenheit + "F", "Conversion", JOptionPane.INFORMATION_MESSAGE);
    }


    public static void main(String[] args) {
        CelsiusConverterApp app = new CelsiusConverterApp();
        app.setVisible(true);
    }
}
