package tddmicroexercises.telemetrysystem.principle.TelementryClient;

import java.util.Random;

public class TelementryClientStatus implements ITelementryClientStatus{

    private boolean onlineStatus;

    private final Random connectionEventsSimulator = new Random(42);

    public boolean getOnlineStatus()
    {
        return onlineStatus;
    }

    public void connect(String telemetryServerConnectionString)
    {
        if (telemetryServerConnectionString == null || "".equals(telemetryServerConnectionString))
        {
            throw new IllegalArgumentException();
        }

        // simulate the operation on a real modem
        boolean success = connectionEventsSimulator.nextInt(10) <= 8;

        onlineStatus = success;
    }
    public void disconnect()
    {
        onlineStatus = false;
    }
}
