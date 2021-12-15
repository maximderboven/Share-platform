package domein.transactie;

/**
 * Jonas Leijzen
 * 15/12/2021
 */

@FunctionalInterface
public interface ReservatiePrijsBerekener {
	
	long berekenPrijs (Reservatie reservatie);
	
}
