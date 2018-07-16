package librarySystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class AddUsers extends JPanel {
	
	private JLabel title;
	private JTextField name, dob, address;
	private JButton ok, cancel;
	private MotherPanel motherPanel;
	private String nameEntry, dobEntry, addressEntry;
	
	public AddUsers (MotherPanel motherPanel) {
		
		this.motherPanel = motherPanel;
		title = new JLabel("Add User");
		ok = new JButton("OK");
		cancel = new JButton("Cancel");
		name = new JTextField();
		dob = new JTextField();
		address = new JTextField();
		ok.addActionListener(new OkAction());
		cancel.addActionListener(new CancelAction());
		addMultipleComponents(title, name, dob, address, ok, cancel);
		setTextFieldProperties(name, dob, address);
		
	}
	
	private void addMultipleComponents (Component... components) {
		
		for (Component component:components) {
			this.add(component);
		}
		
	}
	
	private void removeFromMother() {
		
		motherPanel.remove(this);
		
	}
	
	private void clearTextFields () {
		
		name.setText("");
		dob.setText("");
		address.setText("");
		
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
	private void updateUsers () {
		
		nameEntry = name.getText();
		dobEntry = dob.getText();
		addressEntry = address.getText();
		Connection conn = null;
		Statement state = null;
		String nameInput = "'" + nameEntry + "'";
		String dobInput = "'" + dobEntry + "'";
		String addressInput = "'" + addressEntry + "'";
 		
		try {
			
			String classForName = "com.mysql.cj.jdbc.Driver";
			String path = "jdbc:mysql://localhost:3306/library_system";
			String sqlUser = "root";
			String sqlPassword = "Buck5sac568@";
			String sqlStatement = "insert into Users " + "values (" + nameInput + ", " + dobInput + ", " + addressInput + ")";
			
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
	
	private class CancelAction implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			
			motherPanel.card.show(motherPanel, "ViewUsers");
			removeFromMother();
			clearTextFields();
			
		}
		
	}
	
	private class OkAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			if (textFieldData(name, dob, address)) {
				
				updateUsers();
				System.out.printf("%nAdded:%n%nName: %-10s%nDOB: %-10s%nAddress: %-10s", name.getText(), dob.getText(), address.getText());
				clearTextFields();
				
			}
			
		}
	}
	
	

}

/*  
 * 3 TextFields, 2 buttons: ok and cancel, 1 title
*/
