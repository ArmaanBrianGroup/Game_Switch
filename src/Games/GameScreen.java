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
	
	public GameScreen(Image image, Input_Handler handler) {
		this.image = image;
		this.handler = handler; 
	}
	
	protected abstract void draw();
	protected abstract void processInput();
	protected abstract void checkEnd();
	protected abstract void resetGame();

	
	public void run() {
		processInput();
		draw();
		checkEnd();
		
		if(handler.getKeys().size() > 0 && handler.getKeys().get(0) == KeyEvent.VK_ESCAPE) System.exit(0);
		
	}

	
	public int isDone() {
		if (state == PLAYING) {
			return state;
		} else {
			int stateWas = state;
			state = PLAYING;
			resetGame();
			return stateWas;
		}
	}
}
