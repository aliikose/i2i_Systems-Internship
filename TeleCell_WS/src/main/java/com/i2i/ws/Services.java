package com.i2i.ws;

public class Services {
	
	private ServicesDao servicesDao;
	
	private ServicesDao getServicesDao() {
		
		if(this.servicesDao == null)
			this.servicesDao = new ServicesDao();
		return servicesDao;
	}
	
	public int login(String inputPhoneNumber, String inputPassword) {
			
		int result;
		Subscriber subscriber = new Subscriber();
		subscriber.setPhoneNumber(inputPhoneNumber);
		subscriber.setPassword(inputPassword);
		result = getServicesDao().login(subscriber);
				
		return result;
	}
	
	public int createAccount(String inputFullName, String inputPhoneNumber, String inputEmail, String inputPassword, String inputBirthDate) {
			
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