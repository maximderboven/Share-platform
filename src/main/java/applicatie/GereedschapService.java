package applicatie;

import persistence.GereedschapCataloog;

/**
 * Anouar Bannamar
 * 16-12-21
 */
public class GereedschapService {
    private static GereedschapService instance;
    private static GereedschapCataloog gereedschapCataloog;

    public static GereedschapService getInstance() {
        return instance;
    }

    public GereedschapService(GereedschapCataloog gereedschapCataloog) {
        synchronized (instance) {
            if (instance != null)
                return;
            instance = this;
        }
        GereedschapService.gereedschapCataloog = gereedschapCataloog;
    }
}
