package persistence;

import domein.transactie.Transactie;

/**
 * Arne Cools
 * 16/12/2021
 */
public class TransactieCataloogFactory {
	private static TransactieCataloogFactory instance;
	private Cataloog<Long, Transactie> cataloog;
	
	public TransactieCataloogFactory (Cataloog<Long, Transactie> cataloog) {
		synchronized (instance) {
			if (instance != null) {
				return;
			}
			instance = this;
		}
		this.cataloog = cataloog;
	}
	
	public static TransactieCataloogFactory getInstance () {
		return instance;
	}
	
	public Cataloog<Long, Transactie> getCataloog () {
		return cataloog;
	}
}
