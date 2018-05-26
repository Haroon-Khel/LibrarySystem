package librarySystem;

import javax.swing.*;

public class LibrarianMenu extends JPanel {
	
	private JButton addBooks, viewBooks, issueBooks, viewIssuedBooks, returnBooks;
	private MotherPanel motherPanel;
	
	public LibrarianMenu (MotherPanel motherPanel) {
		
		addBooks = new JButton("Add Books");
		viewBooks = new JButton("View Books");
		issueBooks = new JButton("Issue Books");
		viewIssuedBooks = new JButton("View Issued Books");
		returnBooks = new JButton("Return Books");
		this.add(addBooks);
		this.add(viewBooks);
		this.add(issueBooks);
		this.add(viewIssuedBooks);
		this.add(returnBooks);
		/*The Motherpanel supplied will be the motherpanel within this class. This allows this subclass to have
		 * access to the other subclasses when it needs to during card switching
		*/
		this.motherPanel = motherPanel;
		
	}
	
	

}
