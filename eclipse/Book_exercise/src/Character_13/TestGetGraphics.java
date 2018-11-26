package Character_13;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TestGetGraphics extends JFrame {
	
	private JLabel jlblBanner = new JLabel("Banner");
	public TestGetGraphics(){
		add(jlblBanner);
		System.out.println(jlblBanner.getGraphics());
	}
	public static void main(String[] args) {
		TestGetGraphics frame = new TestGetGraphics();
		frame.setTitle("TestGetGraphics");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200,100);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		JOptionPane.showMessageDialog(null,"Delay on putpose\nclick ok to dismiss the dialog");
		Graphics graphics = frame.jlblBanner.getGraphics();
		graphics.drawLine(0, 0, 50, 50);
	}

}
