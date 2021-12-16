package applicatie;

import domein.gebruiker.Gebruiker;
import domein.transactie.Reservatie;
import domein.transactie.Transactie;

import java.time.LocalDateTime;

/**
 * Anouar Bannamar
 * 21-11-21
 */
public class TransactieService {
	
	public static Transactie maakTransactie (Gebruiker ontvanger, Gebruiker betaler, Reservatie reservatie) {
		return new Transactie (CataloogFactory.getInstance ().getNewId (), ontvanger, betaler, reservatie, LocalDateTime.now ());
	}
	
}
