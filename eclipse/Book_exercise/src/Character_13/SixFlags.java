package Character_13;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class SixFlags extends JFrame {
	public SixFlags(){
		Image image1 = new ImageIcon("image/us.jpg").getImage();
		Image image2 = new ImageIcon("image/fr.jpg").getImage();
		Image image3 = new ImageIcon("image/us.jpg").getImage();
		Image image4 = new ImageIcon("image/my.jpg").getImage();
		Image image5 = new ImageIcon("image/china.jpg").getImage();
		Image image6 = new ImageIcon("image/ca.jpg").getImage();
		
		setLayout(new GridLayout(2,0,5,5));
		add(new ImageViewer(image1));
		add(new ImageViewer(image2));
		add(new ImageViewer(image3));
		add(new ImageViewer(image4));
		add(new ImageViewer(image5));
		add(new ImageViewer(image6));
	}
	public static void main(String[] args) {
		SixFlags frame = new SixFlags();
		frame.setTitle("SixFlags");
		frame.setSize(250,140);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
