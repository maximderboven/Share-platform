package domein.gereedschap;

/**
 * Jonas Leijzen
 * 23/12/2021
 */

@FunctionalInterface
public interface GereedschapsPrijsBerekener {
	
	long berekenPrijs (Gereedschap gereedschap, int dagen);
	
}
