package tech.getarrays.employeemanager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeservice;

    public EmployeeResource(EmployeeService employeeservice) {
        this.employeeservice = employeeservice;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employees = employeeservice.findAllEmployees();
        return new ResponseEntity<>(employees , HttpStatus.OK);
    }
   @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        Employee employee = employeeservice.findEmployeeBYId(id);
        return new ResponseEntity(employee , HttpStatus.OK);
   }

   @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody  Employee employee){
       Employee newemployee = employeeservice.addEmployee(employee);
       return new ResponseEntity<>(newemployee , HttpStatus.CREATED);

   }
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody  Employee employee){
        Employee updateEmployee = employeeservice.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee , HttpStatus.OK);


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id")  Long id){
         employeeservice.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
//control and service like mirror 