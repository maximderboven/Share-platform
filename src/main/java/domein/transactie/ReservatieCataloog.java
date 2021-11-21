package domein.transactie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Jonas Leijzen
 * 21/11/2021
 */
public class ReservatieCataloog {
	
	private Set<Reservatie> reservaties = new HashSet<> ();
	
	public Reservatie get (int id) {
		for (Reservatie t : reservaties) {
			if (t.getId () == id)
				return t;
		}
		return null;
	}
	
	public boolean add (Reservatie reservatie) {
		return reservaties.add (reservatie);
	}
	
	public boolean remove (Reservatie reservatie) {
		return reservaties.remove (reservatie);
	}
	
	public List<Reservatie> getAll () {
		return new ArrayList<> (reservaties);
	}
	
}
