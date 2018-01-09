package pl.coni.gabinet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coni.gabinet.model.Termin;
import pl.coni.gabinet.model.Treatment;
import pl.coni.gabinet.model.Customer;
import pl.coni.gabinet.repositories.TreatmentRepositoryInt;

import java.util.List;

@Service
public class TreatmentService {

    @Autowired
    private TreatmentRepositoryInt treatmentRepositoryInt;

    public void saveTreatment(Treatment treatment) {
        treatmentRepositoryInt.save(treatment);
    }

    public List<Treatment> getAllTreatments() {
    return treatmentRepositoryInt.findAll();
    }

    public Treatment getTerm(long id){
        return treatmentRepositoryInt.findOne(id);
    }


}
