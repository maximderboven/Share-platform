package domein.transactie;

import domein.gebruiker.Gebruiker;
import domein.gereedschap.Gereedschap;
import util.Periode;

import java.util.ArrayList;
import java.util.List;

/**
 * Jonas Leijzen
 * 21/11/2021
 */
public class Reservatie {
	
	private int id;
	private Gebruiker aanbieder;
	private Gebruiker ontlener;
	private List<Gereedschap> gereedschap = new ArrayList<> ();
	private Periode periode;
	private List<ReservatieTransactieLijn> reservatieTransactieLijnen;
	
	public Reservatie () {
	
	}
	
	public int getId () {
		return id;
	}
	
	public List<Gereedschap> getGereedschap () {
		return gereedschap;
	}
	
	public void setReservatieTransactieLijnen(List<ReservatieTransactieLijn> reservatieTransactieLijnen) {
		this.reservatieTransactieLijnen = reservatieTransactieLijnen;
	}
	
	public List<ReservatieTransactieLijn> getReservatieTransactieLijnen() {
		return reservatieTransactieLijnen;
	}
	
	public boolean addReservatieTransactieLijn(ReservatieTransactieLijn reservatieTransactieLijn){
		return reservatieTransactieLijnen.add(reservatieTransactieLijn);
	}
	
	public boolean removeReservatieTransactieLijn(ReservatieTransactieLijn reservatieTransactieLijn){
		return reservatieTransactieLijnen.remove(reservatieTransactieLijn);
	}
}