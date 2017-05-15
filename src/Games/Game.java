package Games;

import java.util.ArrayList;

import Main.Image;
import Main.Input_Handler;

public abstract class Game {
	protected Image image;
	protected Input_Handler handler;
	protected boolean done;
	protected ArrayList<Integer> keys;
	
	public Game(Image image, ArrayList<Integer> keys) {
		this.image = image;
		this.keys = keys;
		resetDone();
	}
	
	public abstract void run();
	
	public void resetDone() {
		done = false;
	}
	public void endGame() {
		done = true;
	}
}
