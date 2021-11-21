package domein.transactie;

import domein.gebruiker.Gebruiker;
import domein.gereedschap.Gereedschap;

import java.util.ArrayList;
import java.util.List;

/**
 * Jonas Leijzen
 * 21/11/2021
 */
public class Reservatie {
	
	private int id;
	private Gereedschap gereedschap;
	private List<Gebruiker> ontleners = new ArrayList<> ();
	
	public Reservatie () {
	
	}
	
	public int getId () {
		return id;
	}
	
	public Gereedschap getGereedschap () {
		return gereedschap;
	}
}
