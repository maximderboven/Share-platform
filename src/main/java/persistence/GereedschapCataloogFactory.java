package persistence;

import domein.gereedschap.Gereedschap;

/**
 * Anouar Bannamar
 * 16-12-21
 */
public class GereedschapCataloogFactory {
	
	private static GereedschapCataloogFactory instance;
	private Cataloog<Long, Gereedschap> cataloog;
	
	private GereedschapCataloogFactory () {
	
	}
	
	public static GereedschapCataloogFactory getInstance () {
		if (instance == null)
			instance = new GereedschapCataloogFactory ();
		return instance;
	}
	
	public void setCataloog (Cataloog<Long, Gereedschap> cataloog) {
		this.cataloog = cataloog;
	}
	
	public Cataloog<Long, Gereedschap> getCataloog () {
		return cataloog;
	}
}
