package Main;

public class Timer {
	private int FPS;
	
	public Timer(int FPS) {
		this.FPS = FPS;
	}
	
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000/FPS);
				Main.update();
			} catch (InterruptedException e) {
				e.printStackTrace();
			};
		}		
	}

}
