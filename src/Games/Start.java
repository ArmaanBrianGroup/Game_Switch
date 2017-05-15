package Games;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;

import Main.Image;
import Main.Input_Handler;

public class Start extends GameScreen {
	
	private final long timeTillFontChange = 300;
	private final int fontSize = 100;
	private long last = System.currentTimeMillis();
	private String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	private Font currFont = new Font(fonts[(int) (Math.random()*fonts.length)], Font.BOLD, fontSize);;
	private Color currColor = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
	
	public Start(Image image, Input_Handler handler) {
		super(image, handler);
	}

	@Override
	public void draw() {
		if (System.currentTimeMillis() - timeTillFontChange >= last) {
			currFont = new Font(fonts[(int) (Math.random()*fonts.length)], Font.BOLD, fontSize);
			currColor = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
			last = System.currentTimeMillis();
		}
		
		
		
		image.drawString(currColor, currFont, "GameSwitch", image.getX()/2-fontSize*4, image.getY()/2);
	}

	@Override
	protected void processInput() {
		if (handler.getKeys().size() > 0) {
			System.out.println(0);
			endGame();
		}
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
