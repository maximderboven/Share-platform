package model.controllers;

import model.Reservation;
import model.services.ReservationService;
import model.tools.Lendable;
import model.users.User;
import repositories.ReservationRepository;

import java.time.LocalDate;
import java.util.List;

import static utils.ThrowHelper.throwIfNull;

/**
 * Jonas Leijzen
 * 29/10/2021
 */
public class ReservationController {
	
	private final ReservationRepository repository;
	
	public ReservationController (ReservationRepository repository) {
		throwIfNull ("repository", repository);
		this.repository = repository;
	}
	
	public void scheduleReservation (User owner, User borrower, Lendable lendable, LocalDate startDate, LocalDate endDate) {
		ReservationService.scheduleReservation (repository, owner, borrower, lendable, startDate, endDate);
	}
	
	public List<Reservation> getReservationsForOwnerAndBorrower (String owner, String borrower) {
		return repository.filterReservation (r -> r.getOwner ().getFullName ().equals (owner) && r.getBorrower ().getFullName ().contains (borrower));
	}
	
}
