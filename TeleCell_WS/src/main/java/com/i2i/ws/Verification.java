package com.i2i.ws;

public class Verification {
	
	private static final String PHONE_NUMBER_VERIFICATION_STRING = "\\d{10}$";
	
	private static final String NAME_VERIFICATION_STRING = "[A-Za-z_ðüþýöçÐÜÞÝÖÇ]{2,}$";
	
	private static final String TURKISH_PHONE_NUMBER_PREFIX = "5";
	
	private static final String PASSWORD_VERIFICATION_STRING = "(?=.*[0-9])(?=.*[a-z_ðüþýöç])(?=.*[A-Z_ÐÜÞÝÖÇ]).{8,12}";
	
	private static final String EMAIL_VERIFICATION_STRING = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
												+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public boolean isNameValid(String inputName) {
		
		return inputName.matches(NAME_VERIFICATION_STRING);
	}
	
	public boolean isPhoneNumberValid(String inputPhoneNumber) {
		
		if(String.valueOf(inputPhoneNumber).startsWith(TURKISH_PHONE_NUMBER_PREFIX)) {
			
			return inputPhoneNumber.matches(PHONE_NUMBER_VERIFICATION_STRING);
		}
		
		return false;
	}
	
	public boolean isPasswordValid(String inputPassword) {
		
		return inputPassword.matches(PASSWORD_VERIFICATION_STRING);
	}
	
	public boolean isEmailValid(String inputEmail) {
		
		return inputEmail.matches(EMAIL_VERIFICATION_STRING);
	}
	
	public boolean checkLoginInfo(String inputPhoneNumber, String inputPassword) {
		
		if( !isPhoneNumberValid(inputPhoneNumber) || !isPasswordValid(inputPassword)) {
			
			return false;
		}
		
		return true;
	}
	
	public boolean checkSubscriberInfo(String inputFullName, String inputPhoneNumber,
			String inputEmail, String inputPassword) {

		if (!isNameValid(inputFullName) || !isPhoneNumberValid(inputPhoneNumber)
			|| !isPasswordValid(inputPassword) || !isEmailValid(inputEmail)) {
			
			return false;
			
		}
		
		return true;
	}
		
	public boolean checkChangePasswordInfo(String inputPhoneNumber, String inputEmail, String inputPassword) {

		if ( !isPhoneNumberValid(inputPhoneNumber) || !isPasswordValid(inputPassword) || !isEmailValid(inputEmail)) {
			
			return false;
			
		}
		
		return true;
	}

}


















