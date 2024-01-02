package ru.skypro.lessons.springboot.JPAS.JPAS.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.skypro.lessons.springboot.JPAS.JPAS.model.Position;

@AllArgsConstructor
@NoArgsConstructor
public class EmployeeReadDTO {
    private String name;
    private Integer salary;
//    private String role;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
}
