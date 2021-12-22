package be.kdg.cucumber;

import applicatie.GebruikerController;
import applicatie.GereedschapController;
import applicatie.ReservatieController;
import domein.transactie.Reservatie;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Jonas Leijzen
 * 19/12/2021
 */
public class ToonAfTeHalenGereedschap {
	
	GebruikerController gebruikerController = new GebruikerController ();
	GereedschapController gereedschapController = new GereedschapController ();
	ReservatieController reservatieController = new ReservatieController ();
	Reservatie[] reservaties = null;
	
	@When ("{string} aangeeft dat {string} zijn reservaties wil ophalen")
	public void aangeeftDatZijnReservatiesWilOphalen (String aanbieder, String ontlener) {
		Long[] ids = reservatieController.geefAfhaalbareReservatie (aanbieder, ontlener, StepData.datum);
		reservaties = new Reservatie[ids.length];
		for (int i = 0; i < ids.length; i++) {
			reservaties[i] = reservatieController.geefReservatie (ids[i]);
		}
	}
	
	@Then ("wordt een lijst met {int} reservaties getoond")
	public void wordtEenLijstMetReservatiesGetoond (int amount) {
		assertEquals (amount, reservaties.length);
	}
	
	@And ("bevat de lijst {string}")
	public void bevatDeLijst (String reservatie) {
		Reservatie goal = StepData.reservatieMap.get (reservatie);
		
		assertTrue (arrayContains (reservaties, goal));
	}
	
	private <T> Boolean arrayContains (T[] array, T item) {
		for (T t : array) {
			if (t.equals (item))
				return true;
		}
		return false;
	}
}
