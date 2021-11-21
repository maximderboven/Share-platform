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
	private Gebruiker ontlener;
	private List<Gereedschap> gereedschap = new ArrayList<> ();
	
	public Reservatie () {
	
	}
	
	public int getId () {
		return id;
	}
	
	public List<Gereedschap> getGereedschap () {
		return gereedschap;
	}
}
