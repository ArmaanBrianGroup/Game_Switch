package Games;

import java.awt.Color;

import Main.Image;
import Main.Input_Handler;

public class TicTacToe extends GameScreen {
	public final int BLANK = 0, P1 = 1, P2 = 2;
	public int[][] board = new int[3][3]; 
	public boolean p1Turn;

	public TicTacToe(Image image, Input_Handler handler) {
		super(image, handler);
		p1Turn = Math.random() <= .5;
	}

	@Override
	protected void draw() {
		image.drawLine(Color.white, image.getX()/3, image.getX()/3, 0, image.getY());
		image.drawLine(Color.white, image.getX()/3*2, image.getX()/3*2, 0, image.getY());
		image.drawLine(Color.white, 0, image.getX(), image.getY()/3, image.getY()/3);
		image.drawLine(Color.white, 0, image.getX(), image.getY()/3*2, image.getY()/3*2);
		
		for (int i = 0; i < board.length; i++) {
			for (int x = 0; x < board[i].length; x++) {
				if (board[i][x] == P1) {
					int a = image.getX()/3*i;
					int b = image.getY()/3*x;
					image.drawUnfilledCircle(Color.white, a, b, image.getX()/6);
				} else if (board[i][x] == P2) {
					int a = image.getX()/3*i;
					int b = image.getY()/3*x;
					image.drawX(Color.white, a, b, image.getX()/3, image.getX()/3);
				}
			}
		}
	}

	@Override
	protected void processInput() {
		if (handler.getMouseClick()) {
			int posX = handler.getMouseX()/(image.getX()/3), posY = handler.getMouseY()/(image.getY()/3);
			if (board[posX][posY] == BLANK) {
				board[posX][posY] = p1Turn ? P1 : P2;
				p1Turn = !p1Turn;
			}
		}
		
	}

	@Override
	protected void checkEnd() {
		int p1 = 0, p2 = 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] == P1) p1++;
			if (board[i][0] == P2) p2++;
		}
		
		if (p1 == 3) state = PONE;
		else if (p2 == 3) state = PTWO;
		
		p1 = 0;
		p2 = 0;
		for (int i = 0; i < board[0].length; i++) {
			if (board[0][i] == P1) p1++;
			if (board[0][i] == P2) p2++;
		}
		
		if (p1 == 3) state = PONE;
		else if (p2 == 3) state = PTWO;

		p1 = 0;
		p2 = 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i][i] == P1) p1++;
			if (board[i][i] == P2) p2++;
		}
		
		if (p1 == 3) state = PONE;
		else if (p2 == 3) state = PTWO;
		
		p1 = 0;
		p2 = 0;
		for (int i = 0, x = board.length-1; i < board.length; i++, x--) {
			if (board[i][x] == P1) p1++;
			if (board[i][x] == P2) p2++;
		}
		
		if (p1 == 3) state = PONE;
		else if (p2 == 3) state = PTWO;
		
	}

	@Override
	protected void resetGame() {
		board = new int[3][3];
		p1Turn = Math.random() <= .5;
	}

}
