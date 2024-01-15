package ru.skypro.lessons.springboot.JPAS.JPAS.repository;

import jakarta.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import ru.skypro.lessons.springboot.JPAS.JPAS.model.Report;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Integer> {
    @Query(value = "SELECT * FROM Report",nativeQuery = true)
    List<Report> findAllReport();

    @Query("SELECT r.data FROM Report r  WHERE r.id = :id")
    byte [] findGetReport(@Param("id") Long id);
}
