//TODO: Start on programming ApplicationLogger

package control;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

import model.LogData;
import view.ApplicationPanelView;

/**
 * Application Logger. Not part of any logic within software. Takes care of logs
 * throughout the code.
 * 
 * @author Basheer
 *
 */
public class ApplicationLogger {

	private static ArrayList<LogData> consoleLogs;
	private static ArrayList<LogData> screenLogs;
	private static HashMap<String, String> headerList;

	/**
	 * ApplicationLogger constructor. Creates list of headers and sets up
	 * logger.
	 */
	public ApplicationLogger() {
		consoleLogs = new ArrayList<LogData>();
		screenLogs = new ArrayList<LogData>();
		headerList = new HashMap<String, String>();
		addHeaders();
		addLog("info", "Initializing the logger", true, true);
	}

	/**
	 * Adds lists headers into headerList. Headers used to describe the type of
	 * log given.
	 * 
	 */
	private static void addHeaders() {
		headerList.put("info", "[INFO]:");
		headerList.put("error", "[ERROR]:");
		headerList.put("warn", "[WARN]:");
		headerList.put("other", "[OTHER]:");
		headerList.put("import", "[IMPORTANT]");
		headerList.put("null", "");
	}

	/**
	 * Public method to addLog to console or screen.
	 * 
	 * @param type
	 *            header of log data provided.
	 * @param message
	 *            of log data provided.
	 * @param displayScreen
	 *            indicates if log should display on screen.
	 * @param displayConsole
	 *            indicates if log should display on console.
	 */
	public static void addLog(String type, String message,
			boolean displayScreen, boolean displayConsole) {
		if (displayScreen) {
			screenLogs.add(new LogData(headerList.get(type), message));
		}
		if (displayConsole) {
			consoleLogs.add(new LogData(headerList.get(type), message));
			printLogToConsole();
		}
	}

	/**
	 * Prints latest addition of the consoleLogs to the console.
	 * 
	 */
	private static void printLogToConsole() {
		// Would be simpler to not have a consoleLog list and print to console on
		// addition.
		// Added consoleLogs list if we need the information for later.
		if (consoleLogs.get(consoleLogs.size() - 1).getType()
				.equals(headerList.get("info")))
			System.out.println(consoleLogs.get(consoleLogs.size() - 1)
					.getFullMessage());
		if (consoleLogs.get(consoleLogs.size() - 1).getType()
				.equals(headerList.get("error")))
			System.err.println(consoleLogs.get(consoleLogs.size() - 1)
					.getFullMessage());
		if (consoleLogs.get(consoleLogs.size() - 1).getType()
				.equals(headerList.get("null")))
			System.out.println(consoleLogs.get(consoleLogs.size() - 1)
					.getFullMessage());
	}

	/**
	 * Draws logger on screen and displays on console.
	 * 
	 * @param g
	 *            Graphics object to control elements on panel.
	 */
	public static void draw(Graphics g) {
		g.setFont(new Font("Consolas", 20, 15));
		int indexValue = 20;
		for (int i = 0; i < screenLogs.size(); i++) {
			refresh(g);
			g.setColor(Color.GREEN);
			g.drawString(screenLogs.get(i).getFullMessage(), 0,
					(ApplicationPanelView.HEIGHT * ApplicationPanelView.SCALE)
							- (i * indexValue));
		}
	}

	/**
	 * Refreshes the logger screen.
	 * 
	 * @param g
	 *            Graphics object to control elements on panel.
	 */
	private static void refresh(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, ApplicationPanelView.WIDTH
				* ApplicationPanelView.SCALE, ApplicationPanelView.HEIGHT
				* ApplicationPanelView.SCALE);
		// TODO: Clear the console

	}
}
