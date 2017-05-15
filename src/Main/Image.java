package Main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Image {
	
	private BufferedImage image;
	private Graphics2D g;
	private int winx, winy;
	
	public Image(int winx, int winy, int[][][] pixels) {
		this.winx = winx;
		this.winy = winy;
		resetImage(pixels);
		g = image.createGraphics();
	}
	
	public Image(int winx, int winy) {
		this.winx = winx;
		this.winy = winy;
		image = new BufferedImage(winx, winy, BufferedImage.TYPE_3BYTE_BGR);
		g = image.createGraphics();
	}
	
	public void resetImage() {
		image = new BufferedImage(winx, winy, BufferedImage.TYPE_3BYTE_BGR);
		g = image.createGraphics();
	}
	
	public void resetImage(int[][][] pixels) {
		image = new BufferedImage(winx, winy, BufferedImage.TYPE_3BYTE_BGR);
		
		for (int i = 0; i < winx; i++) {
			for (int j = 0; j < winy; j++) {
				Color color = new Color(pixels[i][j][0], pixels[i][j][1], pixels[i][j][2]); // Color white
				image.setRGB(i, j, color.getRGB());
			}
		}
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public void drawCircle(int red, int green, int blue, int x, int y, int r) {
        g.setColor(new Color(red, green, blue));
        g.fillOval(x, y, r*2, r*2);
	}
	
	public void drawCircle(Color c, int x, int y, int r) {
        g.setColor(c);
        g.fillOval(x, y, r*2, r*2);
	}
	
	public void drawRect(int red, int green, int blue, int x, int y, int w, int h) {
        g.setColor(new Color(red, green, blue));
        g.fillRect(x, y, w, h);;
	}
	
	public void drawRect(Color c, int x, int y, int w, int h) {
        g.setColor(c);
        g.fillRect(x, y, w, h);
	}
	
	public void drawLine(Color c, int x1, int x2, int y1, int y2) {
		g.setColor(c);
		g.drawLine(x1, y1, x2, y2);
	}
	
	public void drawString(Color c, String str, int x, int y) {
		g.setColor(c);
		g.drawString(str, x, y);
	}
}