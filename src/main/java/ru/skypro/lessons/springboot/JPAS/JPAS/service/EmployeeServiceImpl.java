package ru.skypro.lessons.springboot.JPAS.JPAS.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.JPAS.JPAS.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.JPAS.JPAS.dto.EmployeeReadDTO;
import ru.skypro.lessons.springboot.JPAS.JPAS.model.Employee;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.JPAS.JPAS.dto.EmployeeInfoDTO;
import ru.skypro.lessons.springboot.JPAS.JPAS.model.Position;
import ru.skypro.lessons.springboot.JPAS.JPAS.repository.EmployeeRepository;
import ru.skypro.lessons.springboot.JPAS.JPAS.repository.PositionRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private PositionRepository positionRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PositionRepository positionRepository) {
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
    }

    @Override
    public void addEmployee(List<EmployeeDTO> employeeDTO) {
        List<Employee> employees = new ArrayList<>();

        for (EmployeeDTO dto : employeeDTO) {
            Employee employee = new Employee();
            employee.setName(dto.getName());
            employee.setSalary(dto.getSalary());

            Position position = positionRepository.findBYName(dto.getPositionName());
            if (position == null) {
                position = new Position();
                position.setRole(dto.getPositionName());
                positionRepository.save(position);
            }
            employee.setPosition(position);
            employees.add(employee);
        }
        employeeRepository.saveAll(employees);
    }

    @Override
    public boolean readEmployee(Integer id, EmployeeReadDTO employeeReadDTO) {
        if (employeeRepository.existsById(id)) {
            Employee existingEmployee = employeeRepository.getById(id);
            existingEmployee.setName(employeeReadDTO.getName());
            existingEmployee.setSalary(employeeReadDTO.getSalary());
//            Position existingPosirion = new P
//            existingEmployee.setPosition(employeeReadDTO.getRole());

            employeeRepository.save(existingEmployee);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void deleateEmployee(Integer id) {
        employeeRepository.deleteById(id);

    }


    @Override
    public List<EmployeeInfoDTO> withHighestSalary() {
        return employeeRepository.withHighestSalary();
    }

    @Override
    public List<EmployeeInfoDTO> getEmplRole(String role) {
        return employeeRepository.getEmplRole(role);
    }

    @Override
    public List<EmployeeInfoDTO> getAllEmployee() {
        return employeeRepository.getAllEmployee();
    }

    @Override
    public List<EmployeeInfoDTO> getfullInfoById(Integer id) {
        return employeeRepository.getfullInfoById(id);
    }

    @Override
    public void processUploadedEmployees(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("Фаил пуст");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String contentJson = new String(file.getBytes());
        try {
            Employee employeeSingl = objectMapper.readValue(contentJson, Employee.class);
            employeeRepository.save(employeeSingl);
        } catch (JsonProcessingException j) {
            try {
                List<Employee> employeeList = objectMapper.readValue(contentJson, new TypeReference<List<Employee>>() {
                });
                employeeRepository.saveAll(employeeList);
            } catch (JsonProcessingException ex) {
                ex.printStackTrace();
            }
        }
    }

}
