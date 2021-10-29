package utils;

/**
 * Jonas Leijzen
 * 29/10/2021
 */
public class ThrowHelper {
	
	public static void ThrowIfNullOrEmpty (String argName, String toCheck) {
		if (toCheck == null || toCheck.equals (""))
			throw new IllegalArgumentException (String.format ("%s cannot be null or empty.", argName));
	}
	
}
