package persistence;

import domein.transactie.Transactie;

/**
 * Arne Cools
 * 16/12/2021
 */
public class TransactieCataloogFactory {
	private static TransactieCataloogFactory instance;
	private Cataloog<? extends Number, Transactie> cataloog;
	
	public TransactieCataloogFactory (Cataloog<? extends Number, Transactie> cataloog) {
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

    public Cataloog<? extends Number, Transactie> getCataloog(){
        return cataloog;
    }
}
