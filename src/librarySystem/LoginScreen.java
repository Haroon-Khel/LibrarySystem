package librarySystem;

import java.awt.event.*;
import javax.swing.*;

public class LoginScreen extends JPanel {
	
	private JButton adminLog, librarianLog;
	private MotherPanel motherPanel;
	private JLabel title = new JLabel("Login Screen");
	
	public LoginScreen (MotherPanel motherPanel) {
		
		adminLog = new JButton("Administrator");
		librarianLog = new JButton("Librarian");
		this.add(adminLog);
		this.add(librarianLog);
		this.add(title);
		adminLog.addActionListener(new AdministratorLogin());
		librarianLog.addActionListener(new LibrarianLogin());
		/*The Motherpanel supplied will be the motherpanel within this class. This allows this subclass to have
		 * access to the other subclasses when it needs to during card switching
		*/
		this.motherPanel = motherPanel;
		
	}
	
	private class AdministratorLogin implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			motherPanel.card.show(motherPanel, "AdminLogin");
			
		}
		
	}
	
	private class LibrarianLogin implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			motherPanel.card.show(motherPanel, "LibrarianLogin");
			
		}
		
	}

}

/*
 * This panel will only contain two buttons, one for Admin, one for Librarian login
 * 
*/