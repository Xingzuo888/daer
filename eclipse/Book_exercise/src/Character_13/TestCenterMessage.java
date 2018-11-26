package Character_13;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class TestCenterMessage extends JFrame {

	/**
	 * @param args
	 */
	public TestCenterMessage(){
		CenterMessage messagePanel = new CenterMessage();
		add(messagePanel);
		messagePanel.setBackground(Color.white);
		messagePanel.setFont(new Font("Californiom FB",Font.BOLD,20));
	}
	public static void main(String[] args) {
		JFrame frame = new TestCenterMessage();
		frame.setTitle("CenterMessage");
		frame.setSize(300,150);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
class CenterMessage extends JPanel{

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		FontMetrics fm = g.getFontMetrics();
		int stringWidth = fm.stringWidth("Welcome to java");
		int stringAscent = fm.getAscent();
		int xCoordinate = getWidth()/2 - stringWidth/2;
		int yCoordinate = getHeight()/2 - stringAscent/2;
		g.drawString("Welcome to java", xCoordinate, yCoordinate);
	}
		
}