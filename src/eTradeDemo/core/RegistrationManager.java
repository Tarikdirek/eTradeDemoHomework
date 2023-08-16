package eTradeDemo.core;

import eTradeDemo.JGoogleRegistration.JGoogleRegistrationManager;

public class RegistrationManager implements RegistrationService {

	@Override
	public boolean registrationTheSystemWithGoogleAccount() {
		JGoogleRegistrationManager googleRegistrationManager = new JGoogleRegistrationManager();
	 var result =googleRegistrationManager.chechkGoogleRegistration();
		return result;
	}

	
}
