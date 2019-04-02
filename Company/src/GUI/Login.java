package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import database.DBConnection;
import table.UserConnect;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import business.DaoUser;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBConnection.getDBConnection();
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 368, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String a = textField.getText().toString();
				String b = textField_1.getText().toString();
				
				DaoUser du = new DaoUser();
				int nr = du.LogUser(a, b);
				if(nr == 0) {
					JOptionPane.showMessageDialog(null, "Welcome!");
					frame.dispose();
					profileUser p = new profileUser();
					p.setVisible(true);
				}else if(nr == 1) {
					JOptionPane.showMessageDialog(null, "Welcome!");
					frame.dispose();
					Admin am = new Admin();
					am.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Passwords or/and Username is/are incorrect!");
				}
												
			}
		});
		
		btnLogin.setBounds(120, 189, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setBounds(53, 53, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(53, 104, 46, 14);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(156, 50, 142, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(156, 101, 142, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
}
