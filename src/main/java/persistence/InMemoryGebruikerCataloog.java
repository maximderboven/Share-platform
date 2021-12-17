package persistence;

import domein.gebruiker.Gebruiker;

import java.util.*;

/**
 * Jonas Leijzen
 * 16/12/2021
 */
public class InMemoryGebruikerCataloog extends InMemoryCataloog<Long, Gebruiker, RandomLongKeyProvider> implements GebruikerCataloog {
	
	public Set<Gebruiker> gebruikerSet = new HashSet<> ();
	
	@Override
	public Gebruiker getByLogin (String login) {
		return gebruikerSet.stream ().filter (gebruiker -> gebruiker.getLogin ().equals (login)).findFirst ().orElse (null);
	}
	
}
