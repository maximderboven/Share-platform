package persistence;

import domein.transactie.Reservatie;

import java.time.LocalDate;
import java.util.*;

/**
 * @author Maxim Derboven
 * @version 1.0 16/12/2021 15:04
 */
public class InMemoryReservatieCataloog<Key extends Number> extends InMemoryCataloog<Key, Reservatie> implements ReservatieCataloog<Key> {
	
	public InMemoryReservatieCataloog (KeyProvider<Long> keyProvider) {
		super (keyProvider);
	}
	
	@Override
	public Reservatie[] geefAfhaalbareReservaties (String aanbiederLogin, String ontlenerLogin, LocalDate datum) {
		return getAll ().stream ().filter (
						//r -> aanbiederLogin.equals (r.getGereedschap ().getAanbieder ().getLogin ())
						r -> aanbiederLogin.equals (r.getAanbieder ().getLogin ())
								&& ontlenerLogin.equals (r.getOntlener ().getLogin ())
								&& r.isAfhaalbaar (datum))
				.toArray (Reservatie[]::new);
	}
	
	@Override
	public Reservatie geefReservatie (Key reservatieId) {
		return get (reservatieId);
	}

}
