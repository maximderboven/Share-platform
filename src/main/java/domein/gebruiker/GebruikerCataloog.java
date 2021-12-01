package domein.gebruiker;

import domein.Cataloog;

/**
 * Jonas Leijzen
 * 1/12/2021
 */
public class GebruikerCataloog extends Cataloog<Gebruiker> {
	
	public Gebruiker getByLogin (String login) {
		return tSet.stream ().filter (g -> g.getLogin ().equals (login)).findFirst ().orElse (null);
	}
	
	@Override
	public void Seed () {
	
	}
}
