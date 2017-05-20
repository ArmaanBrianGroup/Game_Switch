package Main;

public class Timer {
	private int FPS;
	private long lastRefresh;
	
	/**
	 * 
	 * @param FPS to run at
	 */
	public Timer(int FPS) {
		this.FPS = FPS;
	}
	
	/**
	 * run timer in infinite loop
	 */
	public void run() {
		while (true) {
			if (lastRefresh + 1000/FPS <= System.currentTimeMillis()) {
				lastRefresh = System.currentTimeMillis();
				Main.update();
			}
		}		
	}

}
