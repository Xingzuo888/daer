package Character_15;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AnimationDemo extends JFrame {
	int i = 0;
    public AnimationDemo() {
        // Create a MovingMessagePanel for displaying a moving message
        MovingMessagePanel p = new MovingMessagePanel("message moving?");
        add(p);

        // Create a timer for the listener p
        Timer timer = new Timer(100, p);
        timer.start();
    }

    /** Main method */
    public static void main(String[] args) {
        AnimationDemo frame = new AnimationDemo();
        frame.setTitle("AnimationDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100, 280);
        frame.setVisible(true);
    }
}

// Displaying a moving message
class MovingMessagePanel extends JPanel implements ActionListener {
    private String message = "Welcome to Java";

    private int xCoordinate = 0;

    private int yCoordinate = 20;

    public MovingMessagePanel(String message) {
        this.message = message;
    }

    /** Handle ActionEvent */
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    /** Paint message */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (xCoordinate > getWidth())
            xCoordinate = -20;
        xCoordinate += 5;
        g.drawString(message, xCoordinate, yCoordinate);
    }
}
