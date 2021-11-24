package domein.transactie;

import domein.gebruiker.Gebruiker;

import java.time.LocalDateTime;

/**
 * Jonas Leijzen
 * 21/11/2021
 */
public class Transactie {
	
	private int id;
	private Gebruiker ontvanger;
	private Gebruiker betaler;
	private Reservatie reservatie;
	private LocalDateTime tijdstip;
	private TransactieLijn lijnen;
	
	public Transactie (int id, Gebruiker ontvanger, Gebruiker betaler, Reservatie reservatie, LocalDateTime tijdstip, TransactieLijn lijnen) {
		this.id = id;
		this.ontvanger = ontvanger;
		this.betaler = betaler;
		this.reservatie = reservatie;
		this.tijdstip = tijdstip;
		this.lijnen = lijnen;
	}
	
	public int getId () {
		return id;
	}
	
	public LocalDateTime getTijdstip () {
		return tijdstip;
	}
	
	public TransactieLijn getLijnen () {
		return lijnen;
	}
}
