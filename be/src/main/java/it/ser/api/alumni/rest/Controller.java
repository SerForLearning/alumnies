package it.ser.api.alumni.rest;

import it.ser.api.alumni.handler.AlumniHandler;
import it.ser.api.alumni.rest.generated.AlumniApi;
import it.ser.api.alumni.rest.generated.model.AlumniRequest;
import it.ser.api.alumni.rest.generated.model.AlumniResponse;
import it.ser.api.alumni.rest.generated.model.Error;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
public class Controller implements AlumniApi {

    private final AlumniHandler alumniHandler;

    public Controller(AlumniHandler alumniHandler) {
        this.alumniHandler = alumniHandler;
    }

    @Override
    public ResponseEntity<Object> createAlumni(AlumniRequest alumniRequest) {
        try {
            Optional<AlumniResponse> handle = alumniHandler.handle(alumniRequest);
            if (handle.isPresent()) {
                return ResponseEntity.ok(handle.orElse(new AlumniResponse()));
            }
        } catch (Exception e) {
            log.error("Something unexpected occur", e);
        }
        Error error = buildError();
        return ResponseEntity.badRequest().body(error);

    }

    private static Error buildError() {
        Error error = new Error();
        error.code("001");
        error.message("Alumni creation failed");
        return error;
    }
}
