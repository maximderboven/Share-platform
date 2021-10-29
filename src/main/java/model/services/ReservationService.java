package model.services;

import model.Reservation;
import model.ReservationOverlapException;
import model.tools.Lendable;
import model.users.User;
import repositories.ReservationRepository;

import java.time.LocalDate;

/**
 * Jonas Leijzen
 * 30/10/2021
 */
public class ReservationService {
	
	public static void scheduleReservation (ReservationRepository repository, User owner, User borrower, Lendable lendable, LocalDate startDate, LocalDate endDate) {
		Reservation reservation = new Reservation (owner, borrower, lendable, startDate, endDate);
		if (repository.getAll ().contains (reservation))
			throw new IllegalStateException ("Reservation already exists.");
		if (!repository.areAllToolsAreFree (reservation))
			throw new ReservationOverlapException ("One or more tools have already been reserved for this time period.");
		repository.add (reservation);
	}
	
}
