package the.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

public class SendReminder {

    private Reminder reminder;
    String path = System.getProperty("os.name").toLowerCase().contains("win") ? "data\\reminder.data"
            : "data/reminder.data";

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public String getPath() {
        return path;
    }

    public SendReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public SendReminder() {
    }

    public SendReminder(String path) {
        this.path = path;
    }

    public void sendThePost(Map<String, Reminder> map2) {
        try {
            File file = new File(path);
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(map2);
            out.close();
            fileOut.close();
            System.out.println("Data is saved in " + path);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public Map<String, Reminder> readReceipts() {
        Map<String, Reminder> map = null;
        try {
            File file = new File(path);
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            map = (Map<String, Reminder>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Reminder class not found");
            c.printStackTrace();
            return null;
        }
        return map;
    }
    
}
