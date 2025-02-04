package it.ser.api.alumni.storage.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("MASTER")
@NoArgsConstructor
public class MasterDegreeEntity extends DegreeEntity {

    public MasterDegreeEntity(String university, Integer year) {
        super(university, year);
    }

}
