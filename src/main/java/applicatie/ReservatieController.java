package applicatie;

import domein.transactie.Reservatie;
import domein.transactie.ReservatieAnnuleerder;

import java.time.LocalDate;

/**
 * Maxim Derboven
 * 21-11-21
 */
public class ReservatieController {
	
	public Reservatie[] geefAfhaalbareReservatie (String aanbiederLogin, String ontlenerLogin, LocalDate datum) {
		return ReservatieService.getInstance().geefAfhaalbareReservatie(aanbiederLogin, ontlenerLogin, datum);
	}
	
	public boolean haalReservatieAf (int reservatieId, LocalDate datum) {
		return ReservatieService.getInstance().haalReservatieAf(reservatieId, datum);
	}
	
	public boolean annuleerReservatie (int reservatieId, ReservatieAnnuleerder annuleerder, LocalDate datum) {
		return ReservatieService.getInstance().annuleerReservatie(reservatieId, annuleerder, datum);
	}
	
}
