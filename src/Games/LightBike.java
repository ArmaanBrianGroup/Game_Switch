package Games;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Main.Image;
import Main.Input_Handler;

public class LightBike extends GameScreen {
	
	private int x1, y1, x2, y2;
	private int v1, v2, v1Last, v2Last; //0 up, 1 down, 2 left, 3 right
	private boolean[][] line1, line2;
	
	/**
	 * constructor that initializes variables
	 * @param image
	 * @param handler
	 */
	public LightBike(Image image, Input_Handler handler) {
		super(image, handler);

		x1 = 900; y1 = 900;
		x2 = 100; y2 = 100; 
		v1 = 0; v2 = 1; v1Last = 0; v2Last = 1;

		line1 = new boolean[100][100];
		line2 = new boolean[100][100];
	}

	/**
	 * draws and runs logic for the game
	 */
	protected void draw() {

		image.drawRect(Color.red, x1, y1, 10, 10); 
		image.drawRect(Color.blue, x2, y2, 10, 10);


		for(int y = 0; y < line1.length; y++) {
			for(int x = 0; x < line1[0].length; x++) {
				if(line1[y][x] == true) image.drawRect(Color.pink, 10*y, 10*x, 10, 10);
			}
		}
		for(int y = 0; y < line1.length; y++) {
			for(int x = 0; x < line1[0].length; x++) {
				if(line2[y][x] == true) image.drawRect(Color.magenta, 10*y, 10*x, 10, 10);
			}
		}
		
		if(x1 >= 0 && x1 <= 1000 && y1 >= 0 && y1 <= 1000) line1[x1/10][y1/10] = true;
		if(x2 >= 0 && x2 <= 1000 && y2 >= 0 && y2 <= 1000) line2[x2/10][y2/10] = true;

		if(v1 == 0 && v1Last == 1) v1 = 1;
		if(v1 == 1 && v1Last == 0) v1 = 0;
		if(v1 == 2 && v1Last == 3) v1 = 3;
		if(v1 == 3 && v1Last == 2) v1 = 2;
		if(v2 == 0 && v2Last == 1) v2 = 1;
		if(v2 == 1 && v2Last == 0) v2 = 0;
		if(v2 == 2 && v2Last == 3) v2 = 3;
		if(v2 == 3 && v2Last == 2) v2 = 2;
		
		if(v1 == 0) {
			y1 -= 10;
		}
		else if(v1 == 1) {
			y1 += 10;
		}
		else if(v1 == 2) {
			x1 -= 10;
		}
		else if(v1 == 3) {
			x1 += 10;
		}
		
		
		if(v2 == 0) {
			y2 -= 10;
		}
		else if(v2 == 1) {
			y2 += 10;
		}
		else if(v2 == 2) {
			x2 -= 10;
		}
		else if(v2 == 3) {
			x2 += 10;
		}
		
		v1Last = v1;
		v2Last = v2;
		
	}

	/**
	 * processes inputs of up down left and right to v1 and v2, which are states
	 * 0 is up, 1 is down, 2 is left, 3 is right
	 */
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

	/**
	 * ends game if any player hits a border or a lazer
	 * if it happens simultaneously, it results in a tie
	 */
	@Override
	protected void checkEnd() {
		boolean temp = false;
		if(!(x1 >= 0 && x1 <= 1000 && y1 >= 0 && y1 <= 1000)) {state = PTWO; temp = true;}
		if(!(x2 >= 0 && x2 <= 1000 && y2 >= 0 && y2 <= 1000)) {state = PONE;}
		if(temp == true && state == PONE) state = MENUEND;

		temp = false;
		if(state == 0) {
			if(line1[x1/10][y1/10] == true || line2[x1/10][y1/10] == true) {state = PTWO; temp = true;}  
			if(line1[x2/10][y2/10] == true || line2[x2/10][y2/10] == true) {state = PONE;}
			if(temp == true && state == PONE) state = MENUEND;
		}
	}

	/**
	 * resets variables
	 */
	@Override
	protected void resetGame() {
		x1 = 900; y1 = 900;
		x2 = 100; y2 = 100; 
		v1 = 0; v2 = 1;

		line1 = new boolean[100][100];
		line2 = new boolean[100][100];
	}
	
	
}
