package domein.transactie;

import applicatie.GebruikerService;
import applicatie.TransactieService;
import domein.gebruiker.Gebruiker;
import domein.gereedschap.Gereedschap;
import persistence.CataloogObject;
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
public class Reservatie implements CataloogObject {
	
	private static int idCounter;
	public final int id;
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
		transactie = TransactieService.maakTransactie (aanbieder, ontlener, this);
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
	
	public boolean isAfhaalbaar (LocalDate datum) {
		if (!periode.isIn (datum))
			return false;
		return reservatieStatusQueue.peek ().getType () == ReservatieStatusType.GERESERVEERD;
	}
	
	public void haalAf (LocalDate datum) {
		ReservatieStatusType type = ReservatieStatusType.AFGEHAALD;
		reservatieStatusQueue.add (new ReservatieStatus (transactie, type, LocalDateTime.now ()));
		getTransactie ().getLijnen ().add (new ReservatieTransactieLijn (type, ReservatieTransactieType.HUUR, this));
	}
	
	public void annuleer (ReservatieAnnuleerder reservatieAnnuleerder, LocalDate datum) {
		ReservatieStatusType type = reservatieAnnuleerder == ReservatieAnnuleerder.AANBIEDER ? ReservatieStatusType.ANNULATIE_AANBIEDER : ReservatieStatusType.ANNULATIE_ONTLENER;
		reservatieStatusQueue.add (new ReservatieStatus (transactie, type, LocalDateTime.now ()));
		getTransactie ().getLijnen ().add (new ReservatieTransactieLijn (type, ReservatieTransactieType.ANNULATIE, this));
		if (periode.getVan ().minusDays (7).isBefore (datum)) {
			getTransactie ().getLijnen ().add (new ReservatieTransactieLijn (type, ReservatieTransactieType.WAARBORG, this));
			GebruikerService.schrijfSharepointsOver (aanbieder.getLogin (), ontlener.getLogin (), gereedschap.getDaghuurprijs () * periode.getDays ());
		}
	}
	
	public boolean isAnnuleerbaar () {
		ReservatieStatusType statusType = reservatieStatusQueue.peek ().getType ();
		switch (statusType) {
			case NIEUW:
			case GERESERVEERD:
				return true;
			default:
				return false;
		}
	}
}