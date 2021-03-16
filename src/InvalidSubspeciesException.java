/**
 * Exception for invalid subspecies. No unique behavior.
 * @author Will Brown
 * @version 1.0
 * Spring 2021
 */
public class InvalidSubspeciesException extends RuntimeException {

	public InvalidSubspeciesException() {
		super();
	}

	public InvalidSubspeciesException(String message) {
		super(message);
	}

	public InvalidSubspeciesException(Throwable cause) {
		super(cause);
	}

	public InvalidSubspeciesException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidSubspeciesException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
