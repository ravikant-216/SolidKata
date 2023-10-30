package tddmicroexercises.telemetrysystem.principle.TelementryDiagnosticControls;

public interface ITelemetryDiagnosticControls {
    String getDiagnosticInfo();
    void setDiagnosticInfo(String diagnosticInfo);
    void checkTransmission() throws Exception;
}