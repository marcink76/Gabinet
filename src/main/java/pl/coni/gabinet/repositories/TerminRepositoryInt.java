package pl.coni.gabinet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coni.gabinet.model.Termin;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TerminRepositoryInt extends JpaRepository<Termin, Long>{
    List<Termin> getByDate(LocalDate month);

}
