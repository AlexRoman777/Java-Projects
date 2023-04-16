package the.library;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UtilsTest {
    @Test
    public void testGetRandomNumber() {
        int number = Utils.getRandomNumber(1, 10);
        assertEquals(true, number >= 1 && number <= 10);
    }

}
