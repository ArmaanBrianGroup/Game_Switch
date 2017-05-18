package Main;

public class Timer {
	private int FPS;
	private long lastRefresh;
	
	public Timer(int FPS) {
		this.FPS = FPS;
	}
	
	public void run() {
		while (true) {
			if (lastRefresh + 1000/FPS <= System.currentTimeMillis()) {
				lastRefresh = System.currentTimeMillis();
				Main.update();
			}
		}		
	}

}
