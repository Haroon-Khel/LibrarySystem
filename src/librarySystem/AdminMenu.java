package librarySystem;

import javax.swing.*;

public class AdminMenu extends JPanel {
	
	private JButton aLib, vLib, dLib;
	private MotherPanel motherPanel;
	
	public AdminMenu (MotherPanel motherPanel) {
		
		aLib = new JButton("Add Librarian");
		vLib = new JButton("View Librarian");
		dLib = new JButton("Delete Librarian");
		this.add(aLib);
		this.add(vLib);
		this.add(dLib);
		/*The Motherpanel supplied will be the motherpanel within this class. This allows this subclass to have
		 * access to the other subclasses when it needs to during card switching
		*/
		this.motherPanel = motherPanel;
		
	}

}
