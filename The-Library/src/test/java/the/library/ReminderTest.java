package the.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ReminderTest {

    // Getters and setters
    @Test
    public void testGettersAndSetters() {
        Reminder reminder = new Reminder();
        reminder.setUsername("username2");
        reminder.setEmail("email2@test.com");
        reminder.setAddress("address2");
        reminder.setType("Game");
        reminder.setReturnDate("returnDate2");
        assertEquals("username2", reminder.getUsername());
        assertEquals("email2@test.com", reminder.getEmail());
        assertEquals("address2", reminder.getAddress());
        assertEquals("Game", reminder.getType());
        assertEquals("returnDate2", reminder.getReturnDate());
    }

    @Test
    public void testConstructorWithParams() {
        Reminder reminder = new Reminder("username", "email@test.com", "Game", "2020", "address");
        assertEquals("username", reminder.getUsername());
        assertEquals("email@test.com", reminder.getEmail());
        assertEquals("address", reminder.getAddress());
        assertEquals("Game", reminder.getType());
        assertEquals("2020", reminder.getReturnDate());
    }

    @Test
    public void testConstructor() {
        Reminder reminder = new Reminder("username", "email@test.com", "Game", "2020", "address");
        assertEquals("username", reminder.getUsername());
        assertEquals("email@test.com", reminder.getEmail());
        assertEquals("address", reminder.getAddress());
        assertEquals("Game", reminder.getType());
        assertEquals("2020", reminder.getReturnDate());
    }

    @Test
    public void testToString() {
        Reminder reminder = new Reminder("John", "email@", "Book", "2023", "Home");
        assertEquals(
                "Hello John you have a Book that is due to be returned on 2023 please return it to or you will be charged a late fee.",
                reminder.toString());
    }

    // Good test

    @Test
    public void testSetUsernameEmpty() {
        Reminder reminder = new Reminder("username", "test@test.com", "Book", "2020", "address");
        assertThrows(IllegalArgumentException.class, () -> reminder.setUsername(""));
    }

    @Test
    public void testSetEmailEmpty() {
        Reminder reminder = new Reminder("username", " ", "Book", "2020", "address");
        assertThrows(IllegalArgumentException.class, () -> reminder.setEmail(""));
    }

    @Test
    public void testSetEmailWithoutAt() {
        Reminder reminder = new Reminder("username", " ", "Book", "2020", "address");
        assertThrows(IllegalArgumentException.class, () -> reminder.setEmail("test.com"));
    }

    @Test
    public void testSetTypeWrong() {
        Reminder reminder = new Reminder("username", " ", "Books", "2020", "address");
        assertThrows(IllegalArgumentException.class, () -> reminder.setType("Books"));
    }

}
