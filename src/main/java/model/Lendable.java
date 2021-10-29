package model;

import java.util.*;

/**
 * Arne Cools
 * 27/10/2021
 */
public abstract class Lendable {
	
	private Set<Attachment> attachments = new HashSet<> ();
	
	public boolean addAttachment (Attachment attachment) {
		return attachments.add (attachment);
	}
	
	public boolean removeAttachment (Attachment attachment) {
		return attachments.remove (attachment);
	}
	
	public List<Attachment> getAllAttachments () {
		return new ArrayList<> (attachments);
	}
	
	public abstract double getPrice ();
	
}
