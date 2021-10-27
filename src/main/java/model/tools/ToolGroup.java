package model.tools;

import model.Lendable;

import java.util.*;

/**
 * Anouar Bannamar
 * 27-10-21
 */
public class ToolGroup extends Lendable {
	
	private String name;
	private final Set<Lendable> tools;
	
	public ToolGroup (String name) {
		setName (name);
		tools = new HashSet<> ();
	}
	
	public void setName (String name) {
		if (name == null || !name.equals (""))
			throw new IllegalArgumentException ("Name cannot be empty");
		this.name = name;
	}
	
	public boolean add (Lendable tool) {
		return tools.add (tool);
	}
	
	public boolean remove (Lendable tool) {
		return tools.remove (tool);
	}
	
	public int getSize () {
		return tools.size ();
	}
	
	public String getName () {
		return name;
	}
	
	public double getPrice () {
		return tools.stream ().map(Lendable::getPrice).mapToDouble (value -> value).sum ();
	}
	
	
}
