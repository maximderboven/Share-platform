package applicatie;

import business.ReservatieService;
import domein.transactie.Reservatie;
import domein.transactie.ReservatieAnnuleerder;

import java.time.LocalDate;

/**
 * Maxim Derboven
 * 21-11-21
 */
public class ReservatieController {
	
	public Long voegReservatieToe (Reservatie reservatie) {
		return ReservatieService.getInstance ().voegReservatieToe (reservatie);
	}
	
	public Reservatie geefReservatie (Long id) {
		return ReservatieService.getInstance ().geefReservatie (id);
	}
	
	public Long[] geefAfhaalbareReservatie (String aanbiederLogin, String ontlenerLogin, LocalDate datum) {
		return ReservatieService.getInstance ().geefAfhaalbareReservatie (aanbiederLogin, ontlenerLogin, datum);
	}
	
	public boolean haalReservatieAf (Long reservatieId, LocalDate datum) {
		return ReservatieService.getInstance ().haalReservatieAf (reservatieId, datum);
	}
	
	public boolean annuleerReservatie (Long reservatieId, ReservatieAnnuleerder annuleerder, LocalDate datum) {
		return ReservatieService.getInstance ().annuleerReservatie (reservatieId, annuleerder, datum);
	}


	
}
