package Games;

import java.awt.Color;
import java.awt.event.KeyEvent;

import Main.Image;
import Main.Input_Handler;

public class LightBike extends GameScreen {

	
	

	private int x1, y1, x2, y2, speed1, speed2;
	private int v1, v2; //0 up, 1 down, 2 left, 3 right
	
	public LightBike(Image image, Input_Handler handler) {
		super(image, handler);
		// TODO Auto-generated constructor stub
	}

	protected void draw() {

		image.drawRect(Color.red, x1, y1, 20, 20);
		image.drawRect(Color.blue, x2, y2, 20, 20);
		
		
		if(v1 == 0) x1 -= speed1;
		else if(v1 == 1) x1 += speed1;
		else if(v1 == 2) y1 -= speed1;
		else if(v1 == 3) y1 += speed1;
		
		if(v2 == 0) x2 -= speed2;
		else if(v2 == 1) x2 += speed2;
		else if(v2 == 2) y2 -= speed2;
		else if(v2 == 3) y2 += speed2;
			
		
		
		
		
		
	}

	
	protected void processInput() {
		while (handler.getKeys().size() > 0) {
			int key = handler.getKeys().remove(0);
			if (key == KeyEvent.VK_UP) v1 = 0;
			if (key == KeyEvent.VK_DOWN) v1 = 1;
			if (key == KeyEvent.VK_LEFT) v1 = 2;
			if (key == KeyEvent.VK_RIGHT) v1 = 3;
			if (key == KeyEvent.VK_W) v2 = 0;
			if (key == KeyEvent.VK_S) v2 = 1;
			if (key == KeyEvent.VK_A) v2 = 2;
			if (key == KeyEvent.VK_D) v2 = 3;
		}
		
	}


	protected void checkEnd() {
		// TODO Auto-generated method stub
		
	}


	protected void resetGame() {
		x1 = 400; y1 = 400;
		x2 = 100; y2 = 100;
		v1 = 0; v2 = 1;
		speed1 = 10; speed2 = 10;
		
	}
	
	
	
}
