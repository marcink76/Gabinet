package pl.coni.gabinet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coni.gabinet.model.WorkingDay;

@Repository
public interface WorkingDayInt extends JpaRepository<WorkingDay, Long>{
}
