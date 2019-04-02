package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void Open() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 342, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddUser = new JButton("ADD User");
		btnAddUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Add am = new Add();
				am.setVisible(true);
				
			}
		});
		btnAddUser.setBounds(110, 11, 103, 57);
		contentPane.add(btnAddUser);
		
		JButton btnViewUser = new JButton("View User");
		btnViewUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				View am = new View();
				am.setVisible(true);
				
			}
		});
		btnViewUser.setBounds(110, 104, 103, 57);
		contentPane.add(btnViewUser);
		
		JButton btnNewTeam = new JButton("Team");
		btnNewTeam.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GTeam t = new GTeam();
				t.setVisible(true);
				
			}
		});
		btnNewTeam.setBounds(110, 207, 103, 57);
		contentPane.add(btnNewTeam);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				profileUser am = new profileUser();
				am.setVisible(true);
				
			}
		});
		btnProfile.setBounds(110, 299, 103, 57);
		contentPane.add(btnProfile);
	}
}
