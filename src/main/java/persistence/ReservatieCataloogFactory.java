package persistence;

/**
 * @author Maxim Derboven
 * @version 1.0 16/12/2021 15:31
 */
public class ReservatieCataloogFactory {
	private static ReservatieCataloogFactory instance;
	private ReservatieCataloog cataloog;
	
	private ReservatieCataloogFactory () {
	}
	
	public static ReservatieCataloogFactory getInstance () {
		if (instance == null)
			instance = new ReservatieCataloogFactory ();
		return instance;
	}
	
	public void setCataloog (ReservatieCataloog cataloog) {
		this.cataloog = cataloog;
	}
	
	public ReservatieCataloog getCataloog () {
		return cataloog;
	}
}
