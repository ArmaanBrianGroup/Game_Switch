package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Image {
	
	private BufferedImage image;
	private Graphics2D g;
	private int winx, winy;
	
	public Image(int winx, int winy) {
		this.winx = winx;
		this.winy = winy;
		image = new BufferedImage(winx, winy, BufferedImage.TYPE_3BYTE_BGR);
		g = image.createGraphics();
	}
	
	public int getX() {
		return winx;
	}
	
	public int getY() {
		return winy;
	}
	
	public Graphics2D getGraphics() {
		return g;
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
        
        if(w < 0) {
        	w = Math.abs(w);
        	x -= w;
        }
        if(h < 0) {
        	h = Math.abs(h);
        	y -= h;
        }
        
        
        
        
        
        
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
	
	public void drawString(Color c, Font f, String str, int x, int y) {
		g.setColor(c);
		g.setFont(f);
		g.drawString(str, x, y);
	}
	
	public void drawTriangle(Color c, int x1, int y1, int x2, int y2, int x3, int y3) {
		int[] xPoints = {x1, x2, x3};
		int[] yPoints = {y1, y2, y3};
		g.setColor(c);
		g.drawPolygon(xPoints, yPoints, 3);
	}
	
	public void drawHorizontalTriangle(Color c, int x, int y, int width, int height) {
		int[] xPoints = {x, x+width, x};
		int[] yPoints = {y, y+height/2, y+height};
		g.setColor(c);
		g.drawPolygon(xPoints, yPoints, 3);
	}
	
	public void drawVerticalTriangle (Color c, int x, int y, int width, int height) {
		int[] xPoints = {x, x+width/2, x+width};
		int[] yPoints = {y, y+height, y};
		g.setColor(c);
		g.drawPolygon(xPoints, yPoints, 3);
	}
}