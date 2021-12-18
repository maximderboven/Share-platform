package business;

import domein.gereedschap.Gereedschap;
import persistence.GereedschapCataloogFactory;

/**
 * Anouar Bannamar
 * 16-12-21
 */
public class GereedschapService {
	
	private static GereedschapService instance;
	
	public static GereedschapService getInstance () {
		return instance;
	}
	
	public GereedschapService () {
		synchronized (instance) {
			if (instance != null)
				return;
			instance = this;
		}
	}
	
	public Long voegGereedschapToe (Gereedschap gereedschap) {
		return GereedschapCataloogFactory.getInstance ().getCataloog ().add (gereedschap);
	}
	
	public Gereedschap geefGereedschap (Long id) {
		return GereedschapCataloogFactory.getInstance ().getCataloog ().get (id);
	}
}
