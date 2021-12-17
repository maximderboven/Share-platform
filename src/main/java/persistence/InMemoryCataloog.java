package persistence;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Jonas Leijzen
 * 17/12/2021
 */
public class InMemoryCataloog<Key extends Number, Value> implements Cataloog<Key, Value> {
	
	private final Map<Key, Value> map = new HashMap<> ();
	private final KeyProvider<Key> keyProvider;
	
	public InMemoryCataloog (KeyProvider<Key> keyProvider) {
		this.keyProvider = keyProvider;
	}
	
	@Override
	public Key add (Value t) {
		Key id = getNewId ();
		map.put (id, t);
		return id;
	}
	
	@Override
	public Value get (Key id) {
		return map.get (id);
	}
	
	@Override
	public boolean remove (Key id) {
		return map.remove (id) != null;
	}
	
	@Override
	public Collection<Value> getAll () {
		return map.values ();
	}
	
	public Key getNewId() {
		return keyProvider.getNewKey (map.keySet ());
	}
	
	Map<Key, Value> getMap () {
		return map;
	}
	
}
