package Character_15;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MoveMessageDemo extends JFrame {
    public MoveMessageDemo() {
        // Create a MoveMessagePanel instance for drawing a message
        MoveMessagePanel p = new MoveMessagePanel("Welcome to Java");

        // Place the message panel in the frame
        setLayout(new BorderLayout());
        add(p);
    }

    /** Main method */
    public static void main(String[] args) {
        MoveMessageDemo frame = new MoveMessageDemo();
        frame.setTitle("MoveMessageDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}

// MoveMessagePanel draws a message
class MoveMessagePanel extends JPanel implements MouseMotionListener {
    private String message = "Welcome to Java";

    private int x = 20;

    private int y = 20;

    /** Construct a panel to draw string s */
    public MoveMessagePanel(String s) {
        message = s;
        this.addMouseMotionListener(this);
    }

    /** Handle mouse moved event */
    public void mouseMoved(MouseEvent e) {
    }

    /** Handle mouse dragged event */
    public void mouseDragged(MouseEvent e) {
        // Get the new location and repaint the screen
        x = e.getX();
        y = e.getY();
        repaint();
    }

    /** Paint the component */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(message, x, y);
    }
}
