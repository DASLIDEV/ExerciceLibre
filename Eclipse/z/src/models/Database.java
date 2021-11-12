package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static String dbUrl = "jdbc:mysql://localhost:3306/attestation";
	private static String dbUser = "root";
	private static String dbPassword = "";
	public static Connection connect = null;
	
	public static void connect() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();     
			connect = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		} catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
