package domein.transactie;

import domein.Cataloog;

import java.time.LocalDate;

/**
 * Jonas Leijzen
 * 21/11/2021
 */
public class ReservatieCataloog extends Cataloog<Reservatie> {
	
	private static ReservatieCataloog instance;
	
	public static ReservatieCataloog getInstance () {
		return instance;
	}
	
	private ReservatieCataloog () {
		synchronized (instance) {
			if (instance != null)
				return;
			instance = this;
		}
	}
	
	public Reservatie get (int id) {
		for (Reservatie t : super.getAll ()) {
			if (t.getId () == id)
				return t;
		}
		return null;
	}
	
	public Reservatie[] geefAfhaalbareReservaties (String aanbiederLogin, String ontlenerLogin, LocalDate datum) {
		return getAll ().stream ().filter (
						r -> aanbiederLogin.equals (r.getAanbieder ().getLogin ())
								&& ontlenerLogin.equals (r.getOntlener ().getLogin ())
								&& r.isAfhaalbaar (datum))
				.toArray (Reservatie[]::new);
	}
	
	public Reservatie geefReservatie (int reservatieId) {
		return get (reservatieId);
	}
	
	@Override
	public void Seed () {
	
	}
}
