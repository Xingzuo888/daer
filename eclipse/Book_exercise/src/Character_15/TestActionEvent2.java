package Character_15;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestActionEvent2 extends JFrame implements ActionListener {
    // Create two buttons
    private JButton jbtOk = new JButton("OK");

    private JButton jbtCancel = new JButton("Cancel");

    public TestActionEvent2() {
        // Set the window title
        setTitle("TestActionEvent");

        // Set FlowLayout manager to arrange the components
        // inside the frame
        setLayout(new FlowLayout());

        // Add buttons to the frame
        add(jbtOk);
        add(jbtCancel);

        // Register listeners
        jbtOk.addActionListener(this);
        jbtCancel.addActionListener(this);
    }

    /** Main method */
    public static void main(String[] args) {
        TestActionEvent2 frame = new TestActionEvent2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100, 100);
        frame.setVisible(true);
    }

    /** This method will be invoked when a button is clicked */
    public void actionPerformed(ActionEvent e) {
        System.out.println("The " + e.getActionCommand() + " button is "
                + "clicked at\n  " + new java.util.Date(e.getWhen()));
    }
}
