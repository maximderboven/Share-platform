package persistence;

import domein.gebruiker.Gebruiker;

import java.util.HashSet;
import java.util.Set;

/**
 * Jonas Leijzen
 * 16/12/2021
 */
public class InMemoryGebruikersCataloog implements GebruikersCataloog {
	
	public Set<Gebruiker> gebruikerSet = new HashSet<> ();
	
	@Override
	public Gebruiker getByLogin (String login) {
		return gebruikerSet.stream ().filter (gebruiker -> gebruiker.getLogin ().equals (login)).findFirst ().orElse (null);
	}
}
