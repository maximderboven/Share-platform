package model.users;

/**
 * Jonas Leijzen
 * 29/10/2021
 */
public class InsufficientFundsException extends RuntimeException {
	
	public InsufficientFundsException () {
		super ();
	}
	
	public InsufficientFundsException (String message) {
		super (message);
	}
	
	public InsufficientFundsException (String message, Throwable cause) {
		super (message, cause);
	}
	
	public InsufficientFundsException (Throwable cause) {
		super (cause);
	}
	
	protected InsufficientFundsException (String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super (message, cause, enableSuppression, writableStackTrace);
	}
}
