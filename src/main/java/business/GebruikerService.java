package business;

import domein.gebruiker.Gebruiker;
import persistence.GebruikerCataloog;
import persistence.GebruikerFactory;
import util.GeoLocatie;

/**
 * Jonas Leijzen
 * 1/12/2021
 */
public class GebruikerService {
	
	private static GebruikerService instance;
	private static GebruikerCataloog cataloog;
	
	public static GebruikerService getInstance () {
		return instance;
	}
	
	public GebruikerService (GebruikerCataloog cataloog) {
		synchronized (instance) {
			if (instance != null)
				return;
			instance = this;
		}
		GebruikerService.cataloog = cataloog;
	}
	
	public Gebruiker maakGebruiker (String login, GeoLocatie locatie, long sharepoints) {
		return new Gebruiker (login, locatie, sharepoints);
	}
	
	public Gebruiker geefGebruiker (Long id) {
		return cataloog.get (id);
	}
	
	public void schrijfSharepointsOver (String betalerLogin, String ontvangerLogin, long amount) {
		Gebruiker betaler = cataloog.getByLogin (betalerLogin);
		Gebruiker ontvanger = cataloog.getByLogin (ontvangerLogin);
		if (amount < 0)
			throw new IllegalArgumentException ("Amount cannot be negative.");
		betaler.setSharepoints (betaler.getSharepoints () - amount);
		ontvanger.setSharepoints (betaler.getSharepoints () + amount);
	}
	
}
