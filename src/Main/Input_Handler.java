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

	/**
	 * deals with mouse clicks
	 */
	@Override
	public void mouseClicked(MouseEvent e) {

	}
	/**
	 * deals with mouse entering screen
	 */
	@Override
	public void mouseEntered(MouseEvent e) {


	}

	/**
	 * deals with mouse exiting screen
	 */
	@Override
	public void mouseExited(MouseEvent e) {

	}

	/**
	 * deals with mouse presses
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		//System.exit(0);
		mouseClicked = true;
		mouseX = e.getX();
		mouseY = e.getY();
	}

	/**
	 * deals with mouse releases
	 */
	@Override
	public void mouseReleased(MouseEvent e) {

	}

	/**
	 * deals with keypresses
	 */
	@Override
	public void keyPressed(KeyEvent e) {	
		keys.add(e.getKeyCode());
	}

	/**
	 * deals with key releases
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	/**
	 * deals with key types
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	/**
	 * deals with actions performed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	/**
	 * deals with mouse being dragged
	 */
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * deals with mouse being moved
	 */
	@Override
	public void mouseMoved(MouseEvent arg0) {
		
	}
	
	/**
	 * @return x cord of last click
	 */
	public int getMouseX() {
		return mouseX;
	}
	
	/**
	 * 
	 * @return y cord of last click
	 */
	public int getMouseY() {
		return mouseY;
	}
	
	/**
	 * 
	 * @return mouse has been clicked
	 */
	public boolean getMouseClick() {
		if (mouseClicked) {
			mouseClicked = false;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @return arraylist of keys 
	 */
	public ArrayList<Integer> getKeys() {
		return keys;
	}
	
	/**
	 * clears all keys from key array list
	 */
	public void clearKeyList() {
		keys.removeAll(keys);
	}
}

