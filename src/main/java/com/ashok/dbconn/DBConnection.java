package com.ashok.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DBConnection {
	
	public Connection getConnection()
	{
		
		Connection conn = null;
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Properties connectionProps = new Properties();
			connectionProps.put("user", "root");
			connectionProps.put("password", "pass");

			conn = DriverManager.getConnection("jdbc:" + "mysql" + "://" + "192.168.1.76" + ":" + "3306" + "/cacheDB",
					connectionProps);

			System.out.println("Connected to database");
			System.out.println("connection::" + conn.getMetaData());
			

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;

	}
	

}
