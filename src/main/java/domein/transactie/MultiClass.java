package domein.transactie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Jonas Leijzen
 * 24/11/2021
 */
public class MultiClass<T> {
	
	private Set<T> tSet = new HashSet<> ();
	
	public boolean add (T t) {
		return tSet.add (t);
	}
	
	public boolean remove (T t) {
		return tSet.remove (t);
	}
	
	public List<T> getAll () {
		return new ArrayList<> (tSet);
	}
}

