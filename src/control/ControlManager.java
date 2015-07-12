//TODO: More efficient way to receive a formatted package name (getName function?)
//TODO: Data flow to LOGGER object

package control;

import information.ApplicationLogger;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;

import adapters.InputAdapter;
import states.ApplicationState;
import states.TestState;
import model.AnalysisObject;

/**
 * 
 * ControlManager is the interconnection of MVC (Model-View-Controller)
 * ControlManager holds important instances and also handles the flow of data.
 * There can be extensions of ControlManager in the future if there is too much
 * in the class (each for specific tasks).
 */
public class ControlManager {

	public ArrayList<ApplicationState> applicationStatesList;
	public ApplicationLogger LOGGER;
	public String currentState;
	public HashMap<String, ApplicationState> stateTitleList;
	public InputAdapter INPUT;
	public AnalysisObject OBJECT;
	public TestState state1 = new TestState();

	/**
	 * ControlManager default constructor. Initializes important objects and
	 * prepares program.
	 */
	public ControlManager() {
		LOGGER = new ApplicationLogger();
		ApplicationLogger.addLog("info", "Setting up the program", true, true);
		INPUT = new InputAdapter(this);
		OBJECT = new AnalysisObject("res/SE_Example_1.txt");
		stateTitleList = new HashMap<String, ApplicationState>();
		applicationStatesList = new ArrayList<ApplicationState>();
		insertAllStateOptions();
		importAllStateOptions();
		ApplicationLogger.addLog("null", "-------------------------", true,
				true); // End setup
	}

	/**
	 * Inserts all states of the program into a list.
	 * 
	 */
	public void insertAllStateOptions() {
		ApplicationLogger.addLog("info", "Adding available states to list",
				false, true);
		applicationStatesList.add(state1); // <-- This constructs the object
	}

	/**
	 * Imports all states into a proper HashMap which will be the main command
	 * object for changing states.
	 * 
	 */
	public void importAllStateOptions() {
		ApplicationLogger.addLog("info",
				"Adding available state objects to list", false, true);
		if (applicationStatesList.size() != 0)
			for (ApplicationState currentState : applicationStatesList) {
				if (currentState == null)
					break; /*
							 * ArrayList automatically reserves 10 indexes which
							 * some may be null
							 */
				stateTitleList
						.put(formatClassName(currentState.getClass().getName(),
								currentState.getClass().getPackage().toString()),
								currentState);
			}
	}

	/**
	 * Formats the class name to get rid of "package."
	 * 
	 * @param unformattedClassName
	 *            class name before formatting.
	 * @param classPackageName
	 *            name of the package of the class.
	 * @return formattedClassName the formatted class name.
	 */
	public static String formatClassName(String unformattedClassName,
			String classPackageName) {
		String formattedClassName;
		formattedClassName = unformattedClassName.replace(
				classPackageName.replace("package ", "") + ".", "");
		return formattedClassName;
	}

	/**
	 * Changes the state.
	 * 
	 * @param stateName
	 *            name of the state.
	 */
	public void setState(String stateName) {
		currentState = stateName;
	}

	public void draw(Graphics g) {
		// stateTitleList.get(currentState).draw(g);
		ApplicationLogger.draw(g);
	}

	/**
	 * Updates selected objects within the current state.
	 */
	public void update() {
		stateTitleList.get(currentState).update();
	}

	/**
	 * Sends key pressed input to the current state.
	 * 
	 * @param k
	 *            KeyEvent code of input.
	 */
	public void keyPressed(KeyEvent k) {
		stateTitleList.get(currentState).keyPressed(k);
	}

	/**
	 * Sends key released input to the current state.
	 * 
	 * @param k
	 *            KeyEvent code of input.
	 */
	public void keyReleased(KeyEvent k) {
		stateTitleList.get(currentState).keyReleased(k);
	}
}
