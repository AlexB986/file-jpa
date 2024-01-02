package ru.skypro.lessons.springboot.JPAS.JPAS.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.lessons.springboot.JPAS.JPAS.dto.EmployeeDTO;
import ru.skypro.lessons.springboot.JPAS.JPAS.dto.EmployeeReadDTO;
import ru.skypro.lessons.springboot.JPAS.JPAS.dto.ReportDTO;
import ru.skypro.lessons.springboot.JPAS.JPAS.service.EmployeeService;
import ru.skypro.lessons.springboot.JPAS.JPAS.dto.EmployeeInfoDTO;
import ru.skypro.lessons.springboot.JPAS.JPAS.service.ReportService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping()
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/withHighestSalary")

    public List<EmployeeInfoDTO> withHighestSalary() {
        return employeeService.withHighestSalary();
    }

    @GetMapping("/employee/role")
    public List<?> getEmplRole(@RequestParam("role") String role) {
        if (role != null && !role.isEmpty()) {
            return employeeService.getEmplRole(role);
        } else {
//            return employeeService.getAllEmployee();
            return null;
        }

    }

    @GetMapping("/all")
    public List<EmployeeInfoDTO> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}/full")
    public List<EmployeeInfoDTO> getfullInfoById(@PathVariable(required = false) Integer id) {
        return employeeService.getfullInfoById(id);
    }

    @PostMapping("/")
    public void addEmployee(@RequestBody List<EmployeeDTO> employeeDTO) {
        employeeService.addEmployee(employeeDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> readEmployee(@PathVariable Integer id, @RequestBody EmployeeReadDTO employeeReadDTO) {
        boolean isUpdate = employeeService.readEmployee(id, employeeReadDTO);

        if (isUpdate) {
            return ResponseEntity.ok("Employee with ID " + id + " updated successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to update employee with ID " + id);
        }

    }

    @DeleteMapping("/{id}/delete")
    public void deleateEmployee(@PathVariable Integer id) {
        employeeService.deleateEmployee(id);

    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadReport(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Файл пуст");
        }
        try {
            employeeService.processUploadedEmployees(file);
            return ResponseEntity.ok("Файл загружен и успешно обработан");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка при обработке файла: " + e.getMessage());
        }
    }
}
