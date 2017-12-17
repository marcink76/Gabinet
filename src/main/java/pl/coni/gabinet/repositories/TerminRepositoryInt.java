package pl.coni.gabinet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coni.gabinet.model.Termin;

@Repository
public interface TerminRepositoryInt extends JpaRepository<Termin, Long>{


}
