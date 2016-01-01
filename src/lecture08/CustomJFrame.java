package lecture08;
/**
 * CustomJFrame.java
 *
 * This is a simple program that will be used to demonstrate
 * making custom JFrames.
 *
 * @author Brad Dennis
 * Created:  1/4/2015
 * Modified: --
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;


public class CustomJFrame extends JFrame {


    public CustomJFrame(String title) {
        this.setTitle(title);

        // setSize is w x h in pixels
        setSize(300, 200);

        // we have to tell the frame how to handle close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // this tells the frame what strategy to use when placing components on the frame.
        setLayout(new FlowLayout());

        // now we can add stuff to the GUI
        add(new JLabel("Text label"));
    }

    public static void main(String[] args) {
        CustomJFrame frame = new CustomJFrame("Title Bar Text");

        frame.setVisible(true);
    }
}
