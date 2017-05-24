package Main;
import java.awt.*;

import javax.swing.JPanel;

public class Window extends JPanel {
	/**
	 * the image object to be drawn to the display
	 */
	private Image image;
	
	/**
	 * 
	 * @param image to be displayed
	 */
	public Window(Image image) {
		this.image = image;
	}
	

	/**
	 * paints the image to the display
	 */
	public void paint(Graphics g) {
		g.drawImage(image.getImage(), 0, 0, image.getImage().getWidth(), image.getImage().getHeight(), null);
	}
	
	/**
	 * sets the image instance variable to the given image and paints it to the screen
	 * @param image to draw
	 */
	public void drawImage(Image image) {
		this.image = image;
		repaint();
	}
}