package Main;
import java.awt.*;

import javax.swing.JPanel;

public class Window extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image image;
	
	/**
	 * 
	 * @param image to be displayed
	 */
	public Window(Image image) {
		this.image = image;
	}
	

	/**
	 * paint whats in there
	 */
	public void paint(Graphics g) {
		g.drawImage(image.getImage(), 0, 0, image.getImage().getWidth(), image.getImage().getHeight(), null);
	}
	
	/**
	 * 
	 * @param paint image given
	 */
	public void drawImage(Image image) {
		this.image = image;
		repaint();
	}
}