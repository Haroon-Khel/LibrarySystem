package librarySystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LibrarianMenu extends JPanel {
	
	private JButton addBooks, viewBooks, issueBooks, viewIssuedBooks, returnBooks, logout;
	private MotherPanel motherPanel;
	private JLabel title;
	
	public LibrarianMenu (MotherPanel motherPanel) {
		
		addBooks = new JButton("Add Books");
		viewBooks = new JButton("View Books");
		issueBooks = new JButton("Issue Books");
		viewIssuedBooks = new JButton("View Issued Books");
		returnBooks = new JButton("Return Books");
		logout = new JButton("Logout");
		logout.addActionListener(new LogoutAction());
		title = new JLabel("Librarian Menu");
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
	
	private class LogoutAction implements ActionListener {
		
		public void actionPerformed (ActionEvent e) {
			
			motherPanel.card.show(motherPanel, "LibrarianLogin");
			
		}
		
	}
	

}
