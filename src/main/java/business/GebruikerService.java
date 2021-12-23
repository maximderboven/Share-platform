package business;

import domein.gebruiker.Gebruiker;
import persistence.GebruikerCataloogFactory;

/**
 * Jonas Leijzen
 * 1/12/2021
 */
public class GebruikerService {
	
	private static GebruikerService instance;
	
	private GebruikerService () {
	
	}
	
	public static GebruikerService getInstance () {
		if (instance == null)
			instance = new GebruikerService ();
		return instance;
	}
	
	public Long voegGebruikerToe (Gebruiker gebruiker) {
		return GebruikerCataloogFactory.getInstance ().getCataloog ().add (gebruiker);
	}
	
	public Gebruiker geefGebruiker (Long id) {
		return GebruikerCataloogFactory.getInstance ().getCataloog ().get (id);
	}
	
	public Gebruiker getByLogin (String login) {
		return GebruikerCataloogFactory.getInstance ().getCataloog ().getByLogin (login);
	}
	
	public void schrijfSharepointsOver (String betalerLogin, String ontvangerLogin, long amount) {
		Gebruiker betaler = GebruikerCataloogFactory.getInstance ().getCataloog ().getByLogin (betalerLogin);
		Gebruiker ontvanger = GebruikerCataloogFactory.getInstance ().getCataloog ().getByLogin (ontvangerLogin);
		if (amount < 0)
			throw new IllegalArgumentException ("Amount cannot be negative.");
		betaler.setSharepoints (betaler.getSharepoints () - amount);
		ontvanger.setSharepoints (ontvanger.getSharepoints () + amount);
	}
	
}
