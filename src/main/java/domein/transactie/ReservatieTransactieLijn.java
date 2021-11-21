package domein.transactie;

/**
 * Jonas Leijzen
 * 21/11/2021
 */
public class ReservatieTransactieLijn implements TransactieLijn {
	
	private ReservatieStatusType statusType;
	private ReservatieTransactieType reservatieTransactieType;
	
	@Override
	public long sharepoints () {
		return 0;
	}
}
