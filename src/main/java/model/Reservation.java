package model;

import model.services.UserService;
import model.tools.Lendable;
import model.transactions.Transaction;
import model.users.User;

import java.time.LocalDate;

import static utils.ThrowHelper.throwIfInThePast;
import static utils.ThrowHelper.throwIfNull;

/**
 * Arne Cools
 * 27/10/2021
 */
public class Reservation {
	
	private final Transaction transaction;
	private User owner, borrower;
	private Lendable lendable;
	private LocalDate pickUpDate, returnDate;
	private boolean pickedUp, returned;
	
	public Reservation (User owner, User borrower, Lendable lendable, LocalDate pickUpDate, LocalDate returnDate) {
		setOwner (owner);
		setBorrower (borrower);
		setLendable (lendable);
		setPickUpDate (pickUpDate);
		setReturnDate (returnDate);
		transaction = new Transaction ();
	}
	
	public void setOwner (User owner) {
		throwIfNull ("owner", owner);
		this.owner = owner;
	}
	
	public void setBorrower (User borrower) {
		throwIfNull ("borrower", borrower);
		this.borrower = borrower;
	}
	
	public void setLendable (Lendable lendable) {
		throwIfNull ("lendable", lendable);
		this.lendable = lendable;
	}
	
	public void setPickUpDate (LocalDate pickUpDate) {
		throwIfNull ("pickUpDate", pickUpDate);
		throwIfInThePast ("pickUpDate", pickUpDate);
		this.pickUpDate = pickUpDate;
	}
	
	public void setReturnDate (LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	
	public User getOwner () {
		return owner;
	}
	
	public User getBorrower () {
		return borrower;
	}
	
	public Lendable getLendable () {
		return lendable;
	}
	
	public LocalDate getPickUpDate () {
		return pickUpDate;
	}
	
	public LocalDate getReturnDate () {
		return returnDate;
	}
	
	public boolean isPickedUp () {
		return pickedUp;
	}
	
	public boolean isReturned () {
		return returned;
	}
	
	public void pickUpTools () {
		if (pickedUp)
			throw new IllegalStateException ("Tools where already picked up.");
		UserService.TransferSharepoints (borrower, owner, lendable.getPrice () + lendable.getGuaranty ());
		transaction.generatePickupTransactionLinesForLendable (lendable);
		pickedUp = true;
	}
	
	public void returnTools () {
		if (!pickedUp)
			throw new IllegalStateException ("Can't pick up tools when they have not been picked up.");
		if (returned)
			throw new IllegalStateException ("Tools already returned.");
		UserService.TransferSharepoints (owner, borrower, lendable.getGuaranty ());
		transaction.generateReturnTransactionLinesForLendable (lendable);
		returned = true;
	}
	
	public Transaction getTransaction () {
		return transaction;
	}
	
}
