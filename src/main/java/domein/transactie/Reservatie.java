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

/**
 * Jonas Leijzen
 * 21/11/2021
 */
public final class Reservatie {
	
	private final Gebruiker aanbieder;
	private final Gebruiker ontlener;
	private final Gereedschap gereedschap;
	private final Periode periode;
	private final LinkedList<ReservatieStatus> reservatieStatusQueue;
	private final Transactie transactie;
	
	public Reservatie (Gebruiker aanbieder, Gebruiker ontlener, Gereedschap gereedschap, Periode periode, LocalDateTime datum) {
		this.aanbieder = aanbieder;
		this.ontlener = ontlener;
		this.gereedschap = gereedschap;
		this.periode = periode;
		transactie = TransactieService.getInstance ().maakTransactie (aanbieder, ontlener, this, datum);
		TransactieCataloogFactory.getInstance ().getCataloog ().add (transactie);
		reservatieStatusQueue = new LinkedList<> ();
		reservatieStatusQueue.add (new ReservatieStatus (transactie, ReservatieStatusType.NIEUW, datum));
		reservatieStatusQueue.add (new ReservatieStatus (transactie, ReservatieStatusType.GERESERVEERD, datum));
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
	
	public Transactie getTransactie () {
		return transactie;
	}
	
	public boolean isAfhaalbaar (LocalDate datum) {
		if (!periode.isIn (datum))
			return false;
		return reservatieStatusQueue.peekLast ().getType () == ReservatieStatusType.GERESERVEERD;
	}
	
	public void haalAf (LocalDate datum) {
		ReservatieStatusType type = ReservatieStatusType.AFGEHAALD;
		reservatieStatusQueue.add (new ReservatieStatus (transactie, type, LocalDateTime.now ()));
		long huurprijs = gereedschap.getHuurPrijs (periode.getDays ());
		long waarborg = gereedschap.getWaarbord ();
		getTransactie ().getLijnen ().add (new ReservatieTransactieLijn (huurprijs, type, ReservatieTransactieType.HUUR, this));
		GebruikerService.getInstance ().schrijfSharepointsOver (ontlener.getLogin (), aanbieder.getLogin (), huurprijs);
		GebruikerService.getInstance ().schrijfSharepointsOver (ontlener.getLogin (), aanbieder.getLogin (), waarborg);
	}
	
	public Boolean annuleer (ReservatieAnnuleerder reservatieAnnuleerder, LocalDate datum) {
		
		if (!isAnnuleerbaar ())
			return false;
		
		ReservatieStatusType type = reservatieAnnuleerder == ReservatieAnnuleerder.AANBIEDER ? ReservatieStatusType.ANNULATIE_AANBIEDER : ReservatieStatusType.ANNULATIE_ONTLENER;
		reservatieStatusQueue.add (new ReservatieStatus (transactie, type, LocalDateTime.now ()));
		long huurprijs = gereedschap.getHuurPrijs (periode.getDays ());
		long terugbetaalPrijs = gereedschap.getHuurPrijs (periode.getDays ()) / 10;
		long lijnprijs = terugbetaalPrijs * (type == ReservatieStatusType.ANNULATIE_AANBIEDER ? -1 : 1);
		getTransactie ().getLijnen ().add (new ReservatieTransactieLijn (lijnprijs, type, ReservatieTransactieType.ANNULATIE, this));
		if (periode.getVan ().minusDays (7).isBefore (datum)) {
			getTransactie ().getLijnen ().add (new ReservatieTransactieLijn (lijnprijs, type, ReservatieTransactieType.WAARBORG, this));
			String betalerLogin = type == ReservatieStatusType.ANNULATIE_AANBIEDER ? aanbieder.getLogin () : ontlener.getLogin ();
			String ontvangerlogin = type == ReservatieStatusType.ANNULATIE_AANBIEDER ? ontlener.getLogin () : aanbieder.getLogin ();
			GebruikerService.getInstance ().schrijfSharepointsOver (betalerLogin, ontvangerlogin, terugbetaalPrijs);
		}
		
		return true;
	}
	
	public boolean isAnnuleerbaar () {
		ReservatieStatusType statusType = reservatieStatusQueue.peekLast ().getType ();
		switch (statusType) {
			case NIEUW:
			case GERESERVEERD:
				return true;
			default:
				return false;
		}
	}
}