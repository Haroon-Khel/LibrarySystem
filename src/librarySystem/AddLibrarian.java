package librarySystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddLibrarian extends JPanel {
	
	private MotherPanel motherPanel;
	private String administrator;
	private JButton cancel, ok;
	private JTextField newUsername, newPassword;
	private JLabel title, titleUsername, titlePassword;
	private String user, pass;
	
	public AddLibrarian (MotherPanel motherPanel, String administrator) {
		
		this.motherPanel = motherPanel;
		this.administrator = administrator;
		cancel = new JButton("Cancel");
		ok = new JButton("OK");
		title = new JLabel("Add Librarian");
		titleUsername = new JLabel("Username");
		titlePassword = new JLabel("Password");
		newUsername = new JTextField();
		newPassword = new JTextField();
		setTextFieldProperties(newUsername, newPassword);
		addMultipleComponents(title, titleUsername, titlePassword, ok, cancel, newUsername, newPassword);
		ok.addActionListener(new okButton());
		cancel.addActionListener(new cancelButton());
		
	}
	
	private void setTextFieldProperties (JTextField... textfields) {
		
		for (JTextField textfield:textfields) {
			
			textfield.setBackground(Color.WHITE);
			textfield.setPreferredSize(new Dimension(300, 30));
			textfield.setEnabled(true);
			textfield.setHorizontalAlignment(JTextField.LEFT);
			textfield.setDisabledTextColor(Color.BLACK);
			
		}
	}
	
	public void addMultipleComponents (Component... components) {
		
		for (Component component:components) {
			this.add(component);
		}
		
	}
	
	private void clearTextFields (JTextField... fields) {
		
		for (JTextField textfield:fields) {
			textfield.setText("");
		}
		
	}
	
	private void createLibrarianEntrySQL (JTextField username, JTextField password) {
		
		user = username.getText();
		pass = password.getText();
		Connection conn = null;
		Statement state = null;
		ResultSet rs = null;
		String userInput = "'" + user + "'";
		String passInput = "'" + pass + "'";
 		
		try {
			
			String classForName = "com.mysql.cj.jdbc.Driver";
			String path = "jdbc:mysql://localhost:3306/library_system";
			String sqlUser = "root";
			String sqlPassword = "Buck5sac568@";
			String sqlStatement = "insert into Librarians " + "values (" + userInput + ", " + passInput + ")";
			
			Class.forName(classForName);
			conn = DriverManager.getConnection(path, sqlUser, sqlPassword);
			state = conn.createStatement();
			
			state.executeUpdate(sqlStatement);
			
			state.close();
			conn.close();
			
		}
		
		catch (SQLException s) {
			
			/*
			 * Catch any SQL exception
			 */
			s.printStackTrace();
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}

		
		//To close all connection incase of an exception. Good practice depsite the fact that the Garbage collector does it anyway
		finally {
			
			try {

				state.close();
				conn.close();
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	private void removeFromMother () {
		
		motherPanel.remove(this);
		
	}
	
	private class okButton implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			createLibrarianEntrySQL(newUsername, newPassword);
			clearTextFields(newUsername, newPassword);
			motherPanel.card.show(motherPanel, "AdminMenu");
			
		}
		
	}
	
	private class cancelButton implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			motherPanel.card.show(motherPanel, "AdminMenu");
			removeFromMother();
			clearTextFields(newUsername, newPassword);
			
		}
		
	}
}

/*
 * Atleast 2 Textfields. One to input username, the other for the password
 * 2 Buttons, cancel and ok
 * TODO - Quality check with username and password. The very least, usernames must be unique.
 * 		- Display a message, either at the bottom of Admin menu or a popout JFrame telling user that Librarian has been created.
 * 		- Maybe some expection handling.
 */
