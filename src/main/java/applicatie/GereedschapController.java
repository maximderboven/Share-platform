package applicatie;

import business.GereedschapService;
import domein.gereedschap.Gereedschap;

/**
 * Anouar Bannamar
 * 16-12-21
 */
public class GereedschapController {

    public Gereedschap geefGebruiker(long id){
        return GereedschapService.getInstance().geefGereedschap(id);
    }
}
