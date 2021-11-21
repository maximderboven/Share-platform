package domein.transactie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Jonas Leijzen
 * 21/11/2021
 */
public class TransactieCataloog {
	
	private Set<Transactie> transacties = new HashSet<> ();
	
	public Transactie get (int id) {
		for (Transactie t : transacties) {
			if (t.getId () == id)
				return t;
		}
		return null;
	}
	
	public boolean add (Transactie transactie) {
		return transacties.add (transactie);
	}
	
	public boolean remove (Transactie transactie) {
		return transacties.remove (transactie);
	}
	
	public List<Transactie> getAll () {
		return new ArrayList<> (transacties);
	}
	
}
