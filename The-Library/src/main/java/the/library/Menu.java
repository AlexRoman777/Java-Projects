package the.library;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu extends Utils {

    public static void showMenu(String menu) {
        clearTerminal();
        System.out.println(menu);
    }

    /**
     * Prints out the main menu and handle the user input.
     */
    public void mainMenu() throws SQLException {
        PrintOut printOut = new PrintOut();
        String choice;
        DatabaseIO db = new DatabaseIO("jdbc:mysql://localhost:3306/The Library");
        db.setUsername("root");
        db.setPassword("MYdatabase23#");
        Connection conn = db.getConnection();

        try (Scanner input = new Scanner(System.in)) {
            printOut.printTitle();
            // printOut.printInstructions();
            pressEnterToContinue();
            do {
                showMenu(MAIN);
                System.out.print(RED + "Input your choice: " + RESET);
                choice = input.next();

                if (choice.equals("1")) {
                    createMenu(input, db, conn, printOut);

                } else if (choice.equals("2")) {
                    readMenu(input, db, conn, printOut);

                } else if (choice.equals("3")) {
                    updateMenu(input, db, conn, printOut);

                } else if (choice.equals("4")) {
                    deleteMenu(input, db, conn, printOut);

                } else if (choice.equals("5")) {
                    searchMenu(input, db, conn, printOut);

                } else if (choice.equals("6")) {
                    calculateMenu(input, db, conn, printOut);

                } else if (choice.equals("7")) {
                    lendMenu(input, db, conn, printOut);

                } else if (choice.equals("8")) {
                    sendReminderMenu(input, db, conn, printOut);

                } else if (choice.equals("9")) {
                    specialMenu(input, db, conn, printOut);

                } else if (choice.equals("add")) {
                    addTable(input, db, conn, printOut);

                } else if (choice.equals("del")) {
                    delTable(input, db, conn, printOut);

                } else if (choice.equals("upd")) {
                    updTable(input, db, conn, printOut);

                } else if (choice.equals("list")) {
                    listSchema(input, db, conn, printOut);

                } else if (choice.equals("save")) {
                    saveUserListFromDatabase(input, db, conn, printOut);

                } else if (choice.equals("load")) {
                    loadUserList(input, db, conn, printOut);

                } else {
                    if (!"q".equalsIgnoreCase(choice)) {
                        System.out.println("Invalid option!");
                    }
                }
            } while (!"q".equalsIgnoreCase(choice));
        }
    }

    private void loadUserList(Scanner input, DatabaseIO db, Connection conn, PrintOut printOut) {
        SaveLoadToFile saveLoadToFile = new SaveLoadToFile();
        Map<String, Person> map = saveLoadToFile.loadFromFile();
        if (map == null) {
            map = new HashMap<String, Person>();
        }
        clearTerminal();
        System.out.println(BLUE + "Library users" + RESET);
        printSeparator();
        for (Map.Entry<String, Person> entry : map.entrySet()) {
            System.out.println("Name: " + RED + entry.getValue().getUsername() + RESET + "\n" + "e-mail: " + RED
                    + entry.getValue().getEmail() + RESET + "\n" + "Adress: " + RED + entry.getValue().getAddress()
                    + RESET);
            printSeparator();
        }
        printSeparator(61);
        pressEnterToContinue();
    }

    private void saveUserListFromDatabase(Scanner input, DatabaseIO db, Connection conn, PrintOut printOut) {
        SaveLoadToFile saveLoadToFile = new SaveLoadToFile();
        Map<String, Person> map = new HashMap<String, Person>();
        try {
            for (String[] row : db.readAllUsers()) {
                Person person2 = new Person(row);
                map.put(row[0], person2);
            }
        } catch (SQLException e) {
            System.out.println("Error reading from database");
        }
        saveLoadToFile.saveToFile(map);
        System.out.println("Data saved to file");
        printSeparator(61);
        pressEnterToContinue();
    }

    private void listSchema(Scanner input, DatabaseIO db, Connection conn, PrintOut printOut) throws SQLException {
        clearTerminal();
        System.out.println(BLUE + "List database TABLES" + RESET);
        printSeparator();
        printString(db.getSchema());
        printSeparator(61);
        pressEnterToContinue();
    }

    private void updTable(Scanner input, DatabaseIO db, Connection conn, PrintOut printOut) {
        clearTerminal();
        System.out.println(BLUE + "Update table" + RESET);
        printSeparator();
        System.out.print("Input table name: ");
        String tableName = input.next();
        System.out.print("Change table name to: ");
        String newTableName = input.next();
        if (db.updateTable(tableName, newTableName)) {
            System.out.println("Table " + RED + tableName + RESET + " updated to " + RED + newTableName + RESET + "!");
            printSeparator(61);
            pressEnterToContinue();
        } else {
            System.out.println("Table " + RED + tableName + RESET + " not updated!");
            printSeparator(61);
            pressEnterToContinue();
        }
    }

    private void delTable(Scanner input, DatabaseIO db, Connection conn, PrintOut printOut) {
        clearTerminal();
        System.out.println(BLUE + "Delete table" + RESET);
        printSeparator();
        System.out.print("Input table name: ");
        String tableName = input.next();
        try {
            db.dropTable(tableName);
            System.out.println("Table " + RED + tableName + RESET + " deleted!");
            printSeparator(61);
        } catch (SQLException e) {
            System.out.println("Table " + RED + tableName + RESET + " does not exist!");
        }
        pressEnterToContinue();
    }

    private void addTable(Scanner input, DatabaseIO db, Connection conn, PrintOut printOut) {
        clearTerminal();
        System.out.println(BLUE + "Add table" + RESET);
        printSeparator();
        System.out.print("Input table name: ");
        String tableName = input.next();
        System.out.print("Input table columns 1: ");
        String column1 = input.next();
        System.out.print("Input table columns 2: ");
        String column2 = input.next();
        System.out.print("Input table columns 3: ");
        String column3 = input.next();
        try {
            db.createTable(tableName, column1, column2, column3);
            System.out.println("Table " + RED + tableName + RESET + " created!");
        } catch (SQLException e) {
            System.out.println("Table " + RED + tableName + RESET + " already exists or not valid input!");
        }
        printSeparator(61);
        pressEnterToContinue();
    }

    private void specialMenu(Scanner input, DatabaseIO db, Connection conn, PrintOut printOut) throws SQLException {
        String choice;
        do {
            showMenu(SPECIALS);
            System.out.print(RED + "Input your choice: " + RESET);
            choice = input.next();

            if (choice.equals("1")) {
                clearTerminal();
                System.out.println(BLUE + "List books that are not in good or excellent condition" + RESET);
                printSeparator();
                for (String[] row : db.readAllBooks()) {
                    Book bookCondition = new Book(row);
                    System.out.println(bookCondition.printBadCondition());
                }
                printSeparator(61);
                pressEnterToContinue();

            } else if (choice.equals("2")) {
                clearTerminal();
                System.out.println(BLUE + "List the runtime of movies" + RESET);
                printString(db.readMovieRuntime());
                printSeparator();
                pressEnterToContinue();

            } else if (choice.equals("3")) {
                clearTerminal();
                System.out.println(BLUE + "List the number of tracks for CDs" + RESET);
                printString(db.readCDTracks());
                printSeparator();
                pressEnterToContinue();

            } else if (choice.equals("4")) {
                clearTerminal();
                System.out.println(BLUE + "List the age limit of the games" + RESET);
                printString(db.readGameAgeLimit());
                printSeparator();
                pressEnterToContinue();

            } else if (choice.equals("5")) {
                clearTerminal();
                System.out.println(BLUE + "List the e-mail addresses of all borrowers" + RESET);
                printSeparator();
                for (String[] row : db.readAllUsers()) {
                    Person borrower = new Person(row);
                    System.out.println(borrower.toString());
                }
                printSeparator(61);
                pressEnterToContinue();

            } else if (choice.equals("6")) {
                break;
            } else {
                if (!"q".equalsIgnoreCase(choice)) {
                    System.out.println("Invalid option!");
                }
            }
        } while (!"q".equalsIgnoreCase(choice));

    }

    private void sendReminderMenu(Scanner input, DatabaseIO db, Connection conn, PrintOut printOut) {
        String choice;
        do {
            showMenu(REMINDER);
            System.out.print(RED + "Input your choice: " + RESET);
            choice = input.next();

            if (choice.equals("1")) {
                clearTerminal();
                notImplemented("Send reminder to all borrowers");

            } else if (choice.equals("2")) {
                clearTerminal();
                notImplemented("Send reminder to a specific borrower");

            } else if (choice.equals("3")) {
                clearTerminal();
                notImplemented("Send reminder for all expired loans");

            } else if (choice.equals("4")) {
                break;

            } else {
                if (!"q".equalsIgnoreCase(choice)) {
                    System.out.println("Invalid option!");
                }
            }
        } while (!"q".equalsIgnoreCase(choice));
    }

    private void lendMenu(Scanner input, DatabaseIO db, Connection conn, PrintOut printOut) throws SQLException {
        String choice;
        do {
            showMenu(LEND);
            System.out.print(RED + "Input your choice: " + RESET);
            choice = input.next();

            if (choice.equals("1")) {
                clearTerminal();
                System.out.println(BLUE + "Lend a book" + RESET);
                printSeparator();

                input.nextLine();

                int bookId = askForInt("Book ID: ", input);
                int userId = askForInt("User ID: ", input);

                db.lendBook(bookId, userId);
                System.out.println("Book " + RED + bookId + RESET + " lent to user " + RED + userId + RESET + "!");
                printSeparator(61);
                pressEnterToContinue();

            } else if (choice.equals("2")) {
                clearTerminal();
                System.out.println(BLUE + "Lend a movie" + RESET);
                printSeparator();

                input.nextLine();

                int movieId = askForInt("Movie ID: ", input);
                int userId = askForInt("User ID: ", input);

                db.lendMovie(movieId, userId);
                System.out
                        .println("Movie " + RED + movieId + RESET + " lent to user " + RED + userId + RESET + "!");
                printSeparator(61);
                pressEnterToContinue();

            } else if (choice.equals("3")) {
                clearTerminal();
                System.out.println(BLUE + "Lend a CD" + RESET);
                printSeparator();

                input.nextLine();

                int cdId = askForInt("CD ID: ", input);
                int userId = askForInt("User ID: ", input);

                db.lendCD(cdId, userId);
                System.out.println("CD " + RED + cdId + RESET + " lent to user " + RED + userId + RESET + "!");
                printSeparator(61);
                pressEnterToContinue();

            } else if (choice.equals("4")) {
                clearTerminal();
                System.out.println(BLUE + "Lend a game" + RESET);
                printSeparator();

                input.nextLine();

                int gameId = askForInt("Game ID: ", input);
                int userId = askForInt("User ID: ", input);

                db.lendGame(gameId, userId);
                System.out.println("Game " + RED + gameId + RESET + " lent to user " + RED + userId + RESET + "!");
                printSeparator(61);
                pressEnterToContinue();

            } else if (choice.equals("5")) {
                clearTerminal();
                System.out.println(BLUE + "List all loans" + RESET);
                printSeparator();

                ResultSet rs = db.getAllLoans();
                printOut.printLoans(rs);

                printSeparator(61);
                pressEnterToContinue();

            } else if (choice.equals("6")) {
                break;

            } else {
                if (!"q".equalsIgnoreCase(choice)) {
                    System.out.println("Invalid option!");
                }
            }
        } while (!"q".equalsIgnoreCase(choice));
    }

    private void calculateMenu(Scanner input, DatabaseIO db, Connection conn, PrintOut printOut) throws SQLException {
        String choice;
        do {
            showMenu(CALCULATE);
            System.out.print(RED + "Input your choice: " + RESET);
            choice = input.next();

            if (choice.equals("1")) {
                calculateMenuDo("Total value of books", "Book", db);

            } else if (choice.equals("2")) {
                calculateMenuDo("Total value of movies", "Movie", db);

            } else if (choice.equals("3")) {
                calculateMenuDo("Total value of CDs", "CompactDisk", db);

            } else if (choice.equals("4")) {
                calculateMenuDo("Total value of games", "Game", db);

            } else if (choice.equals("5")) {
                calculateMenuDo("Total value of all items in the library", "All", db);

            } else if (choice.equals("6")) {
                break;

            } else {
                if (!"q".equalsIgnoreCase(choice)) {
                    System.out.println(YELLOW + "Invalid option!" + RESET);
                }
            }
        } while (!"q".equalsIgnoreCase(choice));
    }

    private void calculateMenuDo(String title, String table, DatabaseIO db) throws SQLException {
        clearTerminal();
        System.out.println(RED + title + RESET);
        printSeparator();
        if (table.equals("All")) {
            printString(db.readTotalValueView());
        } else {
            printString(db.readTotalValue(table));
        }
        printSeparator(61);
        pressEnterToContinue();

    }

    private void searchMenu(Scanner input, DatabaseIO db, Connection conn, PrintOut printOut) throws SQLException {
        String choice;
        do {
            showMenu(SEARCH);
            System.out.print(RED + "Input your choice: " + RESET);
            choice = input.next();

            if (choice.equals("1")) {
                clearTerminal();
                notImplemented("Search for a book in the library");

            } else if (choice.equals("2")) {
                clearTerminal();
                System.out.println(BLUE + "Search for a movie in the library" + RESET);
                printSeparator();
                System.out.print("Enter the title of the movie: ");
                input.nextLine();
                String title = input.next();
                printString(db.readOneMovie(title));
                printSeparator(61);
                pressEnterToContinue();

            } else if (choice.equals("3")) {
                clearTerminal();
                System.out.println(BLUE + "Search for a CD in the library" + RESET);
                printSeparator();
                System.out.print("Enter the title of the CD: ");
                input.nextLine();
                String title = input.next();
                printString(db.readOneCD(title));
                printSeparator(61);
                pressEnterToContinue();

            } else if (choice.equals("4")) {
                clearTerminal();
                System.out.println(BLUE + "Search for a game in the library" + RESET);
                printSeparator();
                System.out.print("Enter the title of the game: ");
                input.nextLine();
                String title = input.next();
                printString(db.readOneGame(title));
                printSeparator(61);
                pressEnterToContinue();

            } else if (choice.equals("5")) {
                clearTerminal();
                notImplemented("Search for a person");

            } else if (choice.equals("6")) {
                break;
            } else {
                if (!"q".equalsIgnoreCase(choice)) {
                    System.out.println(YELLOW + "Invalid option!" + RESET);
                }
            }
        } while (!"q".equalsIgnoreCase(choice));
    }

    private void deleteMenu(Scanner input, DatabaseIO db, Connection conn, PrintOut printOut) throws SQLException {
        String choice;
        do {
            showMenu(DELETE);
            System.out.print(RED + "Input your choice: " + RESET);
            choice = input.next();

            if (choice.equals("1")) {
                clearTerminal();
                System.out.println(BLUE + "Delete a book from the library" + RESET);
                System.out.println("Enter the id of the book: ");
                input.nextLine();

                int id = askForInt("ID: ", input);
                db.deleteBook(id);
                printSeparator(61);
                System.out.println("Book with id " + id + " was deleted");
                pressEnterToContinue();

            } else if (choice.equals("2")) {
                clearTerminal();
                System.out.println(BLUE + "Delete a movie from the library" + RESET);
                System.out.println("Enter the id of the movie: ");
                input.nextLine();

                int id = askForInt("ID: ", input);
                db.deleteMovie(id);
                printSeparator(61);
                System.out.println("Movie with id " + id + " was deleted");
                pressEnterToContinue();

            } else if (choice.equals("3")) {
                clearTerminal();
                System.out.println(BLUE + "Delete a CD from the library" + RESET);
                System.out.println("Enter the id of the CD: ");
                input.nextLine();

                int id = askForInt("ID: ", input);
                db.deleteCompactDisk(id);
                printSeparator(61);
                System.out.println("CD with id " + id + " was deleted");
                pressEnterToContinue();

            } else if (choice.equals("4")) {
                clearTerminal();
                System.out.println(BLUE + "Delete a game from the library" + RESET);
                System.out.println("Enter the id of the game: ");
                input.nextLine();

                int id = askForInt("ID: ", input);
                db.deleteGame(id);
                printSeparator(61);
                System.out.println("Game with id " + id + " was deleted");
                pressEnterToContinue();

            } else if (choice.equals("5")) {
                clearTerminal();
                System.out.println(BLUE + "Remove a person from the library" + RESET);
                System.out.println("Enter the id of the person: ");
                input.nextLine();

                int id = askForInt("ID: ", input);
                db.deletePerson(id);
                printSeparator(61);
                System.out.println("Person with id " + id + " was deleted");
                pressEnterToContinue();

            } else if (choice.equals("6")) {
                break;

            } else {
                if (!"q".equalsIgnoreCase(choice)) {
                    System.out.println("Invalid option!");
                }
            }
        } while (!"q".equalsIgnoreCase(choice));
    }

    private void updateMenu(Scanner input, DatabaseIO db, Connection conn, PrintOut printOut) throws SQLException {
        String choice;
        do {
            showMenu(UPDATE);
            System.out.print(RED + "Input your choice: " + RESET);
            choice = input.next();

            if (choice.equals("1")) {
                clearTerminal();
                System.out.println(BLUE + "Update a book in the library" + RESET);
                printSeparator();
                System.out.print("Enter the book's ID: ");
                input.nextLine();
                int id = askForInt("ID: ", input);
                if (db.readOneBook(id) != null) {
                    System.out.println("Enter the new inormation for the book");
                    input.nextLine();
                    String title = askForString("Title: ", input);
                    String author = askForString("Author: ", input);
                    String genre = askForString("Genre: ", input);
                    String condition = askForString("Condition: ", input);
                    input.nextLine();
                    int year = askForInt("Year: ", input);
                    int pages = askForInt("Pages: ", input);
                    int copy = askForInt("Copy Nr: ", input);
                    int available = askForInt("Available: ", input);
                    input.nextLine();
                    float price = askForFloat("Price: ", input);
                    db.updateBook(id, copy, available, title, genre, price, year, author, pages, condition);
                    printSeparator(61);
                    System.out.println("Book with id " + id + " was updated");
                    pressEnterToContinue();
                } else {
                    System.out.println("Book with id " + id + " does not exist");
                    pressEnterToContinue();
                }

            } else if (choice.equals("2")) {
                clearTerminal();
                notImplemented("Update a movie in the library");

            } else if (choice.equals("3")) {
                clearTerminal();
                notImplemented("Update a CD in the library");

            } else if (choice.equals("4")) {
                clearTerminal();
                notImplemented("Update a game in the library");

            } else if (choice.equals("5")) {
                clearTerminal();
                notImplemented("Update a person in the library");

            } else if (choice.equals("6")) {
                break;
            } else {
                if (!"q".equalsIgnoreCase(choice)) {
                    System.out.println("Invalid option!");
                }
            }
        } while (!"q".equalsIgnoreCase(choice));
    }

    private void readMenu(Scanner input, DatabaseIO db, Connection conn, PrintOut printOut) throws SQLException {
        String choice;
        do {
            showMenu(READ);
            System.out.print(RED + "Input your choice: " + RESET);
            choice = input.next();

            if (choice.equals("1")) {
                readMenuDo("List books in the library", "Book", db);

            } else if (choice.equals("2")) {
                readMenuDo("List movies in the library", "Movie", db);

            } else if (choice.equals("3")) {
                readMenuDo("List CDs in the library", "CD", db);

            } else if (choice.equals("4")) {
                readMenuDo("List games in the library", "Game", db);

            } else if (choice.equals("5")) {
                readMenuDo("List people in the library", "Person", db);

            } else if (choice.equals("6")) {
                readMenuDo("List all items in the library", "All", db);

            } else if (choice.equals("7")) {
                break;

            } else {
                if (!"q".equalsIgnoreCase(choice)) {
                    System.out.println(YELLOW + "Invalid option!" + RESET);
                }
            }
        } while (!"q".equalsIgnoreCase(choice));
    }

    private void readMenuDo(String title, String table, DatabaseIO db) throws SQLException {
        clearTerminal();
        System.out.println(BLUE + "List " + title + " in the library" + RESET);
        printSeparator();

        if (table.equals("Book")) {
            for (String[] row : db.readAllBooks()) {
                Book book2 = new Book(row);
                for (int i = 0; i < book2.getFewerDetails().length; i++) {
                    System.out.println(book2.getFewerDetails()[i]);
                }
                printSeparator();
            }
            pressEnterToContinue();
        } else if (table.equals("Movie")) {
            for (String[] row : db.readAllMovies()) {
                Movie movie2 = new Movie(row);
                for (int i = 0; i < movie2.getFewerDetails().length; i++) {
                    System.out.println(movie2.getFewerDetails()[i]);
                }
                printSeparator();
            }
            pressEnterToContinue();
        } else if (table.equals("CD")) {
            for (String[] row : db.readAllCDs()) {
                CompactDisk cd2 = new CompactDisk(row);
                for (int i = 0; i < cd2.getFewerDetails().length; i++) {
                    System.out.println(cd2.getFewerDetails()[i]);
                }
                printSeparator();
            }
            pressEnterToContinue();
        } else if (table.equals("Game")) {
            for (String[] row : db.readAllGames()) {
                Game game2 = new Game(row);
                for (int i = 0; i < game2.getFewerDetails().length; i++) {
                    System.out.println(game2.getFewerDetails()[i]);
                }
                printSeparator();
            }
            pressEnterToContinue();
        } else if (table.equals("Person")) {
            for (String[] row : db.readAllUsers()) {
                Person person2 = new Person(row);
                System.out.println(person2.getDetails());
                printSeparator();
            }
            pressEnterToContinue();
        } else if (table.equals("All")) {
            for (String[] row : db.readAllBooks()) {
                Book book2 = new Book(row);
                for (int i = 0; i < book2.getDetailsArray().length; i++) {
                    System.out.println(book2.getDetailsArray()[i]);
                }
                printSeparator();
            }
            for (String[] row : db.readAllMovies()) {
                Movie movie2 = new Movie(row);
                for (int i = 0; i < movie2.getDetailsArray().length; i++) {
                    System.out.println(movie2.getDetailsArray()[i]);
                }
                printSeparator();
            }
            for (String[] row : db.readAllCDs()) {
                CompactDisk cd2 = new CompactDisk(row);
                for (int i = 0; i < cd2.getDetailsArray().length; i++) {
                    System.out.println(cd2.getDetailsArray()[i]);
                }
                printSeparator();
            }
            for (String[] row : db.readAllGames()) {
                Game game2 = new Game(row);
                for (int i = 0; i < game2.getDetailsArray().length; i++) {
                    System.out.println(game2.getDetailsArray()[i]);
                }
                printSeparator();
            }
            pressEnterToContinue();
        }

    }

    private void createMenu(Scanner input, DatabaseIO db, Connection conn, PrintOut printOut) throws SQLException {
        String choice;
        do {
            showMenu(CREATE);
            System.out.print(RED + "Input your choice: " + RESET);
            choice = input.next();

            if (choice.equals("1")) {
                clearTerminal();
                System.out.println(BLUE + "Add a new book to the library" + RESET);
                System.out.println("Please fill in the following information");
                input.nextLine();

                String title = askForString("Title", input);
                String genre = askForString("Genre", input);
                String author = askForString("Author", input);
                String condition = askForString("Condition", input);

                int pages = askForInt("Pages", input);
                int copy = askForInt("Copy number", input);
                int available = askForInt("Available", input);
                float price = askForFloat("Price", input);
                int year = askForInt("Year", input);

                Book book = new Book(copy, available, title, genre, price, year, author, condition, pages);
                db.addBookFromObject(book);
                printSeparator(61);
                pressEnterToContinue();

            } else if (choice.equals("2")) {
                clearTerminal();
                System.out.println(BLUE + "Add a new movie to the library" + RESET);
                System.out.println("Please fill in the following information");
                input.nextLine();

                String title = askForString("Title", input);
                String genre = askForString("Genre", input);
                String director = askForString("Director", input);
                String agerating = askForString("Age rating", input);

                int copy = askForInt("Copy number", input);
                int available = askForInt("Available", input);
                float price = askForFloat("Price", input);
                int year = askForInt("Year", input);
                int runtime = askForInt("Runtime", input);

                Movie movie = new Movie(copy, available, title, genre, price, year, director, runtime, agerating);
                db.addMovieFromObject(movie);
                printSeparator(61);
                pressEnterToContinue();

            } else if (choice.equals("3")) {
                clearTerminal();
                notImplemented("Add a new CD to the library");

            } else if (choice.equals("4")) {
                clearTerminal();
                notImplemented("Add a new game to the library");

            } else if (choice.equals("5")) {
                clearTerminal();
                System.out.println(BLUE + "Add a new person to the library" + RESET);
                System.out.println("Please fill in the following information");
                input.nextLine();
                String name = askForString("Name", input);
                String address = askForString("Address", input);
                String email = askForString("Email", input);

                Person person = new Person(name, address, email);
                db.addPersonFromObject(person);
                printSeparator(61);
                pressEnterToContinue();

            } else if (choice.equals("6")) {
                clearTerminal();
                notImplemented("Add a new lease to the library");

            } else if (choice.equals("7")) {
                break;
            } else {
                if (!"q".equalsIgnoreCase(choice)) {
                    System.out.println("Invalid option!");
                }
            }
        } while (!"q".equalsIgnoreCase(choice));

    }

    /**
     * Asks for a string and returns it
     * Handles InputMismatchException
     * 
     * @param string
     * @param input
     * @return
     */
    private float askForFloat(String string, Scanner input) {
        try {
            System.out.print(RED + "Enter " + string + ": " + RESET);
            return input.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Must be a float");
            input.nextLine();
            return askForFloat(string, input);
        }
    }

    /**
     * Asks for a string and returns it
     * Handles InputMismatchException
     * 
     * @param string
     * @param input
     * @return
     */
    private int askForInt(String string, Scanner input) {
        try {
            System.out.print(RED + "Enter " + string + ": " + RESET);
            return input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Must be an integer");
            input.nextLine();
            return askForInt(string, input);
        }
    }

    /**
     * Asks for a string and returns it
     * Handles InputMismatchException
     * 
     * @param string
     * @param input
     * @return
     */
    private String askForString(String string, Scanner input) {
        try {
            System.out.print(RED + "Enter " + string + ": " + RESET);
            return input.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Must be a string");
            input.nextLine();
            return askForString(string, input);
        } catch (NoSuchElementException e) {
            System.out.println("Invalid input! Must be a string");
            input.nextLine();
            return askForString(string, input);
        }
    }

}
