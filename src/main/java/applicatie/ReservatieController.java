package applicatie;

import domein.transactie.Reservatie;
import domein.transactie.ReservatieAnnuleerder;

import java.time.LocalDate;

/**
 * Anouar Bannamar
 * 21-11-21
 */
public class ReservatieController {
	
	public Reservatie[] geefAfhaalbareReservatie (String aanbiederLogin, String ontlenerLogin, LocalDate datum) {
		return ReservatieService.geefAfhaalbareReservatie (aanbiederLogin, ontlenerLogin, datum);
	}
	
	public boolean annuleerReservatie (String aanbiederLogin, String ontlenerLogin, ReservatieAnnuleerder annuleerder, LocalDate datum) {
		return ReservatieService.annuleerReservatie (aanbiederLogin, ontlenerLogin, annuleerder, datum);
	}
	
}
