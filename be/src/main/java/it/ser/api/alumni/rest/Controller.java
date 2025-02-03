package it.ser.api.alumni.rest;

import it.ser.api.alumni.handler.Handler;
import it.ser.api.alumni.generated.AlumniApi;
import it.ser.api.alumni.generated.model.AlumniRequest;
import it.ser.api.alumni.generated.model.AlumniResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller implements AlumniApi {

    private final Handler handler;

    public Controller(Handler handler) {
        this.handler = handler;
    }

    @Override
    public ResponseEntity<AlumniResponse> createAlumni(AlumniRequest alumniRequest) {
        return ResponseEntity.ok(handler.handle(alumniRequest).orElse(new AlumniResponse()));
    }
}
