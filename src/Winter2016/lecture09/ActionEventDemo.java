package Winter2016.lecture09;
/**
 * ActionEventDemo.java
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


public class ActionEventDemo extends JFrame implements ActionListener {

    private JLabel counterLabel;
    private JButton addButton;

    private int counter = 0;

    public ActionEventDemo(String title) {
        this.setTitle(title);

        // configure the frame
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // create out components
        counterLabel = new JLabel("Clicks: 0");

        addButton = new JButton("Add");
        addButton.addActionListener(this);


        // add them the gui
        add(counterLabel);
        add(addButton);

    }

    public static void main(String[] args) {
        ActionEventDemo frame = new ActionEventDemo("Events Demo");

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        counter++;
        counterLabel.setText("Clicks: " + counter);
    }
}
