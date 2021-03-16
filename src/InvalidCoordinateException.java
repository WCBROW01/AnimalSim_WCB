/**
 * Exception for invalid coordinates. No unique behavior.
 * @author Will Brown
 * @version 1.0
 * Spring 2021
 */
public class InvalidCoordinateException extends RuntimeException {

	public InvalidCoordinateException() {
		super();
	}

	public InvalidCoordinateException(String message) {
		super(message);
	}

	public InvalidCoordinateException(Throwable cause) {
		super(cause);
	}

	public InvalidCoordinateException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidCoordinateException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
