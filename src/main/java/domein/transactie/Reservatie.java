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
	private Gereedschap gereedschap;
	private List<Gebruiker> ontleners = new ArrayList<> ();
	private Periode periode;
	private List<ReservatieTransactieLijn> reservatieTransactieLijnen;
	
	public Reservatie () {
	
	}
	
	public int getId () {
		return id;
	}
	
	public Gereedschap getGereedschap () {
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
