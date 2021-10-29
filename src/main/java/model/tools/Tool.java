package model.tools;

import java.util.*;

/**
 * Anouar Bannamar
 * 27-10-21
 */
public class Tool extends Lendable {
	
	private String name;
	private String description;
	private ToolType type;
	private double price;
	
	public Tool (String name, String description, ToolType type, double price) {
		setName (name);
		setDescription (description);
		setToolType (type);
		setPrice (price);
	}
	
	public void setName (String name) {
		if (name == null || name.length () == 0)
			throw new IllegalArgumentException ("Name cannot be null or empty");
		this.name = name;
	}
	
	public void setDescription (String description) {
		if (description == null || description.length () == 0)
			throw new IllegalArgumentException ("Description cannot be null or empty");
		this.description = description;
	}
	
	public void setToolType (ToolType type) {
		this.type = type;
	}
	
	public void setPrice (double price) {
		if (price < 0)
			throw new IllegalArgumentException ("Price cannot be negative.");
		this.price = price;
	}
	
	public String getName () {
		return name;
	}
	
	public String getDescription () {
		return description;
	}
	
	public ToolType getType () {
		return type;
	}
	
	@Override
	public double getPrice () {
		return price;
	}
	
	@Override
	public List<Lendable> getAllTools () {
		return Arrays.asList (new Lendable[] {this});
	}
}
