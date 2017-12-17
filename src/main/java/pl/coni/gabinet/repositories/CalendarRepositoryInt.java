package pl.coni.gabinet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coni.gabinet.model.TermCalendar;

@Repository
public interface CalendarRepositoryInt extends JpaRepository<TermCalendar, Long> {
}
