package Games;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Main.Image;
import Main.Input_Handler;

public class Pong extends GameScreen{
	
	private final int paddleW = 20, paddleH = 150, speed = 5;
	private int y1, y2;
	
	private int velX, velY, ballX, ballY;
	private final int ballRad = 10;

	
	public Pong(Image image, Input_Handler handler) {
		super(image, handler);
		resetGame();
	}

	@Override
	public void draw() {
		if (y1 > image.getY()-paddleH) y1 = image.getY()-paddleH;
		else if (y1 < 0) y1 = 0;
		
		if (y2 > image.getY()-paddleH) y2 = image.getY()-paddleH;
		else if (y2 < 0) y2 = 0;
		
		if (ballY >= image.getY()-ballRad*2 || ballY <= 0) velY *= -1;
		
		image.drawRect(Color.WHITE, paddleW, y2, paddleW, paddleH);
		image.drawRect(Color.WHITE, image.getX()-paddleW, y1, paddleW, paddleH);
		image.drawCircle(Color.WHITE, ballX, ballY, ballRad);
		
		ballX += velX;
		ballY += velY;		
		
		if (ballX >= image.getX()-ballRad*2 || ballX <= 0) endGame();
	}

	@Override
	protected void processInput() {
		while (handler.getKeys().size() > 0) {
			int key = handler.getKeys().remove(0);
			if (key == KeyEvent.VK_UP) y1-=speed;
			if (key == KeyEvent.VK_DOWN) y1+=speed;
			if (key == KeyEvent.VK_W) y2-=speed;
			if (key == KeyEvent.VK_S) y2+=speed;
		}
	}

	@Override
	protected void checkEnd() {
		
	}

	@Override
	protected void resetGame() {
		y1 = image.getY()/2 - paddleH/2;
		y2 = image.getY()/2 - paddleH/2;
		
		velX = (int) (Math.random()*11);
		velY = (int) (Math.random()*11);
	
		ballX = image.getX()/2 - ballRad/2;
		ballY = image.getX()/2 - ballRad/2;
	}
}
