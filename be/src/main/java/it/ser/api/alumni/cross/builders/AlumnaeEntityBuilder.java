package it.ser.api.alumni.cross.builders;

import it.ser.api.alumni.rest.generated.model.AlumniRequest;
import it.ser.api.alumni.storage.entities.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlumnaeEntityBuilder {
    public AlumnaeEntity build(AlumniRequest alumniRequest) {
        AlumnaeEntity alumnaeEntity = new AlumnaeEntity();
        alumnaeEntity.setName(mapName(alumniRequest));
        alumnaeEntity.setAddresses(mapAddresses(alumniRequest));
        alumnaeEntity.setEducation(mapEducation(alumniRequest));
        return alumnaeEntity;
    }

    public EducationEntity mapEducation(AlumniRequest alumniRequest) {
        return new EducationEntity(
                mapMaster(alumniRequest),
                mapPhd(alumniRequest)
        );
    }

    public PhdDegreeEntity mapPhd(AlumniRequest alumniRequest) {
        return new PhdDegreeEntity(
                alumniRequest.getEducation().getPhd().get().getUniversity(),//TODO manage null and empty values
                alumniRequest.getEducation().getPhd().get().getYear()//TODO manage null and empty values
        );
    }

    public MasterDegreeEntity mapMaster(AlumniRequest alumniRequest) {
        return new MasterDegreeEntity(
                alumniRequest.getEducation().getMaster().get().getUniversity(),//TODO manage null and empty values
                alumniRequest.getEducation().getMaster().get().getYear()//TODO manage null and empty values
        );
    }

    public String mapName(AlumniRequest alumniRequest) {
        return alumniRequest.getName();
    }

    public List<AddressEntity> mapAddresses(AlumniRequest alumniRequest) {
        return alumniRequest.getAddresses().stream().map(address -> new AddressEntity(
                address.getStreet(),
                address.getNumber(),
                address.getCountry()
        )).toList();
    }
}
