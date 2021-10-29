package model.users;

/**
 * Arne Cools
 * 27/10/2021
 */
public class Wallet {
	
	private final String ERR_AMOUNT_CANNOT_BE_NEGATIVE = "Sharepoints amount cannot be negative.";
	private double sharepoints;
	
	Wallet () {
		sharepoints = 0;
	}
	
	void addSharepoints (double amount) {
		if (amount < 0)
			throw new IllegalArgumentException (ERR_AMOUNT_CANNOT_BE_NEGATIVE);
		setSharepoints (sharepoints + amount);
	}
	
	void removeSharepoints (double amount) {
		if (amount < 0)
			throw new IllegalArgumentException (ERR_AMOUNT_CANNOT_BE_NEGATIVE);
		setSharepoints (sharepoints - amount);
	}
	
	double getSharepoints () {
		return sharepoints;
	}
	
	private void setSharepoints (double amount) {
		if (amount < 0)
			throw new InsufficientFundsException ("User does not have enough funds.");
		sharepoints = amount;
	}
}
