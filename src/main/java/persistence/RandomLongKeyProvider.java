package persistence;

import java.util.Collection;
import java.util.Random;

/**
 * Jonas Leijzen
 * 17/12/2021
 */
public class RandomLongKeyProvider implements KeyProvider<Long> {
	
	private static Random randomIDs = new Random ();
	
	@Override
	public Long getNewKey (Collection<Long> existingKeys) {
		Long id;
		do {
			id = randomIDs.nextLong ();
		} while (existingKeys.contains (id));
		return id;
	}
}
