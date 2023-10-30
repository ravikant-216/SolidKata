package tddmicroexercises.telemetrysystem.principle.TelementryClient;

public interface ITelementryClientStatus {
    public boolean getOnlineStatus();
    public void connect(String telemetryServerConnectionString);
    public void disconnect();
}
