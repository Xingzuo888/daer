package Character_14;
import javax.swing.*;

public class MyFrameWithComponents {
	public static void main(String[] args) {
		JFrame frame = new JFrame("MyFrameWithComponents");

		// Add a button into the frame
		JButton jbtOK = new JButton("OK");
		frame.add(jbtOK);

		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null); // New since JDK 1.4
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
