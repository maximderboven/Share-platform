package domein.transactie;

import java.time.LocalDateTime;

/**
 * Jonas Leijzen
 * 21/11/2021
 */
public class ReservatieStatus {
	
	private ReservatieStatusType type;
	private LocalDateTime tijdstip;
	
	public ReservatieStatus (ReservatieStatusType type, LocalDateTime tijdstip) {
		this.type = type;
		this.tijdstip = tijdstip;
	}
	
	public ReservatieStatusType getType () {
		return type;
	}
	
	public LocalDateTime getTijdstip () {
		return tijdstip;
	}
}
