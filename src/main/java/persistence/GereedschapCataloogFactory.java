package persistence;

import domein.gereedschap.Gereedschap;

/**
 * Anouar Bannamar
 * 16-12-21
 */
public class GereedschapCataloogFactory {
	
	private static GereedschapCataloogFactory instance;
	private Cataloog<Long, Gereedschap> cataloog;
	
	public GereedschapCataloogFactory (Cataloog<Long, Gereedschap> cataloog) {
		synchronized (instance) {
			if (instance != null)
				return;
			instance = this;
		}
		this.cataloog = cataloog;
	}
	
	public static GereedschapCataloogFactory getInstance () {
		return instance;
	}
	
	public Cataloog<Long, Gereedschap> getCataloog () {
		return cataloog;
	}
}
