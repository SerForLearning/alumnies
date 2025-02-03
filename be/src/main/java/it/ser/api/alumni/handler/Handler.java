package it.ser.api.alumni.handler;

import it.ser.api.alumni.generated.model.AlumniRequest;
import it.ser.api.alumni.generated.model.AlumniResponse;
import it.ser.api.alumni.storage.entities.Alumnae;
import it.ser.api.alumni.storage.repo.AlumnaeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Handler {
    private final AlumnaeRepository alumnaeRepository;

    @Autowired
    public Handler(AlumnaeRepository alumnaeRepository) {
        this.alumnaeRepository = alumnaeRepository;
    }

    public Optional<AlumniResponse> handle(AlumniRequest alumniRequest) {
        if (alumniRequest == null) {
            return Optional.empty();
        }
        Alumnae alumnae = new Alumnae();
        alumnae.setName(alumniRequest.getName());
        Alumnae saved = alumnaeRepository.save(alumnae);
        AlumniResponse alumniResponse = new AlumniResponse();
        AlumniResponse named = alumniResponse.name(saved.getName());
        AlumniResponse ided = named.id(saved.getId());
        return Optional.of(ided);
    }
}
