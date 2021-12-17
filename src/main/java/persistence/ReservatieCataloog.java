package persistence;

import domein.transactie.Reservatie;

import java.time.LocalDate;

/**
 * @author Maxim Derboven
 * @version 1.0 16/12/2021 14:51
 */
public interface ReservatieCataloog<Key extends Number> extends Cataloog<Key, Reservatie> {
	Reservatie[] geefAfhaalbareReservaties(String aanbiederLogin, String ontlenerLogin, LocalDate datum);
	Reservatie geefReservatie(Key reservatieId);
}
