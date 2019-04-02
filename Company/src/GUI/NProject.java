package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.DaoProject;
import database.DBConnection;
import net.proteanit.sql.DbUtils;
import table.Project;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NProject extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NProject frame = new NProject();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NProject() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 388, 321);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNameproject = new JLabel("Name_Project");
		lblNameproject.setBounds(39, 48, 86, 14);
		contentPane.add(lblNameproject);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(39, 109, 86, 14);
		contentPane.add(lblDescription);
		
		textField = new JTextField();
		textField.setBounds(155, 45, 119, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(155, 106, 119, 71);
		contentPane.add(textField_1);
		
		
	
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String a = textField.getText().toString();
				String b = textField_1.getText().toString();
				
				if(new DaoProject().addProject(a, b)) 		
					JOptionPane.showMessageDialog(null, "Project added successfully!" );
				else 
					JOptionPane.showMessageDialog(null,  "All fields are required");
							
			}
		});
		btnAdd.setBounds(131, 223, 89, 23);
		contentPane.add(btnAdd);
	}
}
