//TODO: Determine if mouse input is needed
//Lucas Test

package adapters;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import control.ControlManager;

/**
 * Controls input within the program.
 * 
 * @author Basheer
 *
 */
public class InputAdapter implements KeyListener {

	ControlManager mainControl;
	
	public InputAdapter(ControlManager mainControl) {
			this.mainControl = mainControl;
	}

/*
	@Override
	public void mouseClicked(MouseEvent inputEvent) {
		mainControl.mouseClicked(inputEvent);
	}

	@Override
	public void mouseEntered(MouseEvent inputEvent) {
		mainControl.mouseEntered(inputEvent);
	}

	@Override
	public void mouseExited(MouseEvent inputEvent) {
		mainControl.mouseExited(inputEvent);
	}

	@Override
	public void mousePressed(MouseEvent inputEvent) {
		mainControl.mousePressed(inputEvent);
	}

	@Override
	public void mouseReleased(MouseEvent inputEvent) {
		mainControl.mouseReleased(inputEvent);
	}
*/
	@Override
	public void keyPressed(KeyEvent inputEvent) {
		mainControl.keyPressed(inputEvent);
	}

	@Override
	public void keyReleased(KeyEvent inputEvent) {
		mainControl.keyReleased(inputEvent);
	}

	@Override
	public void keyTyped(KeyEvent inputEvent) {
		//mainControl.keyTyped(inputEvent);
	}
}
