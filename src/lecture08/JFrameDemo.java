package lecture08;

// http://stackoverflow.com/questions/3348816/intellij-never-use-wildcard-imports
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;

/**
 * JFrame.java
 *
 * This is a simple program that will be used to demonstrate
 *  more JFrame.
 *
 *  @author Brad Dennis
 * Created:  1/4/2015
 *  Modified: --
 */
public class JFrameDemo {

    public static void main(String[] args) {


        // JFrame is a container object.  A Container object is a
        // generic Abstract Windowing Toolkit object that allows
        // multiple AWT components to be added to it.

        // AWT is heavyweight toolkit that is built off the GUI components of the underlying native OS components.
        // Pros:
        //   - has the look and feel of the Operating System
        //   - fast
        // Cons:
        //   - not portable, features on one platform may not exist on another
        //   - don't support all underlying features


        // Swing is a lightweight toolkit built off of AWT components.
        // Pros:
        //   - has same look and feel on all platforms
        //   - portable, features same on all platforms
        // Cons:
        //   - can be slower and buggier than native components
        //   - doesn't look like the underlying platform

        // We can access the content pane of the JFrame

        JFrame frame = new JFrame("Title Bar Text");

        // setSize is w x h in pixels
        frame.setSize(300, 200);

        // we have to tell the frame how to handle close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // this tells the frame what strategy to use when placing components on the frame.
        frame.setLayout(new FlowLayout());

        // now we can add stuff to the GUI
        frame.add(new JLabel("Text label"));

        // now show the frame
        frame.setVisible(true);



/*


*/

    }
}