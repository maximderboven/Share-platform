package persistence;

import domein.gebruiker.Gebruiker;
import domein.transactie.Reservatie;

/**
 * Jonas Leijzen
 * 16/12/2021
 */
public class GebruikerFactory {
	
	private static GebruikerFactory instance;
	private Cataloog<? extends Number, Gebruiker> cataloog;
	
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
	
	public Cataloog<? extends Number, Gebruiker> getCataloog () {
		return cataloog;
	}
}
