package be.kdg.cucumber;

import applicatie.GebruikerController;
import applicatie.GereedschapController;
import applicatie.ReservatieController;
import domein.transactie.Reservatie;
import domein.transactie.ReservatieAnnuleerder;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Jonas Leijzen
 * 1/12/2021
 */

public class AnnulatieOntlening {
	
	GebruikerController gebruikerController = new GebruikerController ();
	GereedschapController gereedschapController = new GereedschapController ();
	ReservatieController reservatieController = new ReservatieController ();
	
	Long ophaalReservatieID, annuleerReservatieID;
	
	@When ("{string} aangeeft dat {string} {string} wil ophalen")
	public void aangeeftDatWilOphalen (String aanbieder, String ontlener, String reservatie) {
		Long[] reservatieIDs = reservatieController.geefAfhaalbareReservatie (aanbieder, ontlener, StepData.datum);
		Long reservatieID = reservatieController.getId (StepData.reservatieMap.get (reservatie));
		
		assertTrue (arrayContains (reservatieIDs, reservatieID));
		
		ophaalReservatieID = reservatieID;
	}
	
	private <T> Boolean arrayContains (T[] array, T item) {
		for (T t : array) {
			if (t.equals (item))
				return true;
		}
		return false;
	}
	
	@And ("{string} aangeeft dat {string} {string} wil annuleren")
	public void aangeeftDatWilAnnuleren (String aanbieder, String ontlener, String reservatie) {
		
		Reservatie r = StepData.reservatieMap.get (reservatie);
		ReservatieAnnuleerder annuleerder = ontlener.equals (aanbieder) ? ReservatieAnnuleerder.AANBIEDER : ReservatieAnnuleerder.ONTLENER;
		
		Long[] reservatieIDs = reservatieController.geefAfhaalbareReservatie (aanbieder, r.getOntlener ().getLogin (), StepData.datum);
		Long reservatieID = reservatieController.getId (r);
		
		assertTrue (arrayContains (reservatieIDs, reservatieID));
		
		annuleerReservatieID = reservatieID;
		
		assertTrue (reservatieController.annuleerReservatie (reservatieID, annuleerder, StepData.datum));
	}
	
	@And ("{string} bevestigd de afhaling")
	public void bevestigdDeAfhaling (String reservatie) {
		assertTrue (reservatieController.haalReservatieAf (ophaalReservatieID, StepData.datum));
	}
	
	@Then ("Er wordt een afhalingtransactie aangemaakt")
	public void erWordtEenAfhalingtransactieAangemaakt () {
	
	}
	
	@And ("Er wordt een transactielijn gemaakt voor de ontlening van {string} met een prijs van {int} SP")
	public void erWordtEenTransactielijnGemaaktVoorDeOntleningVanMetEenPrijsVanSP (String arg0, int arg1) {
	}
	
	@And ("Er wordt een transactielijn gemaakt voor de waarborg van {string} met een prijs van {int} SP")
	public void erWordtEenTransactielijnGemaaktVoorDeWaarborgVanMetEenPrijsVanSP (String arg0, int arg1) {
	}
	
	@And ("Er wordt een transactielijn gemaakt voor annulatie van {string} met een prijs van {int} SP")
	public void erWordtEenTransactielijnGemaaktVoorAnnulatieVanMetEenPrijsVanSP (String arg0, int arg1) {
	}
	
	@And ("heeft {string} {int} SP")
	public void heeftSP (String arg0, int arg1) {
	
	}
}
