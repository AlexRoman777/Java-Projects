package the.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

public class SendReminderTest {

    @Test
    public void testSetPath() {
        SendReminder sendReminder = new SendReminder();
        sendReminder.setPath("testPath");
        assertEquals("testPath", sendReminder.getPath());

    }

    @Test
    public void testSetReminder() {
        SendReminder sendReminder = new SendReminder();
        Reminder reminder = mock(Reminder.class);
        sendReminder.setReminder(reminder);
        assertEquals(reminder, sendReminder.getReminder());
    }

    @Test
    public void testSendReminder() {
        Reminder reminder = mock(Reminder.class);
        SendReminder sendReminder = new SendReminder(reminder);
        assertEquals(reminder, sendReminder.getReminder());
    }

    @Test
    public void testSendReminderWithPath() {
        // Reminder reminder = mock(Reminder.class);
        SendReminder sendReminder = new SendReminder("testPath");
        assertEquals("testPath", sendReminder.getPath());

    }

}
