package librarySystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AdminLogin extends JPanel {
	
	private MotherPanel motherPanel;
	private JButton back, login;
	private JTextField username, password;
	
	public AdminLogin (MotherPanel motherPanel) {
		
		back = new JButton("Back");
		login = new JButton("Login");
		username = new JTextField();
		password = new JTextField();
		setTextFieldProperties(username);
		setTextFieldProperties(password);
		this.add(back);
		this.add(login);
		this.add(username);
		this.add(password);
		this.motherPanel = motherPanel;
		back.addActionListener(new BackToLoginScreen());
		login.addActionListener(new LoginButton());
		
	}
	
	private void setTextFieldProperties (JTextField textfield) {
		
		textfield.setBackground(Color.WHITE);
		textfield.setPreferredSize(new Dimension(300, 40));
		textfield.setEnabled(true);
		textfield.setHorizontalAlignment(JTextField.LEFT);
		textfield.setDisabledTextColor(Color.BLACK);
		
	}
	
	private class BackToLoginScreen implements ActionListener {
		
		public void actionPerformed (ActionEvent e) {
			
			motherPanel.card.show(motherPanel, "LoginScreen");
			
		}
		
	}
	
	private class LoginButton implements ActionListener {
		
		private String usernameText, passwordText;
		private boolean authenticateReturn;
		
		public void actionPerformed (ActionEvent e) {
			
			usernameText = username.getText();
			passwordText = password.getText();
			
			if (authenticate(usernameText, passwordText)) {
				
				motherPanel.card.show(motherPanel, "AdminMenu");
				
			}
			
			else {
				System.out.println("Error: Username or password is incorrect");
			}
			
		}
		
		private boolean authenticate (String usernameText, String passwordText) {
			
			String usernameSearch = "'" + usernameText + "'";
			authenticateReturn = false;
			
			Connection conn = null;
			Statement state = null;
			ResultSet rs = null;
			
			String passwordData = null;
			
			try {
				
				String classForName = "com.mysql.cj.jdbc.Driver";
				String path = "jdbc:mysql://localhost:3306/library_system";
				String user = "root";
				String password = "Buck5sac568@";
				String sqlStatement = "select * from Admin_users where user = " + usernameSearch;
				
				Class.forName(classForName);
				conn = DriverManager.getConnection(path, user, password);
				state = conn.createStatement();
				
				rs = state.executeQuery(sqlStatement);
				
				//Reading return statement
				
				while (rs.next()) {
					
		//			usernameData = rs.getString("user");
					passwordData = rs.getString("password");
					
				}
				
				rs.close();
				state.close();
				conn.close();
				
			}
			
			catch (Exception e) {
				e.printStackTrace();
			}
			//To close all connection incase of an exception. Good practice depsite the fact that the Garbage collector does it anyway
			finally {
				
				try {
					
					rs.close();
					state.close();
					conn.close();
					
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
			if (passwordData.equals(passwordText)) {
				
				authenticateReturn = true;
				
			}
			
			return authenticateReturn;
			
		}
		
	}

}

/*
 * 2 Textfields: Username and Password. If incorrect username or password is given, an error message should appear
 * 2 Buttons: one to submit username and password, one to go back to the menu
 * TODO - If rs returns nothing, handle that exception: "Username and password incorrect" or whatever
*/
