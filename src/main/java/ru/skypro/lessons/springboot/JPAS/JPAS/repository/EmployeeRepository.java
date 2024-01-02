package ru.skypro.lessons.springboot.JPAS.JPAS.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.skypro.lessons.springboot.JPAS.JPAS.dto.EmployeeInfoDTO;
import ru.skypro.lessons.springboot.JPAS.JPAS.dto.ReportDTO;
import ru.skypro.lessons.springboot.JPAS.JPAS.model.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    @Query("SELECT new ru.skypro.lessons.springboot.JPAS.JPAS.dto.EmployeeInfoDTO(e.id, e.name, e.salary,p.role) " +
            "FROM Employee e join e.position p  " +
            "WHERE e.salary = (SELECT MAX(salary) FROM Employee e)")
    List<EmployeeInfoDTO> withHighestSalary();

    @Query("SELECT new ru.skypro.lessons.springboot.JPAS.JPAS.dto.EmployeeInfoDTO(e.id, e.name, e.salary,p.role) " +
            "FROM Employee e join e. position p " +
            "WHERE p.role = :role ")
    List<EmployeeInfoDTO> getEmplRole(String role);

    @Query("SELECT new ru.skypro.lessons.springboot.JPAS.JPAS.dto.EmployeeInfoDTO(e.id, e.name, e.salary,p.role) " +
            "FROM Employee e join e. position p ")
    List<EmployeeInfoDTO> getAllEmployee();

    @Query("SELECT new ru.skypro.lessons.springboot.JPAS.JPAS.dto.EmployeeInfoDTO(e.id, e.name, e.salary,p.role) " +
            "FROM Employee e join e. position p " +
            "WHERE e.id = :id")
    List<EmployeeInfoDTO> getfullInfoById(Integer id);

    @Override
    boolean existsById(Integer integer);


    @Query("SELECT new ru.skypro.lessons.springboot.JPAS.JPAS.dto.ReportDTO( " +
            "p.role " +
            ",COUNT(e.id) " +
            ",MAX(e.salary) " +
            ",MIN(e.salary) " +
            ",AVG(e.salary)) " +
            "FROM Employee e join  position p " +
            "GROUP BY p.id")
    List<ReportDTO> statisticReported();
}