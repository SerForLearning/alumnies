package it.ser.api.alumni.handler;

import it.ser.api.alumni.rest.generated.model.AlumniRequest;
import it.ser.api.alumni.rest.generated.model.AlumniResponse;
import it.ser.api.alumni.storage.entities.*;
import it.ser.api.alumni.storage.repo.AlumnaeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
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
        AlumniResponse ided = map(alumniRequest);
        return Optional.of(ided);
    }

    private AlumniResponse map(AlumniRequest alumniRequest) {
        AlumnaeEntity alumnaeEntity = new AlumnaeEntity();
        alumnaeEntity.setName(mapName(alumniRequest));
        alumnaeEntity.setAddresses(mapAddresses(alumniRequest));
        alumnaeEntity.setEducation(mapEducation(alumniRequest));
        AlumnaeEntity saved = alumnaeRepository.save(alumnaeEntity);
        AlumniResponse alumniResponse = new AlumniResponse();
        AlumniResponse named = alumniResponse.name(saved.getName());
        return named.id(saved.getId());
    }

    private static EducationEntity mapEducation(AlumniRequest alumniRequest) {
        return new EducationEntity(
                mapMaster(alumniRequest),
                mapPhd(alumniRequest)
        );
    }

    private static PhdDegreeEntity mapPhd(AlumniRequest alumniRequest) {
        return new PhdDegreeEntity(
                alumniRequest.getEducation().getPhd().get().getUniversity(),//TODO manage null and empty values
                alumniRequest.getEducation().getPhd().get().getYear()//TODO manage null and empty values
        );
    }

    private static MasterDegreeEntity mapMaster(AlumniRequest alumniRequest) {
        return new MasterDegreeEntity(
                alumniRequest.getEducation().getMaster().get().getUniversity(),//TODO manage null and empty values
                alumniRequest.getEducation().getMaster().get().getYear()//TODO manage null and empty values
        );
    }

    private static String mapName(AlumniRequest alumniRequest) {
        return alumniRequest.getName();
    }

    private static List<AddressEntity> mapAddresses(AlumniRequest alumniRequest) {
        return alumniRequest.getAddresses().stream().map(address -> new AddressEntity(
                address.getStreet(),
                address.getNumber(),
                address.getCountry()
        )).toList();
    }
}
