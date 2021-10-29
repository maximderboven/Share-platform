package model;

import java.io.File;

/**
 * Jonas Leijzen
 * 29/10/2021
 */
public final class Attachment {
	
	private final String name;
	private final String filename;
	
	public Attachment (String name, String filename) {
		if (!doesFileExist (filename))
			throw new IllegalArgumentException ("File does not exist.");
		this.name = name;
		this.filename = filename;
	}
	
	public String getName () {
		return name;
	}
	
	public String getFilename () {
		return filename;
	}
	
	private boolean doesFileExist (String filename) {
		return new File (filename).exists ();
	}
	
	public boolean doesFileExist () {
		return doesFileExist (filename);
	}
	
}
