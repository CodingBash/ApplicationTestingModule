//TODO: More efficient way to receive a formatted package name (getName function?)
//TODO: Data flow to LOGGER object

package control;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;

import model.AnalysisObject;

public class ControlManager {

	public ArrayList<ApplicationState> applicationStatesList;
	public String currentState;
	public HashMap<String, ApplicationState> stateTitleList;
	public InputAdapter INPUT;
	public ApplicationLogger LOGGER;
	public AnalysisObject OBJECT;
	public TestState state1 = new TestState();

	public ControlManager() {
		LOGGER = new ApplicationLogger();
		ApplicationLogger.addLog("info","Setting up the program");
		INPUT = new InputAdapter(this);
		OBJECT = new AnalysisObject("SE_Example_1.txt");
		stateTitleList = new HashMap<String, ApplicationState>();
		applicationStatesList = new ArrayList<ApplicationState>();
		insertAllStateOptions();
		importAllStateOptions();
		ApplicationLogger.addLog("null", "-------------------------"); //End setup
	}

	public void insertAllStateOptions() {
		ApplicationLogger.addLog("info", "Adding available states to list");
		applicationStatesList.add(state1); // <-- This constructs the object
	}

	public void importAllStateOptions() {
		ApplicationLogger.addLog("info", "Adding available state objects to list");
		if (applicationStatesList.size() != 0)
			for (ApplicationState currentState : applicationStatesList) {
				if (currentState == null)
					break; /*ArrayList automatically reserves 10 indexes which some may be null */
				stateTitleList
						.put(formatClassName(currentState.getClass().getName(),
								currentState.getClass().getPackage().toString()),
								currentState);
			}
	}

	public static String formatClassName(String unformattedClassName,
			String classPackageName) {
		String formattedClassName;
		formattedClassName = unformattedClassName.replace(
				classPackageName.replace("package ", "") + ".", "");
		return formattedClassName;
	}

	public void setState(String stateName) {
		currentState = stateName;
	}

	public void draw(Graphics g) {
		//stateTitleList.get(currentState).draw(g);
		LOGGER.draw(g);
	}

	public void update() {
		stateTitleList.get(currentState).update();
	}

	public void keyPressed(KeyEvent k) {
		stateTitleList.get(currentState).keyPressed(k);
	}

	public void keyReleased(KeyEvent k) {
		stateTitleList.get(currentState).keyReleased(k);
	}
}
