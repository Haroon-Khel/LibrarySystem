package librarySystem;

import java.awt.*;
import javax.swing.*;

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
		
	}
	
	private void setTextFieldProperties (JTextField textfield) {
		
		textfield.setBackground(Color.WHITE);
		textfield.setPreferredSize(new Dimension(300, 40));
		textfield.setEnabled(true);
		textfield.setHorizontalAlignment(JTextField.LEFT);
		textfield.setDisabledTextColor(Color.BLACK);
		
	}

}

/*
 * 2 Textfields: Username and Password. If incorrect username or password is given, an error message should appear
 * 2 Buttons: one to submit username and password, one to go back to the menu
*/
