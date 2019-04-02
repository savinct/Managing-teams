package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import table.User;
import table.UserConnect;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class profileUser extends JFrame {
	

	private String filename = null;
	private UserConnect u = UserConnect.getInstance();
	
	private static final String EMAIL_VALIDATION_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel label;
	
	private InputStream is;
	private String path = null;
	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					profileUser frame = new profileUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ImageIcon ResizeImage(String imgPath){
        ImageIcon MyImage = new ImageIcon(imgPath);
        Image img = MyImage.getImage();
        Image newImage = img.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImage);
        return image;
    }

	/**
	 * Create the frame.
	 */
	public profileUser() {
		 label = new JLabel("");
		 
		JRadioButton radioButton = new JRadioButton("");
		JRadioButton radioButton_1 = new JRadioButton("");
		JRadioButton radioButton_2 = new JRadioButton("");
		JRadioButton radioButton_3 = new JRadioButton("");
		JRadioButton radioButton_4 = new JRadioButton("");
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 442, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Change picture");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
								
				 JFileChooser fileChooser = new JFileChooser();
		         fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		         FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
		         fileChooser.addChoosableFileFilter(filter);
		         int result = fileChooser.showSaveDialog(null);
		         if(result == JFileChooser.APPROVE_OPTION){
		             File selectedFile = fileChooser.getSelectedFile();
		             path = selectedFile.getAbsolutePath();
		             label.setIcon(ResizeImage(path));
		             u.setFoto(path);
		             System.out.println(path + "\n asd \n");
		         }
		         else if(result == JFileChooser.CANCEL_OPTION){
		             System.out.println("No Data");
		         }
					
			}
		});
		btnNewButton.setBounds(10, 165, 126, 42);
		contentPane.add(btnNewButton);
		
		
		label.setBounds(20, 23, 116, 129);
		contentPane.add(label);
		
		if(u.getFoto() != null)
			 label.setIcon(ResizeImage(u.getFoto()));
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int viz = 0;
				
				
				if(radioButton.isSelected() == true)
					viz = viz + 1 * 10000;
				else
					viz = viz + 0 * 10000;
				
				if(radioButton_1.isSelected() == true)
					viz = viz + 1 * 1000;
				else
					viz = viz + 0 * 1000;
				
				if(radioButton_2.isSelected() == true)
					viz = viz + 1 * 100;
				else
					viz = viz + 0 * 100;
				
				if(radioButton_3.isSelected() == true)
					viz = viz + 1 * 10;
				else
					viz = viz + 0 * 10;
				
				if(radioButton_4.isSelected() == true)
					viz = viz + 1 * 1;
				else
					viz = viz + 0 * 1;
				
				
				
				u.setVizibil(viz);
				
				
				String a = textField.getText().toString();
				String b = textField_1.getText().toString();
				String c = textField_2.getText().toString();
				String d = textField_3.getText().toString();
				String e1 = textField_4.getText().toString();
				
				if(a.length() > 2 && b.length() > 2 && c.length() > 2 && d.length() > 2 && e1.length() > 2) {
					if(b.matches(EMAIL_VALIDATION_REGEX )) {
						
						
						System.out.println(u.getFoto() +"\n");
						u.setName(a);
						u.setE_mail(b);
						u.setPass(c);
						u.setSkills(d);
						u.setHobbies(e1);
						
						u.UpdateUserC();
						//u.UpdateUserC();
						JOptionPane.showMessageDialog(null, "Update completed!");
										
					}else JOptionPane.showMessageDialog(null, "Invalid email!" );
					
				}else JOptionPane.showMessageDialog(null,  "All fields are required");
				
				
				
				
			}
		});
		btnUpdate.setBounds(170, 345, 89, 23);
		contentPane.add(btnUpdate);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(170, 38, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblMail = new JLabel("mail");
		lblMail.setBounds(170, 87, 46, 14);
		contentPane.add(lblMail);
		
		JLabel lblPass = new JLabel("pass");
		lblPass.setBounds(170, 130, 46, 14);
		contentPane.add(lblPass);
		
		JLabel lblSkills = new JLabel("skills");
		lblSkills.setBounds(170, 179, 46, 14);
		contentPane.add(lblSkills);
		
		JLabel lblHobbies = new JLabel("hobbies");
		lblHobbies.setBounds(170, 226, 46, 14);
		contentPane.add(lblHobbies);
		
		textField = new JTextField();
		textField.setBounds(235, 35, 148, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(235, 84, 148, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(235, 127, 148, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(235, 176, 148, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(235, 223, 148, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		
			
		
		
		radioButton.setBounds(10, 7, 21, 14);
		contentPane.add(radioButton);
		
		
		radioButton_1.setBounds(389, 29, 28, 23);
		contentPane.add(radioButton_1);
		
		
		radioButton_2.setBounds(389, 78, 28, 23);
		contentPane.add(radioButton_2);
		
		
		radioButton_3.setBounds(392, 175, 28, 23);
		contentPane.add(radioButton_3);
		
		
		radioButton_4.setBounds(392, 222, 28, 23);
		contentPane.add(radioButton_4);
		
		
		textField.setText(u.getName());
		textField_1.setText(u.getE_mail());
		textField_2.setText(u.getPass());
		textField_3.setText(u.getSkills());
		textField_4.setText(u.getHobbies());
		
		
		JButton btnProject = new JButton("Project");
		btnProject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SProject p = new SProject();
				p.setVisible(true);
				
			}
		});
		btnProject.setBounds(327, 412, 89, 23);
		contentPane.add(btnProject);
		
		
		 
		int number = u.getVizibil();
		int len = Integer.toString(number).length();
		int[] iarray = new int[8];
		for (int index = 0; index < len; index++) {
		    iarray[index] = number % 10;
		    number /= 10;
		} 
		
		
		if(iarray[4] == 1)
			radioButton.setSelected(true);
		
		if(iarray[3]  == 1)
			radioButton_1.setSelected(true);
		
		if(iarray[2] == 1)
			radioButton_2.setSelected(true);
		
		if(iarray[1] == 1)
			radioButton_3.setSelected(true);
		
		if(iarray[0] == 1)
			radioButton_4.setSelected(true);
		
		
	}
}
