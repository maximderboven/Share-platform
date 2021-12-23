package persistence;

/**
 * Jonas Leijzen
 * 15/12/2021
 */
public interface CataloogFactory<T> {
	
	Cataloog<? extends Number, T> getCataloog ();
	
}
