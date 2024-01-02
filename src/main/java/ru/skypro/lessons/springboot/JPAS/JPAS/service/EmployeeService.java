package ru.skypro.lessons.springboot.JPAS.JPAS.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.JPAS.JPAS.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.JPAS.JPAS.dto.EmployeeInfoDTO;
import ru.skypro.lessons.springboot.JPAS.JPAS.dto.EmployeeReadDTO;
import ru.skypro.lessons.springboot.JPAS.JPAS.model.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public interface EmployeeService {

    public void addEmployee(List<EmployeeDTO> employeeDTO);

    public boolean readEmployee(Integer id,EmployeeReadDTO employeeReadDTO);

    public void deleateEmployee(Integer id);

    public List<EmployeeInfoDTO> withHighestSalary();

    public List<EmployeeInfoDTO> getEmplRole(String role);

    public List<EmployeeInfoDTO> getAllEmployee();

    public List<EmployeeInfoDTO> getfullInfoById(Integer id);

    public void processUploadedEmployees(MultipartFile file) throws IOException, IllegalAccessException;


}
