package model.users;

/**
 * Arne Cools
 * 27/10/2021
 */
public class User extends Visitor {
	
	private final Wallet wallet = new Wallet();
	private String firstName, lastName;
	private String address;
	
	public User(String firstName, String lastName, String address) {
		setFirstName (firstName);
		setLastName (lastName);
		setAddress (address);
	}
	
	public void setFirstName (String firstName) {
		ThrowIfNullOrEmpty ("firstName", firstName);
		this.firstName = firstName;
	}
	
	public void setLastName (String lastName) {
		ThrowIfNullOrEmpty ("lastName", lastName);
		this.lastName = lastName;
	}
	
	public void setAddress (String address) {
		ThrowIfNullOrEmpty ("address", address);
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
	
	private void ThrowIfNullOrEmpty (String argName, String toCheck) {
		if (toCheck == null || toCheck.equals ("")) throw new IllegalArgumentException (String.format("%s cannot be null or empty.", argName));
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
