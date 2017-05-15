package Games;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;

import org.omg.CORBA.Environment;

import Main.Image;
import Main.Input_Handler;

public class StartMenu extends GameScreen {
	
	private final long timeTillFontChange = 300;
	private final int fontSize = 100;
	private long last = System.currentTimeMillis();
	private String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); 
	private Font currFont;
	private Color currColor;
	private Color backColor;
	
	public StartMenu(Image image, Input_Handler handler) {
		super(image, handler);
		randomize();
	}

	@Override
	public void draw() {
		if (System.currentTimeMillis() - timeTillFontChange >= last) {
			randomize();
			last = System.currentTimeMillis();
		}
		
		
		image.drawRect(backColor, 0, 0, image.getX(), image.getY());
		
	    FontMetrics metrics = image.getGraphics().getFontMetrics(currFont);
	    int x = (image.getX() - metrics.stringWidth("GameSwitch")) / 2;
	    int y = ((image.getY() - metrics.getHeight()) / 2) + metrics.getAscent();

		
		image.drawString(currColor, currFont, "GameSwitch", x, y);
	}

	@Override
	protected void processInput() {
		if (handler.getKeys().size() > 0) {
			System.out.println(0);
			endGame();
		}
	}
	
	private void randomize() {
		currFont = new Font(fonts[(int) (Math.random()*fonts.length)], Font.BOLD, fontSize);
		currColor = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
		backColor = new Color (255-currColor.getRed(), 255-currColor.getGreen(), 255-currColor.getBlue());
	}

	@Override
	protected void checkEnd() { //checked in processInput
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void resetGame() {
		// TODO Auto-generated method stub
		
	}

	
}
