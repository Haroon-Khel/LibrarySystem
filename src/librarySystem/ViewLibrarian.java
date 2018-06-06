package librarySystem;

import javax.swing.*;
import java.sql.*;

public class ViewLibrarian extends JPanel {
	
	private MotherPanel motherPanel;

	
	public ViewLibrarian (MotherPanel motherPanel) {
		
		this.motherPanel = motherPanel;
		
	}

}

/*
 * A section that lists all the librarians, their usernames and passwords, dates of creation, by which Administrator perhaps.
 * Perhaps a history of books that theyve issued.
 * Button to delete librarians
 */