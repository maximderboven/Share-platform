package domein.gereedschap;

import java.util.HashMap;
import java.util.Map;

/**
 * Jonas Leijzen
 * 19/12/2021
 */
public class GereedschapsTypen {
	
	public static GereedschapsTypen instance;
	
	private Map<String, Integer> types = new HashMap<> ();
	
	private GereedschapsTypen () {
	
	}
	
	public static GereedschapsTypen getInstance () {
		if (instance == null)
			instance = new GereedschapsTypen ();
		return instance;
	}
	
	public void addType (String name, int waarborg) {
		if (waarborg < 0)
			throw new IllegalArgumentException ("Waarborg cannot be smaller than zero.");
		types.put (name, waarborg);
	}
	
	public int getWaarborg (String name) {
		return types.get (name);
	}
}
