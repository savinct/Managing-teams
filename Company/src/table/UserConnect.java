package table;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.DBConnection;

public class UserConnect {
	
	private static UserConnect cuser = null;
	
	private String foto;
	private String name;
	private String e_mail;
	private String pass;
	private String skills;
	private String hobbies;
	private int vizibil;


	UserConnect() {	
	}
	
	public static UserConnect getInstance() {
		
		if(cuser == null) {
			cuser = new UserConnect();
		}
		
		return cuser;
		
	}
	
	public void setUserConnect(String e_mail, String pass) {
		Connection conn;
		DBConnection db = DBConnection.getDBConnection();
		try {
			conn = db.getConn();
			Statement myStm = conn.createStatement();
			
			//ResultSet myRs = myStm.executeQuery("SELECT * FROM user where mail = 'savin@yahoo.com' and pass = '12345'");
			
			ResultSet myRs = myStm.executeQuery("SELECT * FROM user");
			

			
			while(myRs.next()) {

				if(myRs.getString("mail").equals(e_mail) && myRs.getString("pass").contentEquals(pass)) {
				this.foto = myRs.getString("foto");
				this.name = myRs.getString("name");
				this.e_mail = myRs.getString("mail");
				this.pass = myRs.getString("pass");
				this.skills = myRs.getString("skills");
				this.hobbies = myRs.getString("hobbies");
				this.vizibil = Integer.parseInt(myRs.getString("vizibil"));
				}
			}

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void UpdateUserC() {
		
		Connection conn;
		DBConnection db = DBConnection.getDBConnection();	
	
		
		try {
			conn = db.getConn();
			Statement myStm = conn.createStatement();
			
			
			String sql = "update user set foto = ?, name = ?, pass = ?, skills = ?, hobbies = ?, vizibil = ? where mail = ?";
			
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			
			preparedStmt.setString(1, this.foto);
			preparedStmt.setString(2, this.name);
			preparedStmt.setString(3, this.pass);
			preparedStmt.setString(4, this.skills);
			preparedStmt.setString(5, this.hobbies);
			preparedStmt.setInt(6, this.vizibil);
			
			
			preparedStmt.setString(7, this.e_mail);
			preparedStmt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
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

	public int getVizibil() {
		return vizibil;
	}

	public void setVizibil(int vizibil) {
		this.vizibil = vizibil;
	}
	
}
