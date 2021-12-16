package business;

import domein.gebruiker.Gebruiker;
import domein.gereedschap.Gereedschap;
import domein.gereedschap.GereedschapsType;
import persistence.GereedschapCataloog;
import persistence.GereedschapFactory;

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

    public Gereedschap maakGereedschap(String naam, String beschrijving, Gebruiker aanbieder, long daghuurprijs, int aankoopprijs, int waarde, GereedschapsType gereedschapsType) {
        return GereedschapFactory.getInstance ().maakGereedschap (naam, beschrijving, aanbieder, daghuurprijs, aankoopprijs, waarde, gereedschapsType);
    }

    public Gereedschap geefGereedschap(int id) {
        return gereedschapCataloog.get(id);
    }
}
