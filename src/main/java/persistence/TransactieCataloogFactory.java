package persistence;

import domein.transactie.Transactie;

/**
 * Arne Cools
 * 16/12/2021
 */
public class TransactieCataloogFactory {
	private static TransactieCataloogFactory instance;
	private Cataloog<Long, Transactie> cataloog;
	
	private TransactieCataloogFactory () {
	}
	
	public static TransactieCataloogFactory getInstance () {
		if (instance == null) {
			instance = new TransactieCataloogFactory ();
		}
		return instance;
	}
	
	public void setCataloog (Cataloog<Long, Transactie> cataloog) {
		this.cataloog = cataloog;
	}
	
	public Cataloog<Long, Transactie> getCataloog () {
		return cataloog;
	}
}
