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
	
	
	public Input_Handler() {
	}

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
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) Main.keys.add(1);
		if (e.getKeyCode() == KeyEvent.VK_DOWN) Main.keys.add(2);
		if (e.getKeyCode() == KeyEvent.VK_LEFT) Main.keys.add(3);
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) Main.keys.add(4);
		if (e.getKeyCode() == KeyEvent.VK_W) Main.keys.add(5);
		if (e.getKeyCode() == KeyEvent.VK_S) Main.keys.add(6);
		if (e.getKeyCode() == KeyEvent.VK_A) Main.keys.add(7);
		if (e.getKeyCode() == KeyEvent.VK_D) Main.keys.add(8);

		
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
		// TODO Auto-generated method stub
		
	}
}

