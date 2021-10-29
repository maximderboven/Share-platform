package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Jonas Leijzen
 * 29/10/2021
 */
public class ThrowHelper {
	
	public static void throwIfNull (String argName, Object object) {
		if (object == null)
			throw new NullPointerException (String.format ("%s cannot be null.", argName));
	}
	
	public static void throwIfNullOrEmpty (String argName, String string) {
		if (string == null || string.equals (""))
			throw new IllegalArgumentException (String.format ("%s cannot be null or empty.", argName));
	}
	
	public static void throwIfInThePast (String argName, LocalDate time) {
		if (time.isBefore (LocalDate.now ()))
			throw new IllegalArgumentException (String.format ("%s cannot be in the past.", time));
	}
	
	public static void throwIfInTheFuture (String argName, LocalDate time) {
		if (time.isAfter (LocalDate.now ()))
			throw new IllegalArgumentException (String.format ("%s cannot be in the future.", time));
	}
	
	public static void throwIfInThePast (String argName, LocalDateTime time) {
		if (time.isBefore (LocalDateTime.now ()))
			throw new IllegalArgumentException (String.format ("%s cannot be in the past.", time));
	}
	
	public static void throwIfInTheFuture (String argName, LocalDateTime time) {
		if (time.isAfter (LocalDateTime.now ()))
			throw new IllegalArgumentException (String.format ("%s cannot be in the future.", time));
	}
	
	public static void throwIfNegative (String argName, Number number) {
		if (number.doubleValue () < 0)
			throw new IllegalArgumentException (String.format ("%s cannot be negative.", argName));
	}
	
}
