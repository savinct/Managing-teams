package table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.DBConnection;

public class Team {
	
	 private int id;
	 private String name_project;
	 private String id_User;
	 private boolean verified;
	 
	public Team() {
		
	}
	
	public Team(int id, String name_project, String id_User, boolean verified) {
		super();
		this.id = id;
		this.name_project = name_project;
		this.id_User = id_User;
		this.verified = verified;
	}
	
	public ResultSet statementTeam() {
		
		Connection conn;
		DBConnection db = DBConnection.getDBConnection();	
		ResultSet rs = null;
		
		try {
			conn = db.getConn();
			Statement myStm = conn.createStatement();
			String sql = "SELECT * FROM team";
			
			rs = myStm.executeQuery(sql);	

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet statementTeamU() {
		
		Connection conn;
		DBConnection db = DBConnection.getDBConnection();	
		ResultSet rs = null;
		
		try {
			conn = db.getConn();
			Statement myStm = conn.createStatement();
			String sql = "SELECT * FROM team where id_User = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			
			preparedStmt.setString(1, new UserConnect().getInstance().getE_mail());
			
			
			rs = preparedStmt.executeQuery();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public void addTeamU(String name_P) {
		
		Connection conn;
		DBConnection db = DBConnection.getDBConnection();	
		ResultSet rs = null;
		
		try {
			conn = db.getConn();
			Statement myStm = conn.createStatement();
			String sql = "insert into team " + " (id, name_project, id_USER, verified)"
                    + " values (?, ?, ?, ?)";
			String sql1 = "SELECT * FROM team";
			PreparedStatement preparedStmt = conn.prepareStatement(sql1);
			
			rs = preparedStmt.executeQuery();
			int id = 0;
			if (rs != null) 
			{
			  rs.last();    // moves cursor to the last row
			  id = rs.getRow(); // get row id 
			}
			System.out.println("\n" + id + "," + name_P + "," + new UserConnect().getInstance().getE_mail() + ",");
			preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setInt(1, id);
			preparedStmt.setString(2, name_P);
			preparedStmt.setString(3, new UserConnect().getInstance().getE_mail());
			preparedStmt.setBoolean(4, false);
			
			preparedStmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void UpTeam(int id) {
		
		Connection conn;
		DBConnection db = DBConnection.getDBConnection();	
		ResultSet rs = null;
		
		try {
			conn = db.getConn();
			Statement myStm = conn.createStatement();
			String sql = "update team set verified = ?  where id = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			
			preparedStmt.setBoolean(1, true);
			preparedStmt.setInt(2, id);
			
			
			preparedStmt.execute();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName_project() {
		return name_project;
	}
	public void setName_project(String name_project) {
		this.name_project = name_project;
	}
	public String getId_User() {
		return id_User;
	}
	public void setId_User(String id_User) {
		this.id_User = id_User;
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	 
	

}
