package persistence;

import domein.gebruiker.Gebruiker;

/**
 * Jonas Leijzen
 * 16/12/2021
 */
public interface GebruikerCataloog extends Cataloog<Gebruiker>, IdGenerator {
	
	Gebruiker getByLogin (String login);
	
}
