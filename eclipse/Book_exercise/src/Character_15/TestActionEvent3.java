package Character_15;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestActionEvent3 extends JFrame {
	// Create two buttons
	private JButton jbtOk = new JButton("OK");

	private JButton jbtCancel = new JButton("Cancel");

	public TestActionEvent3() {
		// Set the window title
		setTitle("TestActionEvent");

		// Set FlowLayout manager to arrange the components
		// inside the frame
		setLayout(new FlowLayout());

		// Add buttons to the frame
		add(jbtOk);
		add(jbtCancel);

		// Register listeners
		jbtOk.addActionListener(new OkListener());
		jbtCancel.addActionListener(new CancelListener());
	}

	/** Main method */
	public static void main(String[] args) {
		TestActionEvent3 frame = new TestActionEvent3();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(100, 100);
		frame.setVisible(true);
	}

	/*
	 * 内部类
	 */
	class OkListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("It is OK");
		}
	}

	/*
	 * 内部类
	 */
	class CancelListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("It is Cancel");
		}
	}
}


