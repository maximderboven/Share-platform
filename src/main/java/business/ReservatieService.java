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

	public static ReservatieService getInstance() {
		return instance;
	}

	private ReservatieService () {
		synchronized (instance) {
			if (instance != null)
				return;
			instance = this;
		}
	}

	public Reservatie[] geefAfhaalbareReservatie (String aanbiederLogin, String ontlenerLogin, LocalDate datum) {
		return ReservatieCataloogFactory.getInstance ().getCataloog ().geefAfhaalbareReservaties (aanbiederLogin, ontlenerLogin, datum);
	}
	
	public boolean haalReservatieAf (Long reservatieId, LocalDate datum) {
		try {
			geefReservatie (reservatieId).haalAf (datum);
			return true;
		} catch (Exception ignored) {
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
		try {
			geefReservatie (reservatieId).annuleer (annuleerder, datum);
			return true;
		} catch (Exception ignored) {
			return false;
		}
	}
}
