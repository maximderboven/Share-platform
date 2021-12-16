package persistence;

import domein.gebruiker.Gebruiker;
import domein.gereedschap.Gereedschap;
import domein.transactie.Reservatie;
import util.Periode;

/**
 * @author Maxim Derboven
 * @version 1.0 16/12/2021 15:31
 */
public class ReservatieFactory<T extends Cataloog<Reservatie>> {
	private static ReservatieFactory instance;
	private static ReservatieCataloog cataloog;
	public static ReservatieFactory<Cataloog<Reservatie>> getInstance() {
		return instance;
	}
	private ReservatieFactory() {
		synchronized (instance) {
			if (instance != null)
				return;
			instance = this;
		}
		cataloog = new InMemoryReservatieCataloog();
	}

	public static ReservatieCataloog getCataloog() {
		return cataloog;
	}

	public static Reservatie maakReservatie(Gebruiker aanbieder, Gebruiker ontlener, Gereedschap gereedschap, Periode periode) {
		return new Reservatie(cataloog.getNewId(), aanbieder,ontlener,gereedschap,periode);
	}
}
