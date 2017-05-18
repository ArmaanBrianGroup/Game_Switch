package Main;


import javax.swing.JFrame;
import Games.*;

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

	private static GameScreen screens[] = {new TicTacToe(image, handler)};


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
		if (state != GameScreen.PLAYING) {
			if (state == GameScreen.PONE) scoreA++;
			else if (state == GameScreen.PTWO) scoreB++;
			
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
