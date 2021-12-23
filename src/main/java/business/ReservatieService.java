package business;

import domein.transactie.Reservatie;
import domein.transactie.ReservatieAnnuleerder;
import persistence.ReservatieCataloogFactory;

import java.time.LocalDate;

/**
 * Maxim Derboven
 * 21-11-21
 */
public class ReservatieService {
	
	
	private static ReservatieService instance;
	
	private ReservatieService () {
	
	}
	
	public static ReservatieService getInstance () {
		if (instance == null)
			instance = new ReservatieService ();
		return instance;
	}
	
	public Long[] geefAfhaalbareReservatie (String aanbiederLogin, String ontlenerLogin, LocalDate datum) {
		return ReservatieCataloogFactory.getInstance ().getCataloog ().geefAfhaalbareReservaties (aanbiederLogin, ontlenerLogin, datum);
	}
	
	public boolean haalReservatieAf (Long reservatieId, LocalDate datum) {
		try {
			geefReservatie (reservatieId).haalAf (datum);
			return true;
		} catch (Exception ignored) {
			ignored.printStackTrace ();
			return false;
		}
	}
	
	public Long voegReservatieToe (Reservatie reservatie) {
		return ReservatieCataloogFactory.getInstance ().getCataloog ().add (reservatie);
	}
	
	public Reservatie geefReservatie (Long reservatieId) {
		return ReservatieCataloogFactory.getInstance ().getCataloog ().get (reservatieId);
	}
	
	public boolean annuleerReservatie (Long reservatieId, ReservatieAnnuleerder annuleerder, LocalDate datum) {
		return geefReservatie (reservatieId).annuleer (annuleerder, datum);
	}
	
	public Long getId (Reservatie reservatie) {
		return ReservatieCataloogFactory.getInstance ().getCataloog ().getId (reservatie);
	}
}
