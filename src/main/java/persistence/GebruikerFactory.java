package persistence;

/**
 * Jonas Leijzen
 * 16/12/2021
 */
public class GebruikerFactory {
	
	private static GebruikerFactory instance;
	private static GebruikerCataloog cataloog;
	
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
	
	public static GebruikerCataloog getCataloog () {
		return cataloog;
	}
}
