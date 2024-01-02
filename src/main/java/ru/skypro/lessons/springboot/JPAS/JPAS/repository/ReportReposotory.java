package ru.skypro.lessons.springboot.JPAS.JPAS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.skypro.lessons.springboot.JPAS.JPAS.dto.ReportDTO;
import ru.skypro.lessons.springboot.JPAS.JPAS.model.Report;

import java.util.List;

public interface ReportReposotory extends CrudRepository<Report, Integer> {
    @Query(value = "SELECT * FROM Report",nativeQuery = true)
    List<Report> findAllReport();
}
