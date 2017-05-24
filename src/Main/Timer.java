package Main;

public class Timer {
	/**
	 * stores the FPS that the game should be run at
	 */
	private int FPS;
	
	/**
	 * 
	 * @param FPS to run at
	 */
	public Timer(int FPS) {
		this.FPS = FPS;
	}
	
	/**
	 * run timer in infinite loop, updating the game at the fps desired
	 */
	public void run() {
		long lastRefresh = 0;
		while (true) {
			if (lastRefresh + 1000/FPS <= System.currentTimeMillis()) {
				lastRefresh = System.currentTimeMillis();
				Main.update();
			}
		}		
	}

}
