package the.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testEquals() {
        Game game1 = new Game(1, 1, "The Witcher 3", "RPG", 100.00f, 2015, "CD Projekt Red", "XBOX", 100, "M");
        Game game2 = new Game(1, 1, "The Witcher 3", "RPG", 100.00f, 2015, "CD Projekt Red", "XBOX", 100, "M");
        assertEquals(false, game1.equals(game2));
    }

    @Test
    public void testGetDetailsArray() {
        Game game = new Game(1, 1, "The Witcher 3", "RPG", 100.00f, 2015, "CD Projekt Red", "XBOX", 100, "M");
        String[] details = game.getDetailsArray();
        assertEquals("The Witcher 3", details[0]);
        assertEquals("RPG", details[1]);
        assertEquals("100.0", details[2]);
        assertEquals("2015", details[3]);
        assertEquals("CD Projekt Red", details[4]);
        assertEquals("XBOX", details[5]);
        assertEquals("100", details[6]);
        assertEquals("M", details[7]);
        assertEquals("1", details[8]);
        assertEquals("1", details[9]);
    }

    @Test
    public void testGameFewerParameters() {
        Game game = new Game("The Witcher 3", "XBOX", 1);
        assertEquals("The Witcher 3", game.getTitle());
        assertEquals("XBOX", game.getPlatform());
        assertEquals(1, game.getAvailable());
    }

    @Test
    public void testCompareTO() {
        Game game1 = new Game(1, 1, "The Witcher 3", "RPG", 100.00f, 2015, "CD Projekt Red", "XBOX", 100, "M");
        Game game2 = new Game(1, 1, "The Witcher 3", "RPG", 100.00f, 2015, "CD Projekt Red", "XBOX", 100, "M");
        assertEquals(0, game1.compareTo(game2));
    }

    // All getters and setters
    @Test
    public void testGettersAndSetters() {
        Game game = new Game(1, 1, "The Witcher 3", "RPG", 100.00f, 2015, "CD Projekt Red", "XBOX", 100, "M");
        game.setCopy(2);
        game.setAvailable(0);
        game.setTitle("The Witcher 3: Wild Hunt");
        game.setGenre("Action");
        game.setPrice(200);
        game.setYear(2016);
        game.setPublisher("CD Projekt Red");
        game.setPlatform("PS4");
        game.setPlaytime(200);
        game.setAgeRating("T");
        assertEquals(2, game.getCopy());
        assertEquals(0, game.getAvailable());
        assertEquals("The Witcher 3: Wild Hunt", game.getTitle());
        assertEquals("Action", game.getGenre());
        assertEquals(200, game.getPrice());
        assertEquals(2016, game.getYear());
        assertEquals("CD Projekt Red", game.getPublisher());
        assertEquals("PS4", game.getPlatform());
        assertEquals(200, game.getPlaytime());
        assertEquals("T", game.getAgeRating());
    }

    // Good tests !?


    @Test
    public void testSetEmptyTitle() {
        Game game = new Game(1, 1, "The Witcher 3", "RPG", 100.00f, 2015, "CD Projekt Red", "XBOX", 100, "M");
        assertThrows(IllegalArgumentException.class, () -> game.setTitle(""));
    }

    @Test
    public void testSetCopyNegative() {
        Game game = new Game(1, 1, "The Witcher 3", "RPG", 100.00f, 2015, "CD Projekt Red", "XBOX", 100, "M");
        assertThrows(IllegalArgumentException.class, () -> game.setCopy(-1));
    }

    @Test
    public void testSetAvailableNegative() {
        Game game = new Game(1, 1, "The Witcher 3", "RPG", 100.00f, 2015, "CD Projekt Red", "XBOX", 100, "M");
        assertThrows(IllegalArgumentException.class, () -> game.setAvailable(-1));
    }

    @Test
    public void testSetPriceNegative() {
        Game game = new Game(1, 1, "The Witcher 3", "RPG", 100.00f, 2015, "CD Projekt Red", "XBOX", 100, "M");
        assertThrows(IllegalArgumentException.class, () -> game.setPrice(-1));
    }

    @Test
    public void testSetYearNegative() {
        Game game = new Game(1, 1, "The Witcher 3", "RPG", 100.00f, 2015, "CD Projekt Red", "XBOX", 100, "M");
        assertThrows(IllegalArgumentException.class, () -> game.setYear(-1));
    }

    @Test
    public void testSetYearTooHigh() {
        Game game = new Game(1, 1, "The Witcher 3", "RPG", 100.00f, 2015, "CD Projekt Red", "XBOX", 100, "M");
        assertThrows(IllegalArgumentException.class, () -> game.setYear(2025));
    }

    @Test
    public void testSetPlaytimeNegative() {
        Game game = new Game(1, 1, "The Witcher 3", "RPG", 100.00f, 2015, "CD Projekt Red", "XBOX", 100, "M");
        assertThrows(IllegalArgumentException.class, () -> game.setPlaytime(-1));
    }

    @Test
    public void testSetPlatformEmpty() {
        Game game = new Game(1, 1, "The Witcher 3", "RPG", 100.00f, 2015, "CD Projekt Red", "XBOX", 100, "M");
        assertThrows(IllegalArgumentException.class, () -> game.setPlatform(""));
    }

    @Test
    public void testSetPublisherEmpty() {
        Game game = new Game(1, 1, "The Witcher 3", "RPG", 100.00f, 2015, "CD Projekt Red", "XBOX", 100, "M");
        assertThrows(IllegalArgumentException.class, () -> game.setPublisher(""));
    }

}
