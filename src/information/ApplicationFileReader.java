//TODO: Send exception to LOGGER to print to console

package information;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import model.AnalysisObject;

/**
 * Reader and scans and creates a list of each line from a .TXT file only.
 * 
 * @author Basheer
 *
 */
public class ApplicationFileReader {

	/**
	 * Extracts the lines in the .TXT file.
	 * 
	 * @param inputtedObject
	 * @return
	 */
	public static boolean extractFileText(AnalysisObject inputtedObject) {
		ApplicationLogger.addLog("info", "Validating file path", false, true);
		if (!validateFilePathLocation(inputtedObject.getFilePathLocation()))
			return false;
		ApplicationLogger.addLog("info", "Validation successful", false, true);
		try {
			ApplicationLogger.addLog("info", "Extracting lines from file", false, true);
			Path path_filePath = Paths
					.get(inputtedObject.getFilePathLocation());
			inputtedObject.addFileTextLines((ArrayList<String>) Files
					.readAllLines(path_filePath, StandardCharsets.UTF_8));
			for (String eachListLine : inputtedObject.getFileTextLines()) {
				inputtedObject.setFileText(inputtedObject.getFileText() + " "
						+ eachListLine);
			}
		} catch (IOException e) {
			ApplicationLogger.addLog("error",
					"Error when extracting lines from file", false, true);
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Validates the file path provided.
	 * 
	 * @param filePathLocation
	 *            String URL of file.
	 * @return true if validation was a success.
	 * @return false if validation was a failure.
	 * @throws IOException
	 *             if could not find file.
	 * 
	 */
	@SuppressWarnings("finally")
	private static boolean validateFilePathLocation(String filePathLocation) {
		try {
			File temporaryFile = new File(filePathLocation);
			if (!temporaryFile.exists() && temporaryFile.isDirectory())
				throw new IOException();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			return true;
		}
	}

}