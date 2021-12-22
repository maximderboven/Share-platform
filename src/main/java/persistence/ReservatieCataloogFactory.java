package persistence;

/**
 * @author Maxim Derboven
 * @version 1.0 16/12/2021 15:31
 */
public class ReservatieCataloogFactory {
	private static ReservatieCataloogFactory instance;
	private final ReservatieCataloog cataloog;
	
	private ReservatieCataloogFactory () {
		cataloog = new InMemoryReservatieCataloog (new RandomLongKeyProvider ());
	}
	
	public static ReservatieCataloogFactory getInstance () {
		if (instance == null)
			instance = new ReservatieCataloogFactory ();
		
		return instance;
	}
	
	public ReservatieCataloog getCataloog () {
		return cataloog;
	}
}
