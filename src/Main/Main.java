package Main;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

import Games.Game;
import Games.Start;
import Main.Input_Handler;

public class Main {
	
	private static Window w;
	private static JFrame f;
	public static int x;
	public static int y;
	private static Input_Handler handler;
	public int subX, subY;
	private static Image image;
	private static int scoreA, scoreB;
	public static ArrayList<Integer> keys;

	public static void main (String[] args) {
		x = 1000;
		y = 1000;
	
		image = new Image(x, y);
		w = new Window(x, y, image);  
		
		f = new JFrame();  
		f.add(w);  
		w.addMouseListener(handler);

			        
		f.setSize(x, y);
		f.setVisible(true);
		
		Timer t = new Timer(60);
		t.run();
	}
	
	public static void update() {
		

		Game start = new Start(image, keys);
		start.run();
		
		
	}
	
		
}
