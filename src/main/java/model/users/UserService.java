package model.users;

/**
 * Jonas Leijzen
 * 29/10/2021
 */
public class UserService {
	
	public void TransferSharepoints (User source, User receiver, double amount) {
		if (amount < 0)
			throw new IllegalArgumentException ("Amount cannot be negative");
		try {
			source.removeSharepoints (amount);
		} catch (InsufficientFundsException e) {
			throw new InsufficientFundsException ("The paying user does not have enough sharepoints in their wallet.");
		}
		receiver.addSharepoints (amount);
	}
	
}
