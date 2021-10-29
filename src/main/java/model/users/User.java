package model.users;

import static utils.ThrowHelper.throwIfNullOrEmpty;

/**
 * Arne Cools
 * 27/10/2021
 */
public class User extends Visitor {
	
	private final Wallet wallet = new Wallet ();
	private String firstName, lastName;
	private String address;
	
	public User(String firstName, String lastName, String address) {
		setFirstName (firstName);
		setLastName (lastName);
		setAddress (address);
	}
	
	public void setFirstName (String firstName) {
		throwIfNullOrEmpty ("firstName", firstName);
		this.firstName = firstName;
	}
	
	public void setLastName (String lastName) {
		throwIfNullOrEmpty ("lastName", lastName);
		this.lastName = lastName;
	}
	
	public String getFullName () {
		return String.format ("%s %s", firstName, lastName);
	}
	
	public void setAddress (String address) {
		throwIfNullOrEmpty ("address", address);
		this.address = address;
	}
	
	public String getFirstName () {
		return firstName;
	}
	
	public String getLastName () {
		return lastName;
	}
	
	public String getAddress () {
		return address;
	}
	
	public void addSharepoints (double amount) {
		wallet.addSharepoints (amount);
	}
	
	public void removeSharepoints (double amount) {
		wallet.removeSharepoints (amount);
	}
	
	public double getSharepoints () {
		return wallet.getSharepoints ();
	}
}
