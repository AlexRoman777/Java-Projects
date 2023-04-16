package the.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    public void testSetUsername() {
        Person person = new Person("username", "email", "address");
        person.setUsername("username2");
        assertEquals("username2", person.getUsername());
    }

    @Test
    public void testSetEmail() {
        Person person = new Person("username", "email", "address");
        person.setEmail("email2@test.com");
        assertEquals("email2@test.com", person.getEmail());
    }

    @Test
    public void testSetAddress() {
        Person person = new Person("username", "email", "address");
        person.setAddress("address2");
        assertEquals("address2", person.getAddress());
    }

    @Test
    public void testConstructor() {
        Person person = new Person("username", "email", "address");
        assertEquals("username", person.getUsername());
        assertEquals("email", person.getEmail());
        assertEquals("address", person.getAddress());
    }

    @Test
    public void testToString() {
        Person person = new Person("username", "email", "address");
        assertEquals("username, with email: email", person.toString());
    }

    @Test
    public void testGetDetails() {
        Person person = new Person("username", "email", "address");
        assertEquals(
                "Username: \u001B[31musername\u001B[0m\nEmail: \u001B[31memail\u001B[0m\nAddress: \u001B[31maddress\u001B[0m",
                person.getDetails());
    }

    @Test
    public void testGetDetailsWIthParams() {
        Person person = new Person("username", "email");
        assertEquals("Username: \u001B[31musername\u001B[0m\nEmail: \u001B[31memail\u001B[0m",
                person.getDetails("username", "email"));
    }



    // Good test

    @Test
    public void testSetUsernameEmpty() {
        Person person = new Person("username", "test@test.com", "address");
        assertThrows(IllegalArgumentException.class, () -> person.setUsername(""));
    }

    @Test
    public void testSetEmailWithoutAt() {
        Person person = new Person("username", "test@test.com", "address");
        assertThrows(IllegalArgumentException.class, () -> person.setEmail("testtest.com"));
    }






}
