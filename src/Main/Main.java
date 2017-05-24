package Main;


import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import Games.*;

public class Main {
	
	/**
	 * x dimension for screen
	 */
	public static int x = 1000;
	/**
	 * y dimension for screen
	 */
	public static int y = 1000;

	/**
	 * scores for both players
	 */
	private static int scoreA = 0, scoreB = 0;

	/**
	 * JFrame object that is the display for the user
	 */
	private static JFrame f = new JFrame();  
	/**
	 * the input handler, that takes in inputs and allows games to read them
	 */
	private static Input_Handler handler = new Input_Handler();
	/**
	 * the image object that is drawn to
	 */
	private static Image image = new Image(x, y);
	/**
	 * the image object that draws a completed buffered image from the image object to it
	 */
	private static Window w = new Window(image);

	/**
	 * stores whether the game should be transitioning (true) or should be running one of the games (false)
	 */
	private static boolean isTransitioning = false;
	
	/**
	 * the transition screen that should run whenever the game is transitioning to a new one
	 */
	private static GameScreen transitionScreen = new TransitionMenu(image, handler, 5, 15);
	
	/**
	 * the start menu for the beginning of the game
	 */
	private static GameScreen screen = new StartMenu(image, handler, 30);

	/**
	 * stores all of the different games that can be run
	 */
	private static GameScreen screens[] = {
			new LightBike(image, handler),
			new Pong(image, handler),
			new Snake(image, handler),
			new TicTacToe(image, handler),
			new DualShooter(image, handler)
	};


	/**
	 * the main class which sets up everything for the game and starts the loop
	 * @param args default parameter
	 */
	public static void main (String[] args) {
		f.add(w);
		f.addMouseListener(handler);
		f.addKeyListener(handler);
			        
		f.setSize(x+20, y+50); //for some reason the window is slightly smaller than the image even though they are set to the same value;
		f.setVisible(true);
		
		Timer t = new Timer(15);
		t.run();
	}
	
	/**
	 * updates the data for the games, renders each frame and displays it to the window
	 * first the start menu plays until the player presses a key
	 * then the loop begins a process of: randomly selecting a game to play, running it until a player has won, and then displaying the current score
	 * the game keeps running until players decide to stop
	 */
	public static void update() {
		screen.run();
		w.drawImage(image);
		image.resetImage();

		if(handler.getKeys().size() > 0 && handler.getKeys().get(0) == KeyEvent.VK_ESCAPE) System.exit(0);
		
		int state = screen.isDone();
		if (state != GameScreen.PLAYING) {
			if (state == GameScreen.PONE) scoreA++;
			else if (state == GameScreen.PTWO) scoreB++;
			
			isTransitioning = !isTransitioning;
			
			if (isTransitioning) screen = transitionScreen;
			else screen = screens[(int) (Math.random()*screens.length)];
			
		}
	}
	
	/**
	 * for the transition screen to get score data
	 * @return player 1 score
	 */
	public static int scoreA() {
		return scoreA;
	}
	
	/**
	 * for the transition screen to get score data
	 * @return player 2 score
	 */
	public static int scoreB() {
		return scoreB;
	}
		
}
