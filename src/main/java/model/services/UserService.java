package model.services;

import model.users.InsufficientFundsException;
import model.users.User;

/**
 * Jonas Leijzen
 * 29/10/2021
 */
public class UserService {
	
	public void TransferSharepoints (User source, User receiver, double amount) {
		if (amount < 0)
			throw new IllegalArgumentException ("Amount cannot be negative");
		if (source.getSharepoints () < amount)
			throw new InsufficientFundsException ("The paying user does not have enough sharepoints in their wallet.");
		source.removeSharepoints (amount);
		receiver.addSharepoints (amount);
	}
	
}
