package applicatie;

import domein.transactie.Reservatie;
import domein.transactie.ReservatieAnnuleerder;
import persistence.ReservatieCataloog;

import java.time.LocalDate;

/**
 * Anouar Bannamar
 * 21-11-21
 */
public class ReservatieService {
	
	private static ReservatieCataloog cataloog;
	
	public static Reservatie[] geefAfhaalbareReservatie (String aanbiederLogin, String ontlenerLogin, LocalDate datum) {
		return cataloog.geefAfhaalbareReservaties (aanbiederLogin, ontlenerLogin, datum);
	}
	
	public static boolean haalReservatieAf (int reservatieId, LocalDate datum) {
		try {
			cataloog.geefReservatie(reservatieId).haalAf (datum);
			return true;
		} catch (Exception ignored) {
			return false;
		}
	}
	
	public static boolean annuleerReservatie (int reservatieId, ReservatieAnnuleerder annuleerder, LocalDate datum) {
		try {
			cataloog.geefReservatie (reservatieId).annuleer (annuleerder, datum);
			return true;
		} catch (Exception ignored) {
			return false;
		}
	}
}
