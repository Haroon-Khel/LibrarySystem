package librarySystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LibrarianMenu extends JPanel {
	
	private JButton addBooks, viewBooks, issueBooks, viewIssuedBooks, returnBooks, logout;
	private MotherPanel motherPanel;
	private JLabel title;
	
	public LibrarianMenu (MotherPanel motherPanel, String librarian) {
		
		addBooks = new JButton("Add Books");
		viewBooks = new JButton("View Books");
		issueBooks = new JButton("Issue Books");
		viewIssuedBooks = new JButton("View Issued Books");
		returnBooks = new JButton("Return Books");
		logout = new JButton("Logout");
		logout.addActionListener(new LogoutAction());
		title = new JLabel("Librarian Menu. Welcome back " + librarian);
		this.add(addBooks);
		this.add(viewBooks);
		this.add(issueBooks);
		this.add(viewIssuedBooks);
		this.add(returnBooks);
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
			
			motherPanel.card.show(motherPanel, "LibrarianLogin");
			removeFromMother();
			
		}
		
	}
	

}

/* 
 * LibrarianMenu Panels will only by created and added to motherpanel only when a librarian logs in, as opposed to
 * created in the main class and added by default. This way we can make each LibrarianMenu panel unique to each 
 * Librarian by passing a string into its constructor.
 * Also, upon logging out, we can remove this panel from the motherpanel
 */

