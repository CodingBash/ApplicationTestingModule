//TODO: Figure added methods to define as an ApplicationState overtime

package control;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public interface ApplicationState {
	public void init();
	public void draw(Graphics g);
	public void update();
	public void keyPressed(KeyEvent inputEvent);
	public void keyReleased(KeyEvent inputEvent);
}
