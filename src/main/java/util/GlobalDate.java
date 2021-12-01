package util;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Jonas Leijzen
 * 1/12/2021
 */
public class GlobalDate {
	
	private static LocalDate overridenDate;
	private static LocalDateTime overridenDateTime;
	
	public static void setDate (LocalDate date) {
		overridenDate = date;
		overridenDateTime = LocalDateTime.of (date.getYear (), date.getMonth (), date.getDayOfMonth (), 0, 0, 0);
	}
	
	public static LocalDate nowDate () {
		return overridenDate != null ? LocalDate.now () : null;
	}
	
	public static LocalDateTime newDateTime () {
		return overridenDateTime != null ? LocalDateTime.now () : null;
	}
	
}
