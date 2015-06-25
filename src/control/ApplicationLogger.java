//TODO: Start on programming ApplicationLogger

package control;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

import view.ApplicationPanelView;

public class ApplicationLogger {

	private static ArrayList<String> logData;
	private static HashMap<String, String> headerList;
	private static boolean logAdditionFlag;

	public ApplicationLogger() {
		logAdditionFlag = true;
		headerList = new HashMap<String, String>();
		addHeaders();
		logData = new ArrayList<String>();
		addLog("info", "Initializing the logger");
	}

	private static void addHeaders() {
		headerList.put("info", "[INFO]:");
		headerList.put("error", "[ERROR]:");
		headerList.put("other", "[OTHER]:");
		headerList.put("import", "[IMPORTANT]");
		headerList.put("null", "");
	}

	public static void addLog(String type, String message) {
		logData.add(headerList.get(type) + message);
		logAdditionFlag=true;
	}
	
	public static void addLog(String message){
		logData.add( message);
		//logAdditionFlag=true;
	}
	public static void draw(Graphics g) {

		g.setFont(new Font("Consolas", 20, 15));
		int value = 20;
		//if (logAdditionFlag)
			for (int i = 0; i < logData.size(); i++) {
				refresh(g);
				g.setColor(Color.GREEN);
				g.drawString(
						logData.get(i),
						0,
						(ApplicationPanelView.HEIGHT * ApplicationPanelView.SCALE)
								- (i * value));
				if (logData.get(i).contains(headerList.get("info")))
					System.out.println(logData.get(i));
				if (logData.get(i).contains(headerList.get("error")))
					System.err.println(logData.get(i));
				if (logData.get(i).contains(headerList.get("null")))
					System.out.println(logData.get(i));
				
				logAdditionFlag = false;
			}
	}

	private static void refresh(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, ApplicationPanelView.WIDTH
				* ApplicationPanelView.SCALE, ApplicationPanelView.HEIGHT
				* ApplicationPanelView.SCALE);
		// TODO: Clear the console

	}

}
