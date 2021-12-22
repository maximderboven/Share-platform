package persistence;

import domein.transactie.Reservatie;

import java.time.LocalDate;

/**
 * @author Maxim Derboven
 * @version 1.0 16/12/2021 14:51
 */
public interface ReservatieCataloog extends Cataloog<Long, Reservatie> {
	
	Reservatie[] geefAfhaalbareReservaties (String aanbiederLogin, String ontlenerLogin, LocalDate datum);
	
	Long getId (Reservatie reservatie);
}
