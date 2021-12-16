package applicatie;

import domein.gebruiker.Gebruiker;
import persistence.GebruikerCataloog;
import persistence.InMemoryGebruikerCataloog;

/**
 * Jonas Leijzen
 * 1/12/2021
 */
public class GebruikerService {
	
	private static GebruikerCataloog cataloog = new InMemoryGebruikerCataloog ();
	
	public static void schrijfSharepointsOver (String betalerLogin, String ontvangerLogin, long amount) {
		Gebruiker betaler = cataloog.getByLogin (betalerLogin);
		Gebruiker ontvanger = cataloog.getByLogin (ontvangerLogin);
		if (amount < 0)
			throw new IllegalArgumentException ("Amount cannot be negative.");
		betaler.setSharepoints (betaler.getSharepoints () - amount);
		ontvanger.setSharepoints (betaler.getSharepoints () + amount);
	}
	
}
