package Games;

import java.awt.Color;
import java.awt.event.KeyEvent;

import Main.Image;
import Main.Input_Handler;

public class DualShooter extends GameScreen {
	private final int triH = 20, triW = 40, speed = 5;
	private int y1, y2;
	private boolean shot1 = false, shot2 = false;

	public DualShooter(Image image, Input_Handler handler) {
		super(image, handler);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void draw() {
		if (y1 < 0) y1 = 0;
		else if (y1 + triH > image.getY()) y1 = image.getY() - triH;
		
		if (y2 < 0) y2 = 0;
		else if (y2 + triH > image.getY()) y2 = image.getY() - triH;
		
		image.drawHorizontalTriangle(Color.WHITE, 0, y1, triW, triH);
		image.drawHorizontalTriangle(Color.WHITE, image.getX(), y2, -triW, triH);
		
		
	}

	@Override
	protected void processInput() {
		while (handler.getKeys().size() > 0) {
			int key = handler.getKeys().remove(0);
			if (key == KeyEvent.VK_UP) y1-=speed;
			if (key == KeyEvent.VK_DOWN) y1+=speed;
			if (key == KeyEvent.VK_W) y2-=speed;
			if (key == KeyEvent.VK_S) y2+=speed;
			if (key == KeyEvent.VK_TAB) shot1 = true;
			if (key == KeyEvent.VK_ENTER) shot2 = true;
		}
	}

	@Override
	protected void checkEnd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void resetGame() {
		// TODO Auto-generated method stub
		
	}

}
