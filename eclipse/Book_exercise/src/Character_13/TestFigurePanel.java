package Character_13;
import java.awt.GridLayout;

import javax.swing.JFrame;


public class TestFigurePanel extends JFrame {
	
	public TestFigurePanel(){
		setLayout(new GridLayout(2,3,5,5));
		add(new FigurePanel(FigurePanel.LINE));
		add(new FigurePanel(FigurePanel.RECTANGLE));
		add(new FigurePanel(FigurePanel.ROUND_RECTANGLE));
		add(new FigurePanel(FigurePanel.RECTANGLE,true));
		add(new FigurePanel(FigurePanel.ROUND_RECTANGLE,true));
		add(new FigurePanel(FigurePanel.OVAL,true));
	}
	public static void main(String[] args) {
		JFrame frame = new TestFigurePanel();
		frame.setTitle("TestFigurePanel");
		frame.setSize(400, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
