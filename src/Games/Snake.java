package Games;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Main.Image;
import Main.Input_Handler;

public class Snake extends GameScreen {

	private int velX1 = 0, velY1 = 0, velX2 = 0, velY2 = 0;
	private SnakeObj p1, p2;
	private final int speed = 20, framesTillLenIncrease = 60, framesTillMove = 10;
	private final Color c = Color.green;
	/**
	 * 	
	 * @param image for drawing 
	 * @param handler for inputs
	 */
	public Snake(Image image, Input_Handler handler) {
		super(image, handler);
		p1 = new SnakeObj (image.getX()/4, image.getY()/4, speed, c);
		p2 = new SnakeObj(image.getX()/4*3,image.getY()/4*3, speed, c);
	}

	/**
	 * drawing to image
	 */
	@Override
	protected void draw() {				
		if (framesPassed % framesTillMove == 0) {
			p1.adjustX(velX1);
			p1.adjustY(velY1);
			p2.adjustX(velX2);
			p2.adjustY(velY2);
		}
		
		p1.draw(image);
		p2.draw(image);
		
		if (((velX1 != 0 || velY1 != 0) && (velX2 != 0 || velY2 != 0)) && framesPassed % framesTillLenIncrease == 0){
			p1.addNode();
			p2.addNode();
		}
	}

	/**
	 * processing inputs from handler
	 */
	@Override
	protected void processInput() {
		for (int i = 0; i < handler.getKeys().size(); i++) {
			int key = handler.getKeys().remove(i);
			if (key == KeyEvent.VK_UP && velY2 != speed) {
				velX2 = 0;
				velY2 = -speed;
			}
			if (key == KeyEvent.VK_DOWN && velY2 != -speed) {
				velX2 = 0;
				velY2 = speed;
			}
			if (key == KeyEvent.VK_LEFT && velX2 != speed) {
				velY2 = 0;
				velX2 = -speed;
			}
			if (key == KeyEvent.VK_RIGHT && velX2 != -speed) {
				velY2 = 0;
				velX2 = speed;
			}
			
			if (key == KeyEvent.VK_W && velY1 != speed) {
				velX1 = 0;
				velY1 = -speed;
			}
			if (key == KeyEvent.VK_S && velY1 != -speed) {
				velX1 = 0;
				velY1 = speed;
			}
			if (key == KeyEvent.VK_A && velX1 != speed) {
				velY1 = 0;
				velX1 = -speed;
			}
			if (key == KeyEvent.VK_D && velX1 != -speed) {
				velY1 = 0;
				velX1 = speed;
			}
		}
		
	}

	/**
	 * checking if game should end
	 */
	@Override
	protected void checkEnd() {
		if (p1.checkCollision(p1.getX(), p1.getY()) || p2.checkCollision(p1.getX(), p1.getY())) state = PTWO;
		else if (p2.checkCollision(p2.getX(), p2.getY()) || p1.checkCollision(p2.getX(), p2.getY())) state = PONE;
		else if (p1.getX() <= 0 || p1.getX() >= image.getX() || p1.getY() <= 0 || p1.getY() >= image.getY()) state = PTWO;
		else if (p2.getX() <= 0 || p2.getX() >= image.getX() || p2.getY() <= 0 || p2.getY() >= image.getY()) state = PONE;
	}

	/**
	 * reseting game for next play
	 */
	@Override
	protected void resetGame() {
		velX1 = 0;
		velY1 = 0;
		velX2 = 0;
		velY2 = 0;
		
		p1 = new SnakeObj (image.getX()/4, image.getY()/4, speed, c);
		p2 = new SnakeObj(image.getX()/4*3,image.getY()/4*3, speed, c);
		
		framesPassed = 0;
	}
	
	public class SnakeNode {
		private int x, y;
		/**
		 * @param x cord
		 * @param y cord
		 */
		public SnakeNode(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		/**
		 * 
		 * @param sets x to value n
		 */
		public void setX(int n) {
			x = n;
		}
		/**
		 * 
		 * @param sets y to value n
		 */
		public void setY(int n) {
			y = n;
		}
		
		/**
		 * 
		 * @return x value
		 */
		public int getX() {
			return x;
		}
		
		/**
		 * 
		 * @return y value
		 */
		public int getY() {
			return y;
		}
	}
	
	public class SnakeObj {
		private int x, y;
		private int lastX, lastY;
		private ArrayList<SnakeNode> nodes;
		private int nodeSize;
		private Color color;
		
		/**
		 * 
		 * @param x of head node
		 * @param y of head node
		 * @param nodeSize size of each node for drawing
		 * @param color of each node for drawing
		 */
		public SnakeObj(int x, int y, int nodeSize, Color color) {
			this.x = x;
			this.y = y;
			this.nodeSize = nodeSize;
			this.color = color;
			
			nodes = new ArrayList<SnakeNode>();
			nodes.add(new SnakeNode(x,y));
		}
		
		/**
		 * 
		 * @return x cord
		 */
		public int getX() {
			// TODO Auto-generated method stub
			return x;
		}

		/**
		 * 
		 * @return y cord
		 */
		public int getY() {
			// TODO Auto-generated method stub
			return y;
		}

		/**
		 * a new node is added to snake at the last positon of last node
		 */
		public void addNode() {
			nodes.add(new SnakeNode(lastX, lastY));
		}
		
		/**
		 * 
		 * @param delta of x
		 */
		public void adjustX (int delta) {
			x = x+delta;
			int lastX = x;
			for (int i = 0; i < nodes.size(); i++) {
				int temp = nodes.get(i).getX();
				nodes.get(i).setX(lastX);
				lastX = temp;
			}
			this.lastX = lastX;
		}
		
		/**
		 * 
		 * @param delta of y
		 */
		public void adjustY (int delta) {
			y = y+delta;
			int lastY = y;
			for (int i = 0; i < nodes.size(); i++) {
				int temp = nodes.get(i).getY();
				nodes.get(i).setY(lastY);
				lastY = temp;
			}
			this.lastY = lastY;
		}
		
		/**
		 * 
		 * @param image to draw to
		 */
		public void draw (Image image) {
			for (int i = 0; i < nodes.size(); i++) {
				image.drawRect(color, nodes.get(i).getX(), nodes.get(i).getY(), nodeSize, nodeSize);
			}
		}
		
		/**
		 * 
		 * @param x cord to be checked against
		 * @param y cord to be checked against
		 * @return true if a snake node will codie with the given coardinate
		 */
		public boolean checkCollision(int x, int y) {
			for (int i = 1; i < nodes.size(); i++) {
				if (nodes.get(i).getX() == x && nodes.get(i).getY() == y) return true;
			}
			return false;
		}
	}

}
