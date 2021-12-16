package applicatie;

import domein.transactie.Reservatie;
import domein.transactie.ReservatieAnnuleerder;
import persistence.Cataloog;
import persistence.InMemoryReservatieCataloog;
import persistence.ReservatieCataloog;
import persistence.ReservatieFactory;

import java.time.LocalDate;

/**
 * Maxim Derboven
 * 21-11-21
 */
public class ReservatieService {


	private static ReservatieService instance;
	private static ReservatieCataloog cataloog;

	public static ReservatieService getInstance() {
		return instance;
	}

	private ReservatieService(ReservatieCataloog cataloog) {
		synchronized (instance) {
			if (instance != null)
				return;
			instance = this;
		}
		ReservatieService.cataloog = cataloog;
	}

	public Reservatie[] geefAfhaalbareReservatie (String aanbiederLogin, String ontlenerLogin, LocalDate datum) {
		return cataloog.geefAfhaalbareReservaties (aanbiederLogin, ontlenerLogin, datum);
	}
	
	public boolean haalReservatieAf (int reservatieId, LocalDate datum) {
		try {
			cataloog.geefReservatie(reservatieId).haalAf (datum);
			return true;
		} catch (Exception ignored) {
			return false;
		}
	}
	
	public boolean annuleerReservatie (int reservatieId, ReservatieAnnuleerder annuleerder, LocalDate datum) {
		try {
			cataloog.geefReservatie (reservatieId).annuleer (annuleerder, datum);
			return true;
		} catch (Exception ignored) {
			return false;
		}
	}
}
