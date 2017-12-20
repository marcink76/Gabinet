package pl.coni.gabinet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coni.gabinet.model.Employee;
import pl.coni.gabinet.model.Termin;
import pl.coni.gabinet.model.Treatment;
import pl.coni.gabinet.model.Customer;
import pl.coni.gabinet.repositories.EmployeeRepositoryInt;
import pl.coni.gabinet.repositories.TerminRepositoryInt;
import pl.coni.gabinet.repositories.CustomerRepositoryInt;
import pl.coni.gabinet.service.TreatmentService;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/termin")
public class TerminController {

    @Autowired
    private CustomerRepositoryInt customerRepositoryInt;

    @Autowired
    private EmployeeRepositoryInt employeeRepositoryInt;

    @Autowired
    private TerminRepositoryInt terminRepositoryInt;

    @Autowired
    private TreatmentService treatmentService;


    @GetMapping("/setEmployeeToTermin")
    private String addEmployeeToTermin(Model model) {
        List<Employee> employeeList = employeeRepositoryInt.findAll();
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("termin", new Termin());
        return "setEmployeeToTerminForm";
    }

    @PostMapping("/setCustomerToTermin")
    private String addUserTermin(@RequestParam Long employId,
                                 Model model,
                                 Termin termin) {
        Employee employee = employeeRepositoryInt.findOne(employId);
        termin.setEmployee(employee);
        terminRepositoryInt.save(termin);
        long terminId = termin.getId();

        List<Customer> customerList = customerRepositoryInt.findAll();
        model.addAttribute("terminId", terminId);
        model.addAttribute("customerList", customerList);
        return "setCustomerToTerminForm";
    }

    @PostMapping("/setTreatmentToTermin")
    private String getUserId(@RequestParam Long customerId,
                             @RequestParam Long terminId,
                             Model model) {
        List<Treatment> treatmentList = treatmentService.getAllTreatments(); //pobranie listy zabiegów
        Termin termin = terminRepositoryInt.findOne(terminId);
        Customer customer = customerRepositoryInt.getOne(customerId); // Pobranie klienta o id
        termin.setCustomer(customer); // przypisanie klienta do terminu
        terminRepositoryInt.save(termin);
        model.addAttribute("treatmentList", treatmentList); // model z listą zabiegów ->
        return "setTreatmentToTerminForm";
    }


    @PostMapping("/settratment")
    private String showTermins(Model model, Termin termin) {
        List<Treatment> treatmentList = treatmentService.getAllTreatments();
        model.addAttribute("treatmentList", treatmentList);
        termin.setTreatmentList(treatmentList); // przypisanie zabiegów do terminu
        return "setTreatmentToTerminForm";
    }



    @GetMapping("/add")
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
