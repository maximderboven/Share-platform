package domein.transactie;

import business.GebruikerService;
import business.TransactieService;
import domein.gebruiker.Gebruiker;
import domein.gereedschap.Gereedschap;
import persistence.TransactieCataloogFactory;
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
	
	private final Gebruiker aanbieder;
	private final Gebruiker ontlener;
	private final Gereedschap gereedschap;
	private final Periode periode;
	private final List<ReservatieTransactieLijn> reservatieTransactieLijnen;
	private final Queue<ReservatieStatus> reservatieStatusQueue;
	private final Transactie transactie;
	
	public Reservatie (Gebruiker aanbieder, Gebruiker ontlener, Gereedschap gereedschap, Periode periode, LocalDateTime datum) {
		this.aanbieder = aanbieder;
		this.ontlener = ontlener;
		this.gereedschap = gereedschap;
		this.periode = periode;
		reservatieTransactieLijnen = new LinkedList<> ();
		transactie = TransactieService.getInstance ().maakTransactie (aanbieder, ontlener, this, datum);
		TransactieCataloogFactory.getInstance ().getCataloog ().add (transactie);
		reservatieStatusQueue = new LinkedList<> ();
		reservatieStatusQueue.add (new ReservatieStatus (transactie, ReservatieStatusType.NIEUW, datum));
		reservatieStatusQueue.add (new ReservatieStatus (transactie, ReservatieStatusType.GERESERVEERD, datum));
		reservatieStatusQueue.poll ();
	}
	
	public Gebruiker getAanbieder () {
		return aanbieder;
	}
	
	public Gebruiker getOntlener () {
		return ontlener;
	}
	
	public Gereedschap getGereedschap () {
		return gereedschap;
	}
	
	public List<ReservatieTransactieLijn> getReservatieTransactieLijnen () {
		return reservatieTransactieLijnen;
	}
	
	public boolean addReservatieTransactieLijn (ReservatieTransactieLijn reservatieTransactieLijn) {
		return reservatieTransactieLijnen.add (reservatieTransactieLijn);
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
		getTransactie ().getLijnen ().add (new ReservatieTransactieLijn (gereedschap.getHuurPrijs (), type, ReservatieTransactieType.HUUR, this));
	}
	
	public Boolean annuleer (ReservatieAnnuleerder reservatieAnnuleerder, LocalDate datum) {
		
		if (!isAnnuleerbaar ())
			return false;
		
		ReservatieStatusType type = reservatieAnnuleerder == ReservatieAnnuleerder.AANBIEDER ? ReservatieStatusType.ANNULATIE_AANBIEDER : ReservatieStatusType.ANNULATIE_ONTLENER;
		reservatieStatusQueue.add (new ReservatieStatus (transactie, type, LocalDateTime.now ()));
		reservatieStatusQueue.poll ();
		getTransactie ().getLijnen ().add (new ReservatieTransactieLijn (gereedschap.getHuurPrijs (), type, ReservatieTransactieType.ANNULATIE, this));
		if (periode.getVan ().minusDays (7).isBefore (datum)) {
			getTransactie ().getLijnen ().add (new ReservatieTransactieLijn (gereedschap.getHuurPrijs () / 10, type, ReservatieTransactieType.WAARBORG, this));
			GebruikerService.getInstance ().schrijfSharepointsOver (aanbieder.getLogin (), ontlener.getLogin (), gereedschap.getDaghuurprijs () * periode.getDays ());
		}
		
		return true;
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