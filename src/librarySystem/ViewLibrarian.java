package librarySystem;

import javax.swing.*;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewLibrarian extends JPanel {
	
	private MotherPanel motherPanel;
	private JLabel title = new JLabel("View Librarian");
	private JButton dLib, cancel;

	
	public ViewLibrarian (MotherPanel motherPanel) {
		
		this.motherPanel = motherPanel;
		dLib = new JButton("Delete Librarian");
		cancel = new JButton("Cancel");
		motherPanel.add(this);
		
	}
	
	public void addMultipleComponents (Component... components) {
		
		for (Component component:components) {
			this.add(component);
		}
	}
	
	
	private void removeFromMother () {
		
		motherPanel.remove(this);
		
	}
	
	private class cancelButton implements ActionListener {

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