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
	private int framesPassed = 0;
	private final int fontSize = 100;
	private String s = "";
	private String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); 
	private Font currFont;
	private Color currColor;
	private Color backColor;
	
	public TransitionMenu (Image image, Input_Handler handler, int FramesTillChange, int FramesTillEnd) {
		super(image, handler);
		this.FramesTillChange = FramesTillChange;
		this.FramesTillEnd = FramesTillEnd;
		randomize();
	}

	@Override
	public void draw() {
		System.out.println(Main.scoreA());
		s = Integer.toString(Main.scoreA()) + " - " + Integer.toString(Main.scoreB());
		framesPassed++;
		if (framesPassed % FramesTillChange == 0) randomize();
		
		image.drawRect(backColor, 0, 0, image.getX(), image.getY());
		
	    FontMetrics metrics = image.getGraphics().getFontMetrics(currFont);
	    
	    int x = (image.getX() - metrics.stringWidth(s))/2;
	    int y = ((image.getY() - metrics.getHeight()) / 2) + metrics.getAscent();

		image.drawString(currColor, currFont, s, x, y);
	}

	@Override
	protected void processInput() {
	}
	
	private void randomize() {
		currFont = new Font(fonts[(int) (Math.random()*fonts.length)], Font.BOLD, fontSize);
		currColor = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
		backColor = new Color (255-currColor.getRed(), 255-currColor.getGreen(), 255-currColor.getBlue());
	}

	@Override
	protected void checkEnd() { //checked in processInput
		if (framesPassed > FramesTillEnd) state = -1;
	}

	@Override
	protected void resetGame() {
		framesPassed = 0;
	}

}
