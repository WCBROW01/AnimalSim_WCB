/**
 * Exception for invalid wingspan. No unique behavior.
 * @author Will Brown
 * @version 1.0
 * Spring 2021
 */
public class InvalidWingspanException extends RuntimeException {

	public InvalidWingspanException() {
		super();
	}

	public InvalidWingspanException(String message) {
		super(message);
	}

	public InvalidWingspanException(Throwable cause) {
		super(cause);
	}

	public InvalidWingspanException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidWingspanException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
