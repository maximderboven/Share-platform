package domein.transactie;

/**
 * Jonas Leijzen
 * 21/11/2021
 */
public class ReservatieTransactieLijn extends TransactieLijn {
	
	private ReservatieStatusType statusType;
	private ReservatieTransactieType reservatieTransactieType;

	public ReservatieTransactieLijn(ReservatieStatusType statusType) {
		setStatusType(statusType);
		setReservatieTransactieType(reservatieTransactieType);
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
}
