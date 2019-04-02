package database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import table.User;

import java.sql.Connection;

public class DBConnection {
	
	private static DBConnection DBconn = null;
	
	private static String url = "jdbc:mysql://...:3306/company";
	private static String username = "root";
	private static String password = "";
	private Connection conn = null;
	
	
	private DBConnection() {
		
		try{
			   this.conn = DriverManager.getConnection(url, username, password);
			   System.out.println("Connected");
			   
			  } catch(Exception e){System.out.println(e);}

	}
	
	public static DBConnection getDBConnection() {
		
		if(DBconn == null)
			DBconn = new DBConnection();
		
		return DBconn;
		
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	

	
}