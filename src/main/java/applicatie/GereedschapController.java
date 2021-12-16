package applicatie;

import business.GebruikerService;
import business.GereedschapService;
import domein.gebruiker.Gebruiker;
import domein.gereedschap.Gereedschap;
import domein.gereedschap.GereedschapsType;

/**
 * Anouar Bannamar
 * 16-12-21
 */
public class GereedschapController {
    public Gereedschap maakGebruiker (String naam, String beschrijving, Gebruiker aanbieder, long daghuurprijs, int aankoopprijs, int waarde, GereedschapsType gereedschapsType){
        return GereedschapService.getInstance().maakGereedschap(naam, beschrijving, aanbieder, daghuurprijs, aankoopprijs, waarde, gereedschapsType);
    }

    public Gereedschap geefGebruiker(int id){
        return GereedschapService.getInstance().geefGereedschap(id);
    }
}
