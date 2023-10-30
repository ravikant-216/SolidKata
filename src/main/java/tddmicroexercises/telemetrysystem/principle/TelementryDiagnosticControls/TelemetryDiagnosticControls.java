package tddmicroexercises.telemetrysystem.principle.TelementryDiagnosticControls;
import tddmicroexercises.telemetrysystem.principle.TelementryClient.ITelementryClientMessageFlow;
import tddmicroexercises.telemetrysystem.principle.TelementryClient.ITelementryClientStatus;
import tddmicroexercises.telemetrysystem.principle.TelementryClient.TelementryClientMessageFlow;

public class TelemetryDiagnosticControls implements ITelemetryDiagnosticControls {
    private final String DiagnosticChannelConnectionString = "*111#";

    private final ITelementryClientStatus telemetryClient;
    private final ITelementryClientMessageFlow clientMessageFlow;
    private String diagnosticInfo = "";

    public TelemetryDiagnosticControls(ITelementryClientStatus telemetryClient, ITelementryClientMessageFlow clientMessageFlow) {
        this.telemetryClient = telemetryClient;
        this.clientMessageFlow = clientMessageFlow;
    }

    public String getDiagnosticInfo(){
        return diagnosticInfo;
    }

    public void setDiagnosticInfo(String diagnosticInfo){
        this.diagnosticInfo = diagnosticInfo;
    }

    public void checkTransmission() throws Exception
    {
        diagnosticInfo = "";

        telemetryClient.disconnect();

        int retryLeft = 3;
        while (telemetryClient.getOnlineStatus() == false && retryLeft > 0)
        {
            telemetryClient.connect(DiagnosticChannelConnectionString);
            retryLeft -= 1;
        }

        if(telemetryClient.getOnlineStatus() == false)
        {
            throw new Exception("Unable to connect.");
        }

        clientMessageFlow.send(TelementryClientMessageFlow.DIAGNOSTIC_MESSAGE);
        diagnosticInfo = clientMessageFlow.receive();
    }
}
