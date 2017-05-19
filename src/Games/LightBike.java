package Games;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Main.Image;
import Main.Input_Handler;

public class LightBike extends GameScreen {
	private int x1, y1, x2, y2, speed1, speed2, size1, size2;
	private int v1, v2, v1Last, v2Last; //0 up, 1 down, 2 left, 3 right
	private ArrayList<LazerPart> line1, line2;
	private LazerPart lazer;
	
	public LightBike(Image image, Input_Handler handler) {
		super(image, handler);

		x1 = 400; y1 = 400;
		x2 = 100; y2 = 100; 
		v1 = 0; v2 = 1;
		speed1 = 7; speed2 = 7;
	
		size1 = 20; size2 = 20;
		line1 = new ArrayList<LazerPart>();
		line2 = new ArrayList<LazerPart>();
		lazer = new LazerPart(0,0,size1);
	}

	protected void draw() {

		image.drawRect(Color.red, x1, y1, size1, size1); 
		image.drawRect(Color.blue, x2, y2, size2, size2);


		if(v1Last != v1) {
			LazerPart lazer = new LazerPart(x1, y1, size1);
			line1.add(lazer);
		
		}
		
		for(int i = 0; i < line1.size(); i++) {
			line1.get(i).draw();
			System.out.println("asdf");
		}
		

		if(v1 == 0) {
			y1 -= speed1;
			lazer.increaseY(-speed1);
		}
		else if(v1 == 1) {
			y1 += speed1;
			lazer.increaseY(speed1);
		}
		else if(v1 == 2) {
			x1 -= speed1;
			lazer.increaseX(-speed1);
		}
		else if(v1 == 3) {
			x1 += speed1;
			lazer.increaseX(speed1);
		}
		
		
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
	
	
	public class LazerPart {
		private int x0, y0, x, y;
		private final int size;
		
		public LazerPart(int x, int y, int size) {
			x0 = x;
			y0 = y;
			this.x = x;
			this.y =y;
			this.size = size;
		}
		
		public void increaseX(int delta) {
			x+=delta;
		}
		
		public void increaseY(int delta) {
			y+=delta;
		}
		
		public void draw() {
			if (x0 == x) {
				image.drawRect(Color.WHITE, x0, y0, size, y0-y);
			} else {
				image.drawRect(Color.WHITE, x0, y0, x0-x, size);
			}
		}
		
	}
}
