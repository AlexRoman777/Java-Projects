package the.library;

import java.sql.ResultSet;

/**
 * This class is used to print out the title screen and the outro screen.
 * The intention is to move all the print statements to this class.
 * Not much to see here.
 */
public class PrintOut extends Utils {

    public void printTitle() {
        clearTerminal();
        printWithDelay(RED + "Welcome to " + BLUE + "The Library Administration System".toUpperCase() + RESET, 20);
        delayRun(250);
    }

    public void printInstructions() {
        clearTerminal();
        String level = """
                Good Luck!
                    """;
        System.out.println(level);

    }

    public static void outroScreen() {
        printWithDelay(YELLOW + "Goodbye and thanks for all the fish!".toUpperCase() + RESET, 20);
        delayRun(250);
    }

    public void printLoans(ResultSet rs) {
    }

}
