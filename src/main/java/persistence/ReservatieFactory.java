package persistence;

import domein.gebruiker.Gebruiker;
import domein.gereedschap.Gereedschap;
import domein.transactie.Reservatie;
import util.Periode;

import java.time.LocalDateTime;

/**
 * @author Maxim Derboven
 * @version 1.0 16/12/2021 15:31
 */
public class ReservatieFactory<T extends Cataloog<? extends Number, Reservatie>> {
	private static ReservatieFactory instance;
	private Cataloog<? extends Number, Reservatie> cataloog;
	
	public static ReservatieFactory<Cataloog<? extends Number, Reservatie>> getInstance () {
		return instance;
	}
	
	private ReservatieFactory (Cataloog<? extends Number, Reservatie> cataloog) {
		synchronized (instance) {
			if (instance != null)
				return;
			instance = this;
		}
		this.cataloog = cataloog;
	}
	
	public Cataloog<? extends Number, Reservatie> getCataloog () {
		return cataloog;
	}
}
