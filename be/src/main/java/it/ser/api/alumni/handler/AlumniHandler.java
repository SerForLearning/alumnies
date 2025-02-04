package it.ser.api.alumni.handler;

import it.ser.api.alumni.cross.builders.AlumnaeEntityBuilder;
import it.ser.api.alumni.rest.generated.model.AlumniRequest;
import it.ser.api.alumni.rest.generated.model.AlumniResponse;
import it.ser.api.alumni.storage.entities.*;
import it.ser.api.alumni.storage.repo.AlumnaeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
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
            log.warn("Invalid request");
            return Optional.empty();
        }
        return map(alumniRequest);
    }

    private Optional<AlumniResponse> map(AlumniRequest alumniRequest) {
        Optional<AlumnaeEntity> alumnaeEntity = alumnaeEntityBuilder.build(alumniRequest);

        if (alumnaeEntity.isPresent()) {
            AlumnaeEntity saved = save(alumnaeEntity.get());
            AlumniResponse alumniResponse = new AlumniResponse();
            AlumniResponse named = alumniResponse.name(saved.getName());
            return Optional.of(named.id(saved.getId()));
        } else {
            log.error("Alumni not found");
            return Optional.empty();//TODO questo bisognerà gestirlo meglio indicando anche il tipo di errore, in questo caso è un problema di dati
        }
    }

    private AlumnaeEntity save(AlumnaeEntity alumnaeEntity) {
        try {
            return alumnaeRepository.save(alumnaeEntity);
        } catch (Exception e) {
            log.error("Error saving alumnae", e);
            throw new RuntimeException(e);//TODO al posto di uscire così brutalmente è più pulito uscire con un errore ed evitare eccezioni
        }
    }

}
