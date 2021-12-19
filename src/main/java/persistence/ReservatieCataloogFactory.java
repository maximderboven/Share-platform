package persistence;

/**
 * @author Maxim Derboven
 * @version 1.0 16/12/2021 15:31
 */
public class ReservatieCataloogFactory {
	private static ReservatieCataloogFactory instance;
	private ReservatieCataloog cataloog;
	
	public ReservatieCataloogFactory (ReservatieCataloog cataloog) {
		if (instance != null)
			return;
		instance = this;
		this.cataloog = cataloog;
	}
	
	public static ReservatieCataloogFactory getInstance () {
		return instance;
	}
	
	public ReservatieCataloog getCataloog () {
		return cataloog;
	}
}
