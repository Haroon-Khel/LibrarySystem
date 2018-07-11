package librarySystem;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.sql.*;

public class AddBooks extends JPanel {
	
	private JButton add, cancel;
	private MotherPanel motherPanel;
	private JLabel title = new JLabel("Add Book");
	private JTextField name, author, count;	
	private String authorEntry, nameEntry, countEntry;
	
	public AddBooks (MotherPanel motherPanel) {
		
		add = new JButton("Add Book");
		cancel = new JButton("Cancel");
		this.motherPanel = motherPanel;
		name = new JTextField();
		author = new JTextField();
		count = new JTextField();
		setTextFieldProperties(name, author, count);
		addMultipleComponents(title, add, cancel, name, author, count);
		add.addActionListener(new AddAction());
		cancel.addActionListener(new CancelAction());
		
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
	
	private void addMultipleComponents (Component... components) {
		
		for (Component component:components) {
			this.add(component);
		}
		
	}
	
	//Returns true if all three text fields are non empty
	private boolean textFieldData (JTextField... textfields) {

		boolean answer = true;
		
		for (JTextField textfield : textfields) {
			
			if (textfield.getText().equals("")) {
				answer = false;
				System.out.println("The " + textfield.getName() + " is empty. Please fill it in");
			}
			
		}
		
		return answer;
		
	}
	
	//mysql call to update table with name, author and count
	private void updateBooksInventoryTable () {
		
		nameEntry = name.getText();
		authorEntry = author.getText();
		countEntry = count.getText();
		Connection conn = null;
		Statement state = null;
		String nameInput = "'" + nameEntry + "'";
		String authorInput = "'" + authorEntry + "'";
		String countInput = "'" + countEntry + "'";
 		
		try {
			
			String classForName = "com.mysql.cj.jdbc.Driver";
			String path = "jdbc:mysql://localhost:3306/library_system";
			String sqlUser = "root";
			String sqlPassword = "Buck5sac568@";
			String sqlStatement = "insert into Books_inventory " + "values (" + nameInput + ", " + authorInput + ", " + countInput + ")";
			
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
	
	private void clearTextFields () {
		
		name.setText("");
		author.setText("");
		count.setText("");
		
	}	
	
	private class AddAction implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			if (textFieldData(name, author, count)) {
				
				updateBooksInventoryTable();
				System.out.printf("%nName: %-10s%nAuthor: %-10s%nCount: %-10s", name.getText(), author.getText(), count.getText());
				clearTextFields();
				
			}
			
		}
		
	}
	
	private class CancelAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			clearTextFields();
			motherPanel.card.show(motherPanel, "LibrarianMenu");
			removeFromMother();
			
		}
		
	}
}

/* 
 * A jtextbox for each of the columns in Book_inventory: Name, count, author
 * 2 buttons: Add book and cancel
 * 
 */