package it.ser.alumni.api.rest;

import it.ser.alumni.api.cross.Handler;
import it.ser.alumni.api.generated.AlumniApi;
import it.ser.alumni.api.generated.model.AlumniRequest;
import it.ser.alumni.api.generated.model.AlumniResponse;
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
