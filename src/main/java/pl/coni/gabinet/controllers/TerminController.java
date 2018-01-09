package pl.coni.gabinet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coni.gabinet.model.Customer;
import pl.coni.gabinet.model.Employee;
import pl.coni.gabinet.model.Termin;
import pl.coni.gabinet.model.Treatment;
import pl.coni.gabinet.repositories.CustomerRepositoryInt;
import pl.coni.gabinet.repositories.EmployeeRepositoryInt;
import pl.coni.gabinet.repositories.TerminRepositoryInt;
import pl.coni.gabinet.service.EmployeeService;
import pl.coni.gabinet.service.TerminService;
import pl.coni.gabinet.service.TreatmentService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/termin")
public class TerminController {

    @Autowired
    private CustomerRepositoryInt customerRepositoryInt;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TerminRepositoryInt terminRepositoryInt;

    @Autowired
    private TreatmentService treatmentService;

    @Autowired
    private TerminService terminService;


    @GetMapping("/setEmployeeToTermin")
    public String addEmployeeToTermin(Model model) {
        model.addAttribute("employeeList", employeeService.getAllEmployee());
        model.addAttribute("termin", new Termin());
        return "setEmployeeToTerminForm";
    }

    @PostMapping("/setCustomerToTermin")
    public String addUserToTermin(@RequestParam Long employId,
                                 Model model,
                                 Termin termin) {
        Employee employee = employeeService.getOneEmployee(employId);
        termin.setEmployee(employee);
        terminRepositoryInt.save(termin);
        long terminId = termin.getId();

        List<Customer> customerList = customerRepositoryInt.findAll();
        model.addAttribute("message", employee.getLastName());
        model.addAttribute("terminId", terminId);
        model.addAttribute("customerList", customerList);
        return "setCustomerToTerminForm";
    }

    private List<Treatment> tempTreatmentsList = new ArrayList<>();

    @PostMapping("/setTreatmentsToTermin")
    public String getUserId(@RequestParam Long customerId,
                            @RequestParam Long terminId,
                            @RequestParam(required = false) Long treatmentId,
                            Model model) {
        List<Treatment> treatmentList = treatmentService.getAllTreatments(); //pobranie listy zabiegów
        Customer customer = customerRepositoryInt.getOne(customerId); // Pobranie klienta o id
        Termin termin = terminRepositoryInt.findOne(terminId);
        if (treatmentId != null) {
            tempTreatmentsList.add(treatmentService.getTerm(treatmentId));
            treatmentList.removeIf(treatment -> (treatment).getId() == treatmentId);
        }
        model.addAttribute("customerId", customerId);
        model.addAttribute("terminId", terminId);

        termin.setCustomer(customer); // przypisanie klienta do terminu
        terminRepositoryInt.save(termin);

        model.addAttribute("treatmentListToDisplay", treatmentList); // model z listą zabiegów ->
        model.addAttribute("tempTreatmentsList", tempTreatmentsList);
        return "setTreatmentsToTerminForm";
    }


    @PostMapping("/setDateToTermin")
    public String showTermins(@RequestParam Long terminId,
                              Model model) {
        model.addAttribute("terminId", terminId);
        Termin termin = terminRepositoryInt.findOne(terminId);
        List<Treatment> treatmentList = treatmentService.getAllTreatments();
        model.addAttribute("treatmentList", treatmentList);
        termin.setTreatmentList(tempTreatmentsList); // przypisanie zabiegów do terminu
        terminRepositoryInt.save(termin);
        return "setDateToTerminForm";
    }

    @PostMapping
    private String addTermin(Model model) {
        LocalDate localDate = LocalDate.now();

        int tempMonthNumber = localDate.getMonth().maxLength();
        System.out.println(tempMonthNumber);
        model.addAttribute("month", tempMonthNumber);
        model.addAttribute("termin", new Termin());
        return "addterminform";

    }

    @PostMapping("/addtermin")
    private String saveTerm(Termin termin) {

        return "index";
    }
}
