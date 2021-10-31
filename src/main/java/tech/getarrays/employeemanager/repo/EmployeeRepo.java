package tech.getarrays.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.getarrays.employeemanager.model.Employee;

import java.util.List;
import java.util.Optional;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee , Long> { //this make me have access on all jparepository FindAll...
    Optional<Employee> findEmployeeById(Long id);
    void deleteEmployeeById(Long id);

   // boolean existsByPhone(String phone);

    //@Query(value = "UPDATE Employee e SET e.phone = :phone WHERE e.id = :id " , nativeQuery = true)
    @Modifying
    @Query( "update Employee e set e.phone = :phone where e.id = :id ")
    int updatePhone(@Param ("phone") String phone , @Param ("id") Long id);


    boolean existsByPhone(String phone);

    @Query("SELECT e FROM Employee e")
    List<Employee> findAllEmployee();

}
