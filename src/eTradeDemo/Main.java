package eTradeDemo;

import java.util.List;

import eTradeDemo.business.concretes.EmailConfirmation;
import eTradeDemo.business.concretes.UserManager;
import eTradeDemo.core.RegistrationManager;
import eTradeDemo.dataAccess.abstracts.UserDao;
import eTradeDemo.dataAccess.concretes.HibernateUserDao;
import eTradeDemo.entities.concretes.User;

public class Main {

	public static void main(String[] args) {

		User user = new User(1,"Tarik","Direk","tarkdirek@gmail.com","123456");
		
		UserManager userManager = new UserManager(new HibernateUserDao(), new EmailConfirmation(),
				new RegistrationManager());
		
		userManager.registerWithGoogle();
		
	}

}
