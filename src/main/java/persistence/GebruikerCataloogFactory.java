package persistence;

/**
 * Jonas Leijzen
 * 16/12/2021
 */
public class GebruikerCataloogFactory {
	
	private static GebruikerCataloogFactory instance;
	private GebruikerCataloog cataloog;
	
	private GebruikerCataloogFactory () {
	}
	
	public static GebruikerCataloogFactory getInstance () {
		if (instance == null)
			instance = new GebruikerCataloogFactory ();
		return instance;
	}
	
	public void setCataloog (GebruikerCataloog cataloog) {
		this.cataloog = cataloog;
	}
	
	public GebruikerCataloog getCataloog () {
		return cataloog;
	}
}
