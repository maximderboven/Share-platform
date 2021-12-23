package business;

import domein.gebruiker.Gebruiker;
import domein.transactie.Reservatie;
import domein.transactie.Transactie;
import persistence.TransactieCataloogFactory;

import java.time.LocalDateTime;

/**
 * Anouar Bannamar
 * 21-11-21
 */
public class TransactieService {
	private static TransactieService instance;
	
	private TransactieService () {
	
	}
	
	public static synchronized TransactieService getInstance () {
		if (instance == null)
			instance = new TransactieService ();
		return instance;
	}
	
	public Transactie maakTransactie (Gebruiker ontvanger, Gebruiker betaler, Reservatie reservatie, LocalDateTime tijdstip) {
		return new Transactie (ontvanger, betaler, reservatie, tijdstip);
	}
	
	public Long voegTransactieToe (Transactie transactie) {
		return TransactieCataloogFactory.getInstance ().getCataloog ().add (transactie);
	}
	
	public Transactie geefTransactie (Long id) {
		return TransactieCataloogFactory.getInstance ().getCataloog ().get (id);
	}
	
}
