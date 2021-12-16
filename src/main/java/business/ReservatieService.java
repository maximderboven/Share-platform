package business;

import domein.gebruiker.Gebruiker;
import domein.gereedschap.Gereedschap;
import domein.transactie.Reservatie;
import domein.transactie.ReservatieAnnuleerder;
import persistence.GebruikerFactory;
import persistence.ReservatieCataloog;
import persistence.ReservatieFactory;
import util.Periode;

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
			geefReservatie(reservatieId).haalAf (datum);
			return true;
		} catch (Exception ignored) {
			return false;
		}
	}

	public Reservatie geefReservatie(int reservatieId) {
		return cataloog.geefReservatie(reservatieId);
	}
	
	public boolean annuleerReservatie (int reservatieId, ReservatieAnnuleerder annuleerder, LocalDate datum) {
		try {
			geefReservatie(reservatieId).annuleer (annuleerder, datum);
			return true;
		} catch (Exception ignored) {
			return false;
		}
	}

	public Reservatie maakReservatie(Gebruiker aanbieder, Gebruiker ontlener, Gereedschap gereedschap, Periode periode) {
		return ReservatieFactory.getInstance().maakReservatie(aanbieder,ontlener,gereedschap,periode);
	}
}
