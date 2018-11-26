package Character_14;
import javax.swing.*;
import java.awt.FlowLayout;

public class ShowFlowLayout extends JFrame{
	public ShowFlowLayout() {
		// Set FlowLayout, aligned left with horizontal gap 10
		// and vertical gap 20 between components
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
		
		JButton[] buttons = new JButton[10];
		for(int i = 0; i < 10; i++){
			buttons[i] = new JButton("Component" + i);
			add(buttons[i]);
		}
	}
	
	public static void main(String[] args) {
		ShowFlowLayout frame = new ShowFlowLayout();
		frame.setTitle("ShowFlowLayout");
		frame.setSize(200, 200);
		frame.setLocationRelativeTo(null); // New since JDK 1.4
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}