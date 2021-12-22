package persistence;

import domein.gereedschap.Gereedschap;

/**
 * Anouar Bannamar
 * 16-12-21
 */
public class GereedschapCataloogFactory {
	
	private static GereedschapCataloogFactory instance;
	private final Cataloog<Long, Gereedschap> cataloog;
	
	private GereedschapCataloogFactory () {
		cataloog = new InMemoryCataloog<> (new RandomLongKeyProvider ());
	}
	
	public static GereedschapCataloogFactory getInstance () {
		if (instance == null)
			instance = new GereedschapCataloogFactory ();
		return instance;
	}
	
	public Cataloog<Long, Gereedschap> getCataloog () {
		return cataloog;
	}
}
