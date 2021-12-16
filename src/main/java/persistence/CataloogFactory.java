package persistence;

/**
 * Jonas Leijzen
 * 15/12/2021
 */
public interface CataloogFactory {
	
	<T extends CataloogObject> Cataloog<T> getInstance ();
	
}
