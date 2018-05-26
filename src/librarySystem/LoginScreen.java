package librarySystem;

import javax.swing.*;

public class LoginScreen extends JPanel {
	
	private JButton adminLog, librarianLog;
	private MotherPanel motherPanel;
	
	public LoginScreen (MotherPanel motherPanel) {
		
		adminLog = new JButton("Administrator");
		librarianLog = new JButton("librarian");
		this.add(adminLog);
		this.add(librarianLog);
		/*The Motherpanel supplied will be the motherpanel within this class. This allows this subclass to have
		 * access to the other subclasses when it needs to during card switching
		*/
		this.motherPanel = motherPanel;
		
	}
	

}

/*
 * This panel will only contain two buttons, one for Admin, one for Librarian login
 * 
*/