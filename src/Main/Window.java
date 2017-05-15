package Main;
import java.awt.*;

import javax.swing.JPanel;

public class Window extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image image;
	
	
	public Window(Image image) {
		this.image = image;
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image.getImage(), 0, 0, image.getImage().getWidth(), image.getImage().getHeight(), null);
	}
	
	public void drawImage(Image image) {
		this.image = image;
		repaint();
	}
}