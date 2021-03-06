package table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import database.DBConnection;
import net.proteanit.sql.DbUtils;

public class User {

	private byte[] foto;
	private String name;
	private String e_mail;
	private String pass;
	private String skills;
	private String hobbies;
	private int vizibil;
	
	public User() {
		
	}
	
	public User(byte[] foto, String name, String e_mail, String pass, String skills, String hobbies,
			int vizibil) {
		super();

		this.foto = foto;
		this.name = name;
		this.e_mail = e_mail;
		this.pass = pass;
		this.skills = skills;
		this.hobbies = hobbies;
		this.vizibil = vizibil;
	}
	
	public void AddUser() {
		
		Connection conn;
		DBConnection db = DBConnection.getDBConnection();
		
		try {
			conn = db.getConn();
			Statement myStm = conn.createStatement();
			
			String sql = "insert into user " + " (foto, name, mail, pass, skills, hobbies, vizibil)"
                    + " values (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setBytes(1, this.foto);
			preparedStmt.setString(2, this.name);
			preparedStmt.setString(3, this.e_mail);
			preparedStmt.setString(4, this.pass);
			preparedStmt.setString(5, this.skills);
			preparedStmt.setString(6, this.hobbies);
			preparedStmt.setInt(7, this.vizibil);
			preparedStmt.execute();
			
			//myStm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ResultSet allUser() {
		Connection conn;
		DBConnection db = DBConnection.getDBConnection();
		ResultSet rs = null;
		
		try {
			conn = db.getConn();
			Statement myStm = conn.createStatement();
			
			String sql = "SELECT * FROM user";
			
			rs = myStm.executeQuery(sql);			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public boolean deleteUser(String email) {
		Connection conn;
		DBConnection db = DBConnection.getDBConnection();
		try {
			//conectare
			conn = db.getConn();
			Statement myStm = conn.createStatement();
			
			//delete
			String sql = "delete from user where mail = ?";
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, email);
			
			preparedStmt.execute();
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public int getAdmin() {
		return vizibil;
	}

	public void setAdmin(int vizibil) {
		this.vizibil = vizibil;
	}
	

}
