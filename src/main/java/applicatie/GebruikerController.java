package applicatie;

import business.GebruikerService;
import domein.gebruiker.Gebruiker;
import util.GeoLocatie;

/**
 * Jonas Leijzen
 * 16/12/2021
 */
public class GebruikerController {

	public Gebruiker maakGebruiker (String login, GeoLocatie locatie, long sharepoints) {
		return GebruikerService.getInstance ().maakGebruiker (login, locatie, sharepoints);
	}
	
	public Gebruiker geefGebruiker (int id) {
		return GebruikerService.getInstance ().geefGebruiker (id);
	}

}
