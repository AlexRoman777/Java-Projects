package the.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BookTest {

    @Test
    public void testBook() {
        Book book = new Book(1, 1, "The Most Amaizing Book", "Fantasy", 999.00f, 1999, "The Author", "Super", 199);
        assertEquals(1, book.getCopy());
        assertEquals(1, book.getAvailable());
        assertEquals("The Most Amaizing Book", book.getTitle());
        assertEquals("Fantasy", book.getGenre());
        assertEquals(999.00f, book.getPrice());
        assertEquals(1999, book.getYear());
        assertEquals("The Author", book.getAuthor());
        assertEquals("Super", book.getCondition());
        assertEquals(199, book.getPages());
    }

    @Test
    public void testBookFewerParameters() {
        Book book = new Book("The Most Amaizing Book", "John Doe", 1);
        assertEquals("The Most Amaizing Book", book.getTitle());
        assertEquals("John Doe", book.getAuthor());
        assertEquals(1, book.getAvailable());
    }

    @Test
    public void testCompareTO() {
        Book book = new Book(1, 1, "The Most Amaizing Book", "Fantasy", 999.00f, 1999, "The Author", "Super", 199);
        Book book2 = new Book(1, 1, "The Most Amaizing Book", "Fantasy", 999.00f, 1999, "The Author", "Super", 199);
        assertEquals(0, book.compareTo(book2));
    }

    @Test
    public void testToStringShort() {
        Book book = new Book("The Most Amaizing Book", "The Author", 1);
        assertEquals("Title: The Most Amaizing Book, Author: The Author, Available: 1", book.toStringShort());
    }

    @Test
    public void testToStringShortNoAvailable() {
        Book book = new Book("The Most Amaizing Book", "The Author", 0);
        assertEquals("Title: The Most Amaizing Book, Author: The Author, Available: 0", book.toStringShort());
    }

    @Test
    public void testToStringShortNoAvailableNoTitle() {
        Book book = new Book("", "The Author", 0);
        assertEquals("Title: , Author: The Author, Available: 0", book.toStringShort());
    }

    @Test
    public void testToStringShortNoAvailableNoTitleNoAuthor() {
        Book book = new Book("", "", 0);
        assertEquals("Title: , Author: , Available: 0", book.toStringShort());
    }

    @Test
    public void testSetAuthor() {
        Book book = new Book(1, 1, "The Most Amaizing Book", "Fantasy", 999.00f, 1999, "The Author", "Super", 199);
        book.setAuthor("The Author 2");
        assertEquals("The Author 2", book.getAuthor());
    }

    // All getters and setters
    @Test
    public void testGettersAndSetters() {
        Book book = new Book(1, 1, "The Most Amaizing Book", "Fantasy", 999.00f, 1999, "The Author", "Super", 199);
        book.setCopy(2);
        book.setAvailable(0);
        book.setTitle("The Most Amaizing Book 2");
        book.setGenre("Fantasy 2");
        book.setPrice(100.00f);
        book.setYear(2000);
        book.setAuthor("The Author 2");
        book.setCondition("Super 2");
        book.setPages(200);
        assertEquals(2, book.getCopy());
        assertEquals(0, book.getAvailable());
        assertEquals("The Most Amaizing Book 2", book.getTitle());
        assertEquals("Fantasy 2", book.getGenre());
        assertEquals(100.00f, book.getPrice());
        assertEquals(2000, book.getYear());
        assertEquals("The Author 2", book.getAuthor());
        assertEquals("Super 2", book.getCondition());
        assertEquals(200, book.getPages());
    }

    @Test
    public void testGetDetailsArray() {
        Book book = new Book(1, 1, "The Most Amaizing Book", "Fantasy", 999.00f, 2000, "The Author", "Super", 199);
        String[] details = book.getDetailsArray();
        assertEquals("The Most Amaizing Book", details[0]);
        assertEquals("The Author", details[1]);
        assertEquals("Fantasy", details[2]);
        assertEquals("2000", details[3]);
        assertEquals("999.0", details[4]);
        assertEquals("1", details[5]);
        assertEquals("Super", details[6]);
        assertEquals("199", details[7]);
        assertEquals("1", details[8]);
    }

    // Better tests

    @Test
    public void testSetCopyNegative() {
        Book book = new Book(1, 1, "The Most Amaizing Book", "Fantasy", 999.00f, 1999, "The Author", "Super", 199);
        assertThrows(IllegalArgumentException.class, () -> {
            book.setCopy(-1);
        });
    }

    @Test
    public void testSetAvailableNegative() {
        Book book = new Book(1, 1, "The Most Amaizing Book", "Fantasy", 999.00f, 1999, "The Author", "Super", 199);
        assertThrows(IllegalArgumentException.class, () -> {
            book.setAvailable(-1);
        });
    }

    @Test
    public void testSetTitleEmpty() {
        Book book = new Book(1, 1, "The Most Amaizing Book", "Fantasy", 999.00f, 1999, "The Author", "Super", 199);
        assertThrows(IllegalArgumentException.class, () -> {
            book.setTitle("");
        });
    }

    @Test
    public void testSetPriceNegative() {
        Book book = new Book(1, 1, "The Most Amaizing Book", "Fantasy", 999.00f, 1999, "The Author", "Super", 199);
        assertThrows(IllegalArgumentException.class, () -> {
            book.setPrice(-1);
        });
    }

    @Test
    public void testSetYearNegative() {
        Book book = new Book(1, 1, "The Most Amaizing Book", "Fantasy", 999.00f, 1999, "The Author", "Super", 199);
        assertThrows(IllegalArgumentException.class, () -> {
            book.setYear(-1);
        });
    }

    @Test
    public void testSetAuthorEmpty() {
        Book book = new Book(1, 1, "The Most Amaizing Book", "Fantasy", 999.00f, 1999, "The Author", "Super", 199);
        assertThrows(IllegalArgumentException.class, () -> {
            book.setAuthor("");
        });
    }

    @Test
    public void testSetYearBiggerThanCurrentYear() {
        Book book = new Book(1, 1, "The Most Amaizing Book", "Fantasy", 999.00f, 2025, "The Author", "Super", 199);
        assertThrows(IllegalArgumentException.class, () -> {
            book.setYear(2025);
        });
    }

    @Test
    public void testSetPagesNegative() {
        Book book = new Book(1, 1, "The Most Amaizing Book", "Fantasy", 999.00f, 1999, "The Author", "Super", 199);
        assertThrows(IllegalArgumentException.class, () -> {
            book.setPages(-1);
        });
    }

    @Test
    public void testSetPagesBiggerThanMax() {
        Book book = new Book(1, 1, "The Most Amaizing Book", "Fantasy", 999.00f, 1999, "The Author", "Super", 199);
        assertThrows(IllegalArgumentException.class, () -> {
            book.setPages(1000000);
        });
    }

    @Test
    public void testSetConditionEmpty() {
        Book book = new Book(1, 1, "The Most Amaizing Book", "Fantasy", 999.00f, 1999, "The Author", "Unknown", 199);
        assertEquals("Unknown", book.getCondition());
    }

    @Test
    public void testSetGenreEmpty() {
        Book book = new Book(1, 1, "The Most Amaizing Book", "Unknown", 999.00f, 1999, "The Author", "Super", 199);
        assertEquals("Unknown", book.getGenre());
    }
}
