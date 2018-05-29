package librarySystem;

import java.awt.*;
import javax.swing.*;

public class MotherPanel extends JPanel {
	
	CardLayout card = new CardLayout();
	
	public MotherPanel () {
		
		this.setLayout(card);
		
	}
	
	//Instead of adding the subpanels in the constructor, I can add them later. Making it more convenient in the Main class
	public void addSubPanels (LoginScreen loginScreen, LibrarianLogin librarianLogin,
			AdminLogin adminLogin) {
		
		this.add(loginScreen, "LoginScreen");
//		this.add(adminMenu, "AdminMenu");
//		this.add(librarianMenu, "LibrarianMenu");
		this.add(librarianLogin, "LibrarianLogin");
		this.add(adminLogin, "AdminLogin");
		
	}
	

}

//Motherpanel object must have all the subpanel added. That way, each subpanel can switch to eachother
//Pass, as parameters to the MotherPanel, ever other subpanel - Better yet, use addSubPanels method
