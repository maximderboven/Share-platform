package persistence;

import domein.transactie.Reservatie;

/**
 * @author Maxim Derboven
 * @version 1.0 16/12/2021 15:31
 */
public class ReservatieCataloogFactory implements CataloogFactory<Reservatie> {
	private static ReservatieCataloogFactory instance;
	private final ReservatieCataloog cataloog;
	
	private ReservatieCataloogFactory () {
		cataloog = new InMemoryReservatieCataloog (new RandomLongKeyProvider ());
	}
	
	public static synchronized ReservatieCataloogFactory getInstance () {
		if (instance == null)
			instance = new ReservatieCataloogFactory ();
		
		return instance;
	}
	
	@Override
	public ReservatieCataloog getCataloog () {
		return cataloog;
	}
}
