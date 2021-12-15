package domein.gebruiker;

import domein.Cataloog;

/**
 * Jonas Leijzen
 * 1/12/2021
 */
public class GebruikerCataloog extends Cataloog<Gebruiker> {
	
	private static GebruikerCataloog instance;
	
	public static GebruikerCataloog getInstance () {
		return instance;
	}
	
	private GebruikerCataloog () {
		synchronized (instance) {
			if (instance != null)
				return;
			instance = this;
		}
	}
	
	public Gebruiker getByLogin (String login) {
		return tSet.stream ().filter (g -> g.getLogin ().equals (login)).findFirst ().orElse (null);
	}
	
	@Override
	public void Seed () {
	
	}
}
