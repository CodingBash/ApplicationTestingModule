//TODO: Send exception to LOGGER to print to console

package control;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import model.AnalysisObject;

public class ApplicationFileReader {

	public static boolean extractFileText(AnalysisObject inputtedObject) {
		ApplicationLogger.addLog("info", "Validating file path");
		if(!validateFilePathLocation(inputtedObject.getFilePathLocation()))
			return false;
		ApplicationLogger.addLog("info","Validation successful");
		try {
			ApplicationLogger.addLog("info", "Extracting lines from file");
			Path path_filePath = Paths.get(inputtedObject.getFilePathLocation());
			inputtedObject.addFileTextLines((ArrayList<String>) Files.readAllLines(path_filePath, StandardCharsets.UTF_8));
			for(String eachListLine : inputtedObject.getFileTextLines()){
				inputtedObject.setFileText( inputtedObject.getFileText() + " " + eachListLine);
			}
		} catch (IOException e) {
			ApplicationLogger.addLog("error","Error when extracting lines from file");
			e.printStackTrace();
		}
		return true;
	}

	private static boolean validateFilePathLocation(String filePathLocation) {
		try {
			File temporaryFile = new File(filePathLocation);
			if(!temporaryFile.exists() && temporaryFile.isDirectory())
				throw new IOException();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
