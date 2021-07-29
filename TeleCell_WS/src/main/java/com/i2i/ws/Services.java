package com.i2i.ws;

public class Services {

	//private static final int FALSE = 0;
	
	//private Verification verification;
	private ServicesDao servicesDao;
	
	/*private Verification getVerification() {
		
		if(this.verification == null)
			this.verification = new Verification();
		return verification;
	}*/
	
	private ServicesDao getServicesDao() {
		
		if(this.servicesDao == null)
			this.servicesDao = new ServicesDao();
		return servicesDao;
	}
	
	public int login(String inputPhoneNumber, String inputPassword) {
		
		//if(!getVerification().checkLoginInfo(inputPhoneNumber, inputPassword)) {
			
			//return FALSE;
		//}
		
		int result;
		Subscriber subscriber = new Subscriber();
		subscriber.setPhoneNumber(inputPhoneNumber);
		subscriber.setPassword(inputPassword);
		result = getServicesDao().login(subscriber);
		
		
		return result;
	}
	
	public int createAccount(String inputFullName, String inputPhoneNumber, String inputEmail, String inputPassword, String inputBirthDate) {
		
	//	if(!getVerification().checkSubscriberInfo(inputFullName, inputPhoneNumber, inputEmail, inputPassword)) {
			
	//		return FALSE;
	//	}
		
		int result;
		Subscriber subscriber = new Subscriber(inputFullName, inputPhoneNumber, inputEmail, inputPassword, inputBirthDate);
		result = getServicesDao().saveSubscriber(subscriber);
		
		return result;
	}	
				
	public Double[] getBalances(String inputPhoneNumber) {
			
		Double[] remainResults = new Double[3];
		Subscriber subscriber = new Subscriber();
		subscriber.setPhoneNumber(inputPhoneNumber);
		remainResults = getServicesDao().getBalances(subscriber);
			
		return remainResults;
	}
	
	public int changePassword(String inputPhoneNumber, String inputEmail, String inputNewPassword) {
		
	//	if(!getVerification().checkChangePasswordInfo(inputPhoneNumber, inputEmail, inputNewPassword)) {
			
		//	return FALSE;
	//	}
		
		int result;
		Subscriber subscriber = new Subscriber();
		subscriber.setPhoneNumber(inputPhoneNumber);
		subscriber.setEmail(inputEmail);
		subscriber.setPassword(inputNewPassword);
		result = getServicesDao().changePassword(subscriber);
		
		return result;
	}
	
	public String[] showProfile(String inputPhoneNumber) {
		
		String[] subscriberProfileDetails = new String[6];
		Subscriber subscriber = new Subscriber();
		subscriber.setPhoneNumber(inputPhoneNumber);
		subscriberProfileDetails = getServicesDao().showProfile(subscriber);
		
		return subscriberProfileDetails;
	}
}