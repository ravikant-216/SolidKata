package tddmicroexercises.telemetrysystem.principle.TelementryDiagnosticControls;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import tddmicroexercises.telemetrysystem.principle.TelementryClient.ITelementryClientMessageFlow;
import tddmicroexercises.telemetrysystem.principle.TelementryClient.ITelementryClientStatus;
import tddmicroexercises.telemetrysystem.principle.TelementryClient.TelementryClientMessageFlow;
import tddmicroexercises.telemetrysystem.principle.TelementryClient.TelementryClientStatus;

public class TelemetryDiagnosticControlsTest {
    @Test
    public void testCheckTransmission() throws Exception {

        ITelementryClientStatus telemetryClient = new TelementryClientStatus();
        ITelementryClientMessageFlow clientMessageFlow = new TelementryClientMessageFlow();
        ITelemetryDiagnosticControls controls = new TelemetryDiagnosticControls(telemetryClient, clientMessageFlow);

        controls.checkTransmission();

        String diagnosticInfo = controls.getDiagnosticInfo();
        assertNotNull(diagnosticInfo);
    }
}