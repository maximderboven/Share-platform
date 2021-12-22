package persistence;

import domein.transactie.Reservatie;

import java.time.LocalDate;
import java.util.Map;

/**
 * @author Maxim Derboven
 * @version 1.0 16/12/2021 15:04
 */
public class InMemoryReservatieCataloog extends InMemoryCataloog<Long, Reservatie> implements ReservatieCataloog {
	
	public InMemoryReservatieCataloog (KeyProvider<Long> keyProvider) {
		super (keyProvider);
	}
	
	@Override
	public Long[] geefAfhaalbareReservaties (String aanbiederLogin, String ontlenerLogin, LocalDate datum) {
		return getMap ().entrySet ().stream ().filter (
						//r -> aanbiederLogin.equals (r.getGereedschap ().getAanbieder ().getLogin ())
						es -> aanbiederLogin.equals (es.getValue ().getAanbieder ().getLogin ())
								&& ontlenerLogin.equals (es.getValue ().getOntlener ().getLogin ())
								&& es.getValue ().isAfhaalbaar (datum)).map (Map.Entry::getKey)
				.toArray (Long[]::new);
	}

	@Override
	public Long getId(Reservatie reservatie) {
		return getMap().entrySet().stream().filter(entry -> reservatie.equals(entry.getValue())).map(Map.Entry::getKey).findFirst().orElse(0L);
	}

}
