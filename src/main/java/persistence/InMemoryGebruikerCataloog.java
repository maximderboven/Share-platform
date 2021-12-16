package persistence;

import domein.gebruiker.Gebruiker;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Jonas Leijzen
 * 16/12/2021
 */
public class InMemoryGebruikerCataloog implements GebruikerCataloog {
	
	public Set<Gebruiker> gebruikerSet = new HashSet<> ();
	
	@Override
	public Gebruiker getByLogin (String login) {
		return gebruikerSet.stream ().filter (gebruiker -> gebruiker.getLogin ().equals (login)).findFirst ().orElse (null);
	}
	
	private static Random randomIDs = new Random ();
	
	@Override
	public int getNewId () {
		int id;
		do {
			id = randomIDs.nextInt ();
			if (get (id) != null)
				id = -1;
		} while (id != -1);
		return id;
	}
}
