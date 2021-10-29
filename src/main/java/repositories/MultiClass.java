package repositories;

import java.util.*;

/**
 * Jonas Leijzen
 * 29/10/2021
 */
public interface MultiClass<T> {
	
	boolean add (T t);
	
	boolean remove (T t);
	
	List<T> getAll ();
}
