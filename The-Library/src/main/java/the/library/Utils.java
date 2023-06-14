package the.library;

import java.io.IOException;

public class Utils {

    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String MOVEUP = "\033[1A";

    public static final String MAIN = """
            ======================== MAIN MENU ==========================
            #                                                           #
            #             \u001B[33mThe Library Administration System\u001B[0m             #
            #                                                           #
            ========================= CRUD ==============================
            # \u001B[31m1\u001B[0m. \u001B[32mC\u001B[34mREATE\u001B[0m a new item in the library                       #
            # \u001B[31m2\u001B[0m. \u001B[32mR\u001B[34mEAD\u001B[0m an item from the library                          #
            # \u001B[31m3\u001B[0m. \u001B[32mU\u001B[34mPDATE\u001B[0m an item in the library                          #
            # \u001B[31m4\u001B[0m. \u001B[32mD\u001B[34mELETE\u001B[0m an item from the library                        #
            ========================= EXTRA =============================
            # \u001B[31m5\u001B[0m. Search                                                 #
            # \u001B[31m6\u001B[0m. Calculate Value                                        #
            # \u001B[31m7\u001B[0m. Lend an item                                           #
            # \u001B[31m8\u001B[0m. Send a reminder                                        #
            # \u001B[31m9\u001B[0m. List special atributes                                 #
            ========================== ADMIN ============================
            # \u001B[31madd\u001B[0m.  Add a new TABLE (Database Table)                    #
            # \u001B[31mdel\u001B[0m.  Delete a TABLE (Database Table)                     #
            # \u001B[31mlist\u001B[0m. List TABLE names                                    #
            # \u001B[31msave\u001B[0m. Save users to file                                  #
            # \u001B[31mload\u001B[0m. Load users from file                                #
            =============================================================
            # \u001B[31mq\u001B[0m. \u001B[32mExit\u001B[0m                                                   # 
            =============================================================
            """;

    public static final String CREATE = """
            ========================== CREATE ===========================
            #                                                           #
            #             \u001B[33mThe Library Administration System\u001B[0m             #
            #                                                           #
            =============================================================
            # \u001B[31m1\u001B[0m. Add a new book                                         #
            # \u001B[31m2\u001B[0m. Add a new movie                                        #
            # \u001B[31m3\u001B[0m. Add a new CD                                           #
            # \u001B[31m4\u001B[0m. Add a new game                                         #
            # \u001B[31m5\u001B[0m. Add a new person                                       #
            # \u001B[31m6\u001B[0m. Add a new lease                                        #
            =============================================================
            # \u001B[31m7\u001B[0m. Back to Main Menu                                      #
            =============================================================
            """;

    public static final String READ = """
            ============================ READ ===========================
            #                                                           #
            #             \u001B[33mThe Library Administration System\u001B[0m             #
            #                                                           #
            =============================================================
            # \u001B[31m1\u001B[0m. List BOOKS                                             #
            # \u001B[31m2\u001B[0m. List MOVIES                                            #
            # \u001B[31m3\u001B[0m. List CDs                                               #
            # \u001B[31m4\u001B[0m. List GAMES                                             #
            # \u001B[31m5\u001B[0m. List PEOPLE                                            #
            # \u001B[31m6\u001B[0m. List All ITEMS                                         #
            =============================================================
            # \u001B[31m7\u001B[0m. Back to Main Menu                                      #
            =============================================================
            """;

    public static final String UPDATE = """
            ========================== UPDATE ===========================
            #                                                           #
            #             \u001B[33mThe Library Administration System\u001B[0m             #
            #                                                           #
            =============================================================
            # \u001B[31m1\u001B[0m. Update a book                                          #
            # \u001B[31m2\u001B[0m. Update a movie                                         #
            # \u001B[31m3\u001B[0m. Update a CD                                            #
            # \u001B[31m4\u001B[0m. Update a game                                          #
            # \u001B[31m5\u001B[0m. Update info about a person                             #
            =============================================================
            # \u001B[31m6\u001B[0m. Back to Main Menu                                      #
            =============================================================
            """;

    public static final String DELETE = """
            ========================== DELETE ===========================
            #                                                           #
            #             \u001B[33mThe Library Administration System\u001B[0m             #
            #                                                           #
            =============================================================
            # \u001B[31m1\u001B[0m. Delete a book                                          #
            # \u001B[31m2\u001B[0m. Delete a movie                                         #
            # \u001B[31m3\u001B[0m. Delete a CD                                            #
            # \u001B[31m4\u001B[0m. Delete a game                                          #
            # \u001B[31m5\u001B[0m. Remove a person                                        #
            =============================================================
            # \u001B[31m6\u001B[0m. Back to Main Menu                                      #
            =============================================================
            """;

