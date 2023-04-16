package the.library;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class DatabaseIOTest {

    @Mock
    private Scanner sc;

    @Mock
    private Connection conn;
    private DatabaseIO db;

    @BeforeEach
    public void setup() {
        sc = mock(Scanner.class);
        conn = mock(Connection.class);
        mock(Statement.class);
        db = new DatabaseIO("jdbc:mysql://localhost:3306/The Library");
        db.setUsername("root");
        db.setPassword("MYdatabase23#");
    }

    @Test
    public void testCreateDatabase() throws SQLException {
        DatabaseIO db = new DatabaseIO("jdbc:mysql://localhost:3306/The Library");
        db.setUsername("username");
        db.setPassword("password");
        Connection conn = mock(Connection.class);
        Statement stmt = mock(Statement.class);
        when(stmt.executeUpdate(anyString())).thenReturn(1);
        when(conn.createStatement()).thenReturn(stmt);
        db.createDatabase(conn, "test");
        verify(stmt, times(1)).executeUpdate(anyString());
    }

    // getters and setters
    @Test
    public void testGettersAndSetters() {
        DatabaseIO db = new DatabaseIO("jdbc:mysql://localhost:3306/The Library");
        db.setUsername("username");
        db.setPassword("password");
        db.setUrl("jdbc:mysql://localhost:3306/The Library");
        assert db.getUsername().equals("username");
        assert db.getPassword().equals("password");
        assert db.getUrl().equals("jdbc:mysql://localhost:3306/The Library");
    }

}
