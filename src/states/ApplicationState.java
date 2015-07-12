//TODO: Figure added methods to define as an ApplicationState overtime

package states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 * Interface to contain what every state must have.
 * 
 * @author Basheer
 *
 */
public interface ApplicationState {
	public void init();

	public void draw(Graphics g);

	public void update();

	public void keyPressed(KeyEvent inputEvent);

	public void keyReleased(KeyEvent inputEvent);
}