    public static final String SEARCH = """
            ========================== SEARCH ===========================
            #                                                           #
            #             \u001B[33mThe Library Administration System\u001B[0m             #
            #                                                           #
            =============================================================
            # \u001B[31m1\u001B[0m. Search info about a book                               #
            # \u001B[31m2\u001B[0m. Search info about a movie                              #
            # \u001B[31m3\u001B[0m. Search info about a compact disk                       #
            # \u001B[31m4\u001B[0m. Search info about a game                               #
            # \u001B[31m5\u001B[0m. Search info about a person                             #
            =============================================================
            # \u001B[31m6\u001B[0m. Back to Main Menu                                      #
            =============================================================
            """;

    public static final String CALCULATE = """
            ============================ VALUE ==========================
            #                                                           #
            #             \u001B[33mThe Library Administration System\u001B[0m             #
            #                                                           #
            =============================================================
            # \u001B[31m1\u001B[0m. Calculate the total value of books                     #
            # \u001B[31m2\u001B[0m. Calculate the total value of movies                    #
            # \u001B[31m3\u001B[0m. Calculate the total value of CD's                      #
            # \u001B[31m4\u001B[0m. Calculate the total value of games                     #
            # \u001B[31m5\u001B[0m. Calculate the total value of the library               #
            =============================================================
            # \u001B[31m6\u001B[0m. Back to Main Menu                                      #
            =============================================================
            """;

    public static final String LEND = """
            ============================ LEND ===========================
            #                                                           #
            #             \u001B[33mThe Library Administration System\u001B[0m             #
            #                                                           #
            =============================================================
            # \u001B[31m1\u001B[0m. Lend a BOOK                                            #
            # \u001B[31m2\u001B[0m. Lend a MOVIE                                           #
            # \u001B[31m3\u001B[0m. Lend a CD                                              #
            # \u001B[31m4\u001B[0m. Lend a GAME                                            #
            =============================================================
            # \u001B[31m5\u001B[0m. List all leases                                        #
            =============================================================
            # \u001B[31m6\u001B[0m. Back to Main Menu                                      #
            =============================================================
            """;

    public static final String REMINDER = """
            ========================== REMINDER =========================
            #                                                           #
            #             \u001B[33mThe Library Administration System\u001B[0m             #
            #                                                           #
            =============================================================
            # \u001B[31m1\u001B[0m. Send a reminder to all borrowers                       #
            # \u001B[31m2\u001B[0m. Send a reminder to a specific borrower                 #
            # \u001B[31m3\u001B[0m. Send reminders for all expired leases                  #
            =============================================================
            # \u001B[31m4\u001B[0m. Back to Main Menu                                      #
            =============================================================
            """;

    public static final String SPECIALS = """
            ========================== SPECIALS =========================
            #                                                           #
            #             \u001B[33mThe Library Administration System\u001B[0m             #
            #                                                           #
            =============================================================
            # \u001B[31m1\u001B[0m. List the condition of books                            #
            # \u001B[31m2\u001B[0m. List the runtime of movies                             #
            # \u001B[31m3\u001B[0m. List the nr. of track for CD's                         #
            # \u001B[31m4\u001B[0m. List the age rating for games                          #
            # \u001B[31m5\u001B[0m. List the email of borrowers                            #
            =============================================================
            # \u001B[31m6\u001B[0m. Back to Main Menu                                      #
            =============================================================
            """;

    public static void pressEnterToContinue() {
        System.out.println(GREEN + "Press Enter to continue..." + RESET);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printSeparator() {
        System.out.println("=============================================================");
    }


    public static void printSeparator(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(YELLOW + "=");
        }
        System.out.println(RESET);
    }

    public static void printWithDelay(String text, int delay) {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i));
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    public static void delayRun(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print(RESET);
    }

    public static void printRed(String text) {
        System.out.print(RED + text + RESET);
        System.out.println();
    }

    public static String capitalizeWord(String str) {
        String words[] = str.split("\\s");
        String capitalizeWord = "";
        for (String w : words) {
            String first = w.substring(0, 1);
            String afterfirst = w.substring(1);
            capitalizeWord += first.toUpperCase() + afterfirst + " ";
        }
        return capitalizeWord.trim();
    }

    protected static void printString(String[][] res) {
        for (String[] row : res) {
            System.out.println(String.join(",", row));
        }
    }
    
    public static void notImplemented(String feature) {
        printSeparator();
        System.out.println("This feature: " + RED + feature + RESET + " is not implemented yet.");
        printSeparator(61);
        pressEnterToContinue();
    }

}
