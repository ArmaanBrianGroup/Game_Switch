package Games;

import java.awt.Color;
import java.util.ArrayList;

import com.sun.glass.events.KeyEvent;

import Main.Image;
import Main.Input_Handler;

public class Snake extends GameScreen {

	private int velX1 = 0, velY1 = 0, velX2 = 0, velY2 = 0;
	private SnakeObj p1, p2;
	private final int speed = 5;
	
	public Snake(Image image, Input_Handler handler) {
		super(image, handler);
		p1 = new SnakeObj (image.getX()/4, image.getY()/4, 1, Color.white);
		p2 = new SnakeObj(image.getX()/4*3,image.getY()/4*3, 1, Color.white);
	}

	@Override
	protected void draw() {
		System.out.println(velY2);
		
		p1.adjustX(velX1);
		p1.adjustY(velY1);
		p2.adjustX(velX2);
		p2.adjustY(velY2);
		
		p1.draw(image);
		p2.draw(image);
	}

	@Override
	protected void processInput() {
		for (int i = 0; i < handler.getKeys().size(); i++) {
			int key = handler.getKeys().remove(i);
			if (key == KeyEvent.VK_UP) {
				velX2 = 0;
				velY2 = -speed;
			}
			if (key == KeyEvent.VK_DOWN) {
				velX2 = 0;
				velY2 = speed;
			}
			if (key == KeyEvent.VK_LEFT) {
				velY2 = 0;
				velX2 = -speed;
			}
			if (key == KeyEvent.VK_RIGHT) {
				velY2 = 0;
				velX2 = speed;
			}
			
			
			if (key == KeyEvent.VK_W) {
				velX1 = 0;
				velY1 = -speed;
			}
			if (key == KeyEvent.VK_S) {
				velX1 = 0;
				velY1 = speed;
			}
			if (key == KeyEvent.VK_A) {
				velY1 = 0;
				velX1 = -speed;
			}
			if (key == KeyEvent.VK_D) {
				velY1 = 0;
				velX1 = speed;
			}
			
			if (key == KeyEvent.VK_ENTER) {
				p2.addNode();
			}
		}
		
	}

	@Override
	protected void checkEnd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void resetGame() {
		velX1 = 0;
		velY1 = 0;
		velX2 = 0;
		velY2 = 0;
		p1 = new SnakeObj (image.getX()/4, image.getY()/4, 4, Color.white);
		p2 = new SnakeObj(image.getX()/4*3,image.getY()/4*3, 4, Color.white);
	}
	
	public class SnakeNode {
		private int x, y;
		public SnakeNode(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public void setX(int n) {
			x = n;
		}
		public void setY(int n) {
			y = n;
		}
		
		public int getX() {
			return x;
		}
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
		
		public SnakeObj(int x, int y, int nodeSize, Color color) {
			this.x = x;
			this.y = y;
			this.nodeSize = nodeSize;
			this.color = color;
			
			nodes = new ArrayList<SnakeNode>();
			nodes.add(new SnakeNode(x,y));
		}
		
		public void addNode() {
			nodes.add(new SnakeNode(lastX, lastY));
		}
		
		public void adjustX (int delta) {
			x = x+delta;
			int lastX = x;
			for (int i = 0; i < nodes.size(); i++) {
				int temp = nodes.get(i).getX();
				nodes.get(i).setX(lastX);
				lastX = temp;
			}
			//this.lastX = lastX;
		}
		
		public void adjustY (int delta) {
			y = y+delta;
			int lastY = y;
			for (int i = 0; i < nodes.size(); i++) {
				int temp = nodes.get(i).getY();
				nodes.get(i).setY(lastY);
				lastY = temp;
			}
			//this.lastY = lastY;
		}
		
		public void draw (Image image) {
			for (int i = 0; i < nodes.size(); i++) {
				image.drawRect(color, nodes.get(i).getX(), nodes.get(i).getY(), nodeSize, nodeSize);
			}
		}
	}

}
