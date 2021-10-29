package model;

import repositories.MultiClass;

import java.util.*;

/**
 * Arne Cools
 * 27/10/2021
 */
public abstract class Lendable {
	
	private MultiClass<Attachment> attachments = new MultiClass<> ();
	
	public MultiClass<Attachment> getAttachments () {
		return attachments;
	}
	
	public abstract double getPrice ();
	
}
