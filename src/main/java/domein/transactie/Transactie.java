package domein.transactie;

import java.time.LocalDateTime;

/**
 * Jonas Leijzen
 * 21/11/2021
 */
public class Transactie {
	
	private int id;
	private LocalDateTime tijdstip;
	private TransactieLijn lijnen;
	
	public Transactie () {
	
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
