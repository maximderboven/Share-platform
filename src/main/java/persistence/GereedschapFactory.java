package persistence;

import domein.gebruiker.Gebruiker;
import domein.gereedschap.Gereedschap;
import domein.gereedschap.GereedschapsType;

/**
 * Anouar Bannamar
 * 16-12-21
 */
public class GereedschapFactory {
    private static GereedschapFactory instance;
    private static GereedschapCataloog cataloog;

    public static GereedschapFactory getInstance() {
        return instance;
    }

    public GereedschapFactory() {
        synchronized (instance){
            if(instance != null)
                return;
            instance = this;
        }
        cataloog = new InMemoryGereedschapsCataloog();
    }

    public static GereedschapCataloog getCataloog(){
        return cataloog;
    }

    public Gereedschap maakGereedschap (String naam, String beschrijving, Gebruiker aanbieder, long daghuurprijs, int aankoopprijs, int waarde, GereedschapsType gereedschapsType){
        int id = cataloog.getNewId();
        Gereedschap gereedschap =  new Gereedschap(id, naam, beschrijving, aanbieder, daghuurprijs, aankoopprijs, waarde, gereedschapsType);
        return gereedschap;
    }
}
