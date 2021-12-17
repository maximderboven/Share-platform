package persistence;

/**
 * Jonas Leijzen
 * 16/12/2021
 */
public class GebruikerFactory {
	
	private static GebruikerFactory instance;
	private GebruikerCataloog cataloog;
	
	public static GebruikerFactory getInstance () {
		return instance;
	}
	
	private GebruikerFactory (GebruikerCataloog cataloog) {
		synchronized (instance) {
			if (instance != null)
				return;
			instance = this;
		}
		this.cataloog = cataloog;
	}
	
	public GebruikerCataloog getCataloog () {
		return cataloog;
	}
}
