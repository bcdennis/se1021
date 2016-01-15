/**
 * SE1021
 * Winter 2016
 * Lecture 11
 * Name: Brad Dennis
 * Created: 1/15/2016
 */
package lecture14;



import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

/**
 * This is a simple program to demonstrate Box & BorderLayouts.
 */
public class LayoutDemoApp extends JFrame {
    private static final int HEIGHT = 50;
    private static final int WIDTH = 50;
    private JPanel redPanel;
    private JPanel greenPanel;
    private JPanel bluePanel;
    private JPanel blackPanel;
    private JPanel yellowPanel;

    public LayoutDemoApp() {
        setTitle("Layouts Demo");
        setSize(150, 250);
        setResizable(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initPanels();

        //Step 1: Flow Layout
        buildFlowLayout();

        //Step 2: Grid Layout
        //buildGridLayout();

        //Step 3: Box Layout
        //buildBoxLayout();

        //Step 4: BorderLayout
        //buildBorderLayout();
    }


    private void buildFlowLayout() {
        setLayout(new FlowLayout());
        add(redPanel);
        add(greenPanel);
        add(bluePanel);
        add(blackPanel);
        add(yellowPanel);
    }

    private void buildGridLayout() {
        setLayout(new GridLayout(3,2));
        add(redPanel);
        add(greenPanel);
        add(bluePanel);
        add(blackPanel);
        add(yellowPanel);
    }

    private void buildBoxLayout() {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        //setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        add(redPanel);
        add(greenPanel);
        add(bluePanel);
        add(blackPanel);
        add(yellowPanel);
    }

    private void buildBorderLayout() {
        setLayout(new BorderLayout());

        add(redPanel, BorderLayout.NORTH);
        add(greenPanel, BorderLayout.SOUTH);
        add(bluePanel, BorderLayout.EAST);
        add(blackPanel, BorderLayout.WEST);
        add(yellowPanel, BorderLayout.CENTER);

    }

    private void initPanels() {
        redPanel = new JPanel();
        redPanel.setBackground(Color.RED);
        redPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        greenPanel = new JPanel();
        greenPanel.setBackground(Color.GREEN);
        greenPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        bluePanel = new JPanel();
        bluePanel.setBackground(Color.BLUE);
        bluePanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        blackPanel = new JPanel();
        blackPanel.setBackground(Color.BLACK);
        blackPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        yellowPanel = new JPanel();
        yellowPanel.setBackground(Color.YELLOW);
        yellowPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));

    }

    public static void main(String[] args) {
        LayoutDemoApp app = new LayoutDemoApp();
        app.setVisible(true);
    }
}
