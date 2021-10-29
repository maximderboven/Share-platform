package model.tools;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Anouar Bannamar
 * 27-10-21
 */
public class ToolGroup extends Lendable {
	
	private String name;
	private final Set<Lendable> lendables = new HashSet<> ();
	
	public ToolGroup (String name) {
		setName (name);
	}
	
	public void setName (String name) {
		if (name == null || !name.equals (""))
			throw new IllegalArgumentException ("Name cannot be empty");
		this.name = name;
	}
	
	public boolean add (Lendable tool) {
		return lendables.add (tool);
	}
	
	public boolean remove (Lendable tool) {
		return lendables.remove (tool);
	}
	
	public int getSize () {
		return lendables.size ();
	}
	
	public String getName () {
		return name;
	}
	
	@Override
	public double getPrice () {
		return lendables.stream ().map(Lendable::getPrice).mapToDouble (value -> value).sum ();
	}
	
	@Override
	public double getGuaranty () {
		return lendables.stream ().map(Lendable::getGuaranty).mapToDouble (value -> value).sum ();
	}
	
	@Override
	public List<Tool> getAllTools () {
		List<Tool> tools = new ArrayList<> ();
		for (Lendable l : lendables)
			tools.addAll(l.getAllTools ());
		return tools;
	}
}
