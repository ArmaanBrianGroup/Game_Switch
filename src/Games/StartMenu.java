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
	
	private final int FramesTillChange;
	private int framesPassed = 0;
	private final int fontSize = 100;
	private String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(); 
	private Font currFont;
	private Color currColor;
	private Color backColor;
	
	public StartMenu(Image image, Input_Handler handler, int FramesTillChange) {
		super(image, handler);
		this.FramesTillChange = FramesTillChange;
		randomize();
	}

	@Override
	public void draw() {
		framesPassed++;
		if (framesPassed % FramesTillChange == 0) randomize();
		
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
			state = -1;
		}
	}
	
	private void randomize() { //http://paletton.com/#uid=7000u0kllllaFw0g0qFqFg0w0aF
		currFont = new Font(fonts[(int) (Math.random()*fonts.length)], Font.BOLD, fontSize);
		currColor = new Color((int) (Math.random() * 156 + 100), (int) (Math.random() * 156 + 100), (int) (Math.random() * 156 + 100));
		backColor = new Color (255-currColor.getRed(), 255-currColor.getGreen(), 255-currColor.getBlue());
	
		
		int temp = (int) (Math.random() * 1);
		int temp2 = (int) (Math.random() * 5);
		int temp3 = (int) (Math.random() * 2);
		switch(temp) {
		case 0:
			if(temp2 == 0) {currColor = new Color(225, 170, 170); backColor = new Color(136, 204, 136);}
			if(temp2 == 1) {currColor = new Color(212, 106, 106); backColor = new Color(85, 170, 85);}
			if(temp2 == 3) {currColor = new Color(170, 57, 57); backColor = new Color(45, 136, 45);}
			if(temp2 == 4) {currColor = new Color(128, 21, 21); backColor = new Color(17, 102, 17);}
			if(temp2 == 5) {currColor = new Color(85, 0, 0); backColor = new Color(0, 68, 0);}
			
		}
		
		
		if(temp3 == 1) {
			Color tempColor = currColor;
			currColor = backColor;
			backColor = tempColor;
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
