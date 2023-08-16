package eTradeDemo.business.concretes;

import eTradeDemo.business.abstracts.ConfirmationService;

public class EmailConfirmation implements ConfirmationService {
 
	public	boolean checkingEmailConfirmation() {
		return true;
	}

@Override

public void sendConfimationEmail() {
	System.out.println("Confirmation code send your email");
	
	}
}
