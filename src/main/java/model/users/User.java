package model.users;

/**
 * Arne Cools
 * 27/10/2021
 */
public class User {
	
	private Wallet wallet;
	private String addres;
	
	public User(String addres){
		wallet = new Wallet();
		this.addres = addres;
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
