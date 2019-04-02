package business;

import java.sql.ResultSet;
import java.util.List;

import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;
import table.Team;

public class DaoTeam {
	
	private Team t;
	
	public DaoTeam() {
		
	}
	
	public TableModel tableTeam() {
		
		t = new Team();
		TableModel list =  DbUtils.resultSetToTableModel(t.statementTeam());
		
		return list;
	}
	
	public TableModel tableTeamUserC() {
		
		t = new Team();
		TableModel list =  DbUtils.resultSetToTableModel(t.statementTeamU());
		
		return list;
	}
	
	public void addTeam(String name_P) {
		
		t = new Team();
		t.addTeamU(name_P);
		
	}
	
	public void UpTeam(int id) {
		
		t = new Team();
		t.UpTeam(id);
		
	}


}
