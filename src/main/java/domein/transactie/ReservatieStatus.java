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
	private byte[] bevestigingsCode;
	private boolean isBevestigd;
	
	public ReservatieStatus (Transactie transactie, ReservatieStatusType type, LocalDateTime tijdstip, byte[] bevestigingsCode) {
		this.transactie = transactie;
		this.type = type;
		this.tijdstip = tijdstip;
		this.bevestigingsCode = bevestigingsCode;
		this.isBevestigd = false;
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
	
	public byte[] getBevestigingsCode () {
		return bevestigingsCode;
	}
	
	public boolean isBevestigd () {
		return isBevestigd;
	}
}
