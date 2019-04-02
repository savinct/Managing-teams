package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.DaoUser;
import table.User;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;

public class Add extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	
	
	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add frame = new Add();
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
	public Add() {
		JRadioButton admin = new JRadioButton("Admin");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 392, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCreate = new JButton("Add");
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String a = textField.getText().toString();
				String b = textField_1.getText().toString();
				String c = textField_2.getText().toString();
				Boolean d = admin.isSelected();
				
				DaoUser du = new DaoUser();
				if(du.AddUser(a, b, c, d))
					JOptionPane.showMessageDialog(null, "User added successfully!" );
				else
					JOptionPane.showMessageDialog(null,  "You did not complete all the fields or \nInvalid email!");
				
			}
		});
		btnCreate.setBounds(144, 243, 89, 23);
		contentPane.add(btnCreate);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(49, 54, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setBounds(49, 109, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(49, 155, 72, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(131, 51, 115, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(131, 106, 115, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(131, 152, 115, 20);
		contentPane.add(textField_2);
		
		
		admin.setBounds(157, 200, 109, 23);
		contentPane.add(admin);
		
	}
}
