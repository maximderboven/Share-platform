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

	private final int id;
	private Gebruiker ontvanger;
	private Gebruiker betaler;
	private Reservatie reservatie;
	private LocalDateTime tijdstip;
	private final Set<TransactieLijn> lijnen;

	public Transactie(int id, Gebruiker ontvanger, Gebruiker betaler, Reservatie reservatie, LocalDateTime tijdstip) {
		this.id = id;
		this.ontvanger = ontvanger;
		this.betaler = betaler;
		this.reservatie = reservatie;
		this.tijdstip = tijdstip;
		lijnen = new HashSet<>();
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getTijdstip() {
		return tijdstip;
	}

	public Set<TransactieLijn> getLijnen() {
		return lijnen;
	}

	private void AddTransactionLines(float bedrag, HandelsTypeLijn handelsTypeLijn) {
		lijnen.add(new HandelTransactieLijn(bedrag, handelsTypeLijn));
	}


}
