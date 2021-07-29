package com.i2i.ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connector {
		
	public Connection connect() {
		
		Connection connectionDB = null;
		
		try {
			
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			connectionDB = DriverManager.getConnection("jdbc:oracle:thin:@mesutaltan:1521:XE","SYSTEM","1234");
			System.out.println("Baðlantý Baþarýlý...");
		}
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return connectionDB;
	
  }
}
