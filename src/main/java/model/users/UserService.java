package model.users;

/**
 * Jonas Leijzen
 * 29/10/2021
 */
public class UserService {
	
	public void TransferSharepoints (User source, User receiver, double amount) {
		if (source.getSharepoints () < amount)
			throw new InsufficientFundsException ("The paying user not have enough sharepoints in their wallet.");
		source.removeSharepoints (amount);
		receiver.addSharepoints (amount);
	}
	
}
