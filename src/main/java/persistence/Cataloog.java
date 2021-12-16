package persistence;

import java.util.List;

/**
 * Jonas Leijzen
 * 15/12/2021
 */
public interface Cataloog<T extends CataloogObject> {
	
	int add (T t);
	
	T get (int id);
	
	boolean remove (int id);
	
	List<T> getAll ();
	
}
