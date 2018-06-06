package librarySystem;

import javax.swing.*;
import java.sql.*;

public class ViewLibrarian extends JPanel {
	
	private MotherPanel motherPanel;
	private JLabel title = new JLabel("View Librarian");

	
	public ViewLibrarian (MotherPanel motherPanel) {
		
		this.motherPanel = motherPanel;
		
		
	}

}

/*
 * A table that lists all the librarians, their usernames and passwords, dates of creation, by which Administrator perhaps.
 * Perhaps the table can be adjusted, data can be sorted, whatever
 * Perhaps a history of books that theyve issued.
 * Something to delete librarians, either a seperate button leading to a search menu, or delete by clicking on an entry on the table, then clicking delete.
 * A back button. 
 */