package domein.transactie;

import java.time.LocalDateTime;

/**
 * Jonas Leijzen
 * 21/11/2021
 */
public class ReservatieStatus {
	
	private Transactie transactie;
	private ReservatieStatusType type;
	private LocalDateTime tijdstip;
	
	public ReservatieStatus (Transactie transactie, ReservatieStatusType type, LocalDateTime tijdstip) {
		this.transactie = transactie;
		this.type = type;
		this.tijdstip = tijdstip;
	}
	
	public Transactie getTransactie () {
		return transactie;
	}
	
	public ReservatieStatusType getType () {
		return type;
	}
	
	public LocalDateTime getTijdstip () {
		return tijdstip;
	}
}
