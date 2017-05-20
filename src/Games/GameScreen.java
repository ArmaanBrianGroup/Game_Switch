package Games;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Main.Image;
import Main.Input_Handler;

public abstract class GameScreen {
	protected Image image;
	protected Input_Handler handler;
	protected boolean done = false;
	public static final int MENUEND = -1, PLAYING = 0, PONE = 1, PTWO = 21; 
	protected int state = PLAYING;
	protected int framesPassed = 0;
	
	/**
	 * @param image for drawing
	 * @param handler for inputs
	 */
	public GameScreen(Image image, Input_Handler handler) {
		this.image = image;
		this.handler = handler; 
	}
	
	/**
	 * drawing to image
	 */
	protected abstract void draw();
	/**
	 * processing inputs
	 */
	protected abstract void processInput();
	/**
	 * checking if game should end
	 */
	protected abstract void checkEnd();
	/**
	 * reseting instance variables
	 */
	protected abstract void resetGame();

	/**
	 * calls methods for processing input, drawing, and checing if game should end
	 */
	public void run() {
		framesPassed++;
		
		processInput();
		draw();
		checkEnd();		
	}

	/**
	 * 
	 * @return the state of the game
	 */
	public int isDone() {
		if (state == PLAYING) {
			return state;
		} else {
			int stateWas = state;
			state = PLAYING;
			framesPassed = 0;
			resetGame();
			return stateWas;
		}
	}
}
