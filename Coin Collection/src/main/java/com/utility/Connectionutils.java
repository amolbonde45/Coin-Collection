package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

import com.constant.DatabaseConstant;

public class Connectionutils {
	
	static Connection connection;
	public static Connection getConnection() {
		try {
			Class.forName(DatabaseConstant.mySqlDriverClassName);
			connection=DriverManager.getConnection(DatabaseConstant.databaseUrl,DatabaseConstant.databaseUserName,DatabaseConstant.databasePassword);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return connection;
		
	}

}
