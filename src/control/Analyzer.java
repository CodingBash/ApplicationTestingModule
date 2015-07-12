//TODO: Complete simple framework for the Analyzer
//TODO: Send analyzer information to LOGGER
package control;

import java.util.ArrayList;

import model.AnalysisObject;

/**
 * Main class for program analysis.
 * 
 * @author Basheer
 *
 */
public class Analyzer {
	
	private final AnalysisObject object;
	
	/**
	 * Analyzer default constructor. Object MUST be set after.
	 */
	public Analyzer(){
		ApplicationLogger.addLog("info","Constructing the Analyzer", true, true );
		object = null;
		ApplicationLogger.addLog("warn","AnalysisObject not provided to Analyzer! Must Provide!", false, true);
	}
	
	/**
	 * Analyzer arguement constructor. Sets object.
	 * @param object
	 */
	public Analyzer(AnalysisObject object){
		ApplicationLogger.addLog("info","Constructing the Analyzer", true, true);
		this.object = object;
	}
	
	/**
	 * Starts analysis.
	 * 
	 * @return true if analysis was a success.
	 * @return false if analysis was a failure.
	 */
	public boolean beginAnalysis(){
		ApplicationLogger.addLog("info","Beginning the Analysis", true, true);
		return true;
	}

}
