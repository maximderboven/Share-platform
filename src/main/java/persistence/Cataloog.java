package persistence;

import java.util.Collection;

/**
 * Jonas Leijzen
 * 15/12/2021
 */
public interface Cataloog<Key extends Number, Value> {
	
	Key add (Value t);
	
	Value get (Key id);
	
	boolean remove (Key id);
	
	Collection<Value> getAll ();
	
	void clear ();
	
}
