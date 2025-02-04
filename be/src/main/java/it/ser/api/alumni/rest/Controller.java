package it.ser.api.alumni.rest;

import it.ser.api.alumni.handler.AlumniHandler;
import it.ser.api.alumni.rest.generated.AlumniApi;
import it.ser.api.alumni.rest.generated.model.AlumniRequest;
import it.ser.api.alumni.rest.generated.model.AlumniResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller implements AlumniApi {

    private final AlumniHandler alumniHandler;

    public Controller(AlumniHandler alumniHandler) {
        this.alumniHandler = alumniHandler;
    }

    @Override
    public ResponseEntity<AlumniResponse> createAlumni(AlumniRequest alumniRequest) {
        return ResponseEntity.ok(alumniHandler.handle(alumniRequest).orElse(new AlumniResponse()));
    }
}
