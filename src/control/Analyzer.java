//TODO: Complete simple framework for the Analyzer
//TODO: Send analyzer information to LOGGER
package control;

import java.util.ArrayList;

import model.AnalysisObject;

public class Analyzer {
	
	private final AnalysisObject object;
	
	public Analyzer(){
		ApplicationLogger.addLog("info","Constructing the Analyzer");
		object = null;
		ApplicationLogger.addLog("error","AnalysisObject not provided to Analyzer! Must Provide!");
	}
	
	public Analyzer(AnalysisObject object){
		ApplicationLogger.addLog("info","Constructing the Analyzer");
		this.object = object;
	}
	
	public boolean beginAnalysis(){
		ApplicationLogger.addLog("info","Beginning the Analysis");
		return true;
	}

}
