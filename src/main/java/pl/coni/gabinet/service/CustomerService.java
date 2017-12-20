package pl.coni.gabinet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coni.gabinet.repositories.CustomerRepositoryInt;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepositoryInt customerRepositoryInt;
}
