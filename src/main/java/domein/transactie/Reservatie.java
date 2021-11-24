package domein.transactie;

import applicatie.TransactieService;
import domein.gebruiker.Gebruiker;
import domein.gereedschap.Gereedschap;
import util.Periode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Jonas Leijzen
 * 21/11/2021
 */
public class Reservatie {
	
	private static int idCounter;
	private final int id;
	private final Gebruiker aanbieder;
	private final Gebruiker ontlener;
	private final Gereedschap gereedschap;
	private final Periode periode;
	private final List<ReservatieTransactieLijn> reservatieTransactieLijnen;
	private final Queue<ReservatieStatus> reservatieStatusQueue;
	private final Transactie transactie;
	
	public Reservatie (Gebruiker aanbieder, Gebruiker ontlener, Gereedschap gereedschap, Periode periode) {
		id = ++idCounter;
		this.aanbieder = aanbieder;
		this.ontlener = ontlener;
		this.gereedschap = gereedschap;
		this.periode = periode;
		reservatieTransactieLijnen = new LinkedList<> ();
		transactie = TransactieService.createTransactie (aanbieder, ontlener, this);
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
	
	public Gereedschap getGereedschap () {
		return gereedschap;
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
	
	public Transactie getTransactie () {
		return transactie;
	}
	
	public boolean isAfhaalbaar () {
		if (!periode.isIn (LocalDate.now ()))
			return false;
		return reservatieStatusQueue.peek ().getType () == ReservatieStatusType.GERESERVEERD;
	}
}