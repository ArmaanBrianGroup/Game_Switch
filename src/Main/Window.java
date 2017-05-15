package Main;
import java.awt.*;

import javax.swing.JPanel;

public class Window extends JPanel {
	private static final long serialVersionUID = 1L;
	private int win_x, win_y;
	private Image image;
	
	
	public Window(int win_x, int win_y, Image image) {
		this.win_x = win_x;
		this.win_y = win_y;
		this.image = image;
	}
	
	public Window(int win_x, int win_y) {
		this.win_x = win_x;
		this.win_y = win_y;
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