package applicatie;

import domein.transactie.Reservatie;

import java.time.LocalDate;

/**
 * Anouar Bannamar
 * 21-11-21
 */
public class ReservatieController {
	
	public Reservatie[] geefAfhaalbareReservatie (String aanbiederLogin, String ontlener) {
		return ReservatieService.geefAfhaalbareReservatie (aanbiederLogin, ontlener, LocalDate.now ());
	}
	
}
