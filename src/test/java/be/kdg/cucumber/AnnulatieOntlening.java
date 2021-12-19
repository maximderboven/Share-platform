package be.kdg.cucumber;

import applicatie.GebruikerController;
import applicatie.GereedschapController;
import applicatie.ReservatieController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Jonas Leijzen
 * 1/12/2021
 */

public class AnnulatieOntlening {
	
	GebruikerController gebruikerController = new GebruikerController ();
	GereedschapController gereedschapController = new GereedschapController ();
	ReservatieController reservatieController = new ReservatieController ();
	
	@When ("{string} aangeeft dat {string} {string} wil ophalen")
	public void aangeeftDatWilOphalen (String arg0, String arg1, String arg2) {
	}
	
	@And ("{string} aangeeft dat {string} {string} wil annuleren")
	public void aangeeftDatWilAnnuleren (String arg0, String arg1, String arg2) {
	}
	
	@And ("{string} bevestigd de afhaling")
	public void bevestigdDeAfhaling (String arg0) {
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
