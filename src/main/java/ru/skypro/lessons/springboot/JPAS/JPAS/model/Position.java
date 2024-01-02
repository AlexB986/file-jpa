package ru.skypro.lessons.springboot.JPAS.JPAS.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor


@Entity
//@NamedEntityGraph(name = "client_entity-graph", attributeNodes = @NamedAttributeNode("employeeList"))
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String role;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
