package Games;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import Main.Image;
import Main.Input_Handler;

public class Start extends GameScreen {

	public Start(Image image, Input_Handler handler) {
		super(image, handler);
	}

	@Override
	public void draw() {
		image.drawString(Color.white, "GameSwitch", image.getX()/2, image.getY()/2);
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
