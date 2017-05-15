package Games;

import java.awt.Color;
import java.util.ArrayList;

import Main.Image;

public class Start extends Game {

	
	
	
	public Start(Image image, ArrayList<Integer> keys) {
		super(image, keys);
		// TODO Auto-generated constructor stub
	}

	public void run() {
		resetDone();
		while(done == false) {
			image.drawString(Color.white, "arman is", 100, 100);
			

			if(keys.size() > 0) {
				System.out.println("game has ended"); endGame();
				
			}
			
		}
	}

	
}
