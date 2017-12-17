package pl.coni.gabinet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coni.gabinet.model.Treatment;
@Repository
public interface TreatmentRepositoryInt extends JpaRepository<Treatment, Long> {
}
