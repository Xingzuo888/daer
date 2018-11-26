package Character_13;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;


public class ImageViewer extends JPanel {
	private Image image;
	private boolean stretched = true;
	private int xCoordinate;
	private int yCoordinate;
	public ImageViewer(){
	}
	public ImageViewer(Image image){
		this.image = image;
	}
	
	public Image getImage() {
		return image;
	}
	public boolean isStretched() {
		return stretched;
	}
	public int getXCoordinate() {
		return xCoordinate;
	}
	public int getYCoordinate() {
		return yCoordinate;
	}
	public void setImage(Image image) {
		this.image = image;
		repaint();
	}
	public void setStretched(boolean stretched) {
		this.stretched = stretched;
		repaint();
	}
	public void setXCoordinate(int coordinate) {
		xCoordinate = coordinate;
		repaint();
	}
	public void setYCoordinate(int coordinate) {
		yCoordinate = coordinate;
		repaint();
	}
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		if(image != null){
			if(isStretched())
				g.drawImage(image,xCoordinate,yCoordinate,
						getSize().width,getSize().height,this);
			else
				g.drawImage(image, xCoordinate, yCoordinate, this);
		}
	}
	
}
