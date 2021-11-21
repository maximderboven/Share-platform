package domein.transactie;

import domein.gebruiker.Gebruiker;
import util.Periode;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Jonas Leijzen
 * 21/11/2021
 */
public class Reservatie {
	
	private int id;
	private Gebruiker aanbieder;
	private Gebruiker ontlener;
	private Queue<ReservatieStatus> reservatieStatussen = new LinkedList<> ();
	private Periode periode;
	
	public Reservatie () {
	
	}
	
	public int getId () {
		return id;
	}
	
	public Gebruiker getAanbieder () {
		return aanbieder;
	}
	
	public Gebruiker getOntlener () {
		return ontlener;
	}
	
	public boolean isAfhaalbaar () {
		if (!periode.isIn (LocalDate.now ()))
			return false;
		return reservatieStatussen.peek ().getType () == ReservatieStatusType.GERESERVEERD;
	}
}
