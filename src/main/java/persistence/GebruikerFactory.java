package persistence;

import domein.gebruiker.Gebruiker;
import util.GeoLocatie;

/**
 * Jonas Leijzen
 * 16/12/2021
 */
public class GebruikerFactory {
	
	private static GebruikerFactory instance;
	private static GebruikerCataloog cataloog;
	
	public static GebruikerFactory getInstance () {
		return instance;
	}
	
	private GebruikerFactory () {
		synchronized (instance) {
			if (instance != null)
				return;
			instance = this;
		}
		cataloog = new InMemoryGebruikerCataloog ();
	}
	
	public static GebruikerCataloog getCataloog () {
		return cataloog;
	}
	
	public static Gebruiker maakGebruiker (String login, GeoLocatie locatie, long sharepoints) {
		int id = cataloog.getNewId ();
		Gebruiker gebruiker = new Gebruiker (id, login, locatie, sharepoints);
		return gebruiker;
	}
}
