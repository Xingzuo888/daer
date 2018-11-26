package Character_13;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;


public class DisplayClock extends JFrame {

	public DisplayClock(){
		StillClock clock = new StillClock();
		MessagePanel messagePanel = new MessagePanel(clock.getHour() + 
				" : " + clock.getMinute() + " : " + clock.getSecond());
		messagePanel.setCentered(true);
		messagePanel.setForeground(Color.blue);
		messagePanel.setFont(new Font("Courier",Font.BOLD,16));
		add(clock);
		add(messagePanel,BorderLayout.SOUTH);
		
	}
	public static void main(String[] args) {
		DisplayClock frame = new DisplayClock();
		frame.setTitle("DisplayClock");
		frame.setSize(300,350);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
