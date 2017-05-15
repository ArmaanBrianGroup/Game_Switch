package Main;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

import Games.GameScreen;
import Games.Pong;
import Games.StartMenu;
import Main.Input_Handler;

public class Main {
	
	
	public static int x = 1000;
	public static int y = 1000;
	private static int scoreA, scoreB;

	private static JFrame f = new JFrame();  
	private static Input_Handler handler = new Input_Handler();
	private static Image image = new Image(x, y);
	private static Window w = new Window(image);

	
	private static GameScreen screen = new StartMenu(image, handler);
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
		
		if (screen.isDone()) {
			screen = screens[(int) (Math.random()*screens.length)];
		}
	}
	
		
}
