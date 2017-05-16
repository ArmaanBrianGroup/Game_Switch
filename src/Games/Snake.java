package Games;

import java.awt.Color;
import java.util.ArrayList;

import Main.Image;
import Main.Input_Handler;

public class Snake extends GameScreen {

	private int x1, x2, y1, y2;
	private SnakeObj p1, p2;
	private int speed;
	
	public Snake(Image image, Input_Handler handler) {
		super(image, handler);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void draw() {
		p1.draw(image);
		p2.draw(image);
		
		
		
	}

	@Override
	protected void processInput() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void checkEnd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void resetGame() {
		x1 = image.getX()/4;
		y1 = image.getY()/4;
		
		x2 = image.getX()/4*3;
		y2 = image.getY()/4*3;
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
			int lastX = x+delta;
			for (int i = 0; i < nodes.size(); i++) {
				int temp = nodes.get(i).getX();
				nodes.get(i).setX(lastX);
				lastX = temp;
			}
			this.lastX = lastX;
		}
		
		public void adjustY (int delta) {
			int lastY = y+delta;
			for (int i = 0; i < nodes.size(); i++) {
				int temp = nodes.get(i).getY();
				nodes.get(i).setY(lastY);
				lastY = temp;
			}
			this.lastY = lastY;
		}
		
		public void draw (Image image) {
			for (int i = 0; i < nodes.size(); i++) {
				image.drawRect(color, nodes.get(i).getX(), nodes.get(i).getY(), nodeSize, nodeSize);
			}
		}
	}

}
