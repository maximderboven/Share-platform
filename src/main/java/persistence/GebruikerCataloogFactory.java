package persistence;

/**
 * Jonas Leijzen
 * 16/12/2021
 */
public class GebruikerCataloogFactory {
	
	private static GebruikerCataloogFactory instance;
	private GebruikerCataloog cataloog;
	
	public GebruikerCataloogFactory (GebruikerCataloog cataloog) {
		if (instance != null)
			return;
		instance = this;
		this.cataloog = cataloog;
	}
	
	public static GebruikerCataloogFactory getInstance () {
		return instance;
	}
	
	public GebruikerCataloog getCataloog () {
		return cataloog;
	}
}
