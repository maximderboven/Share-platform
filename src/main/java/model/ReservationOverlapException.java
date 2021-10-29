package model;

/**
 * Jonas Leijzen
 * 30/10/2021
 */
public class ReservationOverlapException extends IllegalStateException {
	
	public ReservationOverlapException () {
		super ();
	}
	
	public ReservationOverlapException (String s) {
		super (s);
	}
	
	public ReservationOverlapException (String message, Throwable cause) {
		super (message, cause);
	}
	
	public ReservationOverlapException (Throwable cause) {
		super (cause);
	}
}
