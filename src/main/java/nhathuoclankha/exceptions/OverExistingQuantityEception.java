package nhathuoclankha.exceptions;

public class OverExistingQuantityEception extends ExistingQuantityException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1000L;

	public OverExistingQuantityEception() {
		super();
	}

	public OverExistingQuantityEception(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public OverExistingQuantityEception(String message, Throwable cause) {
		super(message, cause);
	}

	public OverExistingQuantityEception(String message) {
		super(message);
	}

	public OverExistingQuantityEception(Throwable cause) {
		super(cause);
	}
	
}
