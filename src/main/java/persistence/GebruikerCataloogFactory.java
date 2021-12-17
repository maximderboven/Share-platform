package persistence;

/**
 * Jonas Leijzen
 * 16/12/2021
 */
public class GebruikerCataloogFactory {
	
	private static GebruikerCataloogFactory instance;
	private GebruikerCataloog cataloog;
	
	private GebruikerCataloogFactory (GebruikerCataloog cataloog) {
		synchronized (instance) {
			if (instance != null)
				return;
			instance = this;
		}
		this.cataloog = cataloog;
	}
	
	public static GebruikerCataloogFactory getInstance () {
		return instance;
	}
	
	public GebruikerCataloog getCataloog () {
		return cataloog;
	}
}
