package persistence;

import domein.gebruiker.Gebruiker;

import java.util.*;

/**
 * Jonas Leijzen
 * 16/12/2021
 */
public class InMemoryGebruikerCataloog implements GebruikerCataloog {
	
	public Set<Gebruiker> gebruikerSet = new HashSet<> ();
	
	@Override
	public Gebruiker getByLogin (String login) {
		return gebruikerSet.stream ().filter (gebruiker -> gebruiker.getLogin ().equals (login)).findFirst ().orElse (null);
	}
	
	private static Random randomIDs = new Random ();
	
	@Override
	public int getNewId () {
		int id;
		do {
			id = randomIDs.nextInt ();
			if (get (id) != null)
				id = -1;
		} while (id != -1);
		return id;
	}
	
	@Override
	public int add (Gebruiker gebruiker) {
		gebruikerSet.add (gebruiker);
		return gebruiker.id;
	}
	
	@Override
	public Gebruiker get (int id) {
		return gebruikerSet.stream ().filter (t -> t.id == id).findFirst ().orElse (null);
	}
	
	@Override
	public boolean remove (int id) {
		return gebruikerSet.removeIf (t -> t.id == id);
	}
	
	@Override
	public List<Gebruiker> getAll () {
		return new ArrayList<> (gebruikerSet);
	}
}
