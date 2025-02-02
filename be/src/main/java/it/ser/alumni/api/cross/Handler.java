package it.ser.alumni.api.cross;

import it.ser.alumni.api.generated.model.AlumniRequest;
import it.ser.alumni.api.generated.model.AlumniResponse;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Handler {
    public Optional<AlumniResponse> handle(AlumniRequest alumniRequest) {
        if (alumniRequest != null) {
            AlumniResponse alumniResponse = new AlumniResponse();
            return Optional.of(alumniResponse.name("Mario Rossi"));
        } else {
            return Optional.empty();
        }
    }
}
