package it.ser.api.alumni.storage.repo;

import it.ser.api.alumni.storage.entities.Alumnae;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnaeRepository extends JpaRepository<Alumnae, Long> {
}
