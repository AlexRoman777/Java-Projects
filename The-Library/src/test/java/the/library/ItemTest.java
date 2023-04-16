package the.library;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    public void testCopy() {
        assertEquals(0, Item.copy);
    }

    @Test
    public void testAvailable() {
        assertEquals(0, Item.available);
    }

    @Test
    public void testTitle() {
        assertEquals(null, Item.title);
    }

    @Test
    public void testGenre() {
        assertEquals(null, Item.genre);
    }

    @Test
    public void testPrice() {
        assertEquals(0f, Item.price);
    }

    @Test
    public void testYear() {
        assertEquals(0, Item.year);
    }

}
