package it.ser.api.alumni.cross.builders;

import it.ser.api.alumni.rest.generated.model.AlumniRequest;
import it.ser.api.alumni.storage.entities.*;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class AlumnaeEntityBuilder {

    public Optional<AlumnaeEntity> build(AlumniRequest alumniRequest) {
        if (alumniRequest == null) {
            return Optional.empty();
        }

        AlumnaeEntity alumnaeEntity = new AlumnaeEntity();
        alumnaeEntity.setName(mapName(alumniRequest));
        alumnaeEntity.setAddresses(mapAddresses(alumniRequest));
        alumnaeEntity.setEducation(mapEducation(alumniRequest));
        return Optional.of(alumnaeEntity);
    }

    private EducationEntity mapEducation(AlumniRequest alumniRequest) {
        return new EducationEntity(
                mapMaster(alumniRequest),
                mapPhd(alumniRequest)
        );
    }

    private PhdDegreeEntity mapPhd(AlumniRequest alumniRequest) {
        return alumniRequest.getEducation()
                .getPhd()
                .flatMap(phd -> Optional.of(new PhdDegreeEntity(
                        safeGet(phd::getUniversity),
                        safeGet(phd::getYear)
                )))
                .orElse(null);
    }

    private MasterDegreeEntity mapMaster(AlumniRequest alumniRequest) {
        return alumniRequest.getEducation()
                .getMaster()
                .flatMap(master -> Optional.of(new MasterDegreeEntity(
                        safeGet(master::getUniversity),
                        safeGet(master::getYear)
                )))
                .orElse(null);
    }

    private String mapName(AlumniRequest alumniRequest) {
        return Optional.ofNullable(alumniRequest.getName()).orElse("Unknown");
    }

    private List<AddressEntity> mapAddresses(AlumniRequest alumniRequest) {
        return Optional.ofNullable(alumniRequest.getAddresses())
                .orElse(Collections.emptyList())
                .stream()
                .map(address -> new AddressEntity(
                        safeGet(address::getStreet),
                        safeGet(address::getNumber),
                        safeGet(address::getCountry)
                ))
                .toList();
    }

    private String safeGet(Supplier<String> getter) {
        return Optional.ofNullable(getter.get()).filter(value -> !value.trim().isEmpty()).orElse("Unknown");
    }

    private Integer safeGet(IntegerGetter getter) {
        return Optional.ofNullable(getter.get()).orElse(0);
    }

    @FunctionalInterface
    private interface IntegerGetter {
        Integer get();
    }

    @FunctionalInterface
    private interface Supplier<T> {
        T get();
    }
}
