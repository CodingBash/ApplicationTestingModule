package view;

import java.awt.Dimension;
import java.awt.Panel;

import javax.swing.JFrame;

public class ApplicationFrameView {

	public static JFrame mainFrame = new JFrame("Security Application");
	public static ApplicationPanelView mainPanel = new ApplicationPanelView();
	
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
