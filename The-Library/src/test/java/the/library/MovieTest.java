package the.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class MovieTest {

        @Test
        public void testCompareTO() {
                Movie movie = new Movie(1, 1, "The Lord of the Rings: The Fellowship of the Ring", "Fantasy", 100.00f,
                                2001,
                                "Peter Jackson", 178, "PG-13");
                Movie movie2 = new Movie(1, 1, "The Lord of the Rings: The Fellowship of the Ring", "Fantasy", 100.00f,
                                2001,
                                "Peter Jackson", 178, "PG-13");
                assertEquals(0, movie.compareTo(movie2));
        }

        @Test
        public void testPrintMovieRuntime() {
                Movie movie = new Movie(1, 1, "The Lord of the Rings: The Fellowship of the Ring", "Fantasy", 100.00f,
                                2001,
                                "Peter Jackson", 178, "PG-13");
                assertEquals("The Lord of the Rings: The Fellowship of the Ring (2001) - Runtime: 178 minutes",
                                movie.printMovieRuntime());
        }

        @Test
        public void testConstructorWithFewerParameters() {
                Movie movie = new Movie("The Lord of the Rings: The Fellowship of the Ring", 2000, 1);
                assertEquals("The Lord of the Rings: The Fellowship of the Ring", movie.getTitle());
                assertEquals(2000, movie.getYear());
                assertEquals(1, movie.getAvailable());
        }

        // All getters and setters
        @Test
        public void testGettersAndSetters() {
                Movie movie = new Movie(1, 1, "The Lord of the Rings: The Fellowship of the Ring", "Fantasy", 100.00f,
                                2001,
                                "Peter Jackson", 178, "PG-13");
                movie.setCopy(2);
                movie.setAvailable(0);
                movie.setTitle("The Lord of the Rings: The Two Towers");
                movie.setGenre("Adventure");
                movie.setPrice(200);
                movie.setYear(2002);
                movie.setDirector("Jackson");
                movie.setRuntime(180);
                movie.setAgeRating("PG-14");
                assertEquals(2, movie.getCopy());
                assertEquals(0, movie.getAvailable());
                assertEquals("The Lord of the Rings: The Two Towers", movie.getTitle());
                assertEquals("Adventure", movie.getGenre());
                assertEquals(200, movie.getPrice());
                assertEquals(2002, movie.getYear());
                assertEquals("Jackson", movie.getDirector());
                assertEquals(180, movie.getRuntime());
                assertEquals("PG-14", movie.getAgeRating());
        }


        // Maybe better tests

        @Test
        public void testSetCopyNegative() {
                Movie movie = new Movie(1, 1, "The Lord of the Rings: The Fellowship of the Ring", "Fantasy", 100.00f,
                                2001,
                                "Peter Jackson", 178, "PG-13");
                assertThrows(IllegalArgumentException.class, () -> movie.setCopy(-1));
        }

        @Test
        public void testSetAvailableNegative() {
                Movie movie = new Movie(1, 1, "The Lord of the Rings: The Fellowship of the Ring", "Fantasy", 100.00f,
                                2001,
                                "Peter Jackson", 178, "PG-13");
                assertThrows(IllegalArgumentException.class, () -> movie.setAvailable(-1));
        }

        @Test
        public void testSetTitleEmpty() {
                Movie movie = new Movie(1, 1, "The Lord of the Rings: The Fellowship of the Ring", "Fantasy", 100.00f,
                                2001,
                                "Peter Jackson", 178, "PG-13");
                assertThrows(IllegalArgumentException.class, () -> movie.setTitle(""));
        }

        @Test
        public void testSetPriceNegative() {
                Movie movie = new Movie(1, 1, "The Lord of the Rings: The Fellowship of the Ring", "Fantasy", 100.00f,
                                2001,
                                "Peter Jackson", 178, "PG-13");
                assertThrows(IllegalArgumentException.class, () -> movie.setPrice(-1));
        }

        @Test
        public void testSetYearTooSmall() {
                Movie movie = new Movie(1, 1, "The Lord of the Rings: The Fellowship of the Ring", "Fantasy", 100.00f,
                                2001,
                                "Peter Jackson", 178, "PG-13");
                assertThrows(IllegalArgumentException.class, () -> movie.setYear(1899));
        }

        @Test
        public void testSetYearTooBig() {
                Movie movie = new Movie(1, 1, "The Lord of the Rings: The Fellowship of the Ring", "Fantasy", 100.00f,
                                2001,
                                "Peter Jackson", 178, "PG-13");
                assertThrows(IllegalArgumentException.class, () -> movie.setYear(2101));
        }

        @Test
        public void testSetDirectorEmpty() {
                Movie movie = new Movie(1, 1, "The Lord of the Rings: The Fellowship of the Ring", "Fantasy", 100.00f,
                                2001,
                                "Peter Jackson", 178, "PG-13");
                assertThrows(IllegalArgumentException.class, () -> movie.setDirector(""));
        }

        @Test
        public void testSetRuntimeGood() {
                Movie movie = new Movie(1, 1, "The Lord of the Rings: The Fellowship of the Ring", "Fantasy", 100.00f,
                                2001,
                                "Peter Jackson", 178, "PG-13");
                movie.setRuntime(1);
                assertEquals(1, movie.getRuntime());
        }

        @Test
        public void testSetRuntimeTooSmall() {
                Movie movie = new Movie(1, 1, "The Lord of the Rings: The Fellowship of the Ring", "Fantasy", 100.00f,
                                2001,
                                "Peter Jackson", 178, "PG-13");
                assertThrows(IllegalArgumentException.class, () -> movie.setRuntime(0));
        }

        @Test
        public void testSetRuntimeTooBig() {
                Movie movie = new Movie(1, 1, "The Lord of the Rings: The Fellowship of the Ring", "Fantasy", 100.00f,
                                2001,
                                "Peter Jackson", 178, "PG-13");
                assertThrows(IllegalArgumentException.class, () -> movie.setRuntime(1000));
        }
}
