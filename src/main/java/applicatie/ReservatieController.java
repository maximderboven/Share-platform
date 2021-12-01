package applicatie;

import domein.transactie.Reservatie;
import domein.transactie.ReservatieAnnuleerder;

import java.time.LocalDate;

/**
 * Anouar Bannamar
 * 21-11-21
 */
public class ReservatieController {
	
	public Reservatie[] geefAfhaalbareReservatie (String aanbiederLogin, String ontlenerLogin) {
		return ReservatieService.geefAfhaalbareReservatie (aanbiederLogin, ontlenerLogin, LocalDate.now ());
	}
	
	public boolean annuleerReservatie (String aanbiederLogin, String ontlenerLogin, ReservatieAnnuleerder annuleerder) {
		return ReservatieService.annuleerReservatie (aanbiederLogin, ontlenerLogin, annuleerder);
	}
	
}
