package domein.transactie;

/**
 * Jonas Leijzen
 * 21/11/2021
 */
public class ReservatieTransactieLijn extends TransactieLijn {
	
	private ReservatieStatusType statusType;
	private ReservatieTransactieType reservatieTransactieType;
	private Reservatie reservatie;

	public ReservatieTransactieLijn(ReservatieStatusType statusType, ReservatieTransactieType reservatieTransactieType, Reservatie reservatie) {
		setStatusType(statusType);
		setReservatieTransactieType(reservatieTransactieType);
		setReservatie(reservatie);
	}

	public void setStatusType(ReservatieStatusType statusType) {
		if(statusType == null){
			throw new IllegalArgumentException("statusType kan niet null zijn");
		}
		this.statusType = statusType;
	}

	public void setReservatieTransactieType(ReservatieTransactieType reservatieTransactieType) {
		if(reservatieTransactieType == null){
			throw new IllegalArgumentException("reservatieTransactieType kan niet null zijn");
		}
		this.reservatieTransactieType = reservatieTransactieType;
	}

	public void setReservatie(Reservatie reservatie) {
		if(reservatie == null){
			throw new IllegalArgumentException("reservatie kan niet null zijn");
		}
		this.reservatie = reservatie;
	}
}
