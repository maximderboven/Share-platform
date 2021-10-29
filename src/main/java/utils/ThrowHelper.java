package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Jonas Leijzen
 * 29/10/2021
 */
public class ThrowHelper {
	
	public static void ThrowIfNull (String argName, Object object) {
		if (object == null)
			throw new NullPointerException (String.format ("%s cannot be null.", argName));
	}
	
	public static void ThrowIfNullOrEmpty (String argName, String string) {
		if (string == null || string.equals (""))
			throw new IllegalArgumentException (String.format ("%s cannot be null or empty.", argName));
	}
	
	public static void ThrowIfInThePast (String argName, LocalDate time) {
		if (time.isBefore (LocalDate.now ()))
			throw new IllegalArgumentException (String.format ("%s cannot be in the past.", time));
	}
	
	public static void ThrowIfInTheFuture (String argName, LocalDate time) {
		if (time.isAfter (LocalDate.now ()))
			throw new IllegalArgumentException (String.format ("%s cannot be in the future.", time));
	}
	
	public static void ThrowIfInThePast (String argName, LocalDateTime time) {
		if (time.isBefore (LocalDateTime.now ()))
			throw new IllegalArgumentException (String.format ("%s cannot be in the past.", time));
	}
	
	public static void ThrowIfInTheFuture (String argName, LocalDateTime time) {
		if (time.isAfter (LocalDateTime.now ()))
			throw new IllegalArgumentException (String.format ("%s cannot be in the future.", time));
	}
	
	public static void ThrowIfNegative (String argName, Number number) {
		if (number.doubleValue () < 0)
			throw new IllegalArgumentException (String.format ("%s cannot be negative.", argName));
	}
	
}
