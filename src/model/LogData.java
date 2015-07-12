package model;

/**
 * Object to represent a log data. Contains a type, message, and two display
 * booleans.
 * 
 * @author Basheer
 *
 */
public class LogData {

	private String type;
	private String message;

	public LogData(String type, String message) {
		this.type = type;
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFullMessage() {
		return type + message;
	}

	public String toString() {
		return getFullMessage();
	}

}
