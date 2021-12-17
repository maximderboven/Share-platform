package persistence;

import domein.gereedschap.Gereedschap;

/**
 * Anouar Bannamar
 * 16-12-21
 */
public class GereedschapCataloogFactory {
	
	private static GereedschapCataloogFactory instance;
	private Cataloog<? super Number, Gereedschap> cataloog;
	
	public GereedschapCataloogFactory (Cataloog<? super Number, Gereedschap> cataloog) {
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
	
	public Cataloog<? super Number, Gereedschap> getCataloog () {
		return cataloog;
	}
}
