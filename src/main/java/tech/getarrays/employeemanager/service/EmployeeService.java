package tech.getarrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.exception.UsernotFoundException;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repo.EmployeeRepo;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeerepo;


    @Autowired //to bring it's dependency
    public EmployeeService(EmployeeRepo employeerepo) {
        this.employeerepo = employeerepo;
    }

    public Employee addEmployee(Employee employee){
       employee.setEmployeeCode(UUID.randomUUID().toString()); //i should generate employee code
        return employeerepo.save(employee);
   }
    public List<Employee> findAllEmployees(){
        return employeerepo.findAll();
    }
    public Employee updateEmployee(Employee employee){
        return employeerepo.save(employee);

    }
   public void deleteEmployee(Long id){
        employeerepo.deleteEmployeeById(id);
   }
   public Employee findEmployeeBYId(Long id){

        return employeerepo.findEmployeeById(id)
                .orElseThrow(() -> new UsernotFoundException("User by id" + id + "NOT FOUND"));
   }

}
