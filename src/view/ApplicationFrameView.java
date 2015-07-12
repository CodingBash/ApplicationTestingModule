package view;

import java.awt.Dimension;
import java.awt.Panel;

import javax.swing.JFrame;
/**
 * Main view of application.
 * 
 * @author Basheer
 * 
 * @see view.ApplicationPanelView
 *
 */
public class ApplicationFrameView {

	public static JFrame mainFrame = new JFrame("Security Application");
	public static ApplicationPanelView mainPanel = new ApplicationPanelView();
	
	/**
	 * Main method of application. Sets the JFrame, JPanel, and other view options.
	 * 
	 * @param args main method's array of strings
	 */
	public static void main(String[] args) {
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.add(mainPanel);
		mainFrame.pack();
		mainFrame.setPreferredSize(new Dimension(mainPanel.getWidth(), mainPanel.getHeight()));
		mainFrame.setVisible(true);
		mainPanel.setFocusable(true);
		mainFrame.setResizable(false);
		mainPanel.requestFocusInWindow();
		mainPanel.run();
		mainFrame.dispose();
	}

}
