package domein.transactie;

import domein.Cataloog;

import java.util.Random;

/**
 * Jonas Leijzen
 * 21/11/2021
 */
public class TransactieCataloog extends Cataloog<Transactie> {
	
	private static TransactieCataloog instance;
	
	public static TransactieCataloog getInstance () {
		return instance;
	}
	
	private TransactieCataloog () {
		synchronized (instance) {
			if (instance != null)
				return;
			instance = this;
		}
	}
	
	private Random randomIDs = new Random ();
	
	public Transactie get (int id) {
		for (Transactie t : getAll ()) {
			if (t.id == id)
				return t;
		}
		return null;
	}
	
	public int getNewId () {
		int id;
		do {
			id = randomIDs.nextInt ();
			if (get (id) != null)
				id = -1;
		} while (id == -1);
		return id;
	}
	
	@Override
	public void Seed () {
	
	}
}
