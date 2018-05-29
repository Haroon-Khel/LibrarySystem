package librarySystem;

import java.awt.event.*;
import javax.swing.*;

public class AdminMenu extends JPanel {
	
	private JButton aLib, vLib, dLib, logout;
	private MotherPanel motherPanel;
	private JLabel title;
	
	public AdminMenu (MotherPanel motherPanel, String administrator) {
		
		aLib = new JButton("Add Librarian");
		vLib = new JButton("View Librarian");
		dLib = new JButton("Delete Librarian");
		title = new JLabel("Administrator Menu. Welcome back " + administrator);
		logout = new JButton("Logout");
		logout.addActionListener(new LogoutAction());
		this.add(aLib);
		this.add(vLib);
		this.add(dLib);
		this.add(logout);
		this.add(title);
		/*The Motherpanel supplied will be the motherpanel within this class. This allows this subclass to have
		 * access to the other subclasses when it needs to during card switching
		*/
		this.motherPanel = motherPanel;
		
	}
	
	private void removeFromMother () {
		
		motherPanel.remove(this);
		
	}
	
	private class LogoutAction implements ActionListener {
		
		public void actionPerformed (ActionEvent e) {
			
			motherPanel.card.show(motherPanel, "AdminLogin");
			removeFromMother();
			
		}
		
	}

}
