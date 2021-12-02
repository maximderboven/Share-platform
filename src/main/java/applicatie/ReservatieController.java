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
	
	public boolean haalReservatieAf (int reservatieId, LocalDate datum) {
		return ReservatieService.haalReservatieAf (reservatieId, datum);
	}
	
	public boolean annuleerReservatie (String aanbieder, String ontlener, ReservatieAnnuleerder annuleerder, LocalDate datum) {
		return ReservatieService.annuleerReservatie (aanbieder, ontlener, annuleerder, datum);
	}
	
}
