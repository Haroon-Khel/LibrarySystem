package librarySystem;

import javax.swing.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class ViewLibrarian extends JPanel {
	
	private MotherPanel motherPanel;
	private JLabel title = new JLabel("View Librarians");
	private JButton dLib = new JButton("Delete Librarian");
	private JButton cancel = new JButton("Cancel");
	
	public ViewLibrarian (MotherPanel motherPanel) {
		
		this.motherPanel = motherPanel;
		this.add(title);
		this.add(dLib);
		this.add(cancel);
		cancel.addActionListener(new CancelButton());
		displayData();
		testTable();
		
	}
	
	public void addMultipleComponents (Component... components) {
		
		for (Component component:components) {
			this.add(component);
		}
	}
	
	
	private void removeFromMother () {
		
		motherPanel.remove(this);
		
	}
	
	private void displayData() {
		
		Connection conn = null;
		Statement state = null;
		ResultSet rs = null;
	//	ArrayList<ArrayList<String>> listOfLists = null;
	//	ArrayList<String> arrayList = null;
		int index = 0;
		
		
		try {
			
			String classForName = "com.mysql.cj.jdbc.Driver";
			String path = "jdbc:mysql://localhost:3306/library_system";
			String user = "root";
			String password = "Buck5sac568@";
			String sqlStatement = "select * from Librarians";
			
			Class.forName(classForName);
			conn = DriverManager.getConnection(path, user, password);
			state = conn.createStatement();
			
			rs = state.executeQuery(sqlStatement);
			
			//Reading return statement
			System.out.printf("%-15s %s%n%n", "Username", "Password");
			
			while (rs.next()) {
				
	//			arrayList.add(0, rs.getString("username"));
	//			arrayList.add(1, rs.getString("password"));
	//			listOfLists.add(arrayList);
				System.out.printf("%-15s %s%n", rs.getString("username"), rs.getString("password"));
				
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
	
	private void deleteLib (String librarian) {
		
		
		
	}
	
	private void testTable () {
		
		String data[][] = {
				{"onenklkjlkjlkjk", "two", ""},
				{"four", "five", "six"},
				{"seven", "eight", "nine"}
		};
		
		String columns[] = {"First", "Second", "Third"};
		
		JTable table = new JTable(data, columns);
//		table.set
		this.add(table);
		
	}
	
	private class DeleteLibrarian implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class CancelButton implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			motherPanel.card.show(motherPanel, "AdminMenu");
			removeFromMother();
			
		}
		
	}
	

}

/*
 * A table that lists all the librarians, their usernames and passwords, dates of creation, by which Administrator perhaps.
 * Perhaps the table can be adjusted, data can be sorted, whatever
 * Perhaps a history of books that theyve issued.
 * Something to delete librarians, either a seperate button leading to a search menu, or delete by clicking on an entry on the table, then clicking delete.
 * A back button. 
*/