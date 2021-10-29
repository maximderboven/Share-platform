package repositories;

import java.util.*;

/**
 * Jonas Leijzen
 * 29/10/2021
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
