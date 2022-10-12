package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	static Connection conn;
	
	// step 1 - Load the driver
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// step 2 - establish connection to the database
	// made the method static here so that I can call the method with the class name
	// as a result I had to make Connection conn also static.
	static Connection makeConnection() {
		String connectionUrl = "jdbc:postgresql://localhost:5432/bank_management_system";
		String userName = "anijahphillip";
		String password = "password";
		try {
			// using singleton design pattern to always return the same connection
			if(conn == null) {
				conn = DriverManager.getConnection(connectionUrl, userName, password); // this line gets us a new connection from the DB every time when it is called
				// we dont want that
				// i would want to get a connection only if a previous connection was not established 
				// otherwise return the same connection	
				// the best way to implement this is Singleton design pattern	
			}
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
