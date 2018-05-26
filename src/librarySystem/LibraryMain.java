package librarySystem;

import java.awt.CardLayout;
import javax.swing.*;

public class LibraryMain {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Library System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(400, 400);
		
		MotherPanel motherPanel = new MotherPanel();
		
		LoginScreen loginScreen = new LoginScreen(motherPanel);
		AdminMenu adminMenu = new AdminMenu(motherPanel);
		LibrarianMenu librarianMenu = new LibrarianMenu(motherPanel);
		
		motherPanel.addSubPanels(loginScreen, adminMenu, librarianMenu);
		
		frame.add(motherPanel);

	}

}

/*
 * One JFrame, one Motherpanel, many subpanels, Cardlayout to switch between panels. 
 * Perhaps each sub panel can be a class?
 * In the main class, the frame, motherpanel, subpanel classes and cardlayout can be initiated
 * Subpanels: Login screen, Admin login, Librarian login, Admin menu, Librarian menu, 
 * Admin:Add librarian, View librarian, Delete librarian,
 * Librarian:Add books, View books, Issue books, View issued books, Return books
 * 
 * motherPanel might have to be its own class
 * CardLayout allows the motherPanel to begin with the first initiated subpanel, in the above case, LoginScreen
*/