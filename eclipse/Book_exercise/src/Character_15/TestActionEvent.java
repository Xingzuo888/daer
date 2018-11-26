package Character_15;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestActionEvent extends JFrame {
    // Create two buttons
    private JButton jbtOk = new JButton("OK");

    private JButton jbtCancel = new JButton("Cancel");

    public TestActionEvent() {
        // Set the window title
        setTitle("TestActionEvent");

        // Set FlowLayout manager to arrange the components
        // inside the frame
        setLayout(new FlowLayout());

        // Add buttons to the frame
        add(jbtOk);
        add(jbtCancel);

        // Create a listener object
        ButtonListener btListener = new ButtonListener();

        // Register listeners
        jbtOk.addActionListener(btListener);
        jbtCancel.addActionListener(btListener);
    }

    /** Main method */
    public static void main(String[] args) {
        TestActionEvent frame = new TestActionEvent();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100, 100);
        frame.setVisible(true);
    }
}

class ButtonListener implements ActionListener {
    /** This method will be invoked when a button is clicked */
    public void actionPerformed(ActionEvent e) {
        System.out.println("The " + e.getActionCommand() + " button is "
                + "clicked at\n  " + new java.util.Date(e.getWhen()));
    }
}
