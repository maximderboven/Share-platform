package persistence;

import java.util.List;

/**
 * Jonas Leijzen
 * 15/12/2021
 */
public interface Cataloog<T extends CataloogObject> {
	
	int Add (T t);
	
	boolean remove (T t);
	
	List<T> getAll ();
	
	Cataloog<T> getInstance ();
	
}
