package applicatie;

import business.GebruikerService;
import domein.gebruiker.Gebruiker;

/**
 * Jonas Leijzen
 * 16/12/2021
 */
public class GebruikerController {
	
	public Long voegGebruikerToe (Gebruiker gebruiker) {
		return GebruikerService.getInstance ().voegGebruikerToe (gebruiker);
	}
	
	public Gebruiker geefGebruiker (Long id) {
		return GebruikerService.getInstance ().geefGebruiker (id);
	}
	
}
