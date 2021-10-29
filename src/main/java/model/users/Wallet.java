package model.users;

/**
 * Arne Cools
 * 27/10/2021
 */
public class Wallet {
	
	private double sharepoints;
	
	Wallet () {
		sharepoints = 0;
	}
	
	void addSharepoints (double amount) {
		setSharepoints (sharepoints + amount);
	}
	
	void removeSharepoints (double amount) {
		setSharepoints (sharepoints - amount);
	}
	
	double getSharepoints () {
		return sharepoints;
	}
	
	private void setSharepoints (double amount) {
		if (amount < 0)
			throw new IllegalArgumentException ("Sharepoints amount cannot be negative.");
		sharepoints = amount;
	}
	
}
