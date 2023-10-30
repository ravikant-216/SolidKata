package tddmicroexercises.telemetrysystem.principle.TelementryClient;

public interface ITelementryClientMessageFlow {
    public void send(String message);
    public String receive();
}
