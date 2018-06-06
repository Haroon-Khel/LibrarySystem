package librarySystem;

import java.awt.event.*;
import javax.swing.*;

public class AdminMenu extends JPanel {
	
	private JButton aLib, vLib, logout;
	private MotherPanel motherPanel;
	private JLabel title;
	private String administrator;
	
	public AdminMenu (MotherPanel motherPanel, String administrator) {
		
		aLib = new JButton("Add Librarian");
		vLib = new JButton("View Librarian");
		title = new JLabel("Administrator Menu. Welcome back " + administrator);
		logout = new JButton("Logout");
		logout.addActionListener(new LogoutAction());
		this.add(aLib);
		this.add(vLib);
		this.add(logout);
		this.add(title);
		this.administrator = administrator;
		/*The Motherpanel supplied will be the motherpanel within this class. This allows this subclass to have
		 * access to the other subclasses when it needs to during card switching
		*/
		this.motherPanel = motherPanel;
		aLib.addActionListener(new ALib());
		
	}
	
	private void removeFromMother () {
		
		motherPanel.remove(this);
				
	}
	
	private String getAdministrator() {
		
		return this.administrator;
		
	}
	
	private class LogoutAction implements ActionListener {
		
		public void actionPerformed (ActionEvent e) {
			
			motherPanel.card.show(motherPanel, "AdminLogin");
			removeFromMother();
			
		}
		
	}
	
	private class ALib implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			AddLibrarian addLibrarian = new AddLibrarian(motherPanel, getAdministrator());
			motherPanel.add(addLibrarian, "AddLibrarian");
			motherPanel.card.show(motherPanel, "AddLibrarian");
			
		}
		
	}
	
	private class VLib implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}

}
