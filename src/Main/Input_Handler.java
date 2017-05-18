package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.event.MouseInputListener;





public class Input_Handler implements ActionListener, MouseListener, KeyListener, MouseInputListener {
	
	private ArrayList<Integer> keys = new ArrayList<Integer>();
	private int mouseX = 0, mouseY = 0;
	private boolean mouseClicked = false;

	@Override
	public void mouseClicked(MouseEvent e) {

	}
	@Override
	public void mouseEntered(MouseEvent e) {


	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		//System.exit(0);
		mouseClicked = true;
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {	
		keys.add(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		
	}
	
	public int getMouseX() {
		return mouseX;
	}
	
	public int getMouseY() {
		return mouseY;
	}
	
	public boolean getMouseClick() {
		if (mouseClicked) {
			mouseClicked = false;
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<Integer> getKeys() {
		return keys;
	}
	
	public void clearKeyList() {
		keys.removeAll(keys);
	}
}

