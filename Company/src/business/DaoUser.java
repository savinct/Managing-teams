package business;

import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;
import table.Team;
import table.User;
import table.UserConnect;

public class DaoUser {
	
	private User user;
	private static final String EMAIL_VALIDATION_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	
	public DaoUser() {
		
	}
	
	public Boolean AddUser(String name, String mail, String pass, Boolean admin) {
		
		if(name.length() > 2 && mail.matches(EMAIL_VALIDATION_REGEX ) && pass.length() > 2) {
			
			int vizibil;
			if(admin == true) {
				vizibil = 1*100000 + 0 * 10000 + 1 * 1000 + 1 * 100;
				
				System.out.print(vizibil + " ");
			}else {
				vizibil = 0*100000 + 0 * 10000 + 1 * 1000 + 1 * 100;
			}
			byte[] b = null;
			user = new User(b, name, mail, pass, "", "", vizibil);
			user.AddUser();
			
			return true;
			
		}
		
		return false;
		
	}
	
	public int LogUser(String mail, String pass) {
		
		UserConnect u = UserConnect.getInstance();
		u.setUserConnect(mail, pass);
		
		if(u.getE_mail() != null)
			if(u.getVizibil() / 100000 == 1)
				return 1;
			else
				return 0;
		
		return -1;
	}
	
	public TableModel tableUser() {
		
		user = new User();
		TableModel list =  DbUtils.resultSetToTableModel(user.allUser());
		
		return list;
	}
	
	public boolean deleteUser(String email) {
		
		user = new User();
		if(user.deleteUser(email))
			return true;
		
		return false;
	}
	
}
