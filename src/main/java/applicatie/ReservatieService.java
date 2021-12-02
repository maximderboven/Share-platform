package applicatie;

import domein.transactie.Reservatie;
import domein.transactie.ReservatieAnnuleerder;
import domein.transactie.ReservatieCataloog;

import java.time.LocalDate;

/**
 * Anouar Bannamar
 * 21-11-21
 */
public class ReservatieService {
	
	private static ReservatieCataloog cataloog;
	
	public static Reservatie[] geefAfhaalbareReservatie (String aanbiederLogin, String ontlenerLogin, LocalDate datum) {
		return cataloog.geefAfhaalbareReservatie (aanbiederLogin, ontlenerLogin, datum);
	}
	
	public static boolean annuleerReservatie (String aanbiederLogin, String ontlenerLogin, ReservatieAnnuleerder annuleerder, LocalDate datum) {
		try {
			cataloog.geefAnnuleerbareReservatie (aanbiederLogin, ontlenerLogin).annuleer (annuleerder, datum);
			return true;
		} catch (IllegalStateException e) {
			return false;
		}
	}
}
