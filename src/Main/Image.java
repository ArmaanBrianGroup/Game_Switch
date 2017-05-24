package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Image {
	/**
	 * the image that is writen to for rendering
	 */
	private BufferedImage image;
	
	/**
	 * graphics that writes to the image
	*/
	private Graphics2D g;
	
	/**
	 * stores the dimensions of the image
	 */
	private int winx, winy;
	
	/**
	 * 
	 * @param winx x dimension
	 * @param winy y dimension
	 */
	public Image(int winx, int winy) {
		this.winx = winx;
		this.winy = winy;
		image = new BufferedImage(winx, winy, BufferedImage.TYPE_3BYTE_BGR);
		g = image.createGraphics();
	}
	
	/**
	 * 
	 * @return x dim
	 */
	public int getX() {
		return winx;
	}
	
	/**
	 * 
	 * @return y dim
	 */
	public int getY() {
		return winy;
	}
	
	/**
	 * 
	 * @return graphics objcect used
	 */
	public Graphics2D getGraphics() {
		return g;
	}
	
	/**
	 * set image to blank buffered image
	 */
	public void resetImage() {
		image = new BufferedImage(winx, winy, BufferedImage.TYPE_3BYTE_BGR);
		g = image.createGraphics();
	}
	
	/**
	 * sets the image two an image of the given pixel values (not used in the project currently)
	 * @param pixel values
	 */
	public void resetImage(int[][][] pixels) {
		image = new BufferedImage(winx, winy, BufferedImage.TYPE_3BYTE_BGR);
		
		for (int i = 0; i < winx; i++) {
			for (int j = 0; j < winy; j++) {
				Color color = new Color(pixels[i][j][0], pixels[i][j][1], pixels[i][j][2]); // Color white
				image.setRGB(i, j, color.getRGB());
			}
		}
	}
	
	/**
	 * returns the image that was rendered to (for displaying the frame)
	 * @return buffered image 
	 */
	public BufferedImage getImage() {
		return image;
	}
	
	/**
	 * draw circle that IS filled in
	 * @param c color value
	 * @param x cord
	 * @param y cord
	 * @param r radius
	 */
	public void drawCircle(Color c, int x, int y, int r) {
        g.setColor(c);
        g.fillOval(x, y, r*2, r*2);
	}
	
	/**
	 * draw circle that IS NOT filled in
	 * @param c color
	 * @param x cord
	 * @param y cord
	 * @param r radius
	 */
	public void drawUnfilledCircle(Color c, int x, int y, int r) {
        g.setColor(c);
        g.drawOval(x, y, r*2, r*2);
	}

	/**
	 * draws a rectangle 
	 * @param c color
	 * @param x value
	 * @param y value
	 * @param w width
	 * @param h height
	 */
	
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
	
	/**
	 * draws a line between the two given points
	 * @param c color
	 * @param x1
	 * @param x2
	 * @param y1
	 * @param y2
	 */
	public void drawLine(Color c, int x1, int x2, int y1, int y2) {
		g.setColor(c);
		g.drawLine(x1, y1, x2, y2);
	}
	
	/**
	 * draws the string provided
	 * @param c color
	 * @param str string
	 * @param x
	 * @param y
	 */
	public void drawString(Color c, String str, int x, int y) {
		g.setColor(c);
		g.drawString(str, x, y);
	}
	
	/**
	 * draws a string provided, and font can be specified
	 * @param c color
	 * @param f font
	 * @param str string
	 * @param x
	 * @param y
	 */
	public void drawString(Color c, Font f, String str, int x, int y) {
		g.setColor(c);
		g.setFont(f);
		g.drawString(str, x, y);
	}
	
	/**
	 * draws a triangle given three points
	 * @param c color
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param x3
	 * @param y3
	 */
	public void drawTriangle(Color c, int x1, int y1, int x2, int y2, int x3, int y3) {
		int[] xPoints = {x1, x2, x3};
		int[] yPoints = {y1, y2, y3};
		g.setColor(c);
		g.drawPolygon(xPoints, yPoints, 3);
	}
	
	/**
	 * draws an isoceles horizontal triangle
	 * @param c color
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void drawHorizontalTriangle(Color c, int x, int y, int width, int height) {
		drawTriangle(c, x, y, x+width, y+height/2, x, y+height);

	}
	
	/**
	 * draws an isolceles verical triangle
	 * @param c color
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void drawVerticalTriangle (Color c, int x, int y, int width, int height) {
		drawTriangle(c, x, y, x+width/2, y+height, x+width, y);
	}
	
	/**
	 * draws an x (for tic tac toe)
	 * @param c color
	 * @param x
	 * @param y
	 * @param w width
	 * @param h height
	 */
	public void drawX(Color c, int x, int y, int w, int h) {
		drawLine(c, x, x+w, y, y+h);
		drawLine(c, x, x+w, y+h, y);
	}
}