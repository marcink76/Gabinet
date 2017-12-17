package pl.coni.gabinet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coni.gabinet.model.Customer;

@Repository
public interface CustomerRepositoryInt extends JpaRepository<Customer, Long> {

}
