package it.ser.api.alumni.storage.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "degrees")
@DiscriminatorColumn(name = "degree_type", discriminatorType = DiscriminatorType.STRING)
@NoArgsConstructor
@Getter
@Setter
public class DegreeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String university;

    @Column(nullable = false)
    private Integer year;

    public DegreeEntity(String university, Integer year) {
        this.university = university;
        this.year = year;
    }
}
