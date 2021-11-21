package applicatie;

import domein.transactie.Reservatie;
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
}
