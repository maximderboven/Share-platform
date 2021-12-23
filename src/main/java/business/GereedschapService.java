package business;

import domein.gereedschap.Gereedschap;
import persistence.GereedschapCataloogFactory;

/**
 * Anouar Bannamar
 * 16-12-21
 */
public class GereedschapService {
	
	private static GereedschapService instance;
	
	private GereedschapService () {
	}
	
	public static synchronized GereedschapService getInstance () {
		if (instance == null)
			instance = new GereedschapService ();
		return instance;
	}
	
	public Long voegGereedschapToe (Gereedschap gereedschap) {
		return GereedschapCataloogFactory.getInstance ().getCataloog ().add (gereedschap);
	}
	
	public Gereedschap geefGereedschap (Long id) {
		return GereedschapCataloogFactory.getInstance ().getCataloog ().get (id);
	}
}
