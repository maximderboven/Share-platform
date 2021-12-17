package applicatie;

import business.TransactieService;
import domein.transactie.Transactie;

/**
 * Arne Cools
 * 16/12/2021
 */
public class TransactieController {
	
	public Transactie geefTransactie (Long id) {
		return TransactieService.getInstance ().geefTransactie (id);
	}
	
}
