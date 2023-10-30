package tddmicroexercises.telemetrysystem.principle.TelementryClient;

import org.junit.jupiter.api.Test;
import tddmicroexercises.telemetrysystem.utils.Constant;

import static org.junit.jupiter.api.Assertions.*;

class TelementryClientMessageFlowTest {

    String mockMessage1= Constant.DIAGNOSTIC_MESSAGE;
    String getMessageResult= Constant.MESSAGE_RETURN;
    private TelementryClientMessageFlow telementryClientMessageFlow = new TelementryClientMessageFlow();
    String getMockMessage2= "";
    @Test
    void sendWith_DIAGNOSTIC_MESSAGE() {
        telementryClientMessageFlow.send(mockMessage1);
        assertEquals(getMessageResult,telementryClientMessageFlow.receive());
    }
    @Test
    void sendWith_empty() {
        assertThrows(IllegalArgumentException.class, () -> telementryClientMessageFlow.send(getMockMessage2));
    }

    @Test
    void receiveWith_DIAGNOSTIC_MESSAGE() {
        telementryClientMessageFlow.send(mockMessage1);
        assertEquals(getMessageResult, telementryClientMessageFlow.receive());
    }

    @Test
    void receiveWith_empty() {
        String message = telementryClientMessageFlow.receive();
        assertNotNull(message);
        assertFalse(message.isEmpty());
    }
}