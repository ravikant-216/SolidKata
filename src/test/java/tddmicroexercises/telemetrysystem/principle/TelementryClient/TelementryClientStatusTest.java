package tddmicroexercises.telemetrysystem.principle.TelementryClient;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TelementryClientStatusTest {

    private TelementryClientStatus telementryClientStatus = new TelementryClientStatus();
    @Test
    void getOnlineStatus() {
        telementryClientStatus.connect("test");
        assertTrue(telementryClientStatus.getOnlineStatus());
    }

    @Test
    void connect() {
        telementryClientStatus.connect("test");
        assertTrue(telementryClientStatus.getOnlineStatus());
        assertThrows(IllegalArgumentException.class,()->telementryClientStatus.connect(""));
    }

    @Test
    void disconnect() {
        telementryClientStatus.connect("test");
        assertTrue(telementryClientStatus.getOnlineStatus());
        telementryClientStatus.disconnect();
        assertFalse(telementryClientStatus.getOnlineStatus());
    }
}