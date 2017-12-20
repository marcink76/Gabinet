package pl.coni.gabinet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coni.gabinet.model.Employee;
import pl.coni.gabinet.repositories.EmployeeRepositoryInt;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepositoryInt employeeRepositoryInt;

    public List<Employee> getAllEmployee(){
        return employeeRepositoryInt.findAll();
    }
    public void addEmployee(Employee employee){
        employeeRepositoryInt.save(employee);
    }
}