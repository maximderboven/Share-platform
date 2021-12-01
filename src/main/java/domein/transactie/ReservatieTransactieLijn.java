package domein.transactie;

/**
 * Jonas Leijzen
 * 21/11/2021
 */
public class ReservatieTransactieLijn extends TransactieLijn {
	
	public final ReservatieStatusType statusType;
	public final ReservatieTransactieType reservatieTransactieType;
	public final Reservatie reservatie;
	
	public ReservatieTransactieLijn (ReservatieStatusType statusType, ReservatieTransactieType reservatieTransactieType, Reservatie reservatie) {
		if (statusType == null) {
			throw new IllegalArgumentException ("statusType kan niet null zijn");
		}
		
		if (reservatieTransactieType == null) {
			throw new IllegalArgumentException ("reservatieTransactieType kan niet null zijn");
		}
		
		if (reservatie == null) {
			throw new IllegalArgumentException ("reservatie kan niet null zijn");
		}
		this.statusType = statusType;
		this.reservatieTransactieType = reservatieTransactieType;
		this.reservatie = reservatie;
	}
	
	public ReservatieStatusType getStatusType () {
		return statusType;
	}
	
	public ReservatieTransactieType getReservatieTransactieType () {
		return reservatieTransactieType;
	}
	
	public Reservatie getReservatie () {
		return reservatie;
	}
}
