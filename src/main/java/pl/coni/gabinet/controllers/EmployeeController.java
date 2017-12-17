package pl.coni.gabinet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coni.gabinet.model.Employee;
import pl.coni.gabinet.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/showall")
    private String showAllEmployee(Model model){
        List<Employee> employeeList = employeeService.getAllEmployee();
        model.addAttribute("employeeList", employeeList);
        return "showEmployee";
    }
    @GetMapping("/add")
    private String addEmploee(Model model){
        model.addAttribute("employee", new Employee());
        return "addEmployeeForm";
    }
    @PostMapping("/add_employee_to_base")
    private String addEmpToBase(Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:add";
    }
}
