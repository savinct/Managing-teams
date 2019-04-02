package business;

import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;
import table.Project;
import table.Team;

public class DaoProject {
	
	private Project pj;
	
	
	public DaoProject() {
		
	}
	
	public boolean addProject(String name_project, String descriere) {
		
		if(name_project.length() > 2 && descriere.length() > 2) {
			Project t = new Project(name_project, descriere);
			t.AddProject();
			
			return true;
		}
		
		return false;
	}
	

	public TableModel tableProject() {
		// TODO Auto-generated method stub
		pj = new Project ();
		TableModel list =  DbUtils.resultSetToTableModel(pj.statementProject());
		
		return list;
	}
	
}
