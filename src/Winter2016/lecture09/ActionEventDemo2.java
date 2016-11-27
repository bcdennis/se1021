package Winter2016.lecture09;
/**
 * ActionEventDemo2.java
 *
 * This is a simple program that will be used to demonstrate
 * simple events and listeners
 *
 * @author Brad Dennis
 * Created:  1/4/2015
 * Modified: --
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ActionEventDemo2 extends JFrame implements ActionListener {

    private JLabel counterLabel;
    private JButton addButton;
    private JButton subButton;

    private int counter = 0;

    public ActionEventDemo2(String title) {
        this.setTitle(title);

        // configure the frame
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // create out components
        counterLabel = new JLabel("Clicks: 0");

        addButton = new JButton(" + ");
        addButton.addActionListener(this);

        subButton = new JButton(" - ");
        subButton.addActionListener(this);


        // add them the gui
        add(counterLabel);
        add(addButton);
        add(subButton);

    }

    public static void main(String[] args) {
        ActionEventDemo2 frame = new ActionEventDemo2("Events Demo");

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() instanceof JButton) {
            String command = e.getActionCommand();
            if (command.equals(addButton.getText())) {
                incrementCounter();
            } else if (command.equals(subButton.getText())) {
                decrementCounter();
            }
        }
    }

    private void decrementCounter() {
        counter--;
        if (counter < 0) {
            counter = 0;
        }
        counterLabel.setText("Clicks: " + counter);
    }

    private void incrementCounter() {
        counter++;
        counterLabel.setText("Clicks: " + counter);
    }
}
