package Character_15;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestActionEvent4 extends JFrame {
	// Create two buttons
	private JButton jbtOk = new JButton("OK");

	private JButton jbtCancel = new JButton("Cancel");

	public TestActionEvent4() {
		// Set the window title
		setTitle("TestActionEvent");

		// Set FlowLayout manager to arrange the components
		// inside the frame
		setLayout(new FlowLayout());

		// Add buttons to the frame
		add(jbtOk);
		add(jbtCancel);

		// 使用匿名内部类
		jbtOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("It is OK");
			}
		});
		jbtCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("It is Cancel");
			}
		});
	}

	/** Main method */
	public static void main(String[] args) {
		TestActionEvent4 frame = new TestActionEvent4();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(100, 100);
		frame.setVisible(true);
	}
}
