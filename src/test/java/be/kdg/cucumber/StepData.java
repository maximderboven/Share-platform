package be.kdg.cucumber;

import applicatie.GebruikerController;
import applicatie.GereedschapController;
import applicatie.ReservatieController;
import business.GebruikerService;
import business.GereedschapService;
import business.ReservatieService;
import business.TransactieService;
import domein.gebruiker.Gebruiker;
import domein.gereedschap.Gereedschap;
import domein.gereedschap.GereedschapsTypen;
import domein.transactie.Reservatie;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import persistence.*;
import util.GeoLocatie;
import util.Periode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Jonas Leijzen
 * 19/12/2021
 */
public class StepData {
	
	public static Map<String, Gereedschap> gereedschapMap = new HashMap<> ();
	public static Map<String, Gebruiker> gebruikerMap = new HashMap<> ();
	public static Map<String, Reservatie> reservatieMap = new HashMap<> ();
	public static LocalDate datum;
	GebruikerController gebruikerController = new GebruikerController ();
	GereedschapController gereedschapController = new GereedschapController ();
	ReservatieController reservatieController = new ReservatieController ();
	
	private LocalDateTime LocalDateToLocalDateTime (LocalDate localDate) {
		return LocalDateTime.of (localDate.getYear (), localDate.getMonthValue (), localDate.getDayOfMonth (), 0, 0, 0);
	}
	
	@Before
	public void setup () {
		new GebruikerService ();
		new GereedschapService ();
		new ReservatieService ();
		new TransactieService ();
		
		GebruikerCataloogFactory.getInstance ().setCataloog (new InMemoryGebruikerCataloog (new RandomLongKeyProvider ()));
		GereedschapCataloogFactory.getInstance ().setCataloog (new InMemoryCataloog<> (new RandomLongKeyProvider ()));
		ReservatieCataloogFactory.getInstance ().setCataloog (new InMemoryReservatieCataloog (new RandomLongKeyProvider ()));
		TransactieCataloogFactory.getInstance ().setCataloog (new InMemoryCataloog<> (new RandomLongKeyProvider ()));
		
		GebruikerCataloogFactory.getInstance ().getCataloog ().clear ();
		GereedschapCataloogFactory.getInstance ().getCataloog ().clear ();
		ReservatieCataloogFactory.getInstance ().getCataloog ().clear ();
		TransactieCataloogFactory.getInstance ().getCataloog ().clear ();
		
		new GereedschapsTypen ();
	}
	
	
	@Given ("today is {string}")
	public void todayIs (String datum) {
		StepData.datum = LocalDate.parse (datum);
	}
	
	@Given ("Users")
	public void users (DataTable table) {
		for (Map<String, String> m : table.asMaps ()) {
			String name = m.get ("naam");
			long sp = Long.parseLong (m.get ("sp"));
			Gebruiker g = new Gebruiker (name, new GeoLocatie (0, 0), sp);
			gebruikerMap.put (name, g);
			gebruikerController.voegGebruikerToe (g);
		}
	}
	
	@Given ("Waarborgen")
	public void waarborgen (DataTable table) {
		for (Map<String, String> m : table.asMaps ()) {
			String name = m.get ("name");
			int value = Integer.parseInt (m.get ("value"));
			GereedschapsTypen.getInstance ().addType (name, value);
		}
	}
	
	@Given ("Tools")
	public void tools (DataTable table) {
		for (Map<String, String> m : table.asMaps ()) {
			String name = m.get ("name");
			long sp = Long.parseLong (m.get ("sp"));
			Gebruiker aanbieder = gebruikerMap.get (m.get ("aanbieder"));
			Gereedschap g = new Gereedschap (name, "", aanbieder, sp, 0, 0, m.get ("type"));
			gereedschapMap.put (name, g);
			gereedschapController.voegGereedschapToe (g);
		}
	}
	
	@Given ("JoinedTools")
	public void joinedtools (DataTable table) {
		for (Map<String, String> m : table.asMaps ()) {
			String name = m.get ("name");
			String[] tools = m.get ("tools").split (":");
			Gebruiker aanbieder = gebruikerMap.get (m.get ("aanbieder"));
			Gereedschap g = new Gereedschap (name, "", aanbieder, 0, 0, 0, m.get ("type"));
			Arrays.stream (tools).forEach (t -> g.addGereedschap (gereedschapMap.get (t)));
			gereedschapMap.put (name, g);
			gereedschapController.voegGereedschapToe (g);
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
			Reservatie r = new Reservatie (gebruikerMap.get (aanbiederKey), gebruikerMap.get (ontlenerKey), gereedschapMap.get (gereedschapKey), new Periode (van, tot), LocalDateToLocalDateTime (datum));
			reservatieMap.put (name, r);
			reservatieController.voegReservatieToe (r);
		}
	}
	
}
