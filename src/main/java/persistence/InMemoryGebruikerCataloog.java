package persistence;

import domein.gebruiker.Gebruiker;

/**
 * Jonas Leijzen
 * 16/12/2021
 */
public class InMemoryGebruikerCataloog extends InMemoryCataloog<Long, Gebruiker> implements GebruikerCataloog {
	
	public InMemoryGebruikerCataloog (KeyProvider<Long> keyProvider) {
		super (keyProvider);
	}
	
	@Override
	public Gebruiker getByLogin (String login) {
		return getMap ().values ().stream ().filter (gebruiker -> gebruiker.getLogin ().equals (login)).findFirst ().orElse (null);
	}
	
}
