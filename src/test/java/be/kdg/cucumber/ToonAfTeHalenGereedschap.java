package be.kdg.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Jonas Leijzen
 * 1/12/2021
 */
public class ToonAfTeHalenGereedschap {
	@When ("{string} aangeeft dat {string} zijn reservaties wil ophalen")
	public void aangeeftDatZijnReservatiesWilOphalen (String arg0, String arg1) {
	}
	
	@Then ("wordt een lijst met {int} reservaties getoond")
	public void wordtEenLijstMetReservatiesGetoond (int arg0) {
	}
	
	@And ("bevat de lijst {string}")
	public void bevatDeLijst (String arg0) {
	}
}
