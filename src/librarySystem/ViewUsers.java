package librarySystem;

import javax.swing.*;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewUsers extends JPanel {
	
	private JButton delete, addUser, edit, backToMenu;
	private JTable table;
	private JLabel title;
	private MotherPanel motherPanel;
	
	public ViewUsers (MotherPanel motherPanel) {
		
		this.motherPanel = motherPanel;
		delete = new JButton("Delete User");
		addUser = new JButton("Add User");
		edit = new JButton("Edit User");
		title = new JLabel("Users");
		backToMenu = new JButton("Back to menu");
		backToMenu.addActionListener(new BackToMenuAction());
		addUser.addActionListener(new AddUserAction());
		addMultipleComponents(delete, edit, backToMenu, addUser, title);
		displayData();
		
	}
	
	private void addMultipleComponents (Component... components) {
		
		for (Component component:components) {
			this.add(component);
		}
		
	}
	
	private void removeFromMother() {
		
		motherPanel.remove(this);
		
	}
	
	public static void displayData() {
		
		Connection conn = null;
		Statement state = null;
		ResultSet rs = null;
		
		try {
			
			String classForName = "com.mysql.cj.jdbc.Driver";
			String path = "jdbc:mysql://localhost:3306/library_system";
			String user = "root";
			String password = "Buck5sac568@";
			String sqlStatement = "select * from Users";
			
			Class.forName(classForName);
			conn = DriverManager.getConnection(path, user, password);
			state = conn.createStatement();
			
			rs = state.executeQuery(sqlStatement);
			
			//Reading return statement
			System.out.printf("%-15s %-15s %s%n%n", "Name", "DOB", "Address");
			
			while (rs.next()) {
				
				System.out.printf("%-15s %-15s %s%n", rs.getString("name"), rs.getString("dob"), rs.getString("address"));
				
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
		
	}
	
	private class AddUserAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			AddUsers addUsers = new AddUsers(motherPanel);
			motherPanel.add(addUsers, "AddUsers");
			motherPanel.card.show(motherPanel, "AddUsers");
			
		}
		
	}
	
	private class BackToMenuAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			motherPanel.card.show(motherPanel, "LibrarianMenu");
			removeFromMother();
			
		}
		
	}

}

/* 
 * Table which displays all users, each user detail
 * button to add users, delete users, modify users
 * Title
 * Button to go back to Librarian Menu
*/