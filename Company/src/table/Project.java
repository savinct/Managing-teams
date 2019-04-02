package table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.DBConnection;

public class Project {
	
	private String name_project;
	private String descriere;
	
	public Project() {

	}
	
	public Project(String name_project, String descriere) {
		super();
		this.name_project = name_project;
		this.descriere = descriere;
	}
	
public void AddProject() {
		
		Connection conn;
		DBConnection db = DBConnection.getDBConnection();
		
		try {
			conn = db.getConn();
			Statement myStm = conn.createStatement();
			String sql = "insert into project " + " (name_project, descriere)"
                    + " values (?, ?)";
			
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, this.name_project);
			preparedStmt.setString(2, this.descriere);

			preparedStmt.execute();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ResultSet statementProject() {
		
		Connection conn;
		DBConnection db = DBConnection.getDBConnection();	
		ResultSet rs = null;
		
		try {
			conn = db.getConn();
			Statement myStm = conn.createStatement();
			String sql = "SELECT * FROM project";
			
			rs = myStm.executeQuery(sql);	
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public String getName_project() {
		return name_project;
	}
	public void setName_project(String name_project) {
		this.name_project = name_project;
	}
	public String getDescriere() {
		return descriere;
	}
	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}
		
}
