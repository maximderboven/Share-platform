package persistence;

/**
 * Jonas Leijzen
 * 16/12/2021
 */
public class GebruikerCataloogFactory {
	
	private static GebruikerCataloogFactory instance;
	private final GebruikerCataloog cataloog;
	
	private GebruikerCataloogFactory () {
		cataloog = new InMemoryGebruikerCataloog (new RandomLongKeyProvider ());
	}
	
	public static GebruikerCataloogFactory getInstance () {
		if (instance == null)
			instance = new GebruikerCataloogFactory ();
		return instance;
	}
	
	public GebruikerCataloog getCataloog () {
		return cataloog;
	}
}
