package Games;

import java.util.ArrayList;

import Main.Image;
import Main.Input_Handler;

public abstract class GameScreen {
	protected Image image;
	protected Input_Handler handler;
	protected boolean done = false;
	
	public GameScreen(Image image, Input_Handler handler) {
		this.image = image;
		this.handler = handler; 
	}
	
	protected abstract void draw();
	protected abstract void processInput();
	protected abstract void checkEnd();
	protected abstract void resetGame();
	
	protected void endGame() {
		done = true;
	}
	
	public void run() {
		processInput();
		draw();
		checkEnd();
	}

	
	public boolean isDone() {
		if (!done) {
			return false;
		} else {
			done = false;
			resetGame();
			return true;
		}
	}
}
