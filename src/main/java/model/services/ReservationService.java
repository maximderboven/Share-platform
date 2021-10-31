package model.services;

import model.Reservation;
import model.ReservationOverlapException;
import model.tools.Lendable;
import model.users.User;
import repositories.ReservationRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

import static utils.ThrowHelper.throwIfNegative;

/**
 * Jonas Leijzen
 * 30/10/2021
 */
public class ReservationService {
	
	public static void scheduleReservation (ReservationRepository repository, User owner, User borrower, Lendable lendable, LocalDate startDate, int days) {
		throwIfNegative ("days", days);
		LocalDate endDate = startDate.plusDays (days);
		Reservation reservation = new Reservation (owner, borrower, lendable, startDate, endDate);
		if (repository.getAll ().contains (reservation))
			throw new IllegalStateException ("Reservation already exists.");
		if (!repository.areAllToolsAreFree (reservation))
			throw new ReservationOverlapException ("One or more tools have already been reserved for this time period.");
		repository.add (reservation);
	}
	
	public static void PickUpReservation (Reservation reservation) {
		reservation.pickUpTools ();
	}
	
	public static void CancelReservation (ReservationRepository repository, Reservation reservation) {
		if (LocalDate.now ().plusWeeks (1).isAfter (reservation.getPickUpDate ())) {
			// Reservation got cancelled less than one week from pickup
			double severancePayAmount = reservation.getLendable ().getPrice () * 0.1;
			UserService.TransferSharepoints (reservation.getBorrower (), reservation.getOwner (), severancePayAmount);
		}
		repository.remove (reservation);
	}
	
	public static List<Reservation> getReservationsForOwnerAndBorrower (ReservationRepository repository, String owner, String borrower) {
		Predicate<Reservation> ownerPredicate = (r) -> r.getOwner ().getFullName ().equals (owner);
		Predicate<Reservation> borrowerPredicate = (r) -> r.getBorrower ().getFullName ().contains (borrower);
		return repository.filterReservations (ownerPredicate.and (borrowerPredicate));
	}
	
}
