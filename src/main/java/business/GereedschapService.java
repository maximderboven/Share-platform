package business;

import domein.gereedschap.Gereedschap;
import persistence.GereedschapFactory;

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

    public Gereedschap geefGereedschap(Long id) {
	    return GereedschapFactory.getInstance ().getCataloog ().get (id);
    }
}
