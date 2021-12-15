package be.kdg.cucumber;

import applicatie.ReservatieController;
import domein.gebruiker.Gebruiker;
import domein.gereedschap.Gereedschap;
import domein.gereedschap.GereedschapsType;
import domein.transactie.Reservatie;
import domein.transactie.ReservatieAnnuleerder;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.GeoLocatie;
import util.Periode;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Jonas Leijzen
 * 1/12/2021
 */
public class AnnulatieOntlening {
	
	Map<String, Gereedschap> gereedschapMap = new HashMap<> ();
	Map<String, Gebruiker> gebruikerMap = new HashMap<> ();
	Map<String, Reservatie> reservatieMap = new HashMap<> ();
	ReservatieController reservatieController;
	LocalDate datum;
	
	@Given ("Tools")
	public void tools (DataTable table) {
		for (Map<String, String> m : table.asMaps ()) {
			String name = m.get ("naam");
			long sp = Long.parseLong (m.get ("sp"));
			GereedschapsType type = convertType (m.get ("type"));
			Gereedschap g = new Gereedschap (name, "", null, sp, 0, 0, type);
			gereedschapMap.put (name, g);
		}
	}
	
	private GereedschapsType convertType (String str) {
		switch (str) {
			case "Elektrisch":
				return GereedschapsType.ELEKTRISCH;
			case "Keuken":
				return GereedschapsType.KEUKEN;
			case "Geluid":
				return GereedschapsType.GELUIDSINSTALLATIE;
			case "Licht":
				return GereedschapsType.LICHTINSTALLATIE;
		}
		throw new IllegalArgumentException ("Couldn't find tooltype.");
	}
	
	
	@Given ("Users")
	public void users (DataTable table) {
		for (Map<String, String> m : table.asMaps ()) {
			String name = m.get ("naam");
			long sp = Long.parseLong (m.get ("sp"));
			Gebruiker g = new Gebruiker (name, new GeoLocatie (0, 0), sp);
			gebruikerMap.put (name, g);
		}
	}
	
	@Given ("Reservations")
	public void reservations (DataTable table) {
		for (Map<String, String> m : table.asMaps ()) {
			String name = m.get ("naam");
			String aanbiederKey = m.get ("aanbieder");
			String ontlenerKey = m.get ("ontlener");
			String gereedschapKey = m.get ("gereedschap");
			LocalDate van = LocalDate.parse (m.get ("van"));
			LocalDate tot = van.plusDays (Integer.parseInt (m.get ("dagen")));
			Reservatie r = new Reservatie (gebruikerMap.get (aanbiederKey), gebruikerMap.get (ontlenerKey), gereedschapMap.get (gereedschapKey), new Periode (van, tot));
			reservatieMap.put (name, r);
		}
	}
	
	@Given ("today is {string}")
	public void todayIs (String datum) {
		this.datum = LocalDate.parse (datum);
	}
	
	@When ("{string} aangeeft dat {string} {string} wil ophalen")
	public void aangeeftDatWilOphalen (String arg0, String arg1, String reservatie) {
		reservatieController.haalReservatieAf (reservatieMap.get (reservatie).id, datum);
	}
	
	@And ("{string} aangeeft dat {string} {string} wil annuleren")
	public void aangeeftDatWilAnnuleren (String aanbieder, String annulerendeGebruiker, String reservatie) {
		ReservatieAnnuleerder annuleerder = annulerendeGebruiker.equals (aanbieder) ? ReservatieAnnuleerder.AANBIEDER : ReservatieAnnuleerder.ONTLENER;
		reservatieController.annuleerReservatie (reservatieMap.get (reservatie).id, annuleerder, datum);
	}
	
	@Then ("Er wordt een afhalingtransactie aangemaakt")
	public void erWordtEenAfhalingtransactieAangemaakt () {
	}
	
	@And ("Er wordt een transactielijn gemaakt voor de onlening van {string} met een prijs van {int} SP")
	public void erWordtEenTransactielijnGemaaktVoorDeOnleningVanMetEenPrijsVanSP (String arg0, int arg1) {
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
