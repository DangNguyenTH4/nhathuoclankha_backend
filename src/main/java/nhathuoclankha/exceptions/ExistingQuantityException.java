package nhathuoclankha.exceptions;

public class ExistingQuantityException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 124L;

	public ExistingQuantityException() {
		super();
	}

	public ExistingQuantityException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExistingQuantityException(String message, Throwable cause) {
		super(message, cause);
	}

	public ExistingQuantityException(String message) {
		super(message);
	}

	public ExistingQuantityException(Throwable cause) {
		super(cause);
	}
}
