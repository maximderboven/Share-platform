package applicatie;

import business.GereedschapService;
import domein.gereedschap.Gereedschap;

/**
 * Anouar Bannamar
 * 16-12-21
 */
public class GereedschapController {
    
    public Long voegGereedschapToe (Gereedschap gereedschap) {
        return GereedschapService.getInstance ().voegGereedschapToe (gereedschap);
    }
    
    public Gereedschap geefGereedschap (long id) {
        return GereedschapService.getInstance ().geefGereedschap (id);
    }
}
