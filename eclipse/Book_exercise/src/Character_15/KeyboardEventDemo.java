package Character_15;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyboardEventDemo extends JFrame {
    private KeyboardPanel keyboardPanel = new KeyboardPanel();

    /** Initialize UI */
    public KeyboardEventDemo() {
        // Add the keyboard panel to accept and display user input
        add(keyboardPanel);

        // Set focus
        keyboardPanel.setFocusable(true);
    }

    /** Main method */
    public static void main(String[] args) {
        KeyboardEventDemo frame = new KeyboardEventDemo();
        frame.setTitle("KeyboardEventDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}

// KeyboardPanel for receiving key input
class KeyboardPanel extends JPanel implements KeyListener {
    private int x = 100;

    private int y = 100;

    private char keyChar = 'A'; // Default key

    public KeyboardPanel() {
        addKeyListener(this); // Register listener
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_DOWN:
            y += 10;
            break;
        case KeyEvent.VK_UP:
            y -= 10;
            break;
        case KeyEvent.VK_LEFT:
            x -= 10;
            break;
        case KeyEvent.VK_RIGHT:
            x += 10;
            break;
        default:
            keyChar = e.getKeyChar();
        }

        repaint();
    }

    /** Draw the character */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
        g.drawString(String.valueOf(keyChar), x, y);
    }
}