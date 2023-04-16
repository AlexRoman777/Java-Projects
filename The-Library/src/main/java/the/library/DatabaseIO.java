package the.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DatabaseIO {
    String url = "url";
    String username = "username";
    String password = "password";
    Connection conn;

    DatabaseIO(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUrl() {
        return this.url;
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.username);
        connectionProps.put("password", this.password);
        conn = DriverManager.getConnection(this.url, connectionProps);
        if (conn == null) {
            throw new SQLException("Could not connect to database");
        }
        this.conn = conn;
        return conn;
    }

    // Not in use - Part of CRUD
    public void createDatabase(Connection conn, String name) throws SQLException {
        String createString = "CREATE DATABASE IF NOT EXISTS " + name;
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(createString);
    }

    // Remove a book from the database
    public void deleteBook(String id) throws SQLException {
        String sql = "DELETE FROM Book WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        pstmt.executeUpdate();
    }

    /**
     * This method reads the last five books added to the database.
     * Good for testing the last insertions
     * 
     * @return String[][] - A 2D array of the last five books
     * @throws SQLException
     */
    public String[][] readLastFiveBooks() throws SQLException {
        String sql = """
                SELECT * FROM `Book` ORDER BY `id` DESC LIMIT 5""";
        List<String[]> results = new ArrayList<String[]>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            String[] row = { rs.getString("id"), rs.getString("copy"), rs.getString("available"),
                    rs.getString("title"), rs.getString("genre"), rs.getString("price"), rs.getString("year"),
                    rs.getString("author"), rs.getString("condition"), rs.getString("pages") };
            results.add(row);
        }
        return results.toArray(new String[0][0]);
    }

    // Calculate MENU

    /**
     * This method reads the total value of a specific type of media
     * 
     * @param type - The type of media, e.g. Book, CompactDisk, Game or Movie
     * @return
     * @throws SQLException
     */
    public String[][] readTotalValue(String type) throws SQLException {
        String sql = """
                SELECT SUM(price) FROM %s
                """.formatted(type);
        List<String[]> results = new ArrayList<String[]>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            results.add(new String[] {
                    "Total value of " + type + "s collection is: " + Utils.RED + rs.getString("SUM(price)")
                            + Utils.RESET + " kr" });
        }
        return results.toArray(new String[0][0]);
    }

    /**
     * This method reads the total value of all media by using a union in the
     * database
     * 
     * @return
     * @throws SQLException
     */
    public String[][] readTotalValue() throws SQLException {
        String sql = """
                SELECT SUM(price) FROM Book
                UNION
                SELECT SUM(price) FROM CompactDisk
                UNION
                SELECT SUM(price) FROM Game
                UNION
                SELECT SUM(price) FROM Movie
                """;
        List<String[]> results = new ArrayList<String[]>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            results.add(new String[] { "Total value of books is: " + Utils.RED + rs.getString("SUM(price)")
                    + Utils.RESET + " kr" });
            rs.next();
            results.add(new String[] { "Total value of CDs is: " + Utils.RED + rs.getString("SUM(price)")
                    + Utils.RESET + " kr" });
            rs.next();
            results.add(new String[] { "Total value of games is: " + Utils.RED + rs.getString("SUM(price)")
                    + Utils.RESET + " kr" });
            rs.next();
            results.add(
                    new String[] { "Total value of movies is: " + Utils.RED + rs.getString("SUM(price)")
                            + Utils.RESET + " kr" });
        }
        return results.toArray(new String[0][0]);
    }

    /**
     * This method reads the total value of all media using a view in the database
     * 
     * @return
     * @throws SQLException
     */
    public String[][] readTotalValueView() throws SQLException {
        String sql = """
                SELECT * FROM TotalLibraryValue""";
        List<String[]> results = new ArrayList<String[]>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            String[] row = { rs.getString("total") };
            results.add(row);
        }
        return results.toArray(new String[0][0]);
    }

    // Read MENU

    /**
     * This method reads all books in the database
     * 
     * @return - A 2D array of all books
     * @throws SQLException
     */
    public String[][] readAllBooks() throws SQLException {
        String sql = """
                SELECT * FROM `Book`""";
        List<String[]> results = new ArrayList<String[]>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            String[] row = { rs.getString("id"), rs.getString("copy"), rs.getString("available"),
                    rs.getString("title"), rs.getString("genre"), rs.getString("price"), rs.getString("year"),
                    rs.getString("author"), rs.getString("condition"), rs.getString("pages") };
            results.add(row);
        }
        return results.toArray(new String[0][0]);
    }

    /**
     * Reads all from CompactDisk table
     * 
     * @return String[][]
     * @throws SQLException
     */
    public String[][] readAllCDs() throws SQLException {
        String sql = """
                SELECT * FROM CompactDisk""";
        List<String[]> results = new ArrayList<String[]>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            String[] row = { rs.getString("id"), rs.getString("copy"), rs.getString("available"),
                    rs.getString("title"), rs.getString("genre"), rs.getString("price"), rs.getString("year"),
                    rs.getString("artist"), rs.getString("tracks"), rs.getString("ageRating") };
            results.add(row);
        }
        return results.toArray(new String[0][0]);
    }

    /**
     * Reads all games from Game table
     * 
     * @return String[][]
     * @throws SQLException
     */
    public String[][] readAllGames() throws SQLException {
        String sql = """
                SELECT * FROM Game""";
        List<String[]> results = new ArrayList<String[]>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            String[] row = { rs.getString("id"), rs.getString("copy"), rs.getString("available"),
                    rs.getString("title"), rs.getString("genre"), rs.getString("price"), rs.getString("year"),
                    rs.getString("publisher"), rs.getString("platform"), rs.getString("playtime"),
                    rs.getString("ageRating") };
            results.add(row);
        }
        return results.toArray(new String[0][0]);
    }

    /**
     * Reads all movies from Movie table
     * 
     * @return String[][]
     * @throws SQLException
     */
    public String[][] readAllMovies() throws SQLException {
        String sql = """
                SELECT * FROM Movie""";
        List<String[]> results = new ArrayList<String[]>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            String[] row = { rs.getString("id"), rs.getString("copy"), rs.getString("available"),
                    rs.getString("title"), rs.getString("genre"), rs.getString("price"), rs.getString("year"),
                    rs.getString("director"), rs.getString("runtime"), rs.getString("ageRating") };
            results.add(row);
        }
        return results.toArray(new String[0][0]);
    }

    /**
     * Reads all users from User table
     * 
     * @return String[][]
     * @throws SQLException
     */
    public String[][] readAllUsers() throws SQLException {
        String sql = """
                SELECT * FROM User""";
        List<String[]> results = new ArrayList<String[]>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            String[] row = { rs.getString("id"), rs.getString("username"), rs.getString("email"),
                    rs.getString("address") };
            results.add(row);
        }
        return results.toArray(new String[0][0]);
    }

    // Special MENU

    /**
     * It reads one book in the database
     * 
     * @param id - The id of the book to be read
     * @return - A 2D array of all books
     * @throws SQLException
     */
    public String[][] readOneBook(int id) throws SQLException {
        String sql = """
                SELECT * FROM Book WHERE `id` = ?""";
        List<String[]> results = new ArrayList<String[]>();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            String[] row = { rs.getString("id"), rs.getString("copy"), rs.getString("available"),
                    rs.getString("title"), rs.getString("genre"), rs.getString("price"), rs.getString("year"),
                    rs.getString("author"), rs.getString("condition"), rs.getString("pages") };
            results.add(row);
        }
        return results.toArray(new String[0][0]);
    }

    /**
     * This method reads all books in the database that are not in good or excellent
     * condition
     * 
     * @return - A 2D array of all books
     * @throws SQLException
     */

    public String[][] readBadCondition() throws SQLException {
        String sql = """
                SELECT * FROM `Book` WHERE `condition` != 'Good' AND `condition` != 'Excellent';
                    """;
        List<String[]> results = new ArrayList<String[]>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            String[] row = { rs.getString("id"), rs.getString("copy"), rs.getString("available"),
                    rs.getString("title"), rs.getString("genre"), rs.getString("price"), rs.getString("year"),
                    rs.getString("author"), rs.getString("condition"), rs.getString("pages") };
            results.add(row);
        }
        return results.toArray(new String[0][0]);
    }

    // Final version
    /**
     * Returns the database schema
     * 
     * @return - A list of all tables in the database
     * @throws SQLException
     */

    public String[][] getSchema() throws SQLException {
        String sql = """
                SELECT * FROM TableNames""";
        List<String[]> results = new ArrayList<String[]>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            String[] row = { rs.getString("Table") };
            results.add(row);
        }
        return results.toArray(new String[0][0]);
    }

    public void dropTable(String tableName) throws SQLException {
        String sql = "DROP TABLE " + tableName;
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
    }

    public void createTable(String tableName, String key1, String key2, String key3) throws SQLException {
        String sql = "CREATE TABLE " + tableName + " (" + key1 + " VARCHAR(255), " + key2 + " VARCHAR(255), " + key3
                + " VARCHAR(255))";
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
    }

    // Add MENU

    /**
     * This method adds a new book to the database
     * 
     * @param book - The book to be added - As a Book object
     * @throws SQLException
     */

    public void addBookFromObject(Book book) throws SQLException {
        String sql = """
                INSERT INTO `Book` (`copy`, `available`, `title`, `genre`, `price`, `year`, `author`, `condition`, `pages`) VALUES(?,?,?,?,?,?,?,?,?)""";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, book.getCopy());
        pstmt.setInt(2, book.getAvailable());
        pstmt.setString(3, book.getTitle());
        pstmt.setString(4, book.getGenre());
        pstmt.setFloat(5, book.getPrice());
        pstmt.setInt(6, book.getYear());
        pstmt.setString(7, book.getAuthor());
        pstmt.setString(8, book.getCondition());
        pstmt.setInt(9, book.getPages());
        pstmt.executeUpdate();
        System.out.println("Book added");
    }

    /**
     * This method adds a new game to the database
     * 
     * @param game - The game to be added - As a Game object
     * @throws SQLException
     */

    public void addGameFromObject(Game game) throws SQLException {
        String sql = """
                INSERT INTO `Game` (`copy`, `available`, `title`, `genre`, `price`, `year`, `publisher`, `platform`, `playtime`, `ageRating`) VALUES(?,?,?,?,?,?,?,?,?,?)""";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, game.getCopy());
        pstmt.setInt(2, game.getAvailable());
        pstmt.setString(3, game.getTitle());
        pstmt.setString(4, game.getGenre());
        pstmt.setFloat(5, game.getPrice());
        pstmt.setInt(6, game.getYear());
        pstmt.setString(7, game.getPublisher());
        pstmt.setString(8, game.getPlatform());
        pstmt.setInt(9, game.getPlaytime());
        pstmt.setString(10, game.getAgeRating());
        pstmt.executeUpdate();
        System.out.println("Game added");
    }

    /**
     * This method adds a new movie to the database
     * 
     * @param movie - The movie to be added - As a Movie object
     * @throws SQLException
     */

    public void addMovieFromObject(Movie movie) throws SQLException {
        String sql = """
                INSERT INTO `Movie` (`copy`, `available`, `title`, `genre`, `price`, `year`, `director`, `runtime`, `ageRating`) VALUES(?,?,?,?,?,?,?,?,?)""";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, movie.getCopy());
        pstmt.setInt(2, movie.getAvailable());
        pstmt.setString(3, movie.getTitle());
        pstmt.setString(4, movie.getGenre());
        pstmt.setFloat(5, movie.getPrice());
        pstmt.setInt(6, movie.getYear());
        pstmt.setString(7, movie.getDirector());
        pstmt.setInt(8, movie.getRuntime());
        pstmt.setString(9, movie.getAgeRating());
        pstmt.executeUpdate();
        System.out.println("Movie added");
    }

    /**
     * This method adds a new compact disk to the database
     * 
     * @param compactDisk - The compact disk to be added - As a CompactDisk object
     * @throws SQLException
     */

    public void addCompactDiskFromObject(CompactDisk compactDisk) throws SQLException {
        String sql = """
                INSERT INTO `CompactDisk` (`copy`, `available`, `title`, `genre`, `price`, `year`, `artist`, `tracks`, `ageRating`) VALUES(?,?,?,?,?,?,?,?,?)""";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, compactDisk.getCopy());
        pstmt.setInt(2, compactDisk.getAvailable());
        pstmt.setString(3, compactDisk.getTitle());
        pstmt.setString(4, compactDisk.getGenre());
        pstmt.setFloat(5, compactDisk.getPrice());
        pstmt.setInt(6, compactDisk.getYear());
        pstmt.setString(7, compactDisk.getArtist());
        pstmt.setInt(8, compactDisk.getTracks());
        pstmt.setString(9, compactDisk.getAgeRating());
        pstmt.executeUpdate();
        System.out.println("CompactDisk added");
    }

    // Search MENU

    /**
     * This method searches info about a book in the database
     * 
     * @param search - The search term
     * @return - The results of the search
     * @throws SQLException
     */

    public String[][] searchBook(String search) throws SQLException {
        String sql = """
                SELECT * FROM `Book` WHERE `title` LIKE ? OR `genre` LIKE ? OR `author` LIKE ? OR `condition` LIKE ? OR `pages` LIKE ?""";
        List<String[]> results = new ArrayList<String[]>();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "%" + search + "%");
        pstmt.setString(2, "%" + search + "%");
        pstmt.setString(3, "%" + search + "%");
        pstmt.setString(4, "%" + search + "%");
        pstmt.setString(5, "%" + search + "%");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            String[] row = { rs.getString("id"), rs.getString("copy"), rs.getString("available"),
                    rs.getString("title"), rs.getString("genre"), rs.getString("price"), rs.getString("year"),
                    rs.getString("author"), rs.getString("condition"), rs.getString("pages") };
            results.add(row);
        }
        return results.toArray(new String[0][0]);
    }

    /**
     * This method searches info in the database
     * 
     * @param search - The search term
     * @return - The results of the search
     * @throws SQLException
     */

    public String[][] searchAll(String search) throws SQLException {
        String sql = """
                SELECT * FROM `Book` WHERE `title` LIKE ? OR `genre` LIKE ? OR `price` LIKE ? OR `copy` LIKE ? OR `available` LIKE ? OR `year` LIKE ? UNION
                SELECT * FROM `Game` WHERE `title` LIKE ? OR `genre` LIKE ? OR `price` LIKE ? OR `copy` LIKE ? OR `available` LIKE ? OR `year` LIKE ? UNION
                SELECT * FROM `Movie` WHERE `title` LIKE ? OR `genre` LIKE ? OR `price` LIKE ? OR `copy` LIKE ? OR `available` LIKE ? OR `year` LIKE ? UNION
                SELECT * FROM `CompactDisk` WHERE `title` LIKE ? OR `genre` LIKE ? OR `price` LIKE ? OR `copy` LIKE ? OR `available` LIKE ? OR `year` LIKE ?""";
        List<String[]> results = new ArrayList<String[]>();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "%" + search + "%");
        pstmt.setString(2, "%" + search + "%");
        pstmt.setString(3, "%" + search + "%");
        pstmt.setString(4, "%" + search + "%");
        pstmt.setString(5, "%" + search + "%");

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            String[] row = { rs.getString("id"), rs.getString("copy"), rs.getString("available"),
                    rs.getString("title"), rs.getString("genre"), rs.getString("price"), rs.getString("year"),
                    rs.getString("author"), rs.getString("condition"), rs.getString("pages") };
            results.add(row);
        }
        return results.toArray(new String[0][0]);
    }

    public void createTableTest() throws SQLException {
        Connection conn = getConnection();
        String createString = "CREATE TABLE Test (id INT NOT NULL AUTO_INCREMENT, name VARCHAR(255), email VARCHAR(255), password VARCHAR(255), PRIMARY KEY (id));";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(createString);
        System.out.println("Table created");
        conn.close();
    }

    public void insertIntoTableTest(String name, String email, String password) throws SQLException {
        Connection conn = getConnection();
        String insertString = "INSERT INTO Test(name, email, password) VALUES(?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(insertString);
        pstmt.setString(1, name);
        pstmt.setString(2, email);
        pstmt.setString(3, password);
        pstmt.executeUpdate();
        System.out.println("Data inserted");
        conn.close();
    }

    public void updateBookAvailable(String title, int copy) throws SQLException {
        String sql = """
                UPDATE Book SET available = 0 WHERE title = ? AND copy = ?""";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, title);
        pstmt.setInt(2, copy);
        pstmt.executeUpdate();
        System.out.println("Book availability status updated");
    }

    public String[][] showRented() throws SQLException {
        String sql = """
                SELECT * FROM `Rented`""";
        List<String[]> results = new ArrayList<>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            String[] row = { rs.getString("title"), rs.getString("price") };
            results.add(row);
        }
        return results.toArray(new String[0][0]);
    }

    public void changeAvailability(int random) {
        try {
            String sql = """
                    UPDATE `Book` SET `available` = ? WHERE `id` = ?""";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 0);
            pstmt.setInt(2, random);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // CRUD - Delete
    public void deleteBook(int id) {
        try {
            String sql = """
                    DELETE FROM `Book` WHERE `id` = ?""";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteMovie(int id) {
        try {
            String sql = """
                    DELETE FROM `Movie` WHERE `id` = ?""";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteCompactDisk(int id) {
        try {
            String sql = """
                    DELETE FROM `CompactDisk` WHERE `id` = ?""";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteGame(int id) {
        try {
            String sql = """
                    DELETE FROM `Game` WHERE `id` = ?""";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deletePerson(int id) {
        try {
            String sql = """
                    DELETE FROM `User` WHERE `id` = ?""";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // CRUD - Update
    public void updateBook(int id, int copy, int available, String title, String genre, float price, int year,
            String author, int pages, String condition) {
        try {
            String sql = """
                    UPDATE `Book` SET `copy` = ?, `available` = ?, `title` = ?, `genre` = ?, `price` = ?, `year` = ?, `author` = ?, `pages` = ? WHERE `id` = ?""";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, copy);
            pstmt.setInt(2, available);
            pstmt.setString(3, title);
            pstmt.setString(4, genre);
            pstmt.setFloat(5, price);
            pstmt.setInt(6, year);
            pstmt.setString(7, author);
            pstmt.setInt(8, pages);
            pstmt.setInt(9, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateMovie(String title, String genre, float price, int year, String director, int length,
            String ageRating) {
        try {
            String sql = """
                    UPDATE `Movie` SET `title` = ?, `genre` = ?, `price` = ?, `year` = ?, `director` = ?, `length` = ?, `ageRating` = ? WHERE `title` = ?""";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, genre);
            pstmt.setFloat(3, price);
            pstmt.setInt(4, year);
            pstmt.setString(5, director);
            pstmt.setInt(6, length);
            pstmt.setString(7, ageRating);
            pstmt.setString(8, title);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateCompactDisk(String title, String genre, float price, int year, String artist, int length,
            String ageRating) {
        try {
            String sql = """
                    UPDATE `CompactDisk` SET `title` = ?, `genre` = ?, `price` = ?, `year` = ?, `artist` = ?, `length` = ?, `ageRating` = ? WHERE `title` = ?""";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, genre);
            pstmt.setFloat(3, price);
            pstmt.setInt(4, year);
            pstmt.setString(5, artist);
            pstmt.setInt(6, length);
            pstmt.setString(7, ageRating);
            pstmt.setString(8, title);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateGame(String title, String genre, float price, int year, String publisher, int length,
            String ageRating) {
        try {
            String sql = """
                    UPDATE `Game` SET `title` = ?, `genre` = ?, `price` = ?, `year` = ?, `publisher` = ?, `length` = ?, `ageRating` = ? WHERE `title` = ?""";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, genre);
            pstmt.setFloat(3, price);
            pstmt.setInt(4, year);
            pstmt.setString(5, publisher);
            pstmt.setInt(6, length);
            pstmt.setString(7, ageRating);
            pstmt.setString(8, title);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Not used in final version
    public String[][] readMaxId() {
        String sql = """
                SELECT MAX(id) FROM `Book`""";
        List<String[]> results = new ArrayList<String[]>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String[] row = { rs.getString("MAX(id)") };
                results.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return results.toArray(new String[0][0]);
    }

    public String[][] readOneMovie(String title) {
        String sql = """
                SELECT * FROM `Movie` WHERE `title` = ?""";
        List<String[]> results = new ArrayList<String[]>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String[] row = { rs.getString("copy"), rs.getString("available"), rs.getString("title"),
                        rs.getString("genre"), rs.getString("price"), rs.getString("year"),
                        rs.getString("director"), rs.getString("ageRating") };
                results.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return results.toArray(new String[0][0]);
    }

    public String[][] readOneCD(String title) {
        String sql = """
                SELECT * FROM `CompactDisk` WHERE `title` = ?""";
        List<String[]> results = new ArrayList<String[]>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String[] row = { rs.getString("copy"), rs.getString("available"), rs.getString("title"),
                        rs.getString("genre"), rs.getString("price"), rs.getString("year"),
                        rs.getString("artist"), rs.getString("tracks"), rs.getString("ageRating") };
                results.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return results.toArray(new String[0][0]);
    }

    public String[][] readOneGame(String title) {
        String sql = """
                SELECT * FROM `Game` WHERE `title` = ?""";
        List<String[]> results = new ArrayList<String[]>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String[] row = { rs.getString("copy"), rs.getString("available"), rs.getString("title"),
                        rs.getString("genre"), rs.getString("price"), rs.getString("year"),
                        rs.getString("publisher"), rs.getString("platform"), rs.getString("playtime"),
                        rs.getString("ageRating") };
                results.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return results.toArray(new String[0][0]);
    }

    // Not working as intended
    public String[][] readOnePerson(String username2) {
        String sql = """
                SELECT * FROM `User` WHERE `username` = ?""";
        List<String[]> results = new ArrayList<String[]>();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username2);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String[] row = { rs.getString("username"), rs.getString("address"), rs.getString("email") };
                results.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return results.toArray(new String[0][0]);
    }

    // Not working as intended
    public boolean updateTable(String tableName, String newTableName) {
        try {
            String sql = """
                    UPDATE ? SET ? = ? WHERE ? = ?
                    """;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tableName);
            pstmt.setString(2, newTableName);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void addPersonFromObject(Person person) {
        String sql = """
                INSERT INTO `User`(`username`, `address`, `email`) VALUES (?,?,?)""";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, person.getUsername());
            pstmt.setString(2, person.getAddress());
            pstmt.setString(3, person.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Person added to database");
    }

    // The next 4 methods will be refactored into one method acceppting 2 parameters
    // Run out of time to do this before deadline
    public String[][] readMovieRuntime() {
        String sql = """
                SELECT * FROM `MovieRuntime`""";
        List<String[]> results = new ArrayList<String[]>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String[] row = { rs.getString("title"), rs.getString("runtime") };
                results.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return results.toArray(new String[0][0]);
    }

    public String[][] readCDTracks() {
        String sql = """
                SELECT * FROM `CompactDiskTracks`""";
        List<String[]> results = new ArrayList<String[]>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String[] row = { rs.getString("title"), rs.getString("tracks") };
                results.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return results.toArray(new String[0][0]);
    }

    public String[][] readGameAgeLimit() {
        String sql = """
                SELECT * FROM `GameAgeRating`""";
        List<String[]> results = new ArrayList<String[]>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String[] row = { rs.getString("title"), rs.getString("ageRating") };
                results.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return results.toArray(new String[0][0]);
    }

    public String[][] readReminders() throws SQLException {
        String sql = """
                SELECT * FROM `Remainders`""";
        List<String[]> results = new ArrayList<String[]>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            String[] row = { rs.getString("id"), rs.getString("username"), rs.getString("Type"),
                    rs.getString("returnDate"), rs.getString("email"), rs.getString("adress") };
            results.add(row);
        }
        return results.toArray(new String[0][0]);
    }

    public void addReminderFromObject(Reminder reminder) {
        String sql = """
                INSERT INTO `Remainders`(`username`, `Type`, `returnDate`, `email`, `adress`) VALUES (?,?,?,?,?)""";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, reminder.getUsername());
            pstmt.setString(2, reminder.getType());
            pstmt.setString(3, reminder.getReturnDate());
            pstmt.setString(4, reminder.getEmail());
            pstmt.setString(5, reminder.getAddress());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Reminder added to database");
    }

    public void lendBook(int bookId, int userId) {
    }

    public void lendMovie(int movieId, int userId) {
    }

    public void lendCD(int cdId, int userId) {
    }

    public void lendGame(int gameId, int userId) {
    }

    public ResultSet getAllLoans() {
        return null;
    }

    public String[][] readOneBook(String title) {
        return null;
    }

}