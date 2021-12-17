package persistence;

import domein.gereedschap.Gereedschap;

/**
 * Anouar Bannamar
 * 16-12-21
 */
public class GereedschapFactory {
	
	private static GereedschapFactory instance;
	private Cataloog<? super Number, Gereedschap> cataloog;

    public static GereedschapFactory getInstance() {
        return instance;
    }
	
	public GereedschapFactory (Cataloog<? super Number, Gereedschap> cataloog) {
		synchronized (instance) {
			if (instance != null)
				return;
			instance = this;
		}
		this.cataloog = cataloog;
	}
	
	public Cataloog<? super Number, Gereedschap> getCataloog () {
		return cataloog;
	}
}
