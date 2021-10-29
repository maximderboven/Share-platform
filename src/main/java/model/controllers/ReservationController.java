package model.controllers;

import model.services.ReservationService;
import model.tools.Lendable;
import model.users.User;
import repositories.ReservationRepository;

import java.time.LocalDate;

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
	
}
