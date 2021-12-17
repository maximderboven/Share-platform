package business;

import domein.gebruiker.Gebruiker;
import domein.gereedschap.Gereedschap;
import domein.gereedschap.GereedschapsType;
import persistence.Cataloog;
import persistence.GereedschapCataloog;
import persistence.GereedschapFactory;

/**
 * Anouar Bannamar
 * 16-12-21
 */
public class GereedschapService<Key extends Number> {
    
    private static GereedschapService instance;

    public static GereedschapService getInstance() {
        return instance;
    }

    public GereedschapService() {
        synchronized (instance) {
            if (instance != null)
                return;
            instance = this;
        }
    }

    public Gereedschap maakGereedschap(String naam, String beschrijving, Gebruiker aanbieder, long daghuurprijs, int aankoopprijs, int waarde, GereedschapsType gereedschapsType) {
        return GereedschapFactory.getInstance ().maakGereedschap (naam, beschrijving, aanbieder, daghuurprijs, aankoopprijs, waarde, gereedschapsType);
    }

    public Gereedschap geefGereedschap(Long id) {
        return GereedschapFactory.getInstance ();
    }
}
