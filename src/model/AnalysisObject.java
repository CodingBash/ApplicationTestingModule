package model;

import java.util.ArrayList;

import control.ApplicationFileReader;
import control.ApplicationLogger;

public class AnalysisObject {

	private String filePathLocation;
	private String fileText;
	private ArrayList<String> fileTextLines;
	
	public AnalysisObject(){
		ApplicationLogger.addLog("info","Constructing the AnalysisObject");
		this.filePathLocation = "";
		this.fileText = "";
		this.fileTextLines = new ArrayList<String>();
	}
	
	public AnalysisObject(String inputtedFilePathLocation){
		ApplicationLogger.addLog("info","Constructing the AnalysisObject");
		this.filePathLocation = inputtedFilePathLocation;
		this.fileText ="";
		this.fileTextLines = new ArrayList<String>();
		ApplicationFileReader.extractFileText(this);
	}
	
	public String getFilePathLocation(){
		return this.filePathLocation;
	}
	
	public String getFileText(){
		return this.fileText;
	}
	
	public ArrayList<String> getFileTextLines(){
		return this.fileTextLines;
	}
	
	public void setFilePathLocation(String filePathLocation){
		this.filePathLocation = filePathLocation;
	}
	
	public void setFileText(String fileText){
		this.fileText = fileText;
	}
	
	public void setFileTextLines(ArrayList<String> fileTextLines){
		this.fileTextLines = fileTextLines;
	}
	
	public void addFileTextLines(ArrayList<String> fileTextLines){
		this.fileTextLines.addAll(fileTextLines);
	}
	
}
