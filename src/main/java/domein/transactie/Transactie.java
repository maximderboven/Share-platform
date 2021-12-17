package domein.transactie;

import domein.gebruiker.Gebruiker;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Jonas Leijzen
 * 21/11/2021
 */
public class Transactie {
	
	private Gebruiker ontvanger;
	private Gebruiker betaler;
	private Reservatie reservatie;
	private LocalDateTime tijdstip;
	private final Set<TransactieLijn> lijnen;

	public Transactie(Gebruiker ontvanger, Gebruiker betaler, Reservatie reservatie, LocalDateTime tijdstip) {
		this.ontvanger = ontvanger;
		this.betaler = betaler;
		this.reservatie = reservatie;
		this.tijdstip = tijdstip;
		lijnen = new HashSet<>();
	}
	
	public LocalDateTime getTijdstip () {
		return tijdstip;
	}
	
	public Set<TransactieLijn> getLijnen () {
		return lijnen;
	}
	
	private void addTransactionLine (float bedrag, HandelsLijnType handelsLijnType) {
		lijnen.add (new HandelTransactieLijn (bedrag, handelsLijnType));
	}
	
	public long sharepoints () {
		// TODO
		return 0;
	}

}
