package pl.coni.gabinet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.Timed;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coni.gabinet.model.Customer;
import pl.coni.gabinet.repositories.CustomerRepositoryInt;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepositoryInt customerRepositoryInt;

    @GetMapping("/showall")
    public String showAllCustomers(Model model ){
        List<Customer> customerList = customerRepositoryInt.findAll();
        model.addAttribute("customerList", customerList);
        return "showCustomer";
    }
    @GetMapping("/addCustomer")

    private String addCustomerForm(Model model){
        model.addAttribute("customer", new Customer());
        return "addCustomer";
    }
    @PostMapping("/addcustomertobase")
    private String addCustomer(Customer customer){
        customer.setRegistrationTime(LocalDateTime.now());
        customer.setEnabled(true);
        customerRepositoryInt.save(customer);
        return "redirect:addCustomer";
    }
}
