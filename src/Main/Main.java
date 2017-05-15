package Main;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

import Games.GameScreen;
import Games.Pong;
import Games.StartMenu;
import Games.TransitionMenu;
import Main.Input_Handler;

public class Main {
	
	
	public static int x = 1000;
	public static int y = 1000;
	private static int scoreA = 0, scoreB = 0;

	private static JFrame f = new JFrame();  
	private static Input_Handler handler = new Input_Handler();
	private static Image image = new Image(x, y);
	private static Window w = new Window(image);

	private static boolean isTransitioning = false;
	private static GameScreen transitionScreen = new TransitionMenu(image, handler, 30, 60);
	private static GameScreen screen = new StartMenu(image, handler, 30);
	private static GameScreen screens[] = {new Pong(image, handler)};


	public static void main (String[] args) {
		f.add(w);
		f.addMouseListener(handler);
		f.addKeyListener(handler);
			        
		f.setSize(x+20, y+50); //for some reason the window is slightly smaller than the image even though they are set to the same value;
		f.setVisible(true);
		
		Timer t = new Timer(60);
		t.run();
	}
	
	public static void update() {
		screen.run();
		w.drawImage(image);
		image.resetImage();
		
		int state = screen.isDone();
		if (state != 0) {
			System.out.println(state);
			if (state == 1) scoreA++;
			else if (state == 2) scoreB++;
			
			isTransitioning = !isTransitioning;
			
			if (isTransitioning) screen = transitionScreen;
			else screen = screens[(int) (Math.random()*screens.length)];
		}
	}
	
	public static int scoreA() {
		return scoreA;
	}
	
	public static int scoreB() {
		return scoreB;
	}
		
}
