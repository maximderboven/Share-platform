package persistence;

/**
 * @author Maxim Derboven
 * @version 1.0 16/12/2021 15:31
 */
public class ReservatieFactory {
	private static ReservatieFactory instance;
	private ReservatieCataloog cataloog;
	
	private ReservatieFactory (ReservatieCataloog cataloog) {
		synchronized (instance) {
			if (instance != null)
				return;
			instance = this;
		}
		this.cataloog = cataloog;
	}
	
	public static ReservatieFactory getInstance () {
		return instance;
	}
	
	public ReservatieCataloog getCataloog () {
		return cataloog;
	}
}
