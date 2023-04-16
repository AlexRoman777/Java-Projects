package the.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

public class SaveLoadToFile {

    private Person person;
    String path = System.getProperty("os.name").toLowerCase().contains("win") ? "data\\person.data"
            : "data/person.data";

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Person getPerson() {
        return person;
    }

    public String getPath() {
        return path;
    }

    public SaveLoadToFile(Person person) {
        this.person = person;
    }

    public SaveLoadToFile() {
    }

    public SaveLoadToFile(String path) {
        this.path = path;
    }


    public void saveToFile(Map<String, Person> map) {
        try {
            File file = new File(path);
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(map);
            out.close();
            fileOut.close();
            System.out.println("Data is saved in " + path);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public Map<String, Person> loadFromFile() {
        Map<String, Person> map = null;
        try {
            File file = new File(path);
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            map = (Map<String, Person>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Person class not found");
            c.printStackTrace();
            return null;
        }
        return map;
    }

    public void deleteFile() {
        File file = new File(path);
        file.delete();
        System.out.println("File deleted");
    }

}
