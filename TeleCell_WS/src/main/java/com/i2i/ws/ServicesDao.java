package com.i2i.ws;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class ServicesDao {
	
	private static final int FALSE = 0;
	
	private Connector connector;
	private Connection connection;
	
	private Connector getConnector() {
		
		if(this.connector == null)
			this.connector = new Connector();
		return connector;
	}
	
	private Connection getConnection() {
		
		if(this.connection == null)
			this.connection = this.getConnector().connect();
		return connection;
	}
	
	public int login(Subscriber subscriber) {
		
		CallableStatement csProcedureObject = null;
		int result;
		
		try {
				csProcedureObject = this.getConnection().prepareCall("{CALL CHECK_USER(?,?,?)}");
				
				csProcedureObject.setString(1, subscriber.getPhoneNumber());
				csProcedureObject.setString(2, subscriber.getPassword());
				csProcedureObject.registerOutParameter(3, Types.INTEGER);
				
				csProcedureObject.execute();
				
				result = csProcedureObject.getInt(3);
		}
		
		catch (SQLException ex) {
			
			ex.getMessage();
			result = FALSE;
		}
		
		finally {
			
			try {
				
					csProcedureObject.close();
					connection.close();
			}
			
			catch (SQLException e) {
				
					e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int saveSubscriber(Subscriber subscriber) {
		
		int result;
		CallableStatement csProcedureObject = null;
		
		try {
			
			csProcedureObject = this.getConnection().prepareCall("{CALL CREATE_USER(?,?,?,?,?,?)}");
			
			csProcedureObject.setString(1, subscriber.getFullName());
			csProcedureObject.setString(2, subscriber.getPhoneNumber());
			csProcedureObject.setString(3, subscriber.getEmail());
			csProcedureObject.setString(4, subscriber.getPassword());
			csProcedureObject.setString(5, subscriber.getBirthDate());
			csProcedureObject.registerOutParameter(6, Types.INTEGER);
			
			csProcedureObject.execute();
			
			result = csProcedureObject.getInt(6);
		}
		
		catch (SQLException ex) {
			
			ex.getMessage();
			result = FALSE;
		}
		
		finally {
			
			try {
				
				connection.close();
				csProcedureObject.close();
			}
			
			catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return result;
	
	}
	
	public Double[] getBalances(Subscriber subscriber) {
		
		Double[] remainResults = new Double[3];
		CallableStatement csProcedureObject = null;
		
		try {
			
			csProcedureObject = this.getConnection().prepareCall("{CALL GET_BALANCES(?,?,?,?)}");
			
			csProcedureObject.setString(1, subscriber.getPhoneNumber());
			csProcedureObject.registerOutParameter(2, Types.DOUBLE);
			csProcedureObject.registerOutParameter(3, Types.DOUBLE);
			csProcedureObject.registerOutParameter(4, Types.DOUBLE);
			
			csProcedureObject.execute();
			
			remainResults[0] = csProcedureObject.getDouble(2);
			remainResults[1] = csProcedureObject.getDouble(3);
			remainResults[2] = csProcedureObject.getDouble(4);
		}
		
		catch (SQLException ex) {
			
			remainResults = null;
			ex.getMessage();
		}
		
		finally {
			
			try {
				
				csProcedureObject.close();
				connection.close();
			}
			
			catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return remainResults;
	}
	
	public int changePassword(Subscriber subscriber) {
		
		int result;
		CallableStatement csProcedureObject = null;
		
		try {
			
			csProcedureObject = this.getConnection().prepareCall("{CALL CHANGE_PASSWORD(?,?,?,?)}");
			
			csProcedureObject.setString(1, subscriber.getPhoneNumber());
			csProcedureObject.setString(2, subscriber.getEmail());
			csProcedureObject.setString(3, subscriber.getPassword());
			csProcedureObject.registerOutParameter(4, Types.INTEGER);
			
			csProcedureObject.execute();
			
			result = csProcedureObject.getInt(4);
		}
		
		catch (SQLException ex) {
			
			ex.getMessage();
			result = FALSE;
		}
		
		finally {
			
			try {
				
				csProcedureObject.close();
				connection.close();
			}
			
			catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public String[] showProfile(Subscriber subscriber) {
		
		String[] subscriberProfileDetails = new String[6];
		CallableStatement csProcedureObject = null;
		
		try {
			
			csProcedureObject = this.getConnection().prepareCall("{CALL SHOW_PROFILE(?,?,?,?,?,?,?)}");
			
			csProcedureObject.setString(1, subscriber.getPhoneNumber());
			csProcedureObject.registerOutParameter(2, Types.VARCHAR);
			csProcedureObject.registerOutParameter(3, Types.VARCHAR);
			csProcedureObject.registerOutParameter(4, Types.VARCHAR);
			csProcedureObject.registerOutParameter(5, Types.INTEGER);
			csProcedureObject.registerOutParameter(6, Types.INTEGER);
			csProcedureObject.registerOutParameter(7, Types.INTEGER);
			
			csProcedureObject.execute();
			
			subscriberProfileDetails[0] = csProcedureObject.getString(2);
		    subscriberProfileDetails[1] = csProcedureObject.getString(3);
		    subscriberProfileDetails[2] = csProcedureObject.getString(4);
		    subscriberProfileDetails[3] = csProcedureObject.getString(5);
		    subscriberProfileDetails[4] = csProcedureObject.getString(6);
		    subscriberProfileDetails[5] = csProcedureObject.getString(7);    
		}
		
		catch (SQLException ex) {
			
			subscriberProfileDetails = null;
			ex.getMessage();
		}
		
		finally {
			
			try {
				
				csProcedureObject.close();
				connection.close();
			}
			
			catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return subscriberProfileDetails;
	}
}