package Games;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Main.Image;
import Main.Input_Handler;

public class LightBike extends GameScreen {
	private int x1, y1, x2, y2, speed1, speed2, size1, size2;
	private int v1, v2, v1Last, v2Last; //0 up, 1 down, 2 left, 3 right
	private ArrayList<Integer> lineX1, lineX2, lineY1, lineY2;
	
	
	public LightBike(Image image, Input_Handler handler) {
		super(image, handler);

		x1 = 400; y1 = 400;
		x2 = 100; y2 = 100; System.out.println("CALLED");
		v1 = 0; v2 = 1;
		speed1 = 7; speed2 = 7;
	
		size1 = 20; size2 = 20;
		
		lineX1 = new ArrayList<Integer>();
		lineY1 = new ArrayList<Integer>();
		lineX2 = new ArrayList<Integer>();
		lineX2 = new ArrayList<Integer>();
	}

	protected void draw() {

		image.drawRect(Color.red, x1, y1, size1, size1); 
		image.drawRect(Color.blue, x2, y2, size2, size2);
		image.drawRect(Color.white, 100, 100, 50, 50);
		for(int i = 0; i < lineX1.size() - 1; i++) {

				image.drawRect(Color.pink, lineX1.get(i), lineY1.get(i),
										   lineX1.get(i+1) - lineX1.get(i), lineY1.get(i+1) - lineY1.get(i));
		}
		for(int i = 0; i < lineX2.size() - 1; i++) {
			
		}
		
		if(lineX1.size() > 1) {
			image.drawRect(Color.pink, lineX1.get(0), lineY1.get(0),
					   lineX1.get(0+1) - lineX1.get(0), lineY1.get(0+1) - lineY1.get(0));
		}
		if(v1Last != v1) {
			lineX1.add(x1);
			lineY1.add(y1);System.out.println(x1 + " " + y1);
		}
			
		if(v1 == 0) y1 -= speed1;
		else if(v1 == 1) y1 += speed1;
		else if(v1 == 2) x1 -= speed1;
		else if(v1 == 3) x1 += speed1;
		
	
		
		if(v2 == 0) y2 -= speed2;
		else if(v2 == 1) y2 += speed2;
		else if(v2 == 2) x2 -= speed2;
		else if(v2 == 3) x2 += speed2;
		
		
		v2Last = v2;
		v1Last = v1;
		
		
	}

	@Override
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

	@Override
	protected void checkEnd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void resetGame() {

	}
	
	
	
}
