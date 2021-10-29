package model.users;

/**
 * Arne Cools
 * 27/10/2021
 */
public class User {
	
	private final Wallet wallet = new Wallet();
	private String address;
	
	public User(String address){
		this.address = address;
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
