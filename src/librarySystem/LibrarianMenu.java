package librarySystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LibrarianMenu extends JPanel {
	
	private JButton addBooks, viewBooks, issueBooks, viewIssuedBooks, returnBooks, viewUsers, logout;
	private MotherPanel motherPanel;
	private JLabel title;
	
	public LibrarianMenu (MotherPanel motherPanel, String librarian) {
		
		addBooks = new JButton("Add Books");
		viewBooks = new JButton("View Books");
		issueBooks = new JButton("Issue Books");
		viewIssuedBooks = new JButton("View Issued Books");
		returnBooks = new JButton("Return Books");
		viewUsers = new JButton("View Users");
		logout = new JButton("Logout");
		logout.addActionListener(new LogoutAction());
		addBooks.addActionListener(new AddBooksAction());
		viewUsers.addActionListener(new UsersAction());
		title = new JLabel("Librarian Menu. Welcome back " + librarian);
		this.add(viewUsers);
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
	
	private class AddBooksAction implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			
			AddBooks addBooks = new AddBooks(motherPanel);
			motherPanel.add(addBooks, "AddBooks");
			motherPanel.card.show(motherPanel, "AddBooks");
			
		}
		
	}
	
	private class UsersAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			ViewUsers viewUsers = new ViewUsers(motherPanel);
			motherPanel.add(viewUsers, "ViewUsers");
			motherPanel.card.show(motherPanel, "ViewUsers");
			
		}
		
	}
	

}

/* 
 * LibrarianMenu Panels will only by created and added to motherpanel only when a librarian logs in, as opposed to
 * created in the main class and added by default. This way we can make each LibrarianMenu panel unique to each 
 * Librarian by passing a string into its constructor.
 * Also, upon logging out, we can remove this panel from the motherpanel
 */

