package pl.coni.gabinet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coni.gabinet.model.Employee;

@Repository
public interface EmployeeRepositoryInt extends JpaRepository<Employee, Long> {
}
