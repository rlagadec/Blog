package bll;

import javax.swing.plaf.synth.SynthScrollPaneUI;

import at.favre.lib.crypto.bcrypt.BCrypt;
import bll.Exception.BLLException;
import bo.User;
import dal.DaoFactory;

public class SecurityService {
	private static SecurityService instance = new SecurityService(); // lazy Singleton

	private SecurityService() {
	}

	public static SecurityService getInstance() {
		return instance;
	}

	public void addUser(User user) {
		// check fields
		user.setPassword(BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray()));
		DaoFactory.getUserDao().insert(user);
	}

	public User login(String username, String password) throws BLLException {
		User user = DaoFactory.getUserDao().selectByUsername(username);
		System.out.println(user);
		System.out.println(username);
		if (user == null) {
			throw new BLLException("Utilisateur non trouvé ! T'es perdu ?");
		}
		BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
		if (!result.verified) {
			throw new BLLException("Le mot de passe est incorrect ! ");
		}

		return user;
	}
}
