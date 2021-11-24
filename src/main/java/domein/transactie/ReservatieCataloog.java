package domein.transactie;

import java.time.LocalDate;

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
						r -> aanbiederLogin.equals (r.getAanbieder ().getLogin ())
								&& ontlenerLogin.equals (r.getOntlener ().getLogin ())
								&& r.isAfhaalbaar ())
				.toArray (Reservatie[]::new);
	}
	
	@Override
	public void Seed () {
	
	}
}
