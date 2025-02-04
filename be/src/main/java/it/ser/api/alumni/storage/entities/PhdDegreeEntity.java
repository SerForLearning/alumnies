package it.ser.api.alumni.storage.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("PHD")
@NoArgsConstructor
public class PhdDegreeEntity extends DegreeEntity {
    public PhdDegreeEntity(String university, Integer year) {
        super(university, year);
    }
}
