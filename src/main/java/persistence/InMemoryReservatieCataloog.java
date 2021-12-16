package persistence;

import domein.transactie.Reservatie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Maxim Derboven
 * @version 1.0 16/12/2021 15:04
 */
public class InMemoryReservatieCataloog implements ReservatieCataloog {
	
	public Set<Reservatie> reservatieSet = new HashSet<> ();
	
	@Override
	public int add (Reservatie reservatie) {
		reservatieSet.add (reservatie);
		return reservatie.id;
	}
	
	@Override
	public boolean remove (int id) {
		return reservatieSet.removeIf (t -> t.id == id);
	}
	
	@Override
	public List<Reservatie> getAll () {
		return new ArrayList<> (reservatieSet);
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
	public Reservatie geefReservatie (int reservatieId) {
		for (Reservatie r : reservatieSet) {
			if (r.getId () == reservatieId)
				return r;
		}
		return null;
	}
}
