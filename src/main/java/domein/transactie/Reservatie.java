package domein.transactie;

import domein.gebruiker.Gebruiker;
import domein.gereedschap.Gereedschap;
import util.Periode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
	private Queue<ReservatieStatus> reservatieStatusQueue;
	private final Transactie transactie;
	
	public Reservatie () {
		transactie =
				TransactieCataloog.add (transactie);
		reservatieStatusQueue = new LinkedList<> ();
		reservatieStatusQueue.add (new ReservatieStatus (transactie, ReservatieStatusType.NIEUW, LocalDateTime.now ()));
	}
	
	public Gebruiker getAanbieder () {
		return aanbieder;
	}
	
	public Gebruiker getOntlener () {
		return ontlener;
	}
	
	public int getId () {
		return id;
	}
	
	public List<Gereedschap> getGereedschap () {
		return gereedschap;
	}
	
	public void setReservatieTransactieLijnen (List<ReservatieTransactieLijn> reservatieTransactieLijnen) {
		this.reservatieTransactieLijnen = reservatieTransactieLijnen;
	}
	
	public List<ReservatieTransactieLijn> getReservatieTransactieLijnen() {
		return reservatieTransactieLijnen;
	}
	
	public boolean addReservatieTransactieLijn (ReservatieTransactieLijn reservatieTransactieLijn) {
		return reservatieTransactieLijnen.add (reservatieTransactieLijn);
	}
	
	public boolean removeReservatieTransactieLijn (ReservatieTransactieLijn reservatieTransactieLijn) {
		return reservatieTransactieLijnen.remove (reservatieTransactieLijn);
	}
	
	public boolean isAfhaalbaar () {
		if (!periode.isIn (LocalDate.now ()))
			return false;
		return reservatieStatusQueue.peek ().getType () == ReservatieStatusType.GERESERVEERD;
	}
}