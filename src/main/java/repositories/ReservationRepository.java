package repositories;

import model.Reservation;
import model.tools.Tool;

import java.time.LocalDate;
import java.util.List;

/**
 * Jonas Leijzen
 * 29/10/2021
 */
public class ReservationRepository extends Repository<Reservation> {
	
	public boolean areAllToolsAreFree (Reservation toPlanReservation) {
		
		for (Reservation reservation : getAll ()) {
			
			if (!hasOverlap (reservation.getPickUpDate (), reservation.getReturnDate (), toPlanReservation.getPickUpDate (), toPlanReservation.getReturnDate ()))
				continue; // The reservations have no overlap so no bother checking the individual items.
			
			List<Tool> usedTools = reservation.getLendable ().getAllTools ();
			for (Tool tool : toPlanReservation.getLendable ().getAllTools ()) {
				if (usedTools.contains (tool))
					return false;
				
			}
			
		}
		return true;
	}
	
	private boolean hasOverlap (LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
		return start1.isBefore (end2) && start2.isBefore (end1);
	}
	
	@Override
	public void Seed () {
	
	}
}
