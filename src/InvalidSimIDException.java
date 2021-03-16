/**
 * Exception for invalid simulation ID. No unique behavior.
 * @author Will Brown
 * @version 1.0
 * Spring 2021
 */
public class InvalidSimIDException extends RuntimeException {

	public InvalidSimIDException() {
		super();
	}

	public InvalidSimIDException(String message) {
		super(message);
	}

	public InvalidSimIDException(Throwable cause) {
		super(cause);
	}

	public InvalidSimIDException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidSimIDException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
