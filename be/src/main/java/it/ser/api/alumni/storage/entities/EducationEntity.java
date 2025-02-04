package it.ser.api.alumni.storage.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "education")
@DiscriminatorColumn(name = "degree_type", discriminatorType = DiscriminatorType.STRING)
@NoArgsConstructor
@Getter
@Setter
public class EducationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "master_id")
    private MasterDegreeEntity master;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "phd_id")
    private PhdDegreeEntity phd;

    public EducationEntity(MasterDegreeEntity master, PhdDegreeEntity phd) {
        this.master = master;
        this.phd = phd;
    }
}
