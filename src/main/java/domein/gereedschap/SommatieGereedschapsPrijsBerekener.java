package domein.gereedschap;

/**
 * Jonas Leijzen
 * 23/12/2021
 */
public class SommatieGereedschapsPrijsBerekener implements GereedschapsPrijsBerekener {
	@Override
	public long berekenPrijs (Gereedschap gereedschap, int dagen) {
		long total = 0;
		total += gereedschap.getDaghuurprijs ();
		for (Gereedschap g : gereedschap.getGereedschapSet ()) {
			total += g.getDaghuurprijs ();
		}
		return total * dagen;
	}
}
