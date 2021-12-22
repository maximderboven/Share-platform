package persistence;

import domein.transactie.Transactie;

/**
 * Arne Cools
 * 16/12/2021
 */
public class TransactieCataloogFactory {
	private static TransactieCataloogFactory instance;
	private final Cataloog<Long, Transactie> cataloog;
	
	private TransactieCataloogFactory () {
		cataloog = new InMemoryCataloog<> (new RandomLongKeyProvider ());
	}
	
	public static TransactieCataloogFactory getInstance () {
		if (instance == null) {
			instance = new TransactieCataloogFactory ();
		}
		return instance;
	}
	
	public Cataloog<Long, Transactie> getCataloog () {
		return cataloog;
	}
}
