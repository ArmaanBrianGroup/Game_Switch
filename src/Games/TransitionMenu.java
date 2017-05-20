package Games;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GraphicsEnvironment;

import Main.Image;
import Main.Input_Handler;
import Main.Main;

public class TransitionMenu extends GameScreen {
	private final int FramesTillChange, FramesTillEnd;
	private final int fontSize = 100;
	private String s = "";
	private String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); 
	private Font currFont;
	private Color currColor;
	private Color backColor;
	
	/**
	 * 
	 * @param image to draw to
	 * @param handler to get input from
	 * @param FramesTillChange frames until the font should randomize
	 * @param FramesTillEnd frames until the transition screen shoudl terminate
	 */
	public TransitionMenu (Image image, Input_Handler handler, int FramesTillChange, int FramesTillEnd) {
		super(image, handler);
		this.FramesTillChange = FramesTillChange;
		this.FramesTillEnd = FramesTillEnd;
		randomize();
	}

	/**
	 * drawing to image
	 */
	@Override
	public void draw() {
		s = Integer.toString(Main.scoreA()) + " - " + Integer.toString(Main.scoreB());
		if (framesPassed % FramesTillChange == 0) randomize();
		
		image.drawRect(backColor, 0, 0, image.getX(), image.getY());
		
	    FontMetrics metrics = image.getGraphics().getFontMetrics(currFont);
	    
	    int x = (image.getX() - metrics.stringWidth(s))/2;
	    int y = ((image.getY() - metrics.getHeight()) / 2) + metrics.getAscent();

		image.drawString(currColor, currFont, s, x, y);
	}

	/**
	 * processing input 
	 */
	@Override
	protected void processInput() {
	}
	
	/**
	 * randomizing colors and fonts
	 */
	private void randomize() {
		currFont = new Font(fonts[(int) (Math.random()*fonts.length)], Font.BOLD, fontSize);
		currColor = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
		backColor = new Color (255-currColor.getRed(), 255-currColor.getGreen(), 255-currColor.getBlue());
	}

	/**
	 * checking if screen should end
	 */
	@Override
	protected void checkEnd() { //checked in processInput
		if (framesPassed > FramesTillEnd) state = -1;
	}

	/**
	 * resets variables
	 */
	@Override
	protected void resetGame() {
		framesPassed = 0;
	}

}
