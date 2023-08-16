package eTradeDemo.business.concretes;

import java.awt.Checkbox;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eTradeDemo.business.abstracts.ConfirmationService;
import eTradeDemo.business.abstracts.UserService;
import eTradeDemo.core.RegistrationService;
import eTradeDemo.dataAccess.abstracts.UserDao;
import eTradeDemo.entities.concretes.User;

public class UserManager implements UserService {

	UserDao userDao;
	ConfirmationService confirmationService;
	RegistrationService registrationService;
	
	
	
	public UserManager(UserDao userDao,ConfirmationService confirmationService,
			RegistrationService registrationService) {
		this.userDao = userDao;
		this.confirmationService = confirmationService;
		this.registrationService = registrationService;
	}

	@Override
	public void register(User user) {
		if (!(checkNameLength(user)) || !(checkLastNameLength(user))) {
			System.out.println("Firstname and lastname length must be at least 2 caracter!");
			return;
		}
		
		final String EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
		final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(user.getEmail());
		
		if (!matcher.matches()) {
			System.out.println("Invalid email format");
			return;
		}
		
		
		if (!checkPasswordLength(user)) {
			System.out.println("Password length must be at least 6 caracter!");
			return;
		}
		if (!checkIfEmailAlreayUse(user)) {
			System.out.println("This email already in use please type another email");
			return;
		}
		
		
		
		
		confirmationService.sendConfimationEmail();
		
		if (confirmationService.checkingEmailConfirmation()) {
			System.out.println("Your email successfully confirmed");
			userDao.register(user);
			return;
		}else {
			System.out.println("Your email not confirmed");
		}
		
		
	}
	
	public void registerWithGoogle() {
		if (registrationService.registrationTheSystemWithGoogleAccount()) {
			System.out.println("You registered with your google account");
			return;
		}else {
			System.out.println("Invalid google account");
		}
		
	}
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void login(User user) {
		if (checkPassword(user) == true && checkIfEmailAlreayUse(user) == true) {
			System.out.println(user.getFirstName() + " you logged the system successfully");
			
		}else {
			System.out.println("Your email or password is incorrect");
		}
		
	}
	
	private boolean checkNameLength(User user) {
		if (user.getFirstName().length()>2) {
			return true;
			
		}return false;
	}
	
	private boolean checkLastNameLength(User user) {
		if (user.getLastName().length()>2) {
			return true;
			
		}return false;
	}
	
	private boolean checkPasswordLength(User user) {
		if (user.getPassword().length()>5) {
			return true;
			
		}return false;
	}
	private boolean checkPassword(User user) {
		if (userDao.userPassword(user).equals("123456")) {
			return true;
		}return false;
	}
	
	private boolean checkIfEmailAlreayUse(User user) {
		if (userDao.getUserByEmail(user).equals("tarkdirek@gmail.com")) {
			return true;
		}return false;
	}

}
