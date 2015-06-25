//TODO: Figure which controlManager methods to call

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import control.ControlManager;
import control.InputAdapter;

@SuppressWarnings("serial")
public class ApplicationPanelView extends JPanel {

	public static final int HEIGHT = 240;
	public static final int WIDTH = 320;
	public static final int SCALE = 2;
	private static final int FPS = 60;
	private static final long targetTime = 1000 / FPS;
	public boolean running = true;
	public static ControlManager control;

	public ApplicationPanelView() {
		control = new ControlManager();
		addKeyListener(control.INPUT);
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setBackground(Color.BLACK);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		control.draw(g);
	}

	public void init() {
		// EMPTY
	}

	public void run() {
		init();

		long startTime;
		long elapsedTime;
		long wait;

		while (running) {
			startTime = System.nanoTime();
			//control.update();
			repaint();
			elapsedTime = System.nanoTime() - startTime;
			wait = targetTime - elapsedTime / ((long) (Math.pow(10, 9)));
			delay((int) wait);
		}
	}

	public void delay(int n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

}
