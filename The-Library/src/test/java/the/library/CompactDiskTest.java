package the.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CompactDiskTest {

    @Test
    public void testCompactDisk() {
        CompactDisk cd = new CompactDisk(1, 1, "The Dark Side of the Moon", "Rock", 200.00f, 1973, "Pink Floyd",
                14,
                "PG");
        assertEquals(1, cd.getCopy());
        assertEquals(1, cd.getAvailable());
        assertEquals("The Dark Side of the Moon", cd.getTitle());
        assertEquals("Rock", cd.getGenre());
        assertEquals(200.00f, cd.getPrice());
        assertEquals(1973, cd.getYear());
        assertEquals("Pink Floyd", cd.getArtist());
        assertEquals(14, cd.getTracks());
        assertEquals("PG", cd.getAgeRating());
    }

    @Test
    public void testCompactDiskFewerParameters() {
        CompactDisk cd = new CompactDisk("The Dark Side of the Moon", "Pink Floyd", 1);
        assertEquals("The Dark Side of the Moon", cd.getTitle());
        assertEquals("Pink Floyd", cd.getArtist());
        assertEquals(1, cd.getAvailable());
    }

    @Test
    public void testGetDetailsArray() {
        CompactDisk cd = new CompactDisk(1, 1, "The Dark Side of the Moon", "Rock", 200.00f, 1973, "Pink Floyd",
                14,
                "PG");
        String[] cdArray = cd.getDetailsArray();
        assertEquals("1", cdArray[0]);
        assertEquals("1", cdArray[1]);
        assertEquals("The Dark Side of the Moon", cdArray[2]);
        assertEquals("Rock", cdArray[3]);
        assertEquals("200.0", cdArray[4]);
        assertEquals("1973", cdArray[5]);
        assertEquals("Pink Floyd", cdArray[6]);
        assertEquals("14", cdArray[7]);
        assertEquals("PG", cdArray[8]);
    }

    @Test
    public void testToStringShort() {
        CompactDisk cd = new CompactDisk(1, 1, "The Dark Side of the Moon", "Rock", 200.00f, 1973, "Pink Floyd",
                14,
                "PG");
        assertEquals("Title: The Dark Side of the Moon, Genre: Rock, Available: 1", cd.toStringShort());
    }

    // All getters and setters
    @Test
    public void testGettersAndSetters() {
        CompactDisk cd = new CompactDisk(1, 1, "The Dark Side of the Moon", "Rock", 200.00f, 1973, "Pink Floyd",
                14,
                "PG");
        cd.setCopy(2);
        cd.setAvailable(0);
        cd.setTitle("The Wall");
        cd.setGenre("Rock");
        cd.setPrice(300);
        cd.setYear(1974);
        cd.setArtist("Pink Floyd");
        cd.setTracks(15);
        cd.setAgeRating("PG-13");

        assertEquals(2, cd.getCopy());
        assertEquals(0, cd.getAvailable());
        assertEquals("The Wall", cd.getTitle());
        assertEquals("Rock", cd.getGenre());
        assertEquals(300, cd.getPrice());
        assertEquals(1974, cd.getYear());
        assertEquals("Pink Floyd", cd.getArtist());
        assertEquals(15, cd.getTracks());
        assertEquals("PG-13", cd.getAgeRating());
    }

    // Good test cases
    @Test
    public void testSetYearGood() {
        CompactDisk cd = new CompactDisk(1, 1, "The Dark Side of the Moon", "Rock", 200.00f, 1973, "Pink Floyd",
                14,
                "PG");
        cd.setYear(1900);
        assertEquals(1900, cd.getYear());
        cd.setYear(2023);
        assertEquals(2023, cd.getYear());
    }

    // Bad test cases
    @Test
    public void testSetYearBad() {
        CompactDisk cd = new CompactDisk(1, 1, "The Dark Side of the Moon", "Rock", 200.00f, 1973, "Pink Floyd",
                14,
                "PG");
        assertThrows(IllegalArgumentException.class, () -> cd.setYear(1899));
        assertThrows(IllegalArgumentException.class, () -> cd.setYear(2024));
    }

    @Test
    public void testSetPriceGood() {
        CompactDisk cd = new CompactDisk(1, 1, "The Dark Side of the Moon", "Rock", 200.00f, 1973, "Pink Floyd",
                14,
                "PG");
        cd.setPrice(0);
        assertEquals(0, cd.getPrice());
        cd.setPrice(1000);
        assertEquals(1000, cd.getPrice());
    }

    @Test
    public void testSetPriceBad() {
        CompactDisk cd = new CompactDisk(1, 1, "The Dark Side of the Moon", "Rock", 200.00f, 1973, "Pink Floyd",
                14,
                "PG");
        assertThrows(IllegalArgumentException.class, () -> cd.setPrice(-1));
    }

    @Test
    public void testSetTracksGood() {
        CompactDisk cd = new CompactDisk(1, 1, "The Dark Side of the Moon", "Rock", 200.00f, 1973, "Pink Floyd",
                14,
                "PG");
        cd.setTracks(1);
        assertEquals(1, cd.getTracks());
        cd.setTracks(99);
        assertEquals(99, cd.getTracks());
    }

    @Test
    public void testSetTracksBad() {
        CompactDisk cd = new CompactDisk(1, 1, "The Dark Side of the Moon", "Rock", 200.00f, 1973, "Pink Floyd",
                14,
                "PG");
        assertThrows(IllegalArgumentException.class, () -> cd.setTracks(0));
        assertThrows(IllegalArgumentException.class, () -> cd.setTracks(100));
    }

    @Test
    public void testSetArtistEmpty() {
        CompactDisk cd = new CompactDisk(1, 1, "The Dark Side of the Moon", "Rock", 200.00f, 1973, "Pink Floyd",
                14,
                "PG");
        assertThrows(IllegalArgumentException.class, () -> cd.setArtist(""));
    }

    @Test
    public void testSetTitleEmpty() {
        CompactDisk cd = new CompactDisk(1, 1, "The Dark Side of the Moon", "Rock", 200.00f, 1973, "Pink Floyd",
                14,
                "PG");
        assertThrows(IllegalArgumentException.class, () -> cd.setTitle(""));
    }

}
