package Games;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Main.Image;
import Main.Input_Handler;

public class DualShooter extends GameScreen {
	
	private final int triH = 80, triW = 60, speed = 5, shotRad = 10;
	private int y1, y2;
	private int v1 = 0, v2= 0;
	private boolean shot1 = false, shot2 = false;
	private ArrayList<int[]> shots = new ArrayList<int[]>();

	/**
	 * 
	 * @param image to draw to
	 * @param handler to get inputs from
	 */
	public DualShooter(Image image, Input_Handler handler) {
		super(image, handler);
		// TODO Auto-generated constructor stub
	}

	/**
	 * draws to image 
	 */
	@Override
	protected void draw() {
		y1+=v1;
		y2+=v2;
		if (y1 < 0) y1 = 0;
		else if (y1 + triH > image.getY()) y1 = image.getY() - triH;
		
		if (y2 < 0) y2 = 0;
		else if (y2 + triH > image.getY()) y2 = image.getY() - triH;
		
		image.drawHorizontalTriangle(Color.WHITE, 0, y1, triW, triH);
		image.drawHorizontalTriangle(Color.WHITE, image.getX(), y2, -triW, triH);
		
		if (shot1) {
			shots.add(new int[]{y1+triH/2-shotRad, triW, 20});
			shot1 = false;
		} else if (shot2) {
			shots.add(new int[]{y2+triH/2-shotRad, image.getX()-triW, -20});
			shot2 = false;
		}
		
		for (int i = 0; i < shots.size(); i++) {
			image.drawCircle(Color.WHITE, shots.get(i)[1], shots.get(i)[0], shotRad);
			shots.get(i)[1] += shots.get(i)[2];
			if (shots.get(i)[1] <= 0 || shots.get(i)[1] + shotRad >= image.getX()) shots.remove(i);
		}
	}

	/**
	 * processes keyinput for game
	 */
	@Override
	protected void processInput() {
		while (handler.getKeys().size() > 0) {
			int key = handler.getKeys().remove(0);
			if (key == KeyEvent.VK_UP) v2 = -speed;
			if (key == KeyEvent.VK_DOWN) v2 = speed;
			if (key == KeyEvent.VK_W) v1 = -speed;
			if (key == KeyEvent.VK_S) v1 = speed;
			if (key == KeyEvent.VK_1) shot1 = true;
			if (key == KeyEvent.VK_BACK_SLASH) shot2 = true;
		}
	}

	/**
	 * checks if game should end
	 */
	@Override
	protected void checkEnd() {
		for (int i = 0; i < shots.size(); i++) {
			if (shots.get(i)[2] < 0 &&shots.get(i)[1] <= triW && shots.get(i)[0] <= y1 + triH && shots.get(i)[0] + shotRad*2 >= y1) {
				state = PTWO;
			}
			if (shots.get(i)[2] > 0 && shots.get(i)[1] + shotRad*2 >= image.getX()-triW && shots.get(i)[0] <= y1 + triH && shots.get(i)[0] + shotRad*2 >= y1) {
				state = PONE;
			}
		}
		
	}

	/**
	 * resets all instance variable for the next game
	 */
	@Override
	protected void resetGame() {
		shots.removeAll(shots);
		y1 = 0;
		y2 = 0;
		shot1 = false;
		shot2 = false;
		
		v1 = 0; 
		v2= 0;
	}

}
