package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class AboutOur extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutOur frame = new AboutOur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AboutOur() {
		setTitle("\u5173\u4E8E\u6211\u4EEC");
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u97E6\u661F\u4F50");
		label.setFont(new Font("ËÎÌו", Font.BOLD, 20));
		label.setBounds(107, 80, 168, 49);
		getContentPane().add(label);

	}

}
