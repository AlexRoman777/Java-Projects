
package the.library;

import java.sql.SQLException;

public class App extends Menu {
	public static void main(String[] args) throws SQLException {
		clearTerminal();
		App app = new App();
		app.mainMenu();
		PrintOut.outroScreen();
	}
}


