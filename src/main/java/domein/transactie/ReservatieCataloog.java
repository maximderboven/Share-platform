package domein.transactie;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Jonas Leijzen
 * 21/11/2021
 */
public class ReservatieCataloog extends Cataloog<Reservatie> {
	
	public Reservatie get (int id) {
		for (Reservatie t : super.getAll ()) {
			if (t.getId () == id)
				return t;
		}
		return null;
	}
	
	public Reservatie[] geefAfhaalbareReservatie (String aanbiederLogin, String ontlenerLogin, LocalDate datum) {
		return getAll ().stream ().filter (
						//r -> aanbiederLogin.equals (r.getGereedschap ().getAanbieder ().getLogin ())
						r -> aanbiederLogin.equals (r.getAanbieder ().getLogin ())
								&& ontlenerLogin.equals (r.getOntlener ().getLogin ())
								&& r.isAfhaalbaar ())
				.toArray (Reservatie[]::new);
	}
	
	@Override
	public void Seed () {
	
	}
	
	public Reservatie geefAnnuleerbareReservatie (String aanbiederLogin, String ontlenerLogin) {
		Optional<Reservatie> optional = getAll ().stream ().filter (
						//r -> aanbiederLogin.equals (r.getGereedschap ().getAanbieder ().getLogin ())
						r -> aanbiederLogin.equals (r.getAanbieder ().getLogin ())
								&& ontlenerLogin.equals (r.getOntlener ().getLogin ())
								&& r.isAnnuleerbaar ())
				.findFirst ();
		return optional.orElse (null);
	}
}
