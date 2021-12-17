package persistence;

import java.util.Collection;

/**
 * Jonas Leijzen
 * 17/12/2021
 */

@FunctionalInterface
public interface KeyProvider<T> {

	T getNewKey (Collection<T> existingKeys);

}
