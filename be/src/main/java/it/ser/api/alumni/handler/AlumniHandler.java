package it.ser.api.alumni.handler;

import it.ser.api.alumni.cross.builders.AlumnaeEntityBuilder;
import it.ser.api.alumni.rest.generated.model.AlumniRequest;
import it.ser.api.alumni.rest.generated.model.AlumniResponse;
import it.ser.api.alumni.storage.entities.*;
import it.ser.api.alumni.storage.repo.AlumnaeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AlumniHandler {
    private final AlumnaeRepository alumnaeRepository;
    private final AlumnaeEntityBuilder alumnaeEntityBuilder;

    @Autowired
    public AlumniHandler(AlumnaeRepository alumnaeRepository, AlumnaeEntityBuilder alumnaeEntityBuilder) {
        this.alumnaeRepository = alumnaeRepository;
        this.alumnaeEntityBuilder = alumnaeEntityBuilder;
    }

    public Optional<AlumniResponse> handle(AlumniRequest alumniRequest) {
        if (alumniRequest == null) {
            return Optional.empty();
        }
        AlumniResponse ided = map(alumniRequest);
        return Optional.of(ided);
    }

    private AlumniResponse map(AlumniRequest alumniRequest) {
        AlumnaeEntity alumnaeEntity = alumnaeEntityBuilder.build(alumniRequest);

        AlumnaeEntity saved = alumnaeRepository.save(alumnaeEntity);

        AlumniResponse alumniResponse = new AlumniResponse();
        AlumniResponse named = alumniResponse.name(saved.getName());
        return named.id(saved.getId());
    }

}
