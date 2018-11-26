package Character_13;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class TestSwingCommonFeature extends JFrame {
	public TestSwingCommonFeature(){
		JPanel pl = new JPanel(new FlowLayout(FlowLayout.LEFT,2,2));
		
		JButton jbtLeft = new JButton("left");
		JButton jbtCenter = new JButton("center");
		JButton jbtRight = new JButton("right");
		
		jbtLeft.setBackground(Color.WHITE);
		jbtCenter.setForeground(Color.GREEN);
		jbtRight.setToolTipText("This is right button");
		
		pl.add(jbtLeft);
		pl.add(jbtCenter);
		pl.add(jbtRight);
		
		pl.setBorder(new TitledBorder("Three Buttons"));
		Font largeFont = new Font("TimesRoman",Font.BOLD,20);
		Border lineBorder = new LineBorder(Color.BLACK,2);
		
		JPanel p2 = new JPanel(new GridLayout(1,2,5,5));
		JLabel jlbRed = new JLabel("Red");
		JLabel jlbOrange = new JLabel("Orange");
		jlbRed.setForeground(Color.RED);
		jlbOrange.setForeground(Color.ORANGE);
		jlbRed.setFont(largeFont);
		jlbOrange.setFont(largeFont);
		jlbRed.setBorder(lineBorder);
		jlbOrange.setBorder(lineBorder);
		
		p2.add(jlbRed);
		p2.add(jlbOrange);
		p2.setBorder(new TitledBorder("Two labels"));
		setLayout(new GridLayout(2,1,5,5));
		
		add(pl);
		add(p2);
			
	}
	public static void main(String[] args){
		
		JFrame frame = new TestSwingCommonFeature();
		frame.setTitle("TestSwingCommonFeature");
		frame.setSize(300, 150);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
