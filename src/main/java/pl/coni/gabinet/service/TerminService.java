package pl.coni.gabinet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coni.gabinet.model.Customer;
import pl.coni.gabinet.model.Employee;
import pl.coni.gabinet.model.Termin;
import pl.coni.gabinet.model.Treatment;
import pl.coni.gabinet.repositories.CustomerRepositoryInt;
import pl.coni.gabinet.repositories.TerminRepositoryInt;

import java.time.LocalDate;
import java.util.List;

@Service
public class TerminService {

    @Autowired
    private TerminRepositoryInt terminRepositoryInt;

    @Autowired
    private CustomerRepositoryInt customerRepositoryInt;

    public List<Termin> getAllTerms() {
        return terminRepositoryInt.findAll();
    }

    public List<Termin> getTermsFromDay(LocalDate day) {
        return terminRepositoryInt.getByDate(day);
    }

    public Termin setEmployeeToTermin(Long employeeId, Termin termin){

    }

    @Service
    class SaveTerm {
        public Termin setCustomerToTerm(long termId, long customerId) {
            Customer customer = customerRepositoryInt.findOne(customerId);
            Termin termin = terminRepositoryInt.findOne(termId);
            termin.setCustomer(customer);
            terminRepositoryInt.save(termin);
            return termin;
        }

        public void saveTermin(Termin termin) {
            terminRepositoryInt.save(termin);
        }

    }


    public void saveCompleteTermin(Termin termin, Customer customer, Employee employee, List<Treatment> treatments) {

        termin.setCustomer(customer);
        termin.setEmployee(employee);
        termin.setTreatmentList(treatments);
        terminRepositoryInt.save(termin);
    }

}
