package tech.getarrays.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.employeemanager.model.Employee;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee , Long> { //this make me have access on all jparepository FindAll...
    Optional<Employee> findEmployeeById(Long id);
    void deleteEmployeeById(Long id);
}
