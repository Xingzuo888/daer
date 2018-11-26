package Character_13;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestPaintComponent extends JFrame {
	
	public TestPaintComponent(){
		add(new NewLabel());
	}
	public static void main(String[] args) {
		TestPaintComponent frame = new TestPaintComponent();
		frame.setTitle("TestPaintComponent");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200,100);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}	
}

class NewLabel extends JLabel{
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawLine(0, 0, 50, 50);
		g.drawString("Banner", 0, 40);
	}
	
}