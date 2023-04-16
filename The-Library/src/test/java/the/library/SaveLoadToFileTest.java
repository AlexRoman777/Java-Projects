package the.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

public class SaveLoadToFileTest {

    @Test
    public void testSetPath() {
        SaveLoadToFile saveLoadToFile = new SaveLoadToFile();
        saveLoadToFile.setPath("testPath");
        assertEquals("testPath", saveLoadToFile.getPath());

    }

    @Test
    public void testSetPerson() {
        SaveLoadToFile saveLoadToFile = new SaveLoadToFile();
        Person person = mock(Person.class);
        saveLoadToFile.setPerson(person);
        assertEquals(person, saveLoadToFile.getPerson());
    }

    @Test
    public void testSaveLoadToFile() {
        Person person = mock(Person.class);
        SaveLoadToFile saveLoadToFile = new SaveLoadToFile(person);
        assertEquals(person, saveLoadToFile.getPerson());
    }

    @Test
    public void testSaveLoadToFileWithPath() {
        // Person person = mock(Person.class);
        SaveLoadToFile saveLoadToFile = new SaveLoadToFile("testPath");
        assertEquals("testPath", saveLoadToFile.getPath());

    }

}