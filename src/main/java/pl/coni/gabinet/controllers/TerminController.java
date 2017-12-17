package pl.coni.gabinet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coni.gabinet.model.Termin;
import pl.coni.gabinet.model.Treatment;
import pl.coni.gabinet.model.Customer;
import pl.coni.gabinet.repositories.TerminRepositoryInt;
import pl.coni.gabinet.repositories.CustomerRepositoryInt;
import pl.coni.gabinet.service.TermService;
import pl.coni.gabinet.service.TreatmentService;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/termin")
public class TerminController {

    @Autowired
    private CustomerRepositoryInt customerRepositoryInt;

    @Autowired
    private TerminRepositoryInt terminRepositoryInt;

    @Autowired
    private TreatmentService treatmentService;

    @Autowired
    private TermService termService;


    @GetMapping("/addtermin")
    private String addUserTermin(
            Model model) {
        List<Customer> userList = customerRepositoryInt.findAll();
        model.addAttribute("userList", userList);
        model.addAttribute("termin", new Termin());
        return "setUserToTerminForm";
    }

    @PostMapping("/adduserterminid")
    private String getUserId(@RequestParam Long id, Termin termin) {
        List<Treatment> treatmentList = treatmentService.getAllTreatments();
        Customer customer = customerRepositoryInt.findOne(id);
        termin.setTreatmentList(treatmentList);
        termin.setUser(customer);
        termService.addTerm(termin);
        return "setTreatmentToTerminForm";
    }


    @PostMapping("/settratment")
    private String showTermins(Model model, Termin termin) {

        List<Treatment> treatmentList = treatmentService.getAllTreatments();
        model.addAttribute("treatmentList", treatmentList);
        return "setTreatmentToTerminForm";
    }

    @PostMapping("/settermin")
    private String saveTermin(Customer user, Model model) {


        //model.addAttribute("termin", termin);

        return "setTreatment";
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
