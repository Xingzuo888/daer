package Character_14;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class ShowGridLayout extends JFrame {
	public ShowGridLayout() {
		// Set GridLayout, 3 rows, 2 columns, and gaps 5 between
		// components horizontally and vertically
		this.setLayout(new GridLayout(3, 2, 5, 5));

		JButton[] buttons = new JButton[10];
		for(int i = 0; i < 10; i++){
			buttons[i] = new JButton("Component" + i);
			this.add(buttons[i]);
		}
	}

	/** Main method */
	public static void main(String[] args) {
		ShowGridLayout frame = new ShowGridLayout();
		frame.setTitle("ShowGridLayout");
		frame.setSize(200, 125);
		frame.setLocationRelativeTo(null); // New since JDK 1.4
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
