package librarySystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class LibrarianLogin extends JPanel {
	
	private MotherPanel motherPanel;
	private JButton back, login;
	private JTextField username, password;
	private JLabel title;
	
	public LibrarianLogin (MotherPanel motherPanel) {
		
		back = new JButton("Back");
		login = new JButton("Login");
		title = new JLabel("Librarian Login");
		back.addActionListener(new BackToLoginScreen());
		login.addActionListener(new LoginButton());
		username = new JTextField();
		password = new JTextField();
		setTextFieldProperties(username);
		setTextFieldProperties(password);
		this.add(back);
		this.add(login);
		this.add(username);
		this.add(password);
		this.add(title);
		this.motherPanel = motherPanel;
		
	}
	
	private void setTextFieldProperties (JTextField textfield) {
		
		textfield.setBackground(Color.WHITE);
		textfield.setPreferredSize(new Dimension(300, 30));
		textfield.setEnabled(true);
		textfield.setHorizontalAlignment(JTextField.LEFT);
		textfield.setDisabledTextColor(Color.BLACK);
		
	}
	
	private void clearTextFields () {
		
		username.setText("");
		password.setText("");
		
	}
	
	private class BackToLoginScreen implements ActionListener {
		
		public void actionPerformed (ActionEvent e) {
			
			clearTextFields();
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
				
				clearTextFields();
				LibrarianMenu librarianMenu = new LibrarianMenu(motherPanel, usernameText);
				motherPanel.add(librarianMenu, "LibrarianMenu");
				motherPanel.card.show(motherPanel, "LibrarianMenu");
				
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
				String sqlStatement = "select * from Librarians where username = " + usernameSearch;
				
				Class.forName(classForName);
				conn = DriverManager.getConnection(path, user, password);
				state = conn.createStatement();
				
				rs = state.executeQuery(sqlStatement);
				
				//Reading return statement
				
				while (rs.next()) {
					
					passwordData = rs.getString("password");
					
				}
				
				rs.close();
				state.close();
				conn.close();
				
			}
			
			catch (SQLException s) {
				
				/*
				 * Catch any SQL exception
				 */
				
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
*/